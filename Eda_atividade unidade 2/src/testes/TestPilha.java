package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import EstruturaDeDados.Pilha;

public class TestPilha {
    private Pilha<Integer> pilha;

    @BeforeEach
    public void setUp() {
        pilha = new Pilha<>();
    }

    // ---------- Estado inicial ----------

    @Test
    public void deveIniciarVazia() {
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void deveLancarExcecaoAoFazerDesempilharEmPilhaVazia() {
        assertThrows(IllegalStateException.class, () -> {
            pilha.desempilhar();
        });
    }

    @Test
    public void deveLancarExcecaoAoConsultarTopoDePilhaVazia() {
        assertThrows(IllegalStateException.class, () -> {
            pilha.topo();
        });
    }

    // ---------- Inserção e topo ----------

    @Test
    public void devePermitirEmpilharEConsultarTopo() {
        pilha.empilhar(10);
        assertEquals(Integer.valueOf(10), pilha.topo());

        pilha.empilhar(20);
        assertEquals(Integer.valueOf(20), pilha.topo());
    }

    @Test
    public void devePermitirValoresDuplicados() {
        pilha.empilhar(42);
        pilha.empilhar(42);
        assertEquals(Integer.valueOf(42), pilha.topo());
        pilha.desempilhar();
        assertEquals(Integer.valueOf(42), pilha.topo());
    }

    // ---------- Remoção (desempilhar) ----------

    @Test
    public void deveRemoverElementosNaOrdemLIFO() {
        pilha.empilhar(10);
        pilha.empilhar(20);
        pilha.empilhar(30);

        assertEquals(Integer.valueOf(30), pilha.desempilhar());
        assertEquals(Integer.valueOf(20), pilha.desempilhar());
        assertEquals(Integer.valueOf(10), pilha.desempilhar());
        assertTrue(pilha.estaVazia());
    }
} 