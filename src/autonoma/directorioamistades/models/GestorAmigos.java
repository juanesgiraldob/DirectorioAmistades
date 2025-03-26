package autonoma.directorioamistades.models;

import autonoma.directorioamistades.exceptions.Excepciones.AmigoDuplicadoException;
import autonoma.directorioamistades.exceptions.Excepciones.AmigosNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class GestorAmigos {
    private List<Amigo> amigos;

    public GestorAmigos() {
        this.amigos = new ArrayList<>();
    }

    public void agregarAmigo(Amigo amigo) throws AmigoDuplicadoException {
        // Verificar duplicados por correo electrónico
        for (Amigo a : amigos) {
            if (a.getCorreoElectronico().equals(amigo.getCorreoElectronico())) {
                throw new AmigoDuplicadoException("El amigo ya está registrado");
            }
        }
        amigos.add(amigo);
    }

    public Amigo buscarAmigoPorCorreo(String correo) throws AmigosNoEncontradoException {
        for (Amigo amigo : amigos) {
            if (amigo.getCorreoElectronico().equals(correo)) {
                return amigo;
            }
        }
        throw new AmigosNoEncontradoException("Amigo no encontrado");
    }
}