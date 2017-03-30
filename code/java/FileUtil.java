import java.io.*;

public class FileUtil {

    public static void main(String[] args) {
        String path = "/Users/kagarwal/textFileWriter";
        String data = "Data1\nData2\nData3";

        FileUtil fw = new FileUtil();
        fw.fileWrite(path,data);

        System.out.println(fw.fileRead(path));
    }

    public void fileWrite(String path, String data) {
        File file = new File(path);
        try(Writer output = new BufferedWriter(new FileWriter(file))) {
            output.write(data);
        }
        catch (IOException e) {
            System.out.println("Error writing to file...");
        }
    }

    public String fileRead(String path) {

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
}
