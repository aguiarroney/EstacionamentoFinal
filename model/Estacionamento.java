
package model;

import java.util.ArrayList;


public class Estacionamento {

    private int tamanhoEstacionamento;
    private int[] vagas; // se o conteudo do vetor for 0 = vazio, 1 = opcupado, 2 = reservado 
    private ArrayList<Veiculo> veiculos;
    
    public Estacionamento(int tamanhoEstacionamento) {
        this.tamanhoEstacionamento = tamanhoEstacionamento;
        this.vagas = new int[this.tamanhoEstacionamento];
        this.veiculos = new ArrayList<>();
    }
    
    public boolean insereVeiculo(Veiculo veiculo) {
        return this.veiculos.add(veiculo);
    }
    
}
