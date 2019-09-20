public class Rover {

    private static final char EAST_ORIENTATION = 'E';
    private static final char WEST_ORIENTATION = 'W';
    private static final char SOUTH_ORIENTATION = 'S';
    private static final char NORTH_ORIENTATION = 'N';
    private static final char RIGHT_DIRECTION = 'R';
    private static final char LEFT_DIRECTION = 'L';
    private static final char MOVE_COMMAND = 'M';

    private int coordX;
    private int coordY;
    private char orientation;

    public Rover(int coordX, int coordY, char orientation) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.orientation = orientation;
    }

    public void move(char[] directions) {
        for (char direction : directions) {
            if (direction == LEFT_DIRECTION || direction == RIGHT_DIRECTION) {
                changeOrientation(direction);
            } else if (direction == MOVE_COMMAND) {
                forwardMove();
            } else {
                throw new RuntimeException("Invalid direction");
            }
        }
    }

    private void changeOrientation(char direction) {
        switch (orientation) {
            case NORTH_ORIENTATION:
                changeOrientation(direction, EAST_ORIENTATION, WEST_ORIENTATION);
                break;
            case EAST_ORIENTATION:
                changeOrientation(direction, SOUTH_ORIENTATION, NORTH_ORIENTATION);
                break;
            case WEST_ORIENTATION:
                changeOrientation(direction, NORTH_ORIENTATION, SOUTH_ORIENTATION);
                break;
            case SOUTH_ORIENTATION:
                changeOrientation(direction, WEST_ORIENTATION, EAST_ORIENTATION);
                break;
            default:
                throw new RuntimeException("Wrong orientation");
        }
    }

    private void changeOrientation(char direction, char rightDirection, char leftDirection) {
        if (direction == RIGHT_DIRECTION) {
            orientation = rightDirection;
        } else {
            orientation = leftDirection;
        }
    }

    private void forwardMove() {
        switch (orientation) {
            case NORTH_ORIENTATION:
                forwardMove(coordX, coordY + 1);
                break;
            case EAST_ORIENTATION:
                forwardMove(coordX + 1, coordY);
                break;
            case WEST_ORIENTATION:
                forwardMove(coordX - 1, coordY);
                break;
            case SOUTH_ORIENTATION:
                forwardMove(coordX, coordY - 1);
                break;
            default:
                throw new RuntimeException("Wrong orientation");
        }
    }

    private void forwardMove(int coordX, int coordY) {
        boolean canMove = Plateau.getInstance().canMove(coordX, coordY);
        if (canMove) {
            this.coordX = coordX;
            this.coordY = coordY;
        } else {
            throw new RuntimeException("This rover cannot move to this position.");
        }
    }

    @Override
    public String toString() {
        return coordX + " " + coordY + " " + orientation;
    }

}