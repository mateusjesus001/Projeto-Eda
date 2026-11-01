package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import EstruturaDeDados.Fila;

public class TestFila {
    private Fila<Integer> fila;

    @BeforeEach
    public void setUp() {
        fila = new Fila<>();
    }

    // ---------- Estado inicial ----------

    @Test
    public void deveIniciarVazia() {
        assertTrue(fila.estaVazia());
    }

    @Test
    public void deveLancarExcecaoAoDesenfileirarEmFilaVazia() {
        assertThrows(IllegalStateException.class, () -> {
            fila.desenfileirar();
        });
    }

    @Test
    public void deveLancarExcecaoAoConsultarFrenteDeFilaVazia() {
        assertThrows(IllegalStateException.class, () -> {
            fila.frente();
        });
    }

    // ---------- Inserção e frente ----------

    @Test
    public void devePermitirEnfileirarEConsultarFrente() {
        fila.enfileirar(100);
        assertEquals(Integer.valueOf(100), fila.frente());

        fila.enfileirar(200);
        assertEquals(Integer.valueOf(100), fila.frente());
    }

    @Test
    public void devePermitirValoresDuplicados() {
        fila.enfileirar(99);
        fila.enfileirar(99);
        assertEquals(Integer.valueOf(99), fila.frente());
        fila.desenfileirar();
        assertEquals(Integer.valueOf(99), fila.frente());
    }

    // ---------- Remoção (desenfileirar) ----------

    @Test
    public void deveRemoverElementosNaOrdemFIFO() {
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);

        assertEquals(Integer.valueOf(10), fila.desenfileirar());
        assertEquals(Integer.valueOf(20), fila.desenfileirar());
        assertEquals(Integer.valueOf(30), fila.desenfileirar());
        assertTrue(fila.estaVazia());
    }
} 