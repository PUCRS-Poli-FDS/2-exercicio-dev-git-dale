public class Rover {
    private int coordX;
    private int coordY;
    private char orientation;

    public Rover(int coordX, int coordY, char orientation) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.orientation = orientation;
    }

    //TODO: fazer os gets e sets dos atributos para o teste unitários

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
            move(coordX, coordY + 1);
            break;
        case 'E':
            move(coordX + 1, coordY);
            break;
        case 'W':
            move(coordX - 1, coordY);
            break;
        case 'S':
            move(coordX, coordY - 1);
            break;
        default:
            throw new RuntimeException("Wrong orientation");
        }
    }

    public void move(char[] orientation) {
        for (char var : orientation) {
            if (var == 'L' || var == 'R') {
                changeOrientation(var);
            } else if (var == 'M') {
                forwardMove();
            }
        }
    }

    private void move(int coordX, int coordY) {
        boolean cm = ((coordX < 0 && coordX < Plateau.getInstance().getCoordX())
                || (coordY < 0 && coordY < Plateau.getInstance().getCoordY()))
                && Plateau.getInstance().getPlateau()[coordX][coordY] == 0;
        if(cm){
            Plateau.getInstance().getPlateau()[this.coordX][this.coordY] = 0;
            this.coordX = coordX;
            this.coordY = coordY;
            Plateau.getInstance().getPlateau()[this.coordX][this.coordY] = 1;
        } else {
            System.out.println("Invalid position");
        }
    }

    @Override
    public String toString() {
        return coordX + " " + coordY + " " + orientation;
    }
}