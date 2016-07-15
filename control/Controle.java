
package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Filial;
import model.Veiculo;
import view.Menu;


public class Controle {

    private ArrayList<Filial> filiais;

    public Controle() {
        this.filiais = new ArrayList<>();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        int codFilial;
        Controle controle = new Controle();
        Filial filialAux;
        boolean flag = true;
        int op = menu.telaEntrada();

        while (flag) {
            switch (op) {
                case 1:
                    // ENTRAR FILIAL 
                    codFilial = menu.logarFilial();
                    filialAux = controle.localizarFilial(codFilial);
                    if (filialAux != null) {
                        int op2 = menu.entrarFilial();
                        // TRATAR TUDO DO MENU ENTRAR FILIAL AQUI
                        switch (op2) {
                            case 1:
                                // ESTACIONAMENTO
                                
                                int op3 = menu.menuEstacionamento(filialAux.getPrecoHoraCarro(), filialAux.getPrecoHoraMoto(), filialAux.getPrecoPernoiteCarro(), filialAux.getPrecoPernoiteMoto());
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

                                            menu.gerarTicket(veiculo.getPlaca(), veiculo.getVaga(), veiculo.getDataEntrada(), veiculo.getHoraEntrada());
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
                    while (controle.localizarFilial(codFilialNova) != null) {
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

                    //AI O PAI CONSERTOU NÉ
                    op = menu.telaEntrada(); // RONEY ADD ESSA LINHA DE BAIXO PQ TAVA COM ERRO
                    break;

                case 3:
                    // EDITAR FILIAL
                    // POR CASE PARA ALTERAR PREÇOS DAS FILIAIS

                    int codEditarFilial = menu.logarFilial();
                    filialAux = controle.localizarFilial(codEditarFilial);
                    if (filialAux == null) {
                        menu.filialInexistente();
                        op = menu.telaEntrada();
                        break;

                    } else {
                        int opEditar = menu.menuEditar();
                        switch (opEditar) {
                            case 1:
                                //REMOVER FILIAL
                                if (controle.removerFilial(codEditarFilial)) {
                                    menu.filialRemovida();
                                } else {
                                    //IMPRIMIR MENSAGEM DE ERRO AO REMOVER
                                }
                                op = menu.telaEntrada();
                                break;
                            case 2:
                                //ALTERAR NOME DA FILIAL MEXER
                                String novoNome;
                                novoNome = menu.informeNome();
                                if (controle.editarFilial(codEditarFilial, novoNome)) {
                                    menu.nomeAlterado();
                                } else {
                                    //LEO CRIAR MENU DE ERRO
                                }
                                op = menu.telaEntrada();
                                break;
                            case 3:
                                // VOLTAR
                                op = menu.telaEntrada();
                                break;
                        }
                    }
                    break;
                case 4:
                    //SAIR
                    menu.sair();
                    flag = false; // ADICIONEI ESSA LINHA AQUI PQ TAVA CM ERRO
                    break;

            }
        }

    }

    private Filial localizarFilial(int codFilial) {
        for (Filial f : filiais) {
            if (f.getCod() == codFilial) {
                return f;
            }
        }
        return null;
    }

    private boolean removerFilial(int codigo) {
        for (Filial f : this.filiais) {

            if (f.getCod() == codigo) {
                filiais.remove(f);
                return true;

            }
        }
        return false;
    }

    private boolean editarFilial(int codEditarFilial, String novoNome) {
        for (Filial f : filiais) {
            if (f.getCod() == codEditarFilial) {
                f.setNome(novoNome);
                return true;
            }
        }
        return false;
    }

}
