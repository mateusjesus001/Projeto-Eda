package EstruturaDeDados;
public class Pilha<T> {
    private ListaDuplamenteEncadeada<T> lista;

    public Pilha() {
        this.lista = new ListaDuplamenteEncadeada<>();
    }

    public void empilhar(T elemento) {
        lista.adicionarInicio(elemento);
    }

    public T desempilhar() {
        if (estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return lista.removerInicio();
    }

    public T topo() {
        if (estaVazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return lista.getInicio();
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public int tamanho() {
        return lista.getTamanho();
    }
} 