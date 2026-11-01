package EstruturaDeDados;
import java.util.ArrayList;
import java.util.List;

public class BalanceadorArvoreBinaria {
    List<NoArvoreBinaria> nosOrdenados = new ArrayList<>();

    public NoArvoreBinaria balancearArvore(NoArvoreBinaria raiz) {
        percorrerEmOrdem(raiz);
        return construirArvoreBalanceada(0, nosOrdenados.size() - 1);
    }

    private void percorrerEmOrdem(NoArvoreBinaria no) {
        if (no == null) {
            return;
        }
        percorrerEmOrdem(no.left);
        nosOrdenados.add(no);
        percorrerEmOrdem(no.right);
    }

    private NoArvoreBinaria construirArvoreBalanceada(int inicio, int fim) {
        if (inicio > fim) {
            return null;
        }
        int meio = inicio + (fim - inicio) / 2;
        NoArvoreBinaria raiz = nosOrdenados.get(meio);
        raiz.left = construirArvoreBalanceada(inicio, meio - 1);
        raiz.right = construirArvoreBalanceada(meio + 1, fim);
        return raiz;
    }
} 