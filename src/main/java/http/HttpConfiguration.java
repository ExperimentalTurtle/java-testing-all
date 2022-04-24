package http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class HttpConfiguration {
    private static HttpConfiguration INSTANCE;
    private final URL webPageUrl;
    private final ImageFormat imageFormat;
    private final int imageMaxNumber;
    private final Path imageOutputFolder;

    private HttpConfiguration() throws IOException {
        try (InputStream inputStream = HttpConfiguration.class.getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            webPageUrl = URI.create(properties.getProperty("webpage.url")).toURL();
            imageFormat = ImageFormat.fromString(properties.getProperty("image.format"));
            imageMaxNumber = Integer.parseInt(properties.getProperty("image.max-number"));
            imageOutputFolder = Paths.get(properties.getProperty("image.output-folder"));
        }
    }

    public static HttpConfiguration getInstance() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new HttpConfiguration();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        return INSTANCE;
    }

    public URL getWebPageUrl() {
        return webPageUrl;
    }

    public ImageFormat getImageFormat() {
        return imageFormat;
    }

    public int getImageMaxNumber() {
        return imageMaxNumber;
    }

    public Path getImageOutputFolder() {
        return imageOutputFolder;
    }
}
