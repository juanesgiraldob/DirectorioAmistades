package autonoma.directorioamistades.models;

import autonoma.directorioamistades.exceptions.Excepciones.CorreoInvalidoException;
import autonoma.directorioamistades.exceptions.Excepciones.TelefonoInvalidoException;

public class Amigo {
    private String nombres;
    private String telefono;
    private String correoElectronico;

    public Amigo(String nombres, String telefono, String correoElectronico) 
            throws CorreoInvalidoException, TelefonoInvalidoException {
        
        validarCorreo(correoElectronico);
        validarTelefono(telefono);

        this.nombres = nombres;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    private void validarCorreo(String correo) throws CorreoInvalidoException {
        if (correo == null || !correo.contains("@")) {
            throw new CorreoInvalidoException("El correo electrónico debe contener @");
        }
    }

    private void validarTelefono(String telefono) throws TelefonoInvalidoException {
        if (telefono == null || 
            (!telefono.startsWith("606") && !telefono.startsWith("30"))) {
            throw new TelefonoInvalidoException("El teléfono debe iniciar con 606 o 30");
        }
    }

    // Getters
    public String getNombres() { return nombres; }
    public String getTelefono() { return telefono; }
    public String getCorreoElectronico() { return correoElectronico; }
}