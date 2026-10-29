import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class CirculoSVG extends FiguraSVG {
    private double cx, cy, r;

    public CirculoSVG(double cx, double cy, double r, Color stroke, double strokeWidth, Color fill) {
        super(stroke, strokeWidth, fill);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        Ellipse2D.Double circle = new Ellipse2D.Double(cx - r, cy - r, r * 2, r * 2);
        if (fill != null) {
            g2d.setColor(fill);
            g2d.fill(circle);
        }
        if (stroke != null) {
            g2d.setColor(stroke);
            g2d.setStroke(new BasicStroke((float) strokeWidth));
            g2d.draw(circle);
        }
    }
}
