import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadingResource {
    public void getResources() throws Exception {
        InputStream textStream = getClass().getResourceAsStream("stuff/test.txt");

        if (textStream == null) {
            throw new Exception("input stream not found");
        }

        InputStreamReader inputStreamReader = new InputStreamReader(textStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String text;

        while ((text = bufferedReader.readLine()) != null) {
            System.out.println(text);
        }
    }
}
