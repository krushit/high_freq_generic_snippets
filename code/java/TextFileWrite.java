import java.io.*;

public class TextFileWrite {

    public static void main(String[] args) {
        String path = "/Users/kagarwal/textFileWriter";
        String data = "Data\n";

        TextFileWrite fw = new TextFileWrite();
        fw.fileWriteExample(data,path);
    }

    public void fileWriteExample(String path, String data) {
        File file = new File(path);
        try(Writer output = new BufferedWriter(new FileWriter(file))) {
            output.write(data);
        }
        catch (IOException e) {
            System.out.println("Error writing to file...");
        }
    }
}
