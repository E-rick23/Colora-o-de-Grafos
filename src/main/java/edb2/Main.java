package edb2;

import javax.swing.*;

public class Main{
    public static void main(String[] args){
        // Configura o grafo
        Grafo grafo = new Grafo(6);
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 5);

        // Executa o algoritmo de coloração
        int[] cores = colorirGrafo(grafo);

        // Cria o frame para exibição
        JFrame frame = new JFrame("Visualização de Coloração de Grafo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        VisualizadorGrafo painel = new VisualizadorGrafo(grafo, cores);
        frame.add(painel);
        frame.setVisible(true);
    }

    public static int[] colorirGrafo(Grafo grafo) {
        int numVertices = grafo.getVertices();
        int[] cores = new int[numVertices];
        boolean[] coresDisponiveis = new boolean[numVertices];

        for (int u = 0; u < numVertices; u++) {
            // Marca todas as cores como disponíveis
            for (int i = 0; i < numVertices; i++) {
                coresDisponiveis[i] = true;
            }

            // Verifica as cores dos vizinhos
            for (int vizinho : grafo.getAdjacentes(u)) {
                if (cores[vizinho] != -1) {
                    coresDisponiveis[cores[vizinho]] = false;
                }
            }

            // Encontra a primeira cor disponível
            for (int cor = 0; cor < numVertices; cor++) {
                if (coresDisponiveis[cor]) {
                    cores[u] = cor;
                    break;
                }
            }
        }

        return cores;
    }
}
