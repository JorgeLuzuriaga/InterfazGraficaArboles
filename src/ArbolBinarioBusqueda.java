import java.util.ArrayList;
import java.util.List;

class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRecursivo(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRecursivo(raiz.derecho, valor);
        }

        return raiz;
    }

    public List<Integer> recorridoPreorden() {
        List<Integer> resultado = new ArrayList<>();
        recorridoPreordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void recorridoPreordenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            resultado.add(nodo.valor);
            recorridoPreordenRecursivo(nodo.izquierdo, resultado);
            recorridoPreordenRecursivo(nodo.derecho, resultado);
        }
    }

    public List<Integer> recorridoInorden() {
        List<Integer> resultado = new ArrayList<>();
        recorridoInordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void recorridoInordenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            recorridoInordenRecursivo(nodo.izquierdo, resultado);
            resultado.add(nodo.valor);
            recorridoInordenRecursivo(nodo.derecho, resultado);
        }
    }

    public List<Integer> recorridoPostorden() {
        List<Integer> resultado = new ArrayList<>();
        recorridoPostordenRecursivo(raiz, resultado);
        return resultado;
    }

    private void recorridoPostordenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            recorridoPostordenRecursivo(nodo.izquierdo, resultado);
            recorridoPostordenRecursivo(nodo.derecho, resultado);
            resultado.add(nodo.valor);
        }
    }

    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);
        } else {
            // Caso 1: nodo sin hijos
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }

            // Caso 2: nodo con un hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }

            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso 3: nodo con dos hijos
            int valorMin = encontrarValorMin(nodo.derecho);
            nodo.valor = valorMin;
            nodo.derecho = eliminarRecursivo(nodo.derecho, valorMin);
        }

        return nodo;
    }

    private int encontrarValorMin(Nodo nodo) {
        int minValor = nodo.valor;
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
            minValor = nodo.valor;
        }
        return minValor;
    }
}


