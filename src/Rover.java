public class Rover {
    private int coordX;
    private int coordY;
    private char orientation;

    public Rover(int coordX, int coordY, char orientation) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.orientation = orientation;
    }

    public void changeOrientation(char direction) {
        switch (orientation) {
            case 'N':
                changeOrientation(direction, 'E', 'W');
                break;
            case 'E':
                changeOrientation(direction, 'S', 'N');
                break;
            case 'W':
                changeOrientation(direction, 'N', 'S');
                break;
            case 'S':
                changeOrientation(direction, 'W', 'E');
                break;
            default:
                throw new RuntimeException("Wrong orientation");
        }
    }

    private void changeOrientation(char direction, char rightDirection, char leftDirection) {
        if (direction == 'R') {
            orientation = rightDirection;
        } else if (direction == 'L') {
            orientation = leftDirection;
        } else {
            throw new RuntimeException("Invalid direction");
        }
    }

    public void move() {
        switch (orientation) {
            case 'N':
                coordY++;
                break;
            case 'E':
                coordX++;
                break;
            case 'W':
                coordX--;
                break;
            case 'S':
                coordY--;
                break;
            default:
                throw new RuntimeException("Wrong orientation");
        }
    }

    @Override
    public String toString() {
        return coordX + " " + coordY + " " + orientation;
    }
}