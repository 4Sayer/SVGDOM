import java.awt.Color;
import java.awt.Graphics2D;

public abstract class FiguraSVG {
    protected Color stroke;
    protected double strokeWidth;
    protected Color fill;

    public FiguraSVG(Color stroke, double strokeWidth, Color fill) {
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
    }

    public abstract void dibujar(Graphics2D g2d);
}
