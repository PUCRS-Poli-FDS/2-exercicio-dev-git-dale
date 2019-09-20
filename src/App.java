import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileReader.readFile();

        String[] plateau = lines.get(0).split(" ");
        Plateau plateauTerra = Plateau.getInstance(Integer.parseInt(plateau[0]), Integer.parseInt(plateau[1]));

        for (int i = 1; i < lines.size(); i += 2) {
            String[] roverStartCoords = lines.get(i).split(" ");

            Rover rover = new Rover(Integer.parseInt(roverStartCoords[0]), Integer.parseInt(roverStartCoords[1]), roverStartCoords[2].charAt(0));
            plateauTerra.getRovers().add(rover);

            char[] moveOrientations = lines.get(i + 1).toCharArray();
            rover.move(moveOrientations);
        }

        for (int i = 0; i < plateauTerra.getRovers().size(); i++) {
            System.out.println(plateauTerra.getRovers().get(i));
        }
    }
}