import com.google.common.io.Files;
import org.apache.commons.io.Charsets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Test6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newReader(new File("d:\\da_pidmidvvuv"), Charsets.UTF_16LE);
        String lineTxt;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            System.out.println(lineTxt);
        }
    }
}
