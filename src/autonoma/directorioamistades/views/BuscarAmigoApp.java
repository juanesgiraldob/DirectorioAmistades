package autonoma.directorioamistades.views;

import autonoma.directorioamistades.models.Amigo;
import autonoma.directorioamistades.models.GestorAmigos;
import autonoma.directorioamistades.exceptions.Excepciones.AmigosNoEncontradoException;
import javax.swing.*;
import java.awt.*;

public class BuscarAmigoApp extends JFrame {
    private JTextField txtBuscarCorreo;
    private JTextArea txtResultados;
    private GestorAmigos gestorAmigos;

    public BuscarAmigoApp(GestorAmigos gestorAmigos) {
        this.gestorAmigos = gestorAmigos;
        setTitle("🔎 Buscar Amigo");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel, BorderLayout.CENTER);

        panel.add(new JLabel("✉️ Correo:"));
        txtBuscarCorreo = new JTextField();
        panel.add(txtBuscarCorreo);

        JButton btnBuscar = new JButton("Buscar 🔎");
        btnBuscar.setBackground(Color.BLACK);
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.addActionListener(e -> buscarAmigo());
        panel.add(btnBuscar);

        txtResultados = new JTextArea(5, 20);
        txtResultados.setEditable(false);
        txtResultados.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(new JScrollPane(txtResultados), BorderLayout.SOUTH);

        setVisible(true);
    }

    private void buscarAmigo() {
        try {
            Amigo amigo = gestorAmigos.buscarAmigoPorCorreo(txtBuscarCorreo.getText());
            txtResultados.setText("👤 Nombre: " + amigo.getNombres() + "\n" +
                    "📞 Teléfono: " + amigo.getTelefono() + "\n" +
                    "📧 Correo: " + amigo.getCorreoElectronico());
        } catch (AmigosNoEncontradoException ex) {
            txtResultados.setText("❌ Amigo no encontrado");
        }
    }
}
