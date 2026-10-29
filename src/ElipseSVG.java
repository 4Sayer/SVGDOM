import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class ElipseSVG extends FiguraSVG {
    private double cx, cy, rx, ry;

    public ElipseSVG(double cx, double cy, double rx, double ry, Color stroke, double strokeWidth, Color fill) {
        super(stroke, strokeWidth, fill);
        this.cx = cx;
        this.cy = cy;
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        Ellipse2D.Double ellipse = new Ellipse2D.Double(cx - rx, cy - ry, rx * 2, ry * 2);
        if (fill != null) {
            g2d.setColor(fill);
            g2d.fill(ellipse);
        }
        if (stroke != null) {
            g2d.setColor(stroke);
            g2d.setStroke(new BasicStroke((float) strokeWidth));
            g2d.draw(ellipse);
        }
    }
}
