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
}

