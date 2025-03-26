package autonoma.directorioamistades.main;

import autonoma.directorioamistades.models.Amigo;
import autonoma.directorioamistades.models.GestorAmigos;
import autonoma.directorioamistades.exceptions.Excepciones.AmigoDuplicadoException;
import autonoma.directorioamistades.exceptions.Excepciones.AmigosNoEncontradoException;
import autonoma.directorioamistades.exceptions.Excepciones.CorreoInvalidoException;
import autonoma.directorioamistades.exceptions.Excepciones.TelefonoInvalidoException;

import java.util.Scanner;

/**
 * clase principal que gestiona el directorio de amistades
 * permite agregar amigos, buscar amigos por correo y mostrar informacion del sistema
 */
public class DirectorioAmistades {
    private static GestorAmigos gestorAmigos = new GestorAmigos();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarNuevoAmigo();
                    break;
                case 2:
                    buscarAmigo();
                    break;
                case 3:
                    mostrarAcercaDe();
                    break;
                case 4:
                    System.out.println("saliendo de la aplicacion");
                    return;
                default:
                    System.out.println("opcion invalida");
            }
        }
    }

    /**
     * muestra menu de opciones en consola
     */
    private static void mostrarMenu() {
        System.out.println("\n- Gestion de Amigos -");
        System.out.println("1. agregar nuevo amigo");
        System.out.println("2. buscar amigo");
        System.out.println("3. acerca de");
        System.out.println("4. salir");
        System.out.print("elija una opcion: ");
    }

    /**
     * permite agregar un nuevo amigo solicitando sus datos al usuario
     */
    private static void agregarNuevoAmigo() {
        try {
            System.out.print("ingrese nombres: ");
            String nombres = scanner.nextLine();

            System.out.print("ingrese telefono: ");
            String telefono = scanner.nextLine();

            System.out.print("ingrese correo electronico: ");
            String correo = scanner.nextLine();

            // crear instancia de amigo y agregarlo al gestor
            Amigo nuevoAmigo = new Amigo(nombres, telefono, correo);
            gestorAmigos.agregarAmigo(nuevoAmigo);
            System.out.println("amigo agregado exitosamente");

        } catch (CorreoInvalidoException | TelefonoInvalidoException | AmigoDuplicadoException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    /**
     * permite buscar un amigo por su correo electronico
     */
    private static void buscarAmigo() {
        try {
            System.out.print("ingrese correo electronico a buscar: ");
            String correo = scanner.nextLine();

            Amigo amigo = gestorAmigos.buscarAmigoPorCorreo(correo);
            System.out.println("amigo encontrado:");
            System.out.println("nombres: " + amigo.getNombres());
            System.out.println("telefono: " + amigo.getTelefono());
            System.out.println("correo: " + amigo.getCorreoElectronico());

        } catch (AmigosNoEncontradoException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    /**
     * muestra informacion acerca de la aplicacion
     */
    private static void mostrarAcercaDe() {
        System.out.println("\n- acerca de -");
        System.out.println("taller: directorio de amistades");
        System.out.println("asignatura: programacion orientada a objetos");
        System.out.println("universidad: universidad autonoma de manizales");
        System.out.println("Desarrolladores: [Juan Esteban Giraldo Betancur e Isabela Quintero Murillo]");
    }
}
