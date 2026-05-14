package lectmocity.vista;

import lectmocity.controlador.LibroController;
import lectmocity.controlador.PrestamoController;
import lectmocity.controlador.UsuarioController;
import lectmocity.modelo.Libro;
import lectmocity.modelo.Usuario;
import lectmocity.patrones.*;

import java.util.Scanner;

public class VentanaPrincipal {

    private Scanner scanner;
    private LibroController libroController;
    private UsuarioController usuarioController;
    private PrestamoController prestamoController;
    private InventarioObservable inventario;

    public VentanaPrincipal() {
        scanner = new Scanner(System.in);

        inventario = new InventarioObservable();

        inventario.agregarObservador(mensaje ->
                System.out.println("[Notificación inventario]: " + mensaje)
        );

        libroController = new LibroController(inventario);
        usuarioController = new UsuarioController();
        prestamoController = new PrestamoController(inventario);
    }

    public void iniciar() {
        ConexionBD.getInstancia().conectar();

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    registrarLibroDigital();
                    break;
                case 3:
                    registrarUsuario();
                    break;
                case 4:
                    listarLibros();
                    break;
                case 5:
                    listarUsuarios();
                    break;
                case 6:
                    prestarLibro();
                    break;
                case 7:
                    devolverLibro();
                    break;
                case 8:
                    listarPrestamos();
                    break;
                case 9:
                    eliminarLibroConPermiso();
                    break;
                case 0:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n===== Sistema LectMoCity Libros =====");
        System.out.println("1. Registrar libro físico");
        System.out.println("2. Registrar libro digital");
        System.out.println("3. Registrar usuario");
        System.out.println("4. Listar libros");
        System.out.println("5. Listar usuarios");
        System.out.println("6. Prestar libro");
        System.out.println("7. Devolver libro");
        System.out.println("8. Listar préstamos");
        System.out.println("9. Eliminar libro con control de acceso");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void registrarLibro() {
        System.out.print("ID del libro: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        Libro libro = new Libro(id, titulo, autor);
        libroController.agregarLibro(libro);
    }

    private void registrarLibroDigital() {
        System.out.print("ID del libro digital: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre del archivo: ");
        String archivo = scanner.nextLine();

        System.out.print("Autor digital: ");
        String autor = scanner.nextLine();

        LibroDigital libroDigital = new LibroDigital(archivo, autor);
        AdaptadorLibroDigital adaptador = new AdaptadorLibroDigital(id, libroDigital);

        libroController.agregarLibro(adaptador);
    }

    private void registrarUsuario() {
        System.out.print("ID del usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Tipo de usuario, Estudiante o Docente: ");
        String tipo = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombre, tipo);
        usuarioController.agregarUsuario(usuario);
    }

    private void listarLibros() {
        libroController.listarLibros();
    }

    private void listarUsuarios() {
        usuarioController.listarUsuarios();
    }

    private void prestarLibro() {
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();

        System.out.print("ID del usuario: ");
        int idUsuario = scanner.nextInt();

        Libro libro = libroController.buscarLibroPorId(idLibro);
        Usuario usuario = usuarioController.buscarUsuarioPorId(idUsuario);

        prestamoController.prestarLibro(libro, usuario);
    }

    private void devolverLibro() {
        System.out.print("ID del libro a devolver: ");
        int idLibro = scanner.nextInt();

        Libro libro = libroController.buscarLibroPorId(idLibro);

        prestamoController.devolverLibro(libro);
    }

    private void listarPrestamos() {
        prestamoController.listarPrestamos();
    }

    private void eliminarLibroConPermiso() {
        scanner.nextLine();

        System.out.print("Ingrese rol del usuario: ");
        String rol = scanner.nextLine();

        System.out.print("Ingrese ID del libro a eliminar: ");
        int idLibro = scanner.nextInt();

        ServicioBiblioteca servicio = new ControlAccesoAdministrador(rol);
        servicio.eliminarLibro(idLibro);
    }
}