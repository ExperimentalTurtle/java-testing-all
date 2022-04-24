import java.util.Locale;

public class LocaleDemo {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();

        System.out.println(defaultLocale.getLanguage());
        System.out.println(defaultLocale.getCountry());
        System.out.println(defaultLocale);

        // set default locale for my application
        Locale.setDefault(new Locale("ka", "GE"));

        defaultLocale = Locale.getDefault();

        System.out.println(defaultLocale.getLanguage());
        System.out.println(defaultLocale.getCountry());
        System.out.println(defaultLocale);
    }
}
