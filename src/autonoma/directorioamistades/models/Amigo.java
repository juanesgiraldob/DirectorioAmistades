package autonoma.directorioamistades.models;

import autonoma.directorioamistades.exceptions.Excepciones.CorreoInvalidoException;
import autonoma.directorioamistades.exceptions.Excepciones.TelefonoInvalidoException;

/**
 * representa un amigo en el directorio
 * contiene informacion personal y validaciones de datos
 */
public class Amigo {
    private String nombres;
    private String telefono;
    private String correoElectronico;

    /**
     * constructor de la clase Amigo
     * @param nombres Nombre completo amigo
     * @param telefono Numero telefono amigo
     * @param correoElectronico Correo electronico amigo.
     * @throws CorreoInvalidoException si el correo no contiene '@'
     * @throws TelefonoInvalidoException si el telefono no empieza con 606 o 30
     */
    public Amigo(String nombres, String telefono, String correoElectronico) 
            throws CorreoInvalidoException, TelefonoInvalidoException {
        
        validarCorreo(correoElectronico);
        validarTelefono(telefono);

        this.nombres = nombres;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    // validacion de correo
    private void validarCorreo(String correo) throws CorreoInvalidoException {
        if (correo == null || !correo.contains("@")) {
            throw new CorreoInvalidoException("el correo electronico debe contener @");
        }
    }

    // validacion de telefono
    private void validarTelefono(String telefono) throws TelefonoInvalidoException {
        if (telefono == null || 
            (!telefono.startsWith("606") && !telefono.startsWith("30"))) {
            throw new TelefonoInvalidoException("el telefono debe iniciar con 606 o 30");
        }
    }

    // metodos getter
    public String getNombres() { return nombres; }
    public String getTelefono() { return telefono; }
    public String getCorreoElectronico() { return correoElectronico; }
}
