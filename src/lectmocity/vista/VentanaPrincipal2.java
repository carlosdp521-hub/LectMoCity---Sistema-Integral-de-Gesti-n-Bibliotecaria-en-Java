package lectmocity.vista;

import lectmocity.controlador.LibroController;
import lectmocity.controlador.PrestamoController;
import lectmocity.controlador.UsuarioController;
import lectmocity.modelo.Libro;
import lectmocity.modelo.Usuario;
import lectmocity.patrones.*;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal2 extends JFrame {

    private LibroController libroController;
    private UsuarioController usuarioController;
    private PrestamoController prestamoController;
    private InventarioObservable inventario;

    private JTextArea areaSalida;

    public VentanaPrincipal2() {
        setTitle("Sistema LectMoCity Libros");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inventario = new InventarioObservable();
        inventario.agregarObservador(mensaje -> mostrarMensaje("[Inventario] " + mensaje));

        libroController = new LibroController(inventario);
        usuarioController = new UsuarioController();
        prestamoController = new PrestamoController(inventario);

        ConexionBD.getInstancia().conectar();

        crearInterfaz();
    }

    private void crearInterfaz() {
        JTabbedPane pestañas = new JTabbedPane();

        pestañas.addTab("Libros", crearPanelLibros());
        pestañas.addTab("Usuarios", crearPanelUsuarios());
        pestañas.addTab("Préstamos", crearPanelPrestamos());
        pestañas.addTab("Salida", crearPanelSalida());

        add(pestañas);
    }

    private JPanel crearPanelLibros() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JTextField txtId = new JTextField();
        JTextField txtTitulo = new JTextField();
        JTextField txtAutor = new JTextField();

        JButton btnAgregar = new JButton("Registrar libro físico");
        JButton btnAgregarDigital = new JButton("Registrar libro digital");
        JButton btnListar = new JButton("Listar libros");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("ID:"));
        panel.add(txtId);

        panel.add(new JLabel("Título / Archivo:"));
        panel.add(txtTitulo);

        panel.add(new JLabel("Autor:"));
        panel.add(txtAutor);

        panel.add(btnAgregar);
        panel.add(btnAgregarDigital);

        panel.add(btnListar);

        btnAgregar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();

                Libro libro = new Libro(id, titulo, autor);
                libroController.agregarLibro(libro);

                mostrarMensaje("Libro físico registrado: " + titulo);
                limpiar(txtId, txtTitulo, txtAutor);
            } catch (Exception ex) {
                mostrarMensaje("Error: revise los datos ingresados.");
            }
        });

        btnAgregarDigital.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String archivo = txtTitulo.getText();
                String autor = txtAutor.getText();

                LibroDigital libroDigital = new LibroDigital(archivo, autor);
                AdaptadorLibroDigital adaptador = new AdaptadorLibroDigital(id, libroDigital);

                libroController.agregarLibro(adaptador);

                mostrarMensaje("Libro digital registrado mediante Adapter: " + archivo);
                limpiar(txtId, txtTitulo, txtAutor);
            } catch (Exception ex) {
                mostrarMensaje("Error: revise los datos ingresados.");
            }
        });

        btnListar.addActionListener(e -> {
            mostrarMensaje("Listado de libros enviado a consola.");
            libroController.listarLibros();
        });

        return panel;
    }

    private JPanel crearPanelUsuarios() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField txtId = new JTextField();
        JTextField txtNombre = new JTextField();

        JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Estudiante", "Docente"});

        JButton btnAgregar = new JButton("Registrar usuario");
        JButton btnListar = new JButton("Listar usuarios");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("ID:"));
        panel.add(txtId);

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);

        panel.add(new JLabel("Tipo de usuario:"));
        panel.add(cmbTipo);

        panel.add(btnAgregar);
        panel.add(btnListar);

        btnAgregar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                String tipo = cmbTipo.getSelectedItem().toString();

                Usuario usuario = new Usuario(id, nombre, tipo);
                usuarioController.agregarUsuario(usuario);

                mostrarMensaje("Usuario registrado: " + nombre + " (" + tipo + ")");
                limpiar(txtId, txtNombre);
            } catch (Exception ex) {
                mostrarMensaje("Error: revise los datos ingresados.");
            }
        });

        btnListar.addActionListener(e -> {
            mostrarMensaje("Listado de usuarios enviado a consola.");
            usuarioController.listarUsuarios();
        });

        return panel;
    }

    private JPanel crearPanelPrestamos() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JTextField txtIdLibro = new JTextField();
        JTextField txtIdUsuario = new JTextField();
        JTextField txtRol = new JTextField();

        JButton btnPrestar = new JButton("Prestar libro");
        JButton btnDevolver = new JButton("Devolver libro");
        JButton btnListarPrestamos = new JButton("Listar préstamos");
        JButton btnEliminar = new JButton("Eliminar libro con Proxy");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("ID Libro:"));
        panel.add(txtIdLibro);

        panel.add(new JLabel("ID Usuario:"));
        panel.add(txtIdUsuario);

        panel.add(new JLabel("Rol para eliminar:"));
        panel.add(txtRol);

        panel.add(btnPrestar);
        panel.add(btnDevolver);

        panel.add(btnListarPrestamos);
        panel.add(btnEliminar);

        btnPrestar.addActionListener(e -> {
            try {
                int idLibro = Integer.parseInt(txtIdLibro.getText());
                int idUsuario = Integer.parseInt(txtIdUsuario.getText());

                Libro libro = libroController.buscarLibroPorId(idLibro);
                Usuario usuario = usuarioController.buscarUsuarioPorId(idUsuario);

                prestamoController.prestarLibro(libro, usuario);

                mostrarMensaje("Operación de préstamo ejecutada.");
            } catch (Exception ex) {
                mostrarMensaje("Error: revise los datos del préstamo.");
            }
        });

        btnDevolver.addActionListener(e -> {
            try {
                int idLibro = Integer.parseInt(txtIdLibro.getText());
                Libro libro = libroController.buscarLibroPorId(idLibro);

                prestamoController.devolverLibro(libro);

                mostrarMensaje("Operación de devolución ejecutada.");
            } catch (Exception ex) {
                mostrarMensaje("Error: revise el ID del libro.");
            }
        });

        btnListarPrestamos.addActionListener(e -> {
            mostrarMensaje("Listado de préstamos enviado a consola.");
            prestamoController.listarPrestamos();
        });

        btnEliminar.addActionListener(e -> {
            try {
                int idLibro = Integer.parseInt(txtIdLibro.getText());
                String rol = txtRol.getText();

                ServicioBiblioteca servicio = new ControlAccesoAdministrador(rol);
                servicio.eliminarLibro(idLibro);

                mostrarMensaje("Operación Proxy ejecutada con rol: " + rol);
            } catch (Exception ex) {
                mostrarMensaje("Error: revise el ID del libro o el rol.");
            }
        });

        return panel;
    }

    private JPanel crearPanelSalida() {
        JPanel panel = new JPanel(new BorderLayout());

        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        areaSalida.setFont(new Font("Consolas", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(areaSalida);

        JButton btnLimpiar = new JButton("Limpiar salida");

        btnLimpiar.addActionListener(e -> areaSalida.setText(""));

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnLimpiar, BorderLayout.SOUTH);

        return panel;
    }

    private void mostrarMensaje(String mensaje) {
        if (areaSalida != null) {
            areaSalida.append(mensaje + "\n");
        }
        System.out.println(mensaje);
    }

    private void limpiar(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }

    public void iniciar() {
        setVisible(true);
    }
}