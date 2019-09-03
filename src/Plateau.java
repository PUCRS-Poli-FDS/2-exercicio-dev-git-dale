import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private int coordX;
    private int coordY;
    private List<Rover> rovers;

    Plateau(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        rovers = new ArrayList<>();
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(List<Rover> rovers) {
        this.rovers = rovers;
    }
}