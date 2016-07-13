/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Filial;
import model.Veiculo;
import view.Menu;

/**
 *
 * @author Leo
 */
public class Controle {

    private ArrayList<Filial> filiais;

    public Controle() {
        this.filiais = new ArrayList<>();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        int codFilial;
        Controle controle = new Controle();
        boolean flag = true;
        int op = menu.telaEntrada();

        while (flag) {
            switch (op) {
                case 1:
                    // ENTRAR FILIAL 
                    codFilial = menu.logarFilial();
                    if (controle.localizarFilial(codFilial)) {
                        int op2 = menu.entrarFilial();
                        flag = false;
                        // TRATAR TUDO DO MENU ENTRAR FILIAL AQUI
                        switch (op2) {
                            case 1:
                                // ESTACIONAMENTO
                                //PASSAR OS PARAMETROS
                                int op3 = menu.menuEstacionamento();
                                switch (op3) {
                                    case 1:
                                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                                        Date hora = Calendar.getInstance().getTime();
                                        String horaEntrada = sdf.format(hora);

                                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                                        Date data = Calendar.getInstance().getTime();
                                        String dataEntrada = sdf2.format(data);

                                        String placa = menu.infomePlaca();
                                        int codVeiculo = menu.informeCodVeiculo();
                                        ///////////////////// calcular a vaga antesss ////////////////////////////////
                                        int vaga = 0;
                                        Veiculo veiculo = new Veiculo(placa, codVeiculo, horaEntrada, dataEntrada, vaga);

                                        if (controle.filiais.get(codFilial).insereVeiculoFilial(veiculo)) {
                                            // gerar ticket entrada
                                            
                                            menu.gerarTicket(veiculo.getPlaca() ,veiculo.getVaga(), veiculo.getDataEntrada(), veiculo.getHoraEntrada());
                                        } else {
                                            menu.erroGerarTicket();
                                        }
                                }
                                break;

                            case 2:
                                // FUNCIONARIO 
                                break;

                            case 3:
                            // VOLTAR AO MENU INICIAL
                        }
                    } else {
                        // VERIFICAR SE DIGITAR OPÇÃO INVÁLIDA NOVAMENTE
                        menu.filialInexistente();
                        op = menu.telaEntrada();
                    }
                    break;

                case 2:
                    // INSERIR FILIAL                   
                    int codFilialNova = menu.informeCodigo();
                    while (controle.localizarFilial(codFilialNova)) {
                        menu.filialExistente();
                        codFilialNova = menu.informeCodigo();
                    }
                    float precoCarroHora = menu.precoCarroHora();
                    float precoCarroPernoite = menu.precoCarroPernoite();
                    float precoMotoHora = menu.precoMotoHora();
                    float precoMotoPernoite = menu.precoMotoPernoite();
                    int tamEstacionamento = menu.informeTamEstacionamento();
                    String nomeFilial = menu.informeNome();
                    String enderecoFilial = menu.informeEndereco();
                    Filial nova = new Filial(codFilialNova, nomeFilial, enderecoFilial, precoCarroPernoite, precoMotoPernoite, precoCarroHora, precoMotoHora, tamEstacionamento);
                    controle.filiais.add(nova);
                    break;

                case 3:
                    // EDITAR FILIAL
                    // POR CASE PARA ALTERAR PREÇOS DAS FILIAIS
                    int codEditarFilial = menu.logarFilial();
                    while (!controle.localizarFilial(codEditarFilial)) {
                        menu.filialInexistente();
                        codEditarFilial = menu.logarFilial();
                    }
                    int opEditar = menu.menuEditar();
                    switch (opEditar) {
                        case 1:
                            //REMOVER FILIAL
                            controle.filiais.remove(controle.filiais.get(codEditarFilial));
                            menu.filialRemovida();
                            break;
                        case 2:
                            //ALTERAR NOME DA FILIAL
                            String novoNome;
                            novoNome = menu.informeNome();
                            controle.filiais.get(codEditarFilial).setNome(novoNome);
                            menu.nomeAlterado();
                            break;
                        case 3:
                            // VOLTAR
                            flag = true;
                            menu.telaEntrada();
                            break;
                    }
                case 4:
                    //SAIR
                    menu.sair();
                    break;

            }
        }

    }

    // VER METODO DE RETORNO
    public boolean localizarFilial(int codFilial) {
        for (Filial f : filiais) {
            if (f.getCod() == codFilial) {
                return true;
            }
        }
        return false;
    }

}
