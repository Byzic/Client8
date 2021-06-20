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

                    {"scriptOptionPaneError1", "Nie udało się wykonać polecenia! Sprawdź poprawne argumenty!\n"},
                    {"scriptOptionPaneError2", "Nie znaleziono pliku"},



                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
