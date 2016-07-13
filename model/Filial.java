/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas
 */
public class Filial {

    private int cod;
    private String nome;
    private String endereco;
    private float precoPernoiteCarro;
    private float precoPernoiteMoto;
    private float precoHoraCarro;
    private float precoHoraMoto;
    private Estacionamento estacionamento;

    public Filial(int cod, String nome, String endereco, float precoPernoiteCarro, float precoPernoiteMoto, float precoHoraCarro, float precoHoraMoto, int tam) {
        this.cod = cod;
        this.nome = nome;
        this.endereco = endereco;
        this.precoPernoiteCarro = precoPernoiteCarro;
        this.precoPernoiteMoto = precoPernoiteMoto;
        this.precoHoraCarro = precoHoraCarro;
        this.precoHoraMoto = precoHoraMoto;
        this.estacionamento = new Estacionamento(tam);
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoPernoiteCarro(float precoPernoiteCarro) {
        this.precoPernoiteCarro = precoPernoiteCarro;
    }

    public void setPrecoPernoiteMoto(float precoPernoiteMoto) {
        this.precoPernoiteMoto = precoPernoiteMoto;
    }

    public void setPrecoHoraCarro(float precoHoraCarro) {
        this.precoHoraCarro = precoHoraCarro;
    }

    public void setPrecoHoraMoto(float precoHoraMoto) {
        this.precoHoraMoto = precoHoraMoto;
    }

    public float getPrecoPernoiteCarro() {
        return precoPernoiteCarro;
    }

    public float getPrecoPernoiteMoto() {
        return precoPernoiteMoto;
    }

    public float getPrecoHoraCarro() {
        return precoHoraCarro;
    }

    public float getPrecoHoraMoto() {
        return precoHoraMoto;
    }

    public boolean insereVeiculoFilial(Veiculo veiculo) {
        return this.estacionamento.insereVeiculo(veiculo);
    }

}
