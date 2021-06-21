package resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleBundle {
    private static ResourceBundle bundle_ma = ResourceBundle.getBundle("resources.Resource_ma");
    private static ResourceBundle bundle_ru = ResourceBundle.getBundle("resources.Resource_ru");
    private static ResourceBundle bundle_pol = ResourceBundle.getBundle("resources.Resource_pol");
    private static ResourceBundle bundle_esp = ResourceBundle.getBundle("resources.Resource_esp");

    private static ResourceBundle currentBundle = bundle_ru;

    public static void setBundle(String lang) {
        switch (lang) {
            case "Русский":
                currentBundle = bundle_ru;
                Locale.setDefault(new Locale("ru", "RU"));
                break;
            case "Македонски":
                currentBundle = bundle_ma;
                Locale.setDefault(new Locale("mk", "MK"));
                break;
            case "Polski":
                currentBundle = bundle_pol;
                break;
            case "Español":
                currentBundle = bundle_esp;
                break;
        }
    }

    public static ResourceBundle getCurrentBundle() {
        return currentBundle;
    }
}
