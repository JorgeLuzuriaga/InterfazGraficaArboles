import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;  // Asegúrate de importar java.util.List

public class VentanaArbol extends JFrame {
    private ArbolBinarioBusqueda arbol;
    private PanelArbol panelArbol;
    private JTextArea areaRecorridos;

    public VentanaArbol() {
        arbol = new ArbolBinarioBusqueda();
        panelArbol = new PanelArbol(arbol);
        areaRecorridos = new JTextArea(5, 20);

        setLayout(new BorderLayout());

        JPanel panelControl = new JPanel();
        JTextField campoValor = new JTextField(5);
        JButton botonInsertar = new JButton("Insertar");
        botonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(campoValor.getText());
                arbol.insertar(valor);
                panelArbol.actualizarArbol(arbol);
                actualizarRecorridos();
                campoValor.setText("");
            }
        });

        panelControl.add(new JLabel("Valor:"));
        panelControl.add(campoValor);
        panelControl.add(botonInsertar);

        add(panelControl, BorderLayout.NORTH);
        add(panelArbol, BorderLayout.CENTER);
        add(new JScrollPane(areaRecorridos), BorderLayout.SOUTH);

        setTitle("Árbol Binario de Búsqueda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void actualizarRecorridos() {
        List<Integer> preorden = arbol.recorridoPreorden();
        List<Integer> inorden = arbol.recorridoInorden();
        List<Integer> postorden = arbol.recorridoPostorden();

        areaRecorridos.setText("");
        areaRecorridos.append("Preorden: " + preorden + "\n");
        areaRecorridos.append("Inorden: " + inorden + "\n");
        areaRecorridos.append("Postorden: " + postorden + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaArbol().setVisible(true);
            }
        });
    }
}
