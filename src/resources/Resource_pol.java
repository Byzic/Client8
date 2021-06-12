package resources;

import java.util.ListResourceBundle;

public class Resource_pol extends ListResourceBundle {

    private static final Object[][] contents =
            {
                    {"back_button", "z powrotem"},
                    {"login_button", "Wejść"},
                    {"registration", "Zameldować się"},
                    {"startMenu_closeButton", "Blisko"},

                    {"login_passwordName", "Hasło"},
                    {"login_loginName", "Zaloguj sie"},
                    {"login_name", "Wejść"},

                    {"register_passwordName", "Hasło"},
                    {"register_confirmPassword", "Potwierdzenie hasła"},
                    {"register_loginName", "Zaloguj sie"},

                    {"UserIsNotFoundException", "Niepoprawna nazwa użytkownika lub hasło"},


                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
