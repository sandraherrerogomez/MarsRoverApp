import exceptions.InvalidMarsInstructionsFileException;
import exceptions.MarsOrderException;
import exceptions.OutOfPlateauException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RoverInstructionsInterpreterTest {

    @Test
    public void testValidInputFile(){
        RoverInstructionsInterpreter interpreter = new RoverInstructionsInterpreter();
        try {
            interpreter.read("marsRoverInstructions.txt");
            System.out.println(interpreter.getPlateauSize());
            assert(interpreter.getPlateauSize().equals("5 5"));
        } catch (Exception e) {
            assert(false);
        }
    }

    @Test
    public void testNonExistingFile(){
        RoverInstructionsInterpreter interpreter = new RoverInstructionsInterpreter();
        try {
            interpreter.read("blabla.txt");
            assert(false);
        } catch (InvalidMarsInstructionsFileException e) {
            assert(true);
        }
    }

    @Test
    public void testCorruptedFile(){
        RoverInstructionsInterpreter interpreter = new RoverInstructionsInterpreter();
        try {
            interpreter.read("marsRoverInstructionsCorrupted.txt");
            assert(false);
        } catch (InvalidMarsInstructionsFileException e) {
            assert(true);
        }
    }




}
