import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;
import java.nio.file.Files;

public class FileReader{

    private static final String FILE_PATH = "\\txt\\mars_commands.txt";

    public void readFile() throws IOException {
        String currDir = Paths.get("").toAbsolutePath().toString();
        File flatFile = new File(currDir + FILE_PATH);
        List<String> lines = Files.readAllLines(flatFile.toPath());
    }
}