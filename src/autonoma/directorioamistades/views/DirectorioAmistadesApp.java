package autonoma.directorioamistades.views;

import autonoma.directorioamistades.models.GestorAmigos;
import javax.swing.*;
import java.awt.*;

public class DirectorioAmistadesApp extends JFrame {
    private GestorAmigos gestorAmigos;

    public DirectorioAmistadesApp() {
        gestorAmigos = new GestorAmigos();
        setTitle("📘 DIRECTORIO DE AMIGOS");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel);

        JLabel lblTitulo = new JLabel("DIRECTORIO DE AMIGOS 👥", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTitulo);

        panel.add(Box.createVerticalStrut(20));
        panel.add(crearBoton("AGREGAR AMIGO ➕", e -> new AgregarAmigoApp(gestorAmigos)));
        panel.add(Box.createVerticalStrut(10));
        panel.add(crearBoton("BUSCAR AMIGO 🔎", e -> new BuscarAmigoApp(gestorAmigos)));
    }

    private JButton crearBoton(String texto, java.awt.event.ActionListener action) {
        JButton boton = new JButton(texto);
        boton.setBackground(Color.BLACK);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setMaximumSize(new Dimension(200, 40));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.addActionListener(action);
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DirectorioAmistadesApp().setVisible(true));
    }
}
