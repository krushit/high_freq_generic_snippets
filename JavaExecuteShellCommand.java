import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaExecuteShellCommand {

    public static void main(String[] args) {

        String shellCommand = "ls -la ";

        if (args.length > 0) {
            shellCommand = args[0];
        }

        System.out.println(shellCommand);

        String output = executeShellCommand(shellCommand);

        System.out.println(output);

    }

    private static String executeShellCommand(String shellCommand) {

        StringBuffer outputBuilder = new StringBuffer();

        Process newProcess;
        try {
            //Execute the shell command
            newProcess = Runtime.getRuntime().exec(shellCommand);
            
            //Wait for full execution
            newProcess.waitFor();

            //Output Reader
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(newProcess.getInputStream()));

            //Read and build the output
            String nextOutputLine;
            while ((nextOutputLine = outputReader.readLine())!= null) {
                outputBuilder.append(nextOutputLine + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Return final output
        return outputBuilder.toString();
    }
}
