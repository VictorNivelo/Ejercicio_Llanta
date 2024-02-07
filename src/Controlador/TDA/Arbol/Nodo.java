
package Controlador.TDA.Arbol;

/**
 *
 * @author Victor
 * @param <E>
 */
public class Nodo<E> {
    private E info;
    private Nodo<E> padre;
    private Nodo<E> derecha;
    private Nodo<E> izquierda;

    public Nodo(E info) {
        this.info = null;
        padre = null;
        derecha = null;
        izquierda = null;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Nodo<E> getPadre() {
        return padre;
    }

    public void setPadre(Nodo<E> padre) {
        this.padre = padre;
    }

    public Nodo<E> getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo<E> derecha) {
        this.derecha = derecha;
    }

    public Nodo<E> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo<E> izquierda) {
        this.izquierda = izquierda;
    }

    @Override
    public String toString() {
        return "Nodo{" + "info=" + info + ", padre=" + padre + ", derecha=" + derecha + ", izquierda=" + izquierda + '}';
    }
    
}
