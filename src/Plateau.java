import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private static Plateau instance;
    
    private int coordX;
    private int coordY;
    private int[][] plateau;
    private List<Rover> rovers;

    private Plateau(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
        plateau = new int[coordX][coordY];
    }

    public static synchronized Plateau getInstance(int coordX, int coordY) {
        if (instance == null)
            instance = new Plateau(coordX, coordY);
        return instance;
    }

    public static synchronized Plateau getInstance() {
        if(instance == null)
            throw new RuntimeException();
        return instance;
    }
    
    public int[][] getPlateau(){ return plateau;}

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