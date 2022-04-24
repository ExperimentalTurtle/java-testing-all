import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadingProperties {
    public void getProperties() throws Exception {
        InputStream propertiesStream = getClass().getResourceAsStream("/config.properties");

        if (propertiesStream != null) {
            // reading properties
            Properties props = new Properties();
            props.load(propertiesStream);
            String something = props.getProperty("something", "default value");
            System.out.println(something);

            // setting new property
            props.setProperty("testing", "321");
            String testing = props.getProperty("testing");
            System.out.println(testing);

            // storing properties
            Path someOtherPropsPath = Paths.get("other.properties");
            OutputStream outputStream = Files.newOutputStream(someOtherPropsPath);
            props.store(outputStream, null);
            System.out.println("stored");
        }
    }
}
