import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransUnderline2Camel {
    public static void main(String[] arg) throws IOException {
        String path = "d:\\param.txt";
        String encoding = "UTF-8";
        List<String> rows = FileUtils.readLines(new File(path), encoding);
        List<String> trans = new ArrayList<>();
        rows.forEach(s -> {
            String s1 = s.trim();
            String s2 = "";
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (c == '_') {
                    i++;
                    char leter = s1.charAt(i);
                    s2 += StringUtils.upperCase(String.valueOf(leter));
                } else {
                    s2 += c;
                }
            }
            trans.add(s2);
        });

        trans.forEach(s -> {
            System.out.println("private String " + s + ";");
        });

    }
}
