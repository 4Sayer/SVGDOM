import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class RectanguloSVG extends FiguraSVG {
    private double x, y, width, height;

    public RectanguloSVG(double x, double y, double width, double height, Color stroke, double strokeWidth, Color fill) {
        super(stroke, strokeWidth, fill);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
        if (fill != null) {
            g2d.setColor(fill);
            g2d.fill(rect);
        }
        if (stroke != null) {
            g2d.setColor(stroke);
            g2d.setStroke(new BasicStroke((float) strokeWidth));
            g2d.draw(rect);
        }
    }
}
