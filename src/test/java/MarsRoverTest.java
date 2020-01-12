import exceptions.MarsOrderException;
import exceptions.OutOfPlateauException;
import org.junit.jupiter.api.Test;

public class MarsRoverTest {

    @Test
    public void testMarsRoverCreation() {
        MarsRover rover = new MarsRover("1 2 N", "5 5");
        assert (rover.getCoords().getX() == 1);
        assert (rover.getCoords().getY() == 2);
        assert (rover.getOrientation() == Orientation.N);
        assert (rover.getLimitX() == 5);
        assert (rover.getLimitY() == 5);
    }

    @Test
    public void testMarsRoverMove() {
        MarsRover rover = new MarsRover("1 2 N", "5 5");
        try {
            rover.move("LMLMLMLMM");
            assert (rover.getCoords().getX() == 1);
            assert (rover.getCoords().getY() == 3);
            assert (rover.getOrientation() == Orientation.N);
        } catch (OutOfPlateauException e) {
            assert (false);
        } catch (MarsOrderException e) {
            assert (false);
        }
    }

    @Test
    public void testMarsRoverMoveError() {
        MarsRover rover = new MarsRover("1 2 N", "1 1");
        try {
            rover.move("LMLMLMLMM");
        } catch (OutOfPlateauException e) {
            assert (true);
        } catch (MarsOrderException e) {
            assert (false);
        }
    }


    @Test
    public void testMarsRoverMoveInvalidOrder() {
        MarsRover rover = new MarsRover("1 2 N", "5 5");
        try {
            rover.move("SNASD");
        } catch (OutOfPlateauException e) {
            assert (false);
        } catch (MarsOrderException e) {
            assert (true);
        }
    }

}
