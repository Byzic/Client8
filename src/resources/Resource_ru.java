package resources;

import java.util.ListResourceBundle;

public class Resource_ru extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"back_button", "Назад"},
                    {"login_button", "Войти"},
                    {"registration", "Регистрация"},
                    {"startMenu_closeButton", "Закрыть"},

                    {"login_passwordName", "Пароль"},
                    {"login_loginName", "Логин"},
                    {"login_name", "Войти"},

                    {"register_passwordName", "Пароль"},
                    {"register_confirmPassword", "Подтверждение пароля"},
                    {"register_loginName", "Логин"},


                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
