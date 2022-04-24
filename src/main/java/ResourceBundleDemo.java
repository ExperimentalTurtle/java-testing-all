import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {
    public static void main(String[] args) {
        // set new locale
        Locale.setDefault(new Locale("ka", "GE"));
        Locale defaultLocale = Locale.getDefault();

        ResourceBundle message = ResourceBundle.getBundle("i18n/message", defaultLocale);

        System.out.println(message.getString("title"));
        System.out.println(defaultLocale);
    }
}
