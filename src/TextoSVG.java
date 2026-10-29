import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class TextoSVG extends FiguraSVG {
    private double x, y;
    private String text;
    private String fontFamily;
    private int fontSize;

    public TextoSVG(double x, double y, String text, String fontFamily, int fontSize, Color fill) {
        super(null, 0, fill);
        this.x = x;
        this.y = y;
        this.text = text;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        if (fill != null) {
            g2d.setColor(fill);
        } else {
            g2d.setColor(Color.BLACK);
        }
        Font font = new Font(fontFamily != null ? fontFamily : "SansSerif", Font.PLAIN, fontSize > 0 ? fontSize : 12);
        g2d.setFont(font);
        g2d.drawString(text, (float) x, (float) y);
    }
}
