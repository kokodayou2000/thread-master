package file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class EchoFile {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fis = new FileOutputStream(new File("src/main/java/file/t"));
        while (true){
            TimeUnit.SECONDS.sleep(1);
            fis.write("A\n".getBytes(StandardCharsets.UTF_8));
        }
    }
}
