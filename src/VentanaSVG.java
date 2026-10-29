import javax.swing.*;
import java.awt.*;
import java.io.File;

public class VentanaSVG extends JFrame {
    private PanelSVG panelSVG;

    public VentanaSVG() {
        setTitle("Visor Java DOM SVG");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSVG = new PanelSVG();
        add(panelSVG, BorderLayout.CENTER);

        JButton btnCargar = new JButton("Cargar SVG");
        btnCargar.addActionListener(e -> cargarArchivo());
        add(btnCargar, BorderLayout.SOUTH);
    }

    private void cargarArchivo() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                panelSVG.setFiguras(ProcesadorSVG.parsear(file));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error procesando el SVG: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
