package edb2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class VisualizadorGrafo extends JPanel {
    private Grafo grafo;
    private List<Integer> cores;
    private int raio = 20; // Raio dos vértices
    private List<Point> posicoes; // Posições dos vértices

    public VisualizadorGrafo(Grafo grafo, List<Integer> cores) {
        this.grafo = grafo;
        this.cores = cores;
        this.posicoes = new ArrayList<>();
        calcularPosicoes();
    }
    //Construtor para atualizar o grafo a medida que novos vertices e arestas forem adicionados
    public void atualizarGrafo(Grafo grafo, List<Integer> cores) {
        this.grafo = grafo;
        this.cores = cores;
        calcularPosicoes();
        repaint();
    }
//Função que adiciona e atualiza os vertices e arestas na interface
    private void calcularPosicoes() {
        posicoes.clear();
        int numVertices = grafo.getVertices();
        int largura = 400; // Largura do painel
        int altura = 400;  // Altura do painel
        int centroX = largura / 2;
        int centroY = altura / 2;
        int raioCirculo = 150; // Raio do círculo de disposição

        for (int i = 0; i < numVertices; i++) {
            double angulo = 2 * Math.PI * i / numVertices;
            int x = centroX + (int) (raioCirculo * Math.cos(angulo));
            int y = centroY + (int) (raioCirculo * Math.sin(angulo));
            posicoes.add(new Point(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Aumentar a grossura das linhas
        g2d.setStroke(new BasicStroke(2.0f));

        // Desenhar as arestas
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < grafo.getVertices(); i++) {
            for (int adj : grafo.getAdjacentes(i)) {
                Point p1 = posicoes.get(i);
                Point p2 = posicoes.get(adj);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        // Desenhar os vértices
        for (int i = 0; i < grafo.getVertices(); i++) {
            Point pos = posicoes.get(i);
            g2d.setColor(getCor(cores.get(i))); // Define a cor do vértice
            g2d.fillOval(pos.x - raio / 2, pos.y - raio / 2, raio, raio);

            // Configurar a cor do texto dependendo da cor do vértice
            if (getCor(cores.get(i)).equals(Color.BLUE)) {
                g2d.setColor(Color.WHITE); // Números brancos para vértices azuis
            } else {
                g2d.setColor(Color.BLACK); // Números pretos para outras cores
            }
            g2d.drawString(String.valueOf(i), pos.x - 5, pos.y + 5);
        }
    }

    private Color getCor(int indice) {
        // Define uma paleta básica de cores
        Color[] paleta = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.CYAN};
        return paleta[indice % paleta.length];
    }
}
