import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

class PanelArbol extends JPanel {
    private ArbolBinarioBusqueda arbol;

    public PanelArbol(ArbolBinarioBusqueda arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarArbol(g, getWidth() / 2, 30, arbol.raiz, getWidth() / 4);
    }

    private void dibujarArbol(Graphics g, int x, int y, Nodo nodo, int espacio) {
        if (nodo != null) {
            int radio = 15;
            int diametro = 2 * radio;

            // Dibujar el nodo
            g.setColor(Color.ORANGE);  // Color del círculo
            g.fillOval(x - radio, y - radio, diametro, diametro);
            g.setColor(Color.BLACK);
            g.drawOval(x - radio, y - radio, diametro, diametro);
            g.drawString(Integer.toString(nodo.valor), x - 5, y + 5);

            // Dibujar las líneas hacia los hijos
            if (nodo.izquierdo != null) {
                g.drawLine(x - radio, y + radio, x - espacio + radio, y + 50 - radio);
                dibujarArbol(g, x - espacio, y + 50, nodo.izquierdo, espacio / 2);
            }

            if (nodo.derecho != null) {
                g.drawLine(x + radio, y + radio, x + espacio - radio, y + 50 - radio);
                dibujarArbol(g, x + espacio, y + 50, nodo.derecho, espacio / 2);
            }
        }
    }

    public void actualizarArbol(ArbolBinarioBusqueda arbol) {
        this.arbol = arbol;
        repaint();
    }
}
