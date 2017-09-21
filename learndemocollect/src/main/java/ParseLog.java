import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseLog {
    public static void main(String[] args) throws IOException {
        String path = "d:\\microsoft_20170920.log";

        List<String> lines = FileUtils.readLines(new File(path), "utf-8");

        List<String> result = new ArrayList<>();


        String id = "";
        int filter = 0;
        int docids = 0;
        int send = 0;
        result.add("id" + "\t" + "Total" + "\t" + "NotSend" + "\t" + "Send");
        for (String line : lines) {
            if (line.startsWith("-----------import XiaobingData ")) {
                if (StringUtils.isNotBlank(id)) {
                    //commit
                    result.add(id + "\t" + docids + "\t" + filter + "\t" + send);

                }
                id = line.substring("-----------import XiaobingData ".length(),"-----------import XiaobingData ".length()+10);
                filter = 0;
                docids = 0;
                send = 0;
            }

            if (line.contains("not be sent")) {
                filter++;
            }

            if (line.contains("docId")) {
                docids++;
            }

            if (line.contains("resultCode")) {
                send++;
            }

        }

        result.add(id + "\t" + docids + "\t" + filter + "\t" + send);
        File f = new File("d:\\result-20.txt");
        if (f.exists()) {
            f.delete();
        }

        f.createNewFile();
        FileUtils.writeLines(f, result);
    }
}
