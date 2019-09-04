import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;
import java.nio.file.Files;

public class FileReader{

    private static final String FILE_PATH = "\\txt\\mars_commands.txt";

    public static void readFile() throws IOException {
        String currDir = Paths.get("").toAbsolutePath().toString();
        File flatFile = new File(currDir + FILE_PATH);
        
        List<String> lines = Files.readAllLines(flatFile.toPath());
        lines.removeAll(Collections.singletonList(""));

        String[] plateau = lines.get(0).split(" ");
        Plateau plateauTerra = new Plateau(Integer.parseInt(plateau[0]), Integer.parseInt(plateau[1]));
    }

    public static void main(String[] args) throws IOException{
        readFile();
    }

}