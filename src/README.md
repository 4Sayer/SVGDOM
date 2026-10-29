# Práctica de laboratorio: Visualizador SVG con DOM y Java 2D

## Arquitectura

Separamos la lectura del archivo (`ProcesadorSVG`) del dibujo en pantalla (`PanelSVG`). Usamos una clase base `FiguraSVG` para que cada figura sepa dibujarse a sí misma de forma independiente (polimorfismo).

## Preguntas de reflexión

1. **DOM vs SAX:** DOM guarda todo el documento en la memoria, lo que nos deja acceder a cualquier parte y encimar las figuras en el orden correcto. SAX es más rápido y ligero, pero al leer línea por línea, complica mucho superponer los dibujos.
2. **Jerarquía XML a Java:** Cada etiqueta del archivo XML se traduce en un objeto en Java (como un círculo o una línea) y se guarda en una lista manteniendo exactamente el orden original en el que aparecen.
3. **Ventajas del Polimorfismo:** Nos ahorra mucho código. En lugar de revisar qué figura es para saber cómo pintarla, solo le decimos a la lista genérica `dibujar()` y cada objeto hace su trabajo.
4. **Separar lectura de gráficos:** La interfaz gráfica se actualiza y repinta constantemente (por ejemplo, al mover la ventana). Si leyéramos el archivo XML en cada actualización, la computadora se sobrecargaría y el programa se trabaría.
5. **Dificultades con el texto:** Los archivos traen medidas con letras (como "10px") o colores en código. Hay que limpiar esos textos usando expresiones regulares y validaciones antes de convertirlos a números para evitar errores.
6. **Agregar nuevas figuras:** Es muy fácil de escalar. Solo creamos una nueva clase para la figura (ej. `PoligonoSVG`) y la agregamos al lector. El panel que dibuja no necesita modificarse.
7. **Rotar y escalar:** Necesitaríamos integrar la herramienta `AffineTransform` de Java 2D para aplicar matemáticas y matrices a las coordenadas de las figuras justo antes de pasarlas al lienzo.