package autonoma.directorioamistades.exceptions;

public class Excepciones {
    // Excepción para correo electrónico inválido
    public static class CorreoInvalidoException extends Exception {
        public CorreoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    // Excepción para teléfono inválido
    public static class TelefonoInvalidoException extends Exception {
        public TelefonoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    // Excepción para amigo duplicado
    public static class AmigoDuplicadoException extends Exception {
        public AmigoDuplicadoException(String mensaje) {
            super(mensaje);
        }
    }

    // Excepción para amigos no encontrados
    public static class AmigosNoEncontradoException extends Exception {
        public AmigosNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }
}