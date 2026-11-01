package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import EstruturaDeDados.ListaDuplamenteEncadeada;

public class TestListaDuplamenteEncadeada {
    private ListaDuplamenteEncadeada<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaDuplamenteEncadeada<>();
    }

    // ---------- Testes de estado inicial ----------

    @Test
    public void deveIniciarVazia() {
        assertTrue(lista.estaVazia());
        assertEquals(0, lista.getTamanho());
    }

    @Test
    public void deveLancarExcecaoAoObterInicioDeListaVazia() {
        assertThrows(IllegalStateException.class, () -> {
            lista.getInicio();
        });
    }

    @Test
    public void deveLancarExcecaoAoObterFimDeListaVazia() {
        assertThrows(IllegalStateException.class, () -> {
            lista.getFim();
        });
    }

    @Test
    public void deveLancarExcecaoAoRemoverElementoInexistente() {
        assertThrows(IllegalStateException.class, () -> {
            lista.removerInicio();
        });
    }

    // ---------- Testes de inserção, busca e tamanho ----------

    @Test
    public void deveInserirElementosEAumentarTamanho() {
        for (int i = 0; i < 999; i++) {
            assertEquals(i, lista.getTamanho());
            lista.adicionarFim(1000 + i);
            assertEquals(i + 1, lista.getTamanho());
        }
    }

    @Test
    public void deveInserirEPermitirBuscaSimples() {
        lista.adicionarFim(555);
        lista.adicionarFim(777);
        assertEquals(Integer.valueOf(555), lista.getInicio());
        assertEquals(Integer.valueOf(777), lista.getFim());
    }

    @Test
    public void deveInserirEPermitirBuscaSequencial() {
        for (int i = 0; i < 999; i++) {
            lista.adicionarFim(1000 + i);
            assertEquals(Integer.valueOf(1000 + i), lista.getFim());
        }
    }

    @Test
    public void devePermitirElementosDuplicados() {
        lista.adicionarFim(42);
        lista.adicionarFim(42);
        assertEquals(2, lista.getTamanho());

        lista.removerInicio(); // remove uma ocorrência
        assertEquals(1, lista.getTamanho());
        assertEquals(Integer.valueOf(42), lista.getInicio());
    }

    // ---------- Testes de início e fim ----------

    @Test
    public void deveRetornarInicioEFimCorretamente() {
        lista.adicionarFim(10);
        lista.adicionarFim(20);
        lista.adicionarFim(30);
        assertEquals(Integer.valueOf(10), lista.getInicio());
        assertEquals(Integer.valueOf(30), lista.getFim());
    }

    // ---------- Testes de remoção ----------

    @Test
    public void deveRemoverElementoComReducaoDeTamanho() {
        lista.adicionarFim(555);
        lista.adicionarFim(777);
        assertEquals(2, lista.getTamanho());
        lista.removerInicio();
        assertEquals(1, lista.getTamanho());
    }

    @Test
    public void deveLancarExcecaoAoObterElementoRemovido() {
        lista.adicionarFim(555);
        lista.adicionarFim(777);
        lista.removerInicio();
        assertEquals(Integer.valueOf(777), lista.getInicio());
    }

    @Test
    public void deveRemoverTodosOsElementos() {
        lista.adicionarFim(1);
        lista.adicionarFim(2);
        lista.adicionarFim(3);
        lista.removerInicio();
        lista.removerInicio();
        lista.removerInicio();
        assertTrue(lista.estaVazia());
        assertEquals(0, lista.getTamanho());
    }

    @Test
    public void deveRemoverInicioEFimCorretamente() {
        lista.adicionarFim(10);
        lista.adicionarFim(20);
        lista.adicionarFim(30);

        lista.removerInicio(); // remove início
        assertEquals(Integer.valueOf(20), lista.getInicio());

        lista.removerFim(); // remove fim
        assertEquals(Integer.valueOf(20), lista.getFim());
    }
} 