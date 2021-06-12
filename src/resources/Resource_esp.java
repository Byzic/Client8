package resources;

import java.util.ListResourceBundle;

public class Resource_esp extends ListResourceBundle {

    private static final Object[][] contents =
            {
                    {"back_button", "De regreso"},
                    {"login_button", "Entrar"},
                    {"registration", "registrarse"},
                    {"startMenu_closeButton", "Cerca"},

                    {"login_passwordName", "Contraseña"},
                    {"login_loginName", "Acceso"},
                    {"login_name", "Entrar"},

                    {"register_passwordName", "Contraseña"},
                    {"register_confirmPassword", "confirmación de contraseña"},
                    {"register_loginName", "Acceso"},

                    {"UserIsNotFoundException", "Nombre de usuario o contraseña incorrectos"},


                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
