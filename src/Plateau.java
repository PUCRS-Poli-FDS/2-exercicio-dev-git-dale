import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private static Plateau instance;
    
    private int coordX;
    private int coordY;
    private List<Rover> rovers;

    private Plateau(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
        rovers = new ArrayList<Rover>();
    }

    //Padrão Singleton
    public static synchronized Plateau getInstance(int coordX, int coordY) {
        if (instance == null)
            instance = new Plateau(coordX, coordY);
 
        return instance;
    }

     //Padrão Singleton
    public static synchronized Plateau getInstance() {
        if(instance == null) 
            //throw new Exception(""); Jogar exceção
        return instance;
    }
/*
    Plateau(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        rovers = new ArrayList<>();
    }
*/
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