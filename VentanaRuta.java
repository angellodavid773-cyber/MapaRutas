import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRuta extends JFrame {
    private JTextField txtNombre;
    private JTextField txtLatitud;
    private JTextField txtLongitud;
    private JTextArea areaResultado;
    private ListaLigadaRuta ruta;

    public VentanaRuta() {
        ruta = new ListaLigadaRuta();

        setTitle("Gestor de MapaRutas - Listas Ligadas");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre Parada:");
        lblNombre.setBounds(20, 20, 120, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 20, 250, 25);
        add(txtNombre);

        JLabel lblLat = new JLabel("Latitud:");
        lblLat.setBounds(20, 60, 120, 25);
        add(lblLat);

        txtLatitud = new JTextField();
        txtLatitud.setBounds(150, 60, 250, 25);
        add(txtLatitud);

        JLabel lblLon = new JLabel("Longitud:");
        lblLon.setBounds(20, 100, 120, 25);
        add(lblLon);

        txtLongitud = new JTextField();
        txtLongitud.setBounds(150, 100, 250, 25);
        add(txtLongitud);

        JButton btnAgregar = new JButton("Agregar Parada");
        btnAgregar.setBounds(150, 140, 150, 30);
        add(btnAgregar);

        areaResultado = new JTextArea();
        areaResultado.setBounds(20, 190, 380, 150);
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBounds(20, 190, 380, 150);
        add(scroll);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    double lat = Double.parseDouble(txtLatitud.getText());
                    double lon = Double.parseDouble(txtLongitud.getText());

                    Parada parada = new Parada(nombre, lat, lon);
                    ruta.agregarParada(parada);

                    areaResultado.setText(ruta.obtenerRutaTexto());

                    txtNombre.setText("");
                    txtLatitud.setText("");
                    txtLongitud.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese valores numéricos válidos en latitud y longitud.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaRuta().setVisible(true);
            }
        });
    }
}