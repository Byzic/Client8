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


                    {"UserIsNotFoundException", "Неправильное имя пользователя или пароль"},


                    {"flatName", "Владелец квартиры"},
                    {"xyLable", "Местоположение"},
                    {"areaLable", "Площадь"},
                    {"numberLable", "Количество комнат"},
                    {"furnishLable", "Отделка"},
                    {"viewLable", "Вид из окна"},
                    {"transportLable", "Количество транспорта"},
                    {"nameHouse", "Название комплексаь"},
                    {"yearHouse", "Сколько лет назад был сдан"},
                    {"floorHouse", "Количество этажей в доме"},
                    {"insertButton", "Создать"},
                    {"updateButton", "Изменить"},
                    {"keyLable", "Ключ"},
                    {"idLable", "id"},



                    {"Exception1", "Ключ должен быть целым числом"},
                    {"Exception2", "Ключ должен быть больше 0"},
                    {"Exception3", "Имя не может быть пустой строкой"},
                    {"Exception4", "Площадь является числом"},
                    {"Exception5", "Площадь может быть в диапазоне от 0 до 741"},
                    {"Exception6", "Год сдачи и количество этажей в доме целое число"},
                    {"Exception7", "Название комплекса не может быть пустой строкой"},
                    {"Exception8", "Поле с годом сдачи дома может иметь значение от 0 до 846"},
                    {"Exception9", "Количество этажей в доме должно быть больше 0"},
                    {"Exception10", "Координаты должны быть числом"},
                    {"Exception11", "Координата x должна быть больше -107"},
                    {"Exception12", "Количество комнат не может быть строкой"},
                    {"Exception13", "количество комнат может быть в диапазоне от 0 до 11"},
                    {"Exception14", "Id должно быть целым числом"},
                    {"Exception15", "Id должно быть больше 0"},




            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
