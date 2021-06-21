package resources;

import java.util.ListResourceBundle;

public class Resource_ma extends ListResourceBundle {

    private static final Object[][] contents =
            {
                    {"back_button", "Назад"},
                    {"choose_button", "Избери датотека"},
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
                    {"furnish?", "Wprowadź wartość umeblowania: NONE," + " FINE," + " BAD;"},
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
                    {"Exception16", "Вредноста не може да биде празна низа"},
                    {"Exception17", "Внесената вредност не се совпаѓа Furnish: NONE, FINE, BAD"},

                    {"ioPaneError", "Се појави грешка при испраќање на барање до серверот!"},
                    {"classNotFoundError", "Настана грешка при примање одговор од серверот!"},

                    {"scriptOptionPaneError1", "Не успеав да ја извршам командата! Проверете ги точните аргументи! \n"},
                    {"scriptOptionPaneError2", "Датотеката не е пронајдена"},
                    {"RegisterSuccess", "Корисникот е регистриран"},
                    {"AlreadyExist", "Овој корисник веќе постои"},
                    {"ElemAlreadyExist", "Елемент со таков клуч веќе постои"},
                    {"DBExeption", "Настана грешка при пристапот до базата на податоци!"},

                    {"CLEAR", "CLEAR: јасна колекција"},
                    {"COUNT_GREATER_THAN_FURNISH", "COUNT_GREATER_THAN_FURNISH: Настана грешка при пристапот до базата на податоци!"},
                    {"EXECUTE_SCRIPT", "EXECUTE_SCRIPT: извршете ја скриптата од наведената датотека"},
                    {"EXIT", "EXIT: крај на програмата"},
                    {"HELP", "HELP: прикажете помош на достапните команди"},
                    {"INFO", "INFO: приказ на информации за колекцијата (тип, датум на иницијализација, број на елементи, итн.)"},
                    {"INSERT", "INSERT: додадете нова ставка со дадениот клуч"},
                    {"REMOVE_ALL_BY_NUMBER_OF_ROOMS", "REMOVE_ALL_BY_NUMBER_OF_ROOMS: отстранете ги од колекцијата сите ставки чијашто вредност на полето бројOfRooms е еквивалентна на наведената"},
                    {"REMOVE_KEY", "REMOVE_KEY: отстрани ставка од колекцијата со нејзиниот клуч"},
                    {"REMOVE_LOWER_KEY", "REMOVE_LOWER_KEY: отстранете ги сите ставки од колекцијата чијшто клуч е помал од наведениот клуч"},
                    {"REPLACE_IF_GREATER", "REPLACE_IF_GREATER: заменете ја вредноста со клуч ако новата вредност е поголема од старата"},
                    {"REPLACE_IF_LOWER", "REPLACE_IF_LOWER: заменете ја вредноста со клуч ако новата вредност е помала од старата"},
                    {"SHOW", "SHOW: прикажи ги сите ставки во колекцијата"},
                    {"UPDATE", "UPDATE: ажурирај ја вредноста на колекционерската ставка чиј ID е еднаков на дадениот"},

                    {"informationCollection", "Информации за колекцијата"},
                    {"Type", "Тип:"},
                    {"DateInit", "Последен датум на иницијализација:"},
                    {"KolvoElem", "Број на елементи"},

                    {"CountFurnish", "Бројот на артикли со мебел е поголем од наведениот:"},
                    {"update_button", "Ажурирање"},
                    {"filter_button", "Филтер"},
                    {"reset_button", "Ресетирање"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
