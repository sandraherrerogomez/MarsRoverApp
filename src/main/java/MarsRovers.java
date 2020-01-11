import com.sun.org.apache.xpath.internal.operations.Or;

public class MarsRovers {

    private Coordinate coords;
    private Orientation orientation;
    private int limitX;
    private int limitY;

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
    public MarsRovers(String originCoordOrientation, String plateauLimits) {
        this.limitX = Character.getNumericValue(plateauLimits.charAt(0));
        this.limitY = Character.getNumericValue(plateauLimits.charAt(2));

        int x = Character.getNumericValue(originCoordOrientation.charAt(0));
        int y = Character.getNumericValue(originCoordOrientation.charAt(2));
        this.coords = new Coordinate(x, y);

        switch (originCoordOrientation.charAt(4)) {
            case 'N':
                this.orientation = Orientation.NORTH;
                break;
            case 'S':
                this.orientation = Orientation.SOUTH;
                break;
            case 'E':
                this.orientation = Orientation.EAST;
                break;
            case 'W':
                this.orientation = Orientation.WEST;
                break;
        }

        if (originCoordOrientation.charAt(4) == 'N') {
            this.orientation = Orientation.NORTH;
        } else if (originCoordOrientation.charAt(4) == 'S') {

        }
    }

    // LMLMLMLMM L=left R=right M=forward
    public void move(String orders) throws Exception{
        for (int i = 0; i < orders.length(); i++) {

            switch (orders.charAt(i)) {
                case 'L': {
                    switch (orientation) {
                        case NORTH:
                            orientation = Orientation.WEST;
                            break;
                        case WEST:
                            orientation = Orientation.SOUTH;
                            break;
                        case SOUTH:
                            orientation = Orientation.EAST;
                            break;
                        case EAST:
                            orientation = Orientation.NORTH;
                            break;
                    }


                }
                break;
                case 'R': {
                    switch (orientation) {
                        case NORTH:
                            orientation = Orientation.EAST;
                            break;
                        case WEST:
                            orientation = Orientation.NORTH;
                            break;
                        case SOUTH:
                            orientation = Orientation.WEST;
                            break;
                        case EAST:
                            orientation = Orientation.SOUTH;
                            break;
                    }


                }
                break;
                case 'M': {
                    switch (orientation) {
                        case NORTH:
                            if(coords.getY()+1>limitY){
                                throw new Exception("WARNING!!! WE HAVE LOST THE ROVER!!!!!! THIS SEEMS EXPENSIVE... :(");
                        }
                            coords.setY(coords.getY() + 1);
                            break;
                        case WEST:
                            if(coords.getX()-1<0){
                                throw new Exception("WARNING!!! WE HAVE LOST THE ROVER!!!!!! THIS SEEMS EXPENSIVE... :(");
                            }
                            coords.setX(coords.getX() - 1);
                            break;
                        case SOUTH:
                            if(coords.getY()-1<0){
                            throw new Exception("WARNING!!! WE HAVE LOST THE ROVER!!!!!! THIS SEEMS EXPENSIVE... :(");
                        }
                            coords.setY(coords.getY() - 1);
                            break;
                        case EAST:
                            if(coords.getX()+1>limitX){
                            throw new Exception("WARNING!!! WE HAVE LOST THE ROVER!!!!!! THIS SEEMS EXPENSIVE... :(");
                        }
                            coords.setX(coords.getX() + 1);
                            break;
                    }

                }

            }

        }

    }
}

enum Orientation {
    NORTH, SOUTH, EAST, WEST
}

