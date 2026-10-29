import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProcesadorSVG {

    public static List<FiguraSVG> parsear(File archivo) throws Exception {
        List<FiguraSVG> figuras = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setExpandEntityReferences(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);
        doc.getDocumentElement().normalize();
        
        NodeList nodos = doc.getElementsByTagName("*");
        
        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nodo;
                String nombre = el.getLocalName() != null ? el.getLocalName() : el.getTagName();
                
                Color stroke = parseColor(el.getAttribute("stroke"), null);
                double strokeWidth = parseDouble(el.getAttribute("stroke-width"), 1.0);
                Color fill = parseColor(el.getAttribute("fill"), null);
                
                switch (nombre) {
                    case "line":
                        figuras.add(new LineaSVG(
                            parseDouble(el.getAttribute("x1"), 0), parseDouble(el.getAttribute("y1"), 0),
                            parseDouble(el.getAttribute("x2"), 0), parseDouble(el.getAttribute("y2"), 0),
                            stroke, strokeWidth
                        ));
                        break;
                    case "circle":
                        figuras.add(new CirculoSVG(
                            parseDouble(el.getAttribute("cx"), 0), parseDouble(el.getAttribute("cy"), 0),
                            parseDouble(el.getAttribute("r"), 0), stroke, strokeWidth, fill
                        ));
                        break;
                    case "polyline":
                        figuras.add(new PolilineaSVG(el.getAttribute("points"), stroke, strokeWidth, fill));
                        break;
                    case "rect":
                        figuras.add(new RectanguloSVG(
                            parseDouble(el.getAttribute("x"), 0), parseDouble(el.getAttribute("y"), 0),
                            parseDouble(el.getAttribute("width"), 0), parseDouble(el.getAttribute("height"), 0),
                            stroke, strokeWidth, fill
                        ));
                        break;
                    case "ellipse":
                        figuras.add(new ElipseSVG(
                            parseDouble(el.getAttribute("cx"), 0), parseDouble(el.getAttribute("cy"), 0),
                            parseDouble(el.getAttribute("rx"), 0), parseDouble(el.getAttribute("ry"), 0),
                            stroke, strokeWidth, fill
                        ));
                        break;
                    case "text":
                        String fontFamily = el.getAttribute("font-family");
                        int fontSize = (int) parseDouble(el.getAttribute("font-size"), 12);
                        figuras.add(new TextoSVG(
                            parseDouble(el.getAttribute("x"), 0), parseDouble(el.getAttribute("y"), 0),
                            el.getTextContent(), fontFamily.isEmpty() ? null : fontFamily, fontSize, fill
                        ));
                        break;
                }
            }
        }
        return figuras;
    }

    private static double parseDouble(String val, double def) {
        try {
            return (val == null || val.isEmpty()) ? def : Double.parseDouble(val.replaceAll("[^0-9.-]", ""));
        } catch (Exception e) {
            return def;
        }
    }

    private static Color parseColor(String val, Color def) {
        if (val == null || val.isEmpty() || val.equals("none")) return def;
        val = val.trim().toLowerCase();
        switch (val) {
            case "red": return Color.RED;
            case "blue": return Color.BLUE;
            case "green": return Color.GREEN;
            case "yellow": return Color.YELLOW;
            case "black": return Color.BLACK;
            case "orange": return Color.ORANGE;
            case "navy": return new Color(0, 0, 128);
            case "lightblue": return new Color(173, 216, 230);
            case "lightgreen": return new Color(144, 238, 144);
        }
        if (val.startsWith("#")) {
            try { return Color.decode(val); } catch (Exception e) { return def; }
        }
        return def;
    }
}
