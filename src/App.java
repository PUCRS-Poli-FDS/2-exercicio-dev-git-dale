import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException{
        List<String> lines = FileReader.readFile();

        Plateau plateau = Plateau.getInstance(5,5);
        //String[] plateau = lines.get(0).split(" ");
        //Plateau plateauTerra = new Plateau(Integer.parseInt(plateau[0]), Integer.parseInt(plateau[1]));

        for (int i = 1; i < lines.size(); i+=2) {
            String[] roverAttr = lines.get(i).split(" ");

            Rover rover = new Rover(Integer.parseInt(roverAttr[0]), Integer.parseInt(roverAttr[1]), roverAttr[2].charAt(0));
            plateauTerra.getRovers().add(rover);

           char[] orientation = lines.get(i+1).toCharArray(); 
           rover.move(orientation);
        }

        for (int i = 0; i < plateauTerra.getRovers().size(); i++) {
            System.out.println(plateauTerra.getRovers().get(i));
        }
    }
}