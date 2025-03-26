package autonoma.directorioamistades.models;

import autonoma.directorioamistades.exceptions.Excepciones.AmigoDuplicadoException;
import autonoma.directorioamistades.exceptions.Excepciones.AmigosNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

/**
 * clase encargada de gestionar la lista de amigos
 * permite agregar y buscar amigos en el directorio
 */
public class GestorAmigos {
    private List<Amigo> amigos;

    public GestorAmigos() {
        this.amigos = new ArrayList<>();
    }

    /**
     * agrega un nuevo amigo a la lista
     * @param amigo amigo a agregar
     * @throws AmigoDuplicadoException si el amigo ya esta registrado
     */
    public void agregarAmigo(Amigo amigo) throws AmigoDuplicadoException {
        for (Amigo a : amigos) {
            if (a.getCorreoElectronico().equals(amigo.getCorreoElectronico())) {
                throw new AmigoDuplicadoException("el amigo ya esta registrado");
            }
        }
        amigos.add(amigo);
    }

    /**
     * busca un amigo por su correo electronico
     * @param correo Correo del amigo a buscar
     * @return Amigo encontrado
     * @throws AmigosNoEncontradoException si el amigo no existe
     */
    public Amigo buscarAmigoPorCorreo(String correo) throws AmigosNoEncontradoException {
        for (Amigo amigo : amigos) {
            if (amigo.getCorreoElectronico().equals(correo)) {
                return amigo;
            }
        }
        throw new AmigosNoEncontradoException("amigo no encontrado");
    }
}
