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

                    {"flatName", "Propietario del Apartamento"},
                    {"xyLable", "Localización"},
                    {"areaLable", "Plaza"},
                    {"numberLable", "Number of rooms"},
                    {"furnishLable", "Finish"},
                    {"viewLable", "Vista de ventana"},
                    {"transportLable", "Número de transporte"},
                    {"nameHouse", "Nombre complejo"},
                    {"yearHouse", "Hace cuántos años se encargó"},
                    {"floorHouse", "Número de pisos de la casa"},
                    {"insertButton", "Create"},
                    {"keyLable", "Key"},
                    {"idLable", "id"},
                    {"updateButton", "Cambiar"},

                    {"removeKey?", "Ingresa la clave del apartamento que deseas eliminar"},

                    {"Exception1", "La clave es un número entero"},
                    {"Exception2", "La clave debe ser mayor que 0"},
                    {"Exception3", "El nombre no puede ser una cadena vacía"},
                    {"Exception4", "Area is a number"},
                    {"Exception5", "El área puede variar de 0 a 741"},
                    {"Exception6", "El año de finalización y el número de pisos de la casa es un número entero"},
                    {"Exception7", "El nombre complejo no puede ser una cadena vacía"},
                    {"Exception8", "El campo con el año de finalización de la casa puede tener un valor de 0 a 846"},
                    {"Exception9", "La cantidad de pisos de la casa debe ser mayor que 0"},
                    {"Exception10", "Las coordenadas deben ser un número"},
                    {"Exception11", "La coordenada x debe ser mayor que -107"},
                    {"Exception12", "Number of rooms can't be string"},
                    {"Exception13", "el número de habitaciones puede oscilar entre 0 y 11"},
                    {"Exception14", "Id debe ser un número entero"},
                    {"Exception15", "Id debe ser mayor que 0"},

                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
