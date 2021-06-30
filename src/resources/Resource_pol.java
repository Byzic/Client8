package resources;

import java.util.ListResourceBundle;

public class Resource_pol extends ListResourceBundle {

    private static final Object[][] contents =
            {
                    {"back_button", "z powrotem"},
                    {"choose_button", "Wybierz plik"},
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

                    {"flatName", "Właściciel mieszkania"},
                    {"xyLable", "Lokalizacja"},
                    {"areaLable", "area"},
                    {"numberLable", "Liczba pokoi"},
                    {"furnishLable", "Finish"},
                    {"viewLable", "Widok okna"},
                    {"transportLable", "Numer transportu"},
                    {"nameHouse", "Złożona nazwa"},
                    {"yearHouse", "Ile lat temu oddano do użytku"},
                    {"floorHouse", "Liczba pięter w domu"},
                    {"insertButton", "Utwórz"},
                    {"keyLable", "Key"},
                    {"idLable", "id"},
                    {"updateButton", "Zmień"},

                    {"removeKey?", "Wprowadź klucz do mieszkania, które chcesz usunąć"},
                    {"furnish?", "Wprowadź wartość umeblowania: NONE," + " FINE," + " BAD;"},
                    {"lowerKey?", "Wprowadź klucz (wszystkie mieszkania z niższym kluczem zostaną usunięte)"},
                    {"numberOfRoomsKey?", "Wpisz liczbę pokoi (wszystkie mieszkania o tym numerze zostaną usunięte)"},


                    {"Exception1", "Kluczem jest liczba całkowita"},
                    {"Exception2", "Klucz musi być większy niż 0"},
                    {"Exception3", "Nazwa nie może być pustym ciągiem"},
                    {"Exception4", "Powierzchnia jest liczba"},
                    {"Exception5", "Powierzchnia może wynosić od 0 do 741"},
                    {"Exception6", "Rok ukończenia i liczba pięter w domu jest liczbą całkowitą"},
                    {"Exception7", "Złożona nazwa nie może być pustym ciągiem"},
                    {"Exception8", "Pole z rokiem ukończenia domu może mieć wartość od 0 do 846"},
                    {"Exception9", "Liczba pięter w domu musi być większa niż 0"},
                    {"Exception10", "Współrzędne muszą być liczbą"},
                    {"Exception11", "Współrzędna x musi być większa niż -107"},
                    {"Exception12", "Liczba pokoi nie może być ciągiem"},
                    {"Exception13", "liczba pokoi może wynosić od 0 do 11"},
                    {"Exception14", "Id musi być liczbą całkowitą"},
                    {"Exception15", "Id musi być większy niż 0"},
                    {"Exception16", "Wartość nie może być pustym ciągiem"},
                    {"Exception17", "Wprowadzona wartość nie pasuje Furnish: NONE, FINE, BAD"},

                    {"ioPaneError", "Wystąpił błąd podczas wysyłania żądania do serwera!"},
                    {"classNotFoundError", "Wystąpił błąd podczas otrzymywania odpowiedzi z serwera!"},

                    {"scriptOptionPaneError1", "Nie udało się wykonać polecenia! Sprawdź poprawne argumenty!\n"},
                    {"scriptOptionPaneError2", "Nie znaleziono pliku"},

                    {"LoginSuccess", "Użytkownik jest autoryzowany"},
                    {"UserIsNotFoundException", "Nie znaleziono użytkownika \n Sprawdź nazwę użytkownika lub hasło"},
                    {"RegisterSuccess", "Użytkownik jest zarejestrowany"},
                    {"AlreadyExist", "Ten użytkownik już istnieje"},
                    {"ElemAlreadyExist", "Element z takim kluczem już istnieje"},
                    {"DBExeption", "Wystąpił błąd podczas dostępu do bazy danych!"},

                    {"CLEAR", "CLEAR: wyczyść kolekcję"},
                    {"COUNT_GREATER_THAN_FURNISH", "COUNT_GREATER_THAN_FURNISH: Wystąpił błąd podczas dostępu do bazy danych!"},
                    {"EXECUTE_SCRIPT", "EXECUTE_SCRIPT: wykonaj skrypt z określonego pliku"},
                    {"EXIT", "EXIT: zakończenie programu"},
                    {"HELP", "HELP: wyświetl pomoc na temat dostępnych poleceń"},
                    {"INFO", "INFO: wyświetl informacje o kolekcji (typ, data inicjalizacji, liczba elementów itp."},
                    {"INSERT", "INSERT: dodaj nową pozycję z podanym kluczem"},
                    {"REMOVE_ALL_BY_NUMBER_OF_ROOMS", "REMOVE_ALL_BY_NUMBER_OF_ROOMS: usuń z kolekcji wszystkie elementy, których wartość pola numberOfRooms jest równoważna podanej"},
                    {"REMOVE_KEY", "REMOVE_KEY: usuń element z kolekcji za pomocą jego klucza"},
                    {"REMOVE_LOWER_KEY", "REMOVE_LOWER_KEY: usuń wszystkie elementy z kolekcji, których klucz jest mniejszy niż określony klucz"},
                    {"REPLACE_IF_GREATER", "REPLACE_IF_GREATER: zastąp wartość kluczem, jeśli nowa wartość jest większa niż stara"},
                    {"REPLACE_IF_LOWER", "REPLACE_IF_LOWER: zastąp wartość kluczem, jeśli nowa wartość jest mniejsza niż stara"},
                    {"SHOW", "SHOW: pokaż wszystkie elementy kolekcji"},
                    {"UPDATE", "UPDATE: zaktualizuj wartość elementu kolekcji o id równym podanemu"},


                    {"Was_Deleted", "Liczba mieszkań, które zostały usunięte:"},
                    {"ElemDelete", "Element z kluczem został usunięty:"},
                    {"ElemReplace", "Element z kluczem został zastąpiony:"},
                    {"notExist", "Żadna pozycja z tym kluczem nie istnieje"},
                    {"anotherUser", "Obiekty należące do innych użytkowników są tylko do odczytu!"},
                    {"less", "Mieszkanie z tym kluczem nie zostało wymienione, ponieważ jest mniejsze lub równe istniejącemu"},
                    {"bigger", "Mieszkanie z tym kluczem nie zostało wymienione, ponieważ jest większe lub równe istniejącemu"},
                    {"idNotExist", "Element o tym identyfikatorze nie istnieje. Nie można zaktualizować wartości nieistniejącego elementu kolekcji"},
                    {"Was_Updated", "Element kolekcji o tym identyfikatorze został pomyślnie zastąpiony:"},
                    {"clear", "Wszystkie elementy należące do tego użytkownika zostały usunięte"},

                    {"informationCollection", "Informacje o kolekcji"},
                    {"Type", "Typ:"},
                    {"DateInit", "Data ostatniej inicjalizacji:"},
                    {"KolvoElem", "Liczba elementów"},

                    {"CountFurnish", "Liczba elementów z Furnish jest większa niż podana:"},
                    {"update_button", "Aktualizuj"},
                    {"filter_button","Filtr"},
                    {"reset_button", "Resetuj"},
                    {"filterbutton", "Filtr"},
                    {"filter_label1", "Pole filtra"},
                    {"filter_label2", "Argument"},
                    {"filter_label3", "Typ filtra"},
                    {"Insert", "Element o podanym kluczu został pomyślnie dodany"},

                    {"Key", "клуч: "},
                    {"Flat №", "рамни №: "},
                    {"Date", "(датум на внесување во протоколот "},
                    {"Name", "Име на сопственикот: "},
                    {"Place", "Место за меморандуми: "},
                    {"Area", "Област: "},
                    {"Rooms", "Број на соби: "},
                    {"Furnish", "Завршувањето: "},
                    {"View", "Поглед од прозорецот: "},
                    {"Transport", "Колку оди транспортот: "},
                    {"House", "Информации за куќата: "},
                    {"HouseName", "Комплексно име: "},
                    {"Year", "година на испорака: "},
                    {"Floors", "Број на подови: "},
                    {"null", "null"},



                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
