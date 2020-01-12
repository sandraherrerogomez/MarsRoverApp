import exceptions.InvalidMarsInstructionsFileException;
import exceptions.MarsOrderException;
import exceptions.OutOfPlateauException;

public class MarsRoverApplication {
    public static void main(String args[]) {

        RoverInstructionsInterpreter interpreter = new RoverInstructionsInterpreter();
        try {
            interpreter.read("marsRoverInstructions.txt");
        } catch (InvalidMarsInstructionsFileException e) {
            System.out.println("Problem detected, stopping the Mars Rover " + e.getMessage());
        }

        for(int i = 0; i < interpreter.getOriginCoordinates().size(); i++){
            MarsRover marsRover = new MarsRover(interpreter.getOriginCoordinates().get(i), interpreter.getPlateauSize());
            try {
                marsRover.move(interpreter.getInstructions().get(i));
                System.out.println(marsRover.getCoords() + " " + marsRover.getOrientation());
            } catch(OutOfPlateauException e) {
                System.out.println(e.getMessage());
            } catch(MarsOrderException e){
                System.out.println(e.getMessage());

            }
        }
    }


}
