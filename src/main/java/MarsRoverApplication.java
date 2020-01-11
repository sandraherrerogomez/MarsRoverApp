public class MarsRoverApplication {
    public static void main (String args[]) {
        MarsRovers rover=new MarsRovers("3 3 E", "1 1");

        try {
            rover.move("MMRMMRMRRM");
            System.out.println(rover.getCoords());
            System.out.println(rover.getOrientation());
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
