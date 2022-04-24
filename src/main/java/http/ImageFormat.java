package http;

import java.util.Locale;

public enum ImageFormat {
    JPG, PNG, GIF;

    public static ImageFormat fromString(String formatName) {
        final String formatNameLowerCased = formatName.toLowerCase();

        return switch (formatNameLowerCased) {
            case "jpg", "" -> ImageFormat.JPG;
            case "png" -> ImageFormat.PNG;
            case "gif" -> ImageFormat.GIF;
            default -> throw new IllegalStateException("Unexpected value: " + formatName.toLowerCase(Locale.ROOT));
        };
    }
}
