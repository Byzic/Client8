package resources;

import java.util.ListResourceBundle;

public class Resource_esp extends ListResourceBundle {

    private static final Object[][] contents =
            {
                    {"back_button", "De regreso"},
                    {"choose_button", "Choose file"},
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
                    {"furnish?", "Ingrese el valor de suministro: NONE," + " FINE," + " BAD;"},
                    {"lowerKey?", "Introduzca la clave (se eliminarán todos los apartamentos con una clave inferior)"},
                    {"numberOfRoomsKey?", "Ingresa el número de habitaciones (se eliminarán todos los apartamentos con este número)"},

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
                    {"Exception16", "El valor no puede ser una cadena vacía"},
                    {"Exception17", "El valor ingresado no coincide Furnish: NONE, FINE, BAD"},

                    {"ioPaneError", "¡Se produjo un error al enviar una solicitud al servidor!"},
                    {"classNotFoundError", "¡Ocurrió un error al recibir una respuesta del servidor!"},

                    {"scriptOptionPaneError1", "No se pudo ejecutar el comando. ¡Verifique los argumentos correctos! \n"},
                    {"scriptOptionPaneError2", "Archivo no encontrado"},

                    {"LoginSuccess", "El usuario está autorizado"},
                    {"UserIsNotFoundException", "Usuario no encontrado \n Verificar nombre de usuario o contraseña"},

                    {"LoginSuccess", "Корисникот е овластен"},
                    {"UserIsNotFoundException", "Корисникот не е пронајден \n Проверете го корисничкото име или лозинката"},
                    {"RegisterSuccess", "El usuario está registrado"},
                    {"AlreadyExist", "Este usuario ya existe"},
                    {"ElemAlreadyExist", "Ya existe un elemento con esa clave"},
                    {"DBExeption", "¡Se produjo un error al acceder a la base de datos!"},

                    {"CLEAR", "CLEAR: borrar colección"},
                    {"COUNT_GREATER_THAN_FURNISH", "COUNT_GREATER_THAN_FURNISH: ¡Se produjo un error al acceder a la base de datos!"},
                    {"EXECUTE_SCRIPT", "EXECUTE_SCRIPT: ejecuta el script desde el archivo especificado"},
                    {"EXIT", "EXIT: finalizar el programa"},
                    {"HELP", "HELP: mostrar ayuda sobre los comandos disponibles"},
                    {"INFO", "INFO: muestra información sobre la colección (tipo, fecha de inicialización, número de elementos, etc."},
                    {"INSERT", "INSERT: agrega un nuevo elemento con la clave dada"},
                    {"REMOVE_ALL_BY_NUMBER_OF_ROOMS", "REMOVE_ALL_BY_NUMBER_OF_ROOMS: eliminar de la colección todos los elementos cuyo valor de campo numberOfRooms es equivalente al especificado"},
                    {"REMOVE_KEY", "REMOVE_KEY: eliminar un elemento de la colección por su clave"},
                    {"REMOVE_LOWER_KEY", "REMOVE_LOWER_KEY: elimina todos los elementos de la colección cuya clave es menor que la clave especificada"},
                    {"REPLACE_IF_GREATER", "REPLACE_IF_GREATER: reemplaza el valor por clave si el nuevo valor es mayor que el anterior"},
                    {"REPLACE_IF_LOWER", "REPLACE_IF_LOWER: reemplaza el valor por clave si el nuevo valor es menor que el anterior"},
                    {"SHOW", "SHOW: mostrar todos los elementos de la colección"},
                    {"UPDATE", "UPDATE: actualiza el valor del elemento de la colección cuya identificación es igual a la dada"},

                    {"Was_Deleted", "Número de apartamentos que se han eliminado:"},
                    {"ElemDelete", "Se eliminó un elemento con una clave:"},
                    {"ElemReplace", "Se reemplazó el elemento con clave:"},
                    {"notExist", "No existe ningún elemento con esta clave"},
                    {"anotherUser", "¡Los objetos que pertenecen a otros usuarios son de solo lectura!"},
                    {"less", "El apartamento con esta clave no ha sido reemplazado, porque es menor o igual que el existente"},
                    {"bigger", "El apartamento con esta clave no ha sido reemplazado porque es mayor o igual que el existente"},
                    {"idNotExist", "Un elemento con este ID no existe. No se puede actualizar el valor de un elemento de colección inexistente"},
                    {"Was_Updated", "Se reemplazó correctamente un elemento de la colección con este ID:"},
                    {"clear", "Todos los elementos que pertenecen a este usuario se han eliminado"},

                    {"informationCollection", "Información de la colección"},
                    {"Type", "Tipo:"},
                    {"DateInit", "Última fecha de inicialización:"},
                    {"KolvoElem", "Número de elementos"},

                    {"CountFurnish", "El número de elementos con Furnish es mayor que el especificado:"},
                    {"update_button", "Actualizar"},
                    {"filter_button", "Filter"},
                    {"reset_button", "Reset"},
                    {"filterbutton", "Filter"},
                    {"filter_label1", "Campo de filtro"},
                    {"filter_label2", "Argumento"},
                    {"filter_label3", "Tipo de filtro"},
                    {"Insert", "El elemento con la clave proporcionada se ha agregado correctamente"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},
                    //{"login_loginName", "Логин"},


            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
