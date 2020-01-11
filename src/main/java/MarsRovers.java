import com.sun.org.apache.xpath.internal.operations.Or;

public class MarsRovers {

    private Coordinate coords;
    private Orientation orientation;

    public Coordinate getCoords() {
        return coords;
    }

    public void setCoords(Coordinate coords) {
        this.coords = coords;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }


    // 1 5 N
    public MarsRovers(String originCoordOrientation){
        int x = Character.getNumericValue(originCoordOrientation.charAt(0));
        int y= Character.getNumericValue(originCoordOrientation.charAt(2));;
        this.coords=new Coordinate(x,y);

        switch (originCoordOrientation.charAt(4)){
            case 'N': this.orientation = Orientation.NORTH;
            break;
            case 'S': this.orientation = Orientation.SOUTH;
            break;
            case 'E': this.orientation = Orientation.EAST;
            break;
            case 'W': this.orientation = Orientation.WEST;
            break;
        }

        if(originCoordOrientation.charAt(4)=='N'){
            this.orientation=Orientation.NORTH;
        }
        else if(originCoordOrientation.charAt(4)=='S'){

        }
    }


    public void move(String orders) {

    }

}

 enum Orientation {
    NORTH, SOUTH, EAST, WEST
};
