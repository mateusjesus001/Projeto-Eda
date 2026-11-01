package EstruturaDeDados;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso da Fila
        System.out.println("Testando a Fila:");
        Fila<Integer> fila = new Fila<>();
        
        // Enfileirando elementos
        System.out.println("\nEnfileirando elementos: 1, 2, 3, 4, 5");
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.enfileirar(4);
        fila.enfileirar(5);
        
        // Desenfileirando elementos
        System.out.println("\nDesenfileirando elementos:");
        while (!fila.estaVazia()) {
            System.out.println("Elemento removido: " + fila.desenfileirar());
        }
        
        // Exemplo de uso da Pilha
        System.out.println("\nTestando a Pilha:");
        Pilha<String> pilha = new Pilha<>();
        
        // Empilhando elementos
        System.out.println("\nEmpilhando elementos: 'A', 'B', 'C'");
        pilha.empilhar("A");
        pilha.empilhar("B");
        pilha.empilhar("C");
        
        // Desempilhando elementos
        System.out.println("\nDesempilhando elementos:");
        while (!pilha.estaVazia()) {
            System.out.println("Elemento removido: " + pilha.desempilhar());
        }

        // Testando o balanceamento da árvore binária
        System.out.println("\nTestando o balanceamento da árvore binária:");
        
        // Construindo a árvore desbalanceada
        NoArvoreBinaria raiz = new NoArvoreBinaria(1);
        raiz.right = new NoArvoreBinaria(2);
        raiz.right.right = new NoArvoreBinaria(3);
        raiz.right.right.right = new NoArvoreBinaria(4);

        System.out.println("Árvore original (desbalanceada):");
        imprimirArvorePorNivel(raiz);

        BalanceadorArvoreBinaria balanceador = new BalanceadorArvoreBinaria();
        NoArvoreBinaria raizBalanceada = balanceador.balancearArvore(raiz);

        System.out.println("\nÁrvore balanceada:");
        imprimirArvorePorNivel(raizBalanceada);
    }

    // Método para imprimir a árvore por nível (BFS) para visualização
    public static void imprimirArvorePorNivel(NoArvoreBinaria raiz) {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<NoArvoreBinaria> fila = new LinkedList<>();
        fila.offer(raiz);

        while (!fila.isEmpty()) {
            int tamanhoNivel = fila.size();
            for (int i = 0; i < tamanhoNivel; i++) {
                NoArvoreBinaria noAtual = fila.poll();
                if (noAtual != null) {
                    System.out.print(noAtual.val + " ");
                    fila.offer(noAtual.left);
                    fila.offer(noAtual.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println(); // Nova linha para o próximo nível
        }
    }
} 