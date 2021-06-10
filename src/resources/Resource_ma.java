package resources;

import java.util.ListResourceBundle;

public class Resource_ma extends ListResourceBundle {

    private static final Object[][] contents =
            {
                    {"back_button", "Назад"},
                    {"login_button", "Влезете"},
                    {"registration", "Пријавување"},
                    {"startMenu_closeButton", "Затвори"},

                    {"login_passwordName", "Лозинка"},
                    {"login_loginName", "Логирај Се"},
                    {"login_name", "Влезете"},

                    {"register_passwordName", "Лозинка"},
                    {"register_confirmPassword", "Потврда на лозинка"},
                    {"register_loginName", "Логирај Се"},


                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
