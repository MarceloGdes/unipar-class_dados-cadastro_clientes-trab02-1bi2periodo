package br.unipar;

import br.unipar.domain.Cliente;
import br.unipar.domain.Lista;
import br.unipar.exceptions.InputNuloExcepetion;
import br.unipar.services.AlterarCadastroClienteService;
import br.unipar.services.CadastrarClienteService;
import br.unipar.services.ConsultarClientesCadastadosService;
import br.unipar.services.ExcluirClienteService;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Lista<Cliente> listaClientes = new Lista<>();
        CadastrarClienteService cadastrarCliente = new CadastrarClienteService();
        ExcluirClienteService excluirCliente = new ExcluirClienteService();
        AlterarCadastroClienteService alterarCliente = new AlterarCadastroClienteService();
        ConsultarClientesCadastadosService consultarClientes = new ConsultarClientesCadastadosService();
        int opcao;
        String[] opcoes = {
                "Cadastrar Clientes",
                "Excluir Cadastro",
                "Alterar Cadastro",
                "Consultar Cadastro",
                "Consultar todos os Cadastros"
        };

        do {
            opcao = (JOptionPane.showOptionDialog(
                    null, "Escolha uma opção: ",
                    "Cadastro de Clientes", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]
            ));

            switch (opcao) {
                case 0:
                    cadastrarCliente.execute(listaClientes);
                    break;
                case 1:
                    excluirCliente.execute(listaClientes);
                    break;
                case 2:
                    alterarCliente.execute(listaClientes);
                    break;
                case 3:
                    try {
                        consultarClientes.consultarClienteNaLista(listaClientes, true);
                    }catch (InputNuloExcepetion e){
                        break;
                    }
                    break;
                case 4:
                    consultarClientes.listarClientes(listaClientes);

                    break;
            }

        }while (opcao >= 0);
    }
}