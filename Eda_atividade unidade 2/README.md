# EDA Atividade Unidade 2

Projeto acadêmico de **Estruturas de Dados** desenvolvido em **Java**, com implementações de listas, pilhas, filas, árvores binárias balanceadas e tabela hash (problema Two Sum), acompanhado de testes unitários com **JUnit 5**.

---

## 📋 Sumário

1. [Sobre o Projeto](#-sobre-o-projeto)
2. [Estrutura do Projeto](#-estrutura-do-projeto)
3. [Tecnologias e Requisitos](#-tecnologias-e-requisitos)
4. [Como Executar](#-como-executar)
   - [No Eclipse IDE](#no-eclipse-ide)
   - [Pela linha de comando](#pela-linha-de-comando)
5. [Como Executar os Testes](#-como-executar-os-testes)
6. [Detalhamento das Estruturas de Dados](#-detalhamento-das-estruturas-de-dados)
7. [Exemplos de Uso](#-exemplos-de-uso)
8. [Classes de Teste (JUnit 5)](#-classes-de-teste-junit-5)
9. [Licença](#-licença)

---

## 🎯 Sobre o Projeto

Este projeto foi desenvolvido como atividade da unidade 2 de uma disciplina de **Estruturas de Dados e Algoritmos (EDA)**. Seu objetivo é implementar do zero, em Java, algumas das principais estruturas de dados lineares e não-lineares, demonstrando:

- Encadeamento de nós (lista duplamente encadeada)
- Implementação de Pilha sobre uma lista duplamente encadeada
- Implementação de Fila utilizando **duas pilhas** (abordagem clássica com amortização O(1))
- Balanceamento de árvore binária de busca por meio de travessia em-ordem e reconstrução balanceada
- Resolução do problema **Two Sum** utilizando tabela hash (dicionário) com complexidade O(n)

O projeto inclui exemplos executáveis (`Main` e `TabelaHashMain`) e uma suíte de testes automatizados com **JUnit 5** para validar o comportamento das estruturas.
---

## 📁 Estrutura do Projeto

```
Edaatvunidade2/
├── .project                      # Configuração do Eclipse (Java project)
├── .classpath                    # Classpath do Eclipse (JRE 22, JUnit 5, output bin/)
├── .settings/                    # Configurações do Eclipse
├── bin/                          # Saída de compilação (bytecode .class)
├── src/
│   ├── module-info.java          # Declaração do módulo Java (requires junit, org.junit.jupiter.api)
│   ├── EstruturaDeDados/         # Código-fonte principal
│   │   ├── Main.java             # Classe principal com exemplos de Fila, Pilha e Balanceador
│   │   ├── TabelaHashMain.java   # Classe principal com exemplos de Tabela Hash (Two Sum)
│   │   ├── No.java               # Nó genérico duplamente encadeado
│   │   ├── ListaDuplamenteEncadeada.java  # Lista duplamente encadeada genérica
│   │   ├── Pilha.java            # Pilha (LIFO) baseada na lista duplamente encadeada
│   │   ├── Fila.java             # Fila (FIFO) baseada em duas pilhas
│   │   ├── NoArvoreBinaria.java  # Nó de árvore binária
│   │   ├── BalanceadorArvoreBinaria.java  # Balanceador de árvore binária
│   │   └── TabelaHash.java       # Tabela hash — solução do Two Sum
│   └── testes/                   # Testes unitários JUnit 5
│       ├── TestFila.java
│       ├── TestListaDuplamenteEncadeada.java
│       └── TestPilha.java
└── README.md                     # Este arquivo
```

---

## 🛠 Tecnologias e Requisitos

| Item | Versão / Detalhe |
|------|------------------|
| Linguagem | Java (JavaSE-22) |
| IDE recomendada | Eclipse IDE |
| Gerenciador de dependências | Nenhum (JUnit via classpath do Eclipse) |
| Framework de testes | JUnit 5 (Jupiter) |
| Módulos Java | Sim (`module-info.java`) |

> **Nota:** O projeto está configurado como um projeto Eclipse. Para compilar e executar fora do Eclipse, será necessário ter o JDK 22+ instalado e o JUnit 5 no classpath.

---

## 🚀 Como Executar

### No Eclipse IDE

1. Importe o projeto no Eclipse:
   - `File > Import > General > Existing Projects into Workspace`
   - Selecione a pasta raiz do projeto (`Eda_atividade unidade 2`)
2. O Eclipse reconhecerá automaticamente o projeto Java com natureza JDT.
3. Para executar um exemplo:
   - Clique com o botão direito na classe desejada (`Main.java` ou `TabelaHashMain.java`)
   - `Run As > Java Application`
4. Para executar os testes:
   - Clique com o botão direito na classe de teste (ex: `TestPilha.java`)
   - `Run As > JUnit Test`

### Pela linha de comando

Certifique-se de ter o **JDK 22+** instalado e o JUnit 5 disponível no classpath.

**Compilar:**
```bash
javac --module-source-path src -d bin $(find src -name "*.java")
```

**Executar o Main (exemplos de Fila, Pilha e Árvore):**
```bash
java --module-path bin -m Edaatvunidade2/EstruturaDeDados.Main
```

**Executar o TabelaHashMain (exemplo de Two Sum):**
```bash
java --module-path bin -m Edaatvunidade2/EstruturaDeDados.TabelaHashMain
```

---

## 🧪 Como Executar os Testes

Os testes estão na pasta `src/testes/` e utilizam **JUnit 5 (Jupiter)**.

No Eclipse, basta executar qualquer classe de teste como `JUnit Test`. Todos os testes devem passar, cobrindo casos como:

- Estruturas iniciando vazias
- Exceções ao operar em estruturas vazias (`IllegalStateException`)
- Ordem FIFO na fila
- Ordem LIFO na pilha
- Inserção/remoção de elementos duplicados
- Redução de tamanho após remoções
- Comportamento em listas com muitos elementos (999 itens)

---

## 📚 Detalhamento das Estruturas de Dados

### Lista Duplamente Encadeada (`ListaDuplamenteEncadeada<T>`)

Implementação genérica de lista duplamente encadeada com:

- `adicionarInicio(T)` — insere elemento no início
- `adicionarFim(T)` — insere elemento no final
- `removerInicio()` — remove e retorna o primeiro elemento
- `removerFim()` — remove e retorna o último elemento
- `getInicio()` / `getFim()` — consulta os extremos sem remover
- `estaVazia()` / `getTamanho()` — estado e tamanho

Todos os nós mantêm referências para o anterior e o próximo, permitindo navegação em ambas as direções.

### Pilha (LIFO) (`Pilha<T>`)

Implementada **sobre a lista duplamente encadeada**, inserindo sempre no início da lista (topo da pilha):

- `empilhar(T)` — empilha elemento
- `desempilhar()` — desempilha e retorna o elemento do topo
- `topo()` — consulta o topo sem remover
- `estaVazia()` / `tamanho()`

Lança `IllegalStateException` se tentar desempilhar ou consultar topo de pilha vazia.

### Fila (FIFO) com Duas Pilhas (`Fila<T>`)

Implementação clássica de fila usando **duas pilhas** (`pilhaEntrada` e `pilhaSaida`):

- `enfileirar(T)` — empilha na pilha de entrada
- `desenfileirar()` — transfere elementos da entrada para a saída (se necessário) e desempilha da saída, garantindo ordem FIFO
- `frente()` — consulta o primeiro elemento sem remover
- `estaVazia()` / `tamanho()`

Cada elemento é movido no máximo uma vez entre pilhas, resultando em complexidade amortizada O(1) por operação.

### Árvore Binária e Balanceador (`NoArvoreBinaria`, `BalanceadorArvoreBinaria`)

- `NoArvoreBinaria` representa um nó com valor inteiro e referências `left` e `right`.
- `BalanceadorArvoreBinaria.balancearArvore(raiz)` recebe uma árvore binária (possivelmente desbalanceada) e retorna uma **árvore binária balanceada** contendo os mesmos elementos.

Algoritmo:

1. Faz travessia **em-ordem** (in-order) coletando todos os nós em uma lista ordenada.
2. Reconstrói a árvore recursivamente escolhendo o elemento do meio como raiz de cada subárvore, garantindo balanceamento (altura O(log n)).

### Tabela Hash – Two Sum (`TabelaHash`)

Implementação do problema clássico **Two Sum**:

> Dado um array de inteiros `nums` e um inteiro `target`, retorne os índices de dois números cuja soma é igual a `target`.

- Utiliza `HashMap<Integer, Integer>` para armazenar número → índice.
- Percorre o array uma única vez, calculando o complemento (`target - nums[i]`).
- Complexidade de tempo: **O(n)** | Complexidade de espaço: **O(n)**.
- Retorna um array vazio `int[0]` se não houver solução.

---

## 💻 Exemplos de Uso

### Exemplo 1 — Pilha e Fila (`Main`)

```java
Pilha<String> pilha = new Pilha<>();
pilha.empilhar("A");
pilha.empilhar("B");
pilha.empilhar("C");
// Desempilha em ordem LIFO: C, B, A

Fila<Integer> fila = new Fila<>();
fila.enfileirar(1);
fila.enfileirar(2);
fila.enfileirar(3);
// Desenfileira em ordem FIFO: 1, 2, 3
```

### Exemplo 2 — Balanceamento de Árvore Binária (`Main`)

```java
NoArvoreBinaria raiz = new NoArvoreBinaria(1);
raiz.right = new NoArvoreBinaria(2);
raiz.right.right = new NoArvoreBinaria(3);
raiz.right.right.right = new NoArvoreBinaria(4);
// Árvore desbalanceada (lista encadeada à direita)

BalanceadorArvoreBinaria balanceador = new BalanceadorArvoreBinaria();
NoArvoreBinaria balanceada = balanceador.balancearArvore(raiz);
// Agora a árvore está balanceada
```

### Exemplo 3 — Two Sum (`TabelaHashMain`)

```java
TabelaHash solution = new TabelaHash();
int[] nums = {2, 7, 11, 15};
int target = 9;
int[] result = solution.twoSum(nums, target);
// result = [0, 1]  (nums[0] + nums[1] = 2 + 7 = 9)
```

---

## 🧪 Classes de Teste (JUnit 5)

| Classe | O que testa |
|--------|-------------|
| `TestFila` | Estado inicial, exceções em fila vazia, ordem FIFO, valores duplicados, consulta da frente |
| `TestPilha` | Estado inicial, exceções em pilha vazia, ordem LIFO, valores duplicados, consulta do topo |
| `TestListaDuplamenteEncadeada` | Estado inicial, inserção no início/fim, remoção início/fim, busca de extremos, tamanho, exceções em lista vazia, elementos duplicados, remoção de todos os elementos |

---

## 📜 Licença

Este projeto é de caráter acadêmico, desenvolvido para fins educacionais na disciplina de Estruturas de Dados.

---

*README gerado para o projeto **EDA Atividade Unidade 2** — Estruturas de Dados em Java.*
