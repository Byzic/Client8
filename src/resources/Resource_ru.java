package resources;

import java.util.ListResourceBundle;

public class Resource_ru extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"back_button", "Назад"},
                    {"choose_button", "Выбрать файл"},

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

                    {"removeKey?", "Введите ключ квартиры, которую хотите удалить"},
                    {"furnish?", "Введите значение furnish(отделки): NONE," + " FINE," + " BAD;"},
                    {"lowerKey?", "Введите ключ(все квартиры с меньшим ключом будут удалены)"},
                    {"numberOfRoomsKey?", "Введите количество комнат(все квартиры с таким количеством будут удалены)"},



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
                    {"Exception16", "Значение не может быть пустой строкой"},
                    {"Exception17", "Введенное значение не соответствует Furnish: NONE, FINE, BAD"},

                    {"ioPaneError", "Произошла ошибка при отправке запроса на сервер!"},
                    {"classNotFoundError", "Произошла ошибка при получении ответа с сервера!"},

                    {"scriptOptionPaneError1", "Не удалось выполнить команду! Проверьте правильность ввода аргументов!\n"},
                    {"scriptOptionPaneError2", "Файл не найден"},

                    {"LoginSuccess", "Пользователь авторизован"},
                    {"UserIsNotFoundException", "Пользователь не найден \n Проверьте логин или пароль"},
                    {"RegisterSuccess", "Пользователь зарегистрирован"},
                    {"AlreadyExist", "Такой пользователь уже существует"},
                    {"ElemAlreadyExist", "Элемент с таким ключом уже сществует"},

                    {"DBExeption", "Произошла ошибка при обращении к базе данных!"},

                    {"CLEAR", "CLEAR: очистить коллекцию"},
                    {"COUNT_GREATER_THAN_FURNISH", "COUNT_GREATER_THAN_FURNISH: произошла ошибка при обращении к базе данных!"},
                    {"EXECUTE_SCRIPT", "EXECUTE_SCRIPT: исполнить скрипт из указанного файла"},
                    {"EXIT", "EXIT: завершить программу"},
                    {"HELP", "HELP: вывести справку по доступным командам"},
                    {"INFO", "INFO: вывести информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"},
                    {"INSERT", "INSERT: добавить новый элемент с заданным ключом"},
                    {"REMOVE_ALL_BY_NUMBER_OF_ROOMS", "REMOVE_ALL_BY_NUMBER_OF_ROOMS: удалить из коллекции все элементы, значение поля numberOfRooms которого эквивалентно заданному"},
                    {"REMOVE_KEY", "REMOVE_KEY: удалить элемент из коллекции по его ключу"},
                    {"REMOVE_LOWER_KEY", "REMOVE_LOWER_KEY: удалить из коллекции все элементы, ключ которых меньше, чем заданный"},
                    {"REPLACE_IF_GREATER", "REPLACE_IF_GREATER: заменить значение по ключу, если новое значение больше старого"},
                    {"REPLACE_IF_LOWER", "REPLACE_IF_LOWER: заменить значение по ключу, если новое значение меньше старого"},
                    {"SHOW", "SHOW: показать все элемены коллекции"},
                    {"UPDATE", "UPDATE: обновить значение элемента коллекции, id которого равен заданному"},

                    {"informationCollection", "Информация о коллекции"},
                    {"Type", "Тип:"},
                    {"DateInit", "Дата последней инициализации:"},
                    {"KolvoElem", "Количество элементов"},

                    {"CountFurnish", "Количество элементов с Furnish больше заданного: "},
                    {"update_button", "Оновить"},
                    {"filter_button", "Фильтр"},
                    {"reset_button", "Сброс"},











            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
