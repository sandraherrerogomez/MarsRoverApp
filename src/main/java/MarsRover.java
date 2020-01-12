import exceptions.MarsOrderException;
import exceptions.OutOfPlateauException;

public class MarsRover {

    private Coordinate coords;
    private Orientation orientation;

    public int getLimitX() {
        return limitX;
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

    public int getLimitY() {
        return limitY;
    }

    public void setLimitY(int limitY) {
        this.limitY = limitY;
    }

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
    public MarsRover(String originCoordOrientation, String plateauLimits) {
        String[] originPosition = originCoordOrientation.split(" ");
        String[] plateauLim = plateauLimits.split(" ");
        this.limitX = Integer.parseInt(plateauLim[0]);
        this.limitY = Integer.parseInt(plateauLim[1]);

        int x = Integer.parseInt(originPosition[0]);
        int y = Integer.parseInt(originPosition[1]);
        this.coords = new Coordinate(x, y);

        this.orientation = Orientation.valueOf(originPosition[2].toUpperCase());


    }

    // LMLMLMLMM L=left R=right M=forward
    public void move(String orders) throws OutOfPlateauException, MarsOrderException {
        for (int i = 0; i < orders.length(); i++) {

            switch (orders.charAt(i)) {
                case 'L': {
                    switch (orientation) {
                        case N:
                            orientation = Orientation.W;
                            break;
                        case W:
                            orientation = Orientation.S;
                            break;
                        case S:
                            orientation = Orientation.E;
                            break;
                        case E:
                            orientation = Orientation.N;
                            break;
                    }


                }
                break;
                case 'R': {
                    switch (orientation) {
                        case N:
                            orientation = Orientation.E;
                            break;
                        case W:
                            orientation = Orientation.N;
                            break;
                        case S:
                            orientation = Orientation.W;
                            break;
                        case E:
                            orientation = Orientation.S;
                            break;
                    }


                }
                break;
                case 'M': {
                    switch (orientation) {
                        case N:
                            if (coords.getY() + 1 > limitY) {
                                throw new OutOfPlateauException("WARNING!!! WE HAVE LOST THE ROVER!!!!!! THIS SEEMS EXPENSIVE... :(");
                            }
                            coords.setY(coords.getY() + 1);
                            break;
                        case W:
                            if (coords.getX() - 1 < 0) {
                                throw new OutOfPlateauException("WARNING!!! WE HAVE LOST THE ROVER!!!!!! THIS SEEMS EXPENSIVE... :(");
                            }
                            coords.setX(coords.getX() - 1);
                            break;
                        case S:
                            if (coords.getY() - 1 < 0) {
                                throw new OutOfPlateauException("WARNING!!! WE HAVE LOST THE ROVER!!!!!! THIS SEEMS EXPENSIVE... :(");
                            }
                            coords.setY(coords.getY() - 1);
                            break;
                        case E:
                            if (coords.getX() + 1 > limitX) {
                                throw new OutOfPlateauException("WARNING!!! WE HAVE LOST THE ROVER!!!!!! THIS SEEMS EXPENSIVE... :(");
                            }
                            coords.setX(coords.getX() + 1);
                            break;
                    }
                }
                break;
                default: throw new MarsOrderException("Order " + orders.charAt(i) + " its not an expected Mars instruction");

            }

        }

    }
}

enum Orientation {
    N, S, E, W
}

