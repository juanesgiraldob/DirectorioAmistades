package autonoma.directorioamistades.views;

import autonoma.directorioamistades.models.Amigo;
import autonoma.directorioamistades.models.GestorAmigos;
import javax.swing.*;
import java.awt.*;

public class AgregarAmigo extends JFrame {
    private JTextField txtNombre, txtTelefono, txtCorreo;
    private JTextArea txtResultados;
    private GestorAmigos gestorAmigos;

    public AgregarAmigo(GestorAmigos gestorAmigos) {
        this.gestorAmigos = gestorAmigos;
        setTitle("➕ Agregar Amigo");
        setSize(350, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel, BorderLayout.CENTER);

        panel.add(new JLabel("📝 Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("📱 Teléfono:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        panel.add(new JLabel("✉️ Correo:"));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);

        JButton btnAgregar = new JButton("Agregar ➕");
        btnAgregar.setBackground(Color.BLACK);
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.addActionListener(e -> agregarAmigo());
        panel.add(btnAgregar);

        txtResultados = new JTextArea(4, 20);
        txtResultados.setEditable(false);
        txtResultados.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(new JScrollPane(txtResultados), BorderLayout.SOUTH);

        setVisible(true);
    }

    private void agregarAmigo() {
        try {
            Amigo amigo = new Amigo(txtNombre.getText(), txtTelefono.getText(), txtCorreo.getText());
            gestorAmigos.agregarAmigo(amigo);
            txtResultados.setText("👏 Amigo agregado exitosamente! 🎉");
        } catch (Exception ex) {
            txtResultados.setText("❌ Error: " + ex.getMessage());
        }
    }
}

