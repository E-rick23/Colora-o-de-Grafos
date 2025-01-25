package edb2;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private int vertices; // Número de vértices
    private List<List<Integer>> adjacencia;

    public Grafo(int vertices) {
        this.vertices = vertices;
        adjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int origem, int destino) {
        adjacencia.get(origem).add(destino);
        adjacencia.get(destino).add(origem); // Para grafos não direcionados
    }

    public List<Integer> getAdjacentes(int vertice) {
        return adjacencia.get(vertice);
    }

    public int getVertices() {
        return vertices;
    }
}

