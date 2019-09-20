import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileReader.readFile();
        Plateau plateauTerra = createPlateau(lines);

        for (int i = 1; i < lines.size(); i += 2) {
            Rover rover = createRoverInPlateau(lines, plateauTerra, i);
            move(lines, i, rover);
        }

        printAllRovers(plateauTerra);
    }

    private static Plateau createPlateau(List<String> lines) {
        String[] plateau = lines.get(0).split(" ");
        return Plateau.getInstance(Integer.parseInt(plateau[0]), Integer.parseInt(plateau[1]));
    }

    private static void move(List<String> lines, int i, Rover rover) {
        char[] moveOrientations = lines.get(i + 1).toCharArray();
        rover.move(moveOrientations);
    }

    private static Rover createRoverInPlateau(List<String> lines, Plateau plateauTerra, int i) {
        String[] roverStartCoords = lines.get(i).split(" ");

        Rover rover = new Rover(Integer.parseInt(roverStartCoords[0]), Integer.parseInt(roverStartCoords[1]), roverStartCoords[2].charAt(0));
        plateauTerra.getRovers().add(rover);
        return rover;
    }

    private static void printAllRovers(Plateau plateauTerra) {
        for (int i = 0; i < plateauTerra.getRovers().size(); i++) {
            System.out.println(plateauTerra.getRovers().get(i));
        }
    }
}