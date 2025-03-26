package autonoma.directorioamistades.exceptions;

/**
 * contiene las excepciones personalizadas utilizadas en la aplicacion
 */
public class Excepciones {
    public static class CorreoInvalidoException extends Exception {
        public CorreoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class TelefonoInvalidoException extends Exception {
        public TelefonoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class AmigoDuplicadoException extends Exception {
        public AmigoDuplicadoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class AmigosNoEncontradoException extends Exception {
        public AmigosNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }
}
