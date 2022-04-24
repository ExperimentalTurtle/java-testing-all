import com.giorgi.example.GitVersionMojo;

@SuppressWarnings("ConstantConditions")
public class Demo {
    public static void main(String[] args) {
        System.out.println("This is my first program in java");

        // testing custom maven plugin dependency
        GitVersionMojo gitVersionMojo = new GitVersionMojo();
        gitVersionMojo.execute();

        boolean logResource = false;
        boolean logProperties = true;

        try {
            if (logResource) {
                ReadingResource readingResource = new ReadingResource();
                readingResource.getResources();
            }

            if (logProperties) {
                ReadingProperties readingProperties = new ReadingProperties();
                readingProperties.getProperties();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


//        Locale.setDefault();
    }
}
