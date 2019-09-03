import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

public class FileReader{
    String file = "txt\\mars_commands.txt";

    public FileReader() {

    }

    public void readFile() {

        String currDir = Paths.get(""). toAbsolutePath().toString();
        String file = currDir + "\\" + this.file;
        Path path = Paths.get(file);
                
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
            


            String linha = null;

            int mi = Integer.parseInt(sc.nextLine().split("\\s+(\\/\\/ )")[0]);
            int mf = Integer.parseInt(sc.nextLine().split("\\s+(\\/\\/ )")[0]);

            while (sc.hasNext()) {
                linha = sc.nextLine();
                String instrucao = linha.split("\\s+(\\/\\/ )")[0];
                mem.add(instrucao);
            }
            
            Gerenciador gm = new Gerenciador(mi, mf, mem);
            System.out.println(gm);

        } catch (IOException e) {
            System.out.println("Excecao: " + e.getMessage());
        }
    }
}