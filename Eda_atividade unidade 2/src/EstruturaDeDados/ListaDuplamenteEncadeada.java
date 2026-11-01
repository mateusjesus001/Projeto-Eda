package EstruturaDeDados;
public class ListaDuplamenteEncadeada<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adicionarInicio(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            inicio = fim = novoNo;
        } else {
            novoNo.setProximo(inicio);
            inicio.setAnterior(novoNo);
            inicio = novoNo;
        }
        tamanho++;
    }

    public void adicionarFim(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            inicio = fim = novoNo;
        } else {
            novoNo.setAnterior(fim);
            fim.setProximo(novoNo);
            fim = novoNo;
        }
        tamanho++;
    }

    public T removerInicio() {
        if (estaVazia()) {
            throw new IllegalStateException("Lista vazia");
        }
        T elemento = inicio.getDado();
        if (tamanho == 1) {
            inicio = fim = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }
        tamanho--;
        return elemento;
    }

    public T removerFim() {
        if (estaVazia()) {
            throw new IllegalStateException("Lista vazia");
        }
        T elemento = fim.getDado();
        if (tamanho == 1) {
            inicio = fim = null;
        } else {
            fim = fim.getAnterior();
            fim.setProximo(null);
        }
        tamanho--;
        return elemento;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public T getInicio() {
        if (estaVazia()) {
            throw new IllegalStateException("Lista vazia");
        }
        return inicio.getDado();
    }

    public T getFim() {
        if (estaVazia()) {
            throw new IllegalStateException("Lista vazia");
        }
        return fim.getDado();
    }
} 