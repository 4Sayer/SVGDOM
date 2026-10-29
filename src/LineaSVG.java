import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineaSVG extends FiguraSVG {
    private double x1, y1, x2, y2;

    public LineaSVG(double x1, double y1, double x2, double y2, Color stroke, double strokeWidth) {
        super(stroke, strokeWidth, null);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        if (stroke != null) {
            g2d.setColor(stroke);
            g2d.setStroke(new BasicStroke((float) strokeWidth));
            g2d.draw(new Line2D.Double(x1, y1, x2, y2));
        }
    }
}
