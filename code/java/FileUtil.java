import java.io.*;
import java.util.UUID;

public class FileUtil {

    public static void main(String[] args) {
        fileWrite("/Users/kagarwal/textFileWriter","Line1\nLine2\nLine3");
        System.out.println(fileRead("/Users/kagarwal/textFileWriter"));
        System.out.println(genUniqueFileName());
    }

    public static void fileWrite(String path, String data) {
        File file = new File(path);
        try(Writer output = new BufferedWriter(new FileWriter(file))) {
            output.write(data);
        }
        catch (IOException e) {
            System.out.println("Error writing to file...");
        }
    }

    public static String fileRead(String path) {

        StringBuilder outputBuilder = new StringBuilder("");

        File file = new File(path);
        try (Reader input = new BufferedReader(new FileReader(file))) {
            while(input.ready()) {
                outputBuilder.append((char)input.read());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found...");
        }
        catch (IOException e) {
            System.out.println("Error reading from file...");
        }
        return outputBuilder.toString();
    }

    public static String genUniqueFileName() {
        return UUID.randomUUID().toString();
    }
}
