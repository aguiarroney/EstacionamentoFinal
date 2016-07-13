/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pai
 */
public class Veiculo {

    private String placa;
    private int codigo; // 0 - carro | 1 - moto
    private String horaEntrada;
    private String dataEntrada;
    private int vaga;

    public Veiculo(String placa, int codigo, String horaEntrada, String dataEntrada, int vaga) {
        this.placa = placa;
        this.codigo = codigo;
        this.horaEntrada = horaEntrada;
        this.dataEntrada = dataEntrada;
        this.vaga = vaga;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public int getVaga() {
        return vaga;
    }

    
    
}
