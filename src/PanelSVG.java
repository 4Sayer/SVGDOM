import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

public class PanelSVG extends JPanel {
    private List<FiguraSVG> figuras = new ArrayList<>();

    public void setFiguras(List<FiguraSVG> figuras) {
        this.figuras = figuras;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for (FiguraSVG figura : figuras) {
            figura.dibujar(g2d);
        }
    }
}
