package edb2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Coloração de Grafos - Interativo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        // Configuração inicial do grafo
        Grafo grafo = new Grafo(0); // Começa vazio
        List<Integer> cores = new ArrayList<>(); // Usando lista dinâmica para cores

        // Painel de visualização do grafo
        VisualizadorGrafo painel = new VisualizadorGrafo(grafo, cores);

        // Painel de controle
        JPanel painelControle = new JPanel();
        painelControle.setLayout(new GridLayout(2, 1));

        // Inputs e botões
        JPanel painelVertices = new JPanel();
        JButton btnAdicionarVertice = new JButton("Adicionar Vértice");
        JButton btnAdicionarAresta = new JButton("Adicionar Aresta");
        JTextField campoVertice1 = new JTextField(3);
        JTextField campoVertice2 = new JTextField(3);

        painelVertices.add(new JLabel("Vértice 1:"));
        painelVertices.add(campoVertice1);
        painelVertices.add(new JLabel("Vértice 2:"));
        painelVertices.add(campoVertice2);
        painelVertices.add(btnAdicionarAresta);
        painelVertices.add(btnAdicionarVertice);

        painelControle.add(painelVertices);

        // Ações dos botões
        btnAdicionarVertice.addActionListener(e -> {
            grafo.adicionarVertice();
            cores.add(cores.size()); // Adiciona uma nova cor
            painel.atualizarGrafo(grafo, cores);
        });

        btnAdicionarAresta.addActionListener(e -> {
            try {
                int v1 = Integer.parseInt(campoVertice1.getText());
                int v2 = Integer.parseInt(campoVertice2.getText());
                grafo.adicionarAresta(v1, v2);
                painel.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Digite números válidos para os vértices.");
            } catch (IndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(frame, "Os vértices não existem.");
            }
        });

        // Adicionar os painéis ao frame
        frame.add(painel, BorderLayout.CENTER);
        frame.add(painelControle, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}