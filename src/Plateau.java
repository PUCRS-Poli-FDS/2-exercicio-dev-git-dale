import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private static Plateau instance;

    private int coordX;
    private int coordY;
    private List<Rover> rovers;

    private Plateau(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.rovers = new ArrayList<>();
    }

    public static synchronized Plateau getInstance(int coordX, int coordY) {
        if (instance == null)
            instance = new Plateau(coordX, coordY);
        return instance;
    }

    public static synchronized Plateau getInstance() {
        if (instance == null)
            throw new RuntimeException();
        return instance;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public boolean canMove(int coordX, int coordY) {
        if (coordX > this.coordX) {
            return false;
        } else if (coordY > this.coordY) {
            return false;
        } else if (coordX < 0 || coordY < 0) {
            return false;
        }
        return true;
    }
}