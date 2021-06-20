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


                    {"UserIsNotFoundException", "Неточни корисничко име или лозинка"},

                    {"flatName", "Сопственик на стан"},
                    {"xyLable", "Локација"},
                    {"areaLable", "Area"},
                    {"numberLable", "Број на соби"},
                    {"furnishLable", "Finish"},
                    {"viewLable", "Преглед на прозорец"},
                    {"transportLable", "Број на транспорт"},
                    {"nameHouse", "Комплексно име"},
                    {"yearHouse", "Колку години беше пуштен во употреба"},
                    {"floorHouse", "Број на подови во куќата"},
                    {"insertButton", "Создади"},
                    {"keyLable", "Key"},
                    {"idLable", "id"},
                    {"updateButton", "Change"},

                    {"removeKey?", "Внесете го клучот од станот што сакате да го отстраните"},
                    {"lowerKey?", "Внесете го клучот (сите станови со помал клуч ќе бидат избришани)"},
                    {"numberOfRoomsKey?", "Внесете го бројот на соби (сите апартмани со овој број ќе бидат избришани)"},



                    {"Exception1", "Клучот е цел број"},
                    {"Exception2", "Клучот мора да биде поголема од 0"},
                    {"Exception3", "Името не може да биде празен стринг"},
                    {"Exception4", "Областа е број"},
                    {"Exception5", "Областа може да биде во опсегот од 0 до 741"},
                    {"Exception6", "Година на испорака и бројот на подови во куќата е цел број"},
                    {"Exception7", "Името на комплексни не може да биде празен стринг"},
                    {"Exception8", "Полето со годината на испорака на домот може да има вредност од 0 до 846"},
                    {"Exception9", "Бројот на подови во куќа мора да биде поголема од 0"},
                    {"Exception10", "Координатите мора да биде број"},
                    {"Exception11", "X coordinate мора да биде поголема од -107"},
                    {"Exception12", "Број на соби не може да биде низа"},
                    {"Exception13", "бројот на соби може да се движи од 0 до 11"},
                    {"Exception14", "Id мора да биде цел број"},
                    {"Exception15", "Id мора да биде поголем од 0"},

                    {"scriptOptionPaneError1", "Не успеав да ја извршам командата! Проверете ги точните аргументи! \n"},
                    {"scriptOptionPaneError2", "Датотеката не е пронајдена"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
