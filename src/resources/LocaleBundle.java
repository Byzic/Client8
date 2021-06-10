package resources;

import java.util.ResourceBundle;

public class LocaleBundle {
    private static ResourceBundle bundle_ma = ResourceBundle.getBundle("resources.Resource_ma");
    private static ResourceBundle bundle_ru = ResourceBundle.getBundle("resources.Resource_ru");
    private static ResourceBundle bundle_pol = ResourceBundle.getBundle("resources.Resource_pol");
    private static ResourceBundle bundle_esp = ResourceBundle.getBundle("resources.Resource_esp");

    private static ResourceBundle currentBundle = bundle_ru;

    public static void setBundle(String lang) {
        switch (lang) {
            case "Russian":
                currentBundle = bundle_ru;
                break;
            case "Македонски":
                currentBundle = bundle_ma;
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
