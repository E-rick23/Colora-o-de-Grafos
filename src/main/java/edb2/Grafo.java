package edb2;

import java.util.ArrayList;
import java.util.List;

class Grafo {
    private int vertices;
    private List<List<Integer>> adjacencia;

    public Grafo(int vertices) {
        this.vertices = vertices;
        adjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int u, int v) {
        if (!adjacencia.get(u).contains(v)) {
            adjacencia.get(u).add(v);
            adjacencia.get(v).add(u); // Para grafo não-direcionado
        }
    }

    public int getVertices() {
        return vertices;
    }

    public List<Integer> getAdjacentes(int v) {
        return adjacencia.get(v);
    }

    public void adicionarVertice() {
        adjacencia.add(new ArrayList<>());
        vertices++;
    }
    public List<Integer> colorirGrafo() {
        List<Integer> cores = new ArrayList<>();
        int vertices = getVertices();

        // Inicializa todos os vértices sem cor (-1 significa "sem cor")
        for (int i = 0; i < vertices; i++) {
            cores.add(-1);
        }

        // Itera sobre os vértices para colorir
        for (int v = 0; v < vertices; v++) {
            // Marca as cores dos vizinhos como ocupadas
            boolean[] coresOcupadas = new boolean[vertices]; // Até "vertices" cores possíveis
            for (int vizinho : getAdjacentes(v)) {
                if (cores.get(vizinho) != -1) {
                    coresOcupadas[cores.get(vizinho)] = true;
                }
            }

            // Encontra a menor cor disponível
            int menorCorDisponivel = 0;
            while (menorCorDisponivel < coresOcupadas.length && coresOcupadas[menorCorDisponivel]) {
                menorCorDisponivel++;
            }

            // Atribui a menor cor disponível ao vértice
            cores.set(v, menorCorDisponivel);
        }

        return cores;
    }

}

