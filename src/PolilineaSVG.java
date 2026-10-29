import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class PolilineaSVG extends FiguraSVG {
    private String points;

    public PolilineaSVG(String points, Color stroke, double strokeWidth, Color fill) {
        super(stroke, strokeWidth, fill);
        this.points = points;
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        if (points == null || points.trim().isEmpty()) return;
        String[] coords = points.trim().split("\\s+|,\\s*");
        if (coords.length < 2) return;
        Path2D.Double path = new Path2D.Double();
        try {
            path.moveTo(Double.parseDouble(coords[0]), Double.parseDouble(coords[1]));
            for (int i = 2; i < coords.length; i += 2) {
                if (i + 1 < coords.length) {
                    path.lineTo(Double.parseDouble(coords[i]), Double.parseDouble(coords[i+1]));
                }
            }
        } catch (Exception e) { return; }
        
        if (fill != null) {
            g2d.setColor(fill);
            g2d.fill(path);
        }
        if (stroke != null) {
            g2d.setColor(stroke);
            g2d.setStroke(new BasicStroke((float) strokeWidth));
            g2d.draw(path);
        }
    }
}
