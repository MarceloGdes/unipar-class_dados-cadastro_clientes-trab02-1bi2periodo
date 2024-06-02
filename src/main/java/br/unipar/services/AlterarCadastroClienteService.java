package br.unipar.services;

import br.unipar.domain.Cliente;
import br.unipar.domain.Lista;
import br.unipar.exceptions.InputNuloExcepetion;
import br.unipar.exceptions.ObjetoNaoEncontradoException;
import br.unipar.exceptions.ValorVazioException;

import javax.swing.*;

public class AlterarCadastroClienteService {
    private ConsultarClientesCadastadosService consultarClientes = new ConsultarClientesCadastadosService();

    public void execute(Lista<Cliente> lista) {
        try {

            Cliente cliente = consultarClientes.consultarClienteNaLista(lista, true);

            String nome = JOptionPane.showInputDialog(null,
                    "Insira o nome do cliente", cliente.getNome());
            if (nome == null) {
                return;
            } else if (nome.isBlank()) {
                throw new ValorVazioException("Você não Inseriu valor no campo nome");
            }

            String dtNasc = JOptionPane.showInputDialog(null,
                    "Insira a data de nascimento do cliente", cliente.getDtNasc());
            if (dtNasc == null) {
                return;
            } else if (dtNasc.isBlank()) {
                throw new ValorVazioException("Você não Inseriu valor no campo data de nascimento");
            }

            String telefone = JOptionPane.showInputDialog(null,
                    "Insira o telefone do  cliente", cliente.getTelefone());
            if (telefone == null) {
                return;
            } else if (telefone.isBlank()) {
                throw new ValorVazioException("Você não Inseriu valor no campo data de nascimento");
            }

            cliente.setDtNasc(dtNasc);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);

            JOptionPane.showMessageDialog(null,
                    "Cliente cod: " + cliente.getId() + " alterado com sucesso!!\n" +
                            "\nNome: " + cliente.getNome() +
                            "\nData Nascimento: " + cliente.getDtNasc() +
                            "\nTelefone: " + cliente.getTelefone()
                    );



        } catch (ValorVazioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            execute(lista);

        } catch (InputNuloExcepetion e) {
            return;

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
