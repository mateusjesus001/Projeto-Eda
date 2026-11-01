package EstruturaDeDados;
public class Fila<T> {
    private Pilha<T> pilhaEntrada;
    private Pilha<T> pilhaSaida;

    public Fila() {
        this.pilhaEntrada = new Pilha<>();
        this.pilhaSaida = new Pilha<>();
    }

    public void enfileirar(T elemento) {
        pilhaEntrada.empilhar(elemento);
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }

        if (pilhaSaida.estaVazia()) {
            while (!pilhaEntrada.estaVazia()) {
                pilhaSaida.empilhar(pilhaEntrada.desempilhar());
            }
        }

        return pilhaSaida.desempilhar();
    }

    public T frente() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }

        if (pilhaSaida.estaVazia()) {
            while (!pilhaEntrada.estaVazia()) {
                pilhaSaida.empilhar(pilhaEntrada.desempilhar());
            }
        }

        return pilhaSaida.topo();
    }

    public boolean estaVazia() {
        return pilhaEntrada.estaVazia() && pilhaSaida.estaVazia();
    }

    public int tamanho() {
        return pilhaEntrada.tamanho() + pilhaSaida.tamanho();
    }
} 