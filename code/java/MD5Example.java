import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example {
    public static void main(String[] args) {
        System.out.println(getMD5Hash("input"));
    }

    public static String getMD5Hash(String input) {

        String algorithm = "MD5";
        String outputHash = "";

        try{
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(input.getBytes(), 0, input.length());
            outputHash = new BigInteger(1, messageDigest.digest()).toString();
        }
        catch (NoSuchAlgorithmException e) {
            System.out.print(algorithm + " algorithm not found...");
        }
        return outputHash;
    }

}
