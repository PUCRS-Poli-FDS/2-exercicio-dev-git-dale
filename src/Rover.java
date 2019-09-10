public class Rover {
    private int coordX;
    private int coordY;
    private char orientation;

    public Rover(int coordX, int coordY, char orientation) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.orientation = orientation;
    }

    private void changeOrientation(char direction) {
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

    private void forwardMove() {
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

    public void move(char[] orientation) {
        for (char var : orientation) {
            if(var == 'L' || var == 'R') {
                changeOrientation(var);
            }else if (var == 'M') {
                forwardMove();
            }
        }
    }
    public boolean canMove(int coordX, int coordY){
        boolean cm = (coordX < 0 && coordX < Plateau.getInstance().getCoordX()) ||
                     (coordY < 0 && coordY < Plateau.getInstance().getCoordY());   
        return cm;
    } 

    @Override
    public String toString() {
        return coordX + " " + coordY + " " + orientation;
    }
}