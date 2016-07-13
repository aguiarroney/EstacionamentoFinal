/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Menu {

    public int telaEntrada() {
        int op;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("(1) Entrar Filial.");
            System.out.println("(2) Inserir Filial.");
            System.out.println("(3) Editar Filial.");
            System.out.println("(4) Sair.");
            Scanner s = new Scanner(System.in);
            op = s.nextInt();
        } while (op < 1 || op > 4);
        return op;
    }

    public int logarFilial() {
        int op;
        System.out.println("Informe o código da filial:");
        Scanner s = new Scanner(System.in);
        do {
            op = s.nextInt();
        } while (op < 0);
        return op;
    }

    public int entrarFilial() {
        int op;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("(1) Estacionamento.");
            System.out.println("(2) Funcionário.");
            System.out.println("(3) Voltar.");
            System.out.println("(4) Sair.");
            Scanner s = new Scanner(System.in);
            op = s.nextInt();
        } while (op < 1 || op > 4);
        return op;
    }

    public int menuEditar() {
        int op;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("(1) Remover Filial.");
            System.out.println("(2) Alterar nome da Filial.");
            System.out.println("(3) Voltar.");
            Scanner s = new Scanner(System.in);
            op = s.nextInt();
        } while (op < 1 || op > 3);
        return op;
    }

    public int menuEstacionamento(float precoHoraC, float precoHoraM, float precoPernoiteC, float precoPernoiteM) {
        int op;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("(1) Registrar entrada.");
            System.out.println("(2) Registrar saída.");
            System.out.println("(3) Fechar conta e sair.");
            System.out.println("Preço Hora Carro: " + precoHoraC);
            System.out.println("Preço Hora Moto: " + precoHoraM);
            System.out.println("Preço Pernoite Carro: " + precoPernoiteC);
            System.out.println("Preço Pernoite Moto: " + precoPernoiteM);
            System.out.println("Melhor vaga carro: ");
            System.out.println("Melhor vaga moto: ");
            Scanner s = new Scanner(System.in);
            op = s.nextInt();
        } while (op < 1 || op > 4);
        return op;
    }

    public void filialExistente() {
        System.out.println("Filial ja existente.");
    }

    public void filialInexistente() {
        System.out.println("Filial inexistente.");
    }

    public int informeCodigo() {
        int cod;
        System.out.println("Informe o codigo da nova filial: ");
        Scanner s = new Scanner(System.in);
        cod = s.nextInt();
        return cod;
    }

    public String informeNome() {
        String nome;
        System.out.println("Informe o nome da nova filial: ");
        Scanner s = new Scanner(System.in);
        nome = s.nextLine();
        return nome;
    }

    public String informeEndereco() {
        String endereco;
        System.out.println("Informe o endereco da nova filial: ");
        Scanner s = new Scanner(System.in);
        endereco = s.nextLine();
        return endereco;
    }

    public void filialRemovida() {
        System.out.println("Filial removida com sucesso!");
    }

    public void nomeAlterado() {
        System.out.println("Nome alterado com sucesso!");
    }

    public void sair() {
        System.out.println("Obrigado pela preferencia");
    }

    public float precoCarroHora() {
        float p;
        System.out.println("Informe o preço da hora para carros da nova filial: ");
        Scanner s = new Scanner(System.in);
        p = s.nextFloat();
        return p;
    }

    public float precoCarroPernoite() {
        float p;
        System.out.println("Informe o preço do pernoite para carros da nova filial: ");
        Scanner s = new Scanner(System.in);
        p = s.nextFloat();
        return p;
    }

    public float precoMotoPernoite() {
        float p;
        System.out.println("Informe o preço do pernoite para motos da nova filial: ");
        Scanner s = new Scanner(System.in);
        p = s.nextFloat();
        return p;
    }

    public float precoMotoHora() {
        float p;
        System.out.println("Informe o preço da hora para motos da nova filial: ");
        Scanner s = new Scanner(System.in);
        p = s.nextFloat();
        return p;
    }

    public String infomePlaca() {
        String placa;
        System.out.println("Informe a placa : ");
        Scanner s = new Scanner(System.in);
        placa = s.next();
        return placa;
    }

    public int informeCodVeiculo() {
        int cod;
        System.out.println("Digite o tipo do veiculo: ");
        System.out.println("0 - carro\n1 -  moto");
        Scanner s = new Scanner(System.in);
        cod = s.nextInt();
        return cod;
    }

    public int informeTamEstacionamento() {
        int tam;
        System.out.println("Digite o tamanho do estacionamento: ");
        Scanner s = new Scanner(System.in);
        tam = s.nextInt();
        return tam;
    }

    public void gerarTicket(String placa, int vaga, String data, String hora){
        System.out.println("-- BEM-VINDO -- ");
        System.out.println("Vaga: " + vaga);
        System.out.println("Placa: " + placa);
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
    }
    
    public void erroGerarTicket(){
        System.out.println("Erro ao gerar ticket.");
    }
}
