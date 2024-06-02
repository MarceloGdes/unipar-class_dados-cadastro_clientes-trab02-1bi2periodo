package br.unipar.services;

import br.unipar.domain.Cliente;
import br.unipar.domain.Lista;
import br.unipar.exceptions.ValorVazioException;

import javax.swing.*;

public class CadastrarClienteService {
    private Integer contId = 1;

    public void execute(Lista<Cliente> lista) {
        String nome, telefone, dtNascimento;

        try {

            //Quando é clicado em cancel ou no X, o JOption deixa o campo nulo;
            nome = JOptionPane.showInputDialog("Digite o nome do cliente");
            if (nome == null) {
                return;
            } else if (nome.isBlank()) {
                throw new ValorVazioException("Você não inseriu valor no campo nome");
            }

            dtNascimento = JOptionPane.showInputDialog("Digite a data de nascimento");
            if (dtNascimento == null) {
                return;
            } else if (dtNascimento.isBlank()) {
                throw new ValorVazioException("Você não inseriu valor no campo data de nascimento");
            }

            telefone = JOptionPane.showInputDialog("Digite o telefone");
            if (telefone == null) {
                return;
            } else if (telefone.isBlank()) {
                throw new ValorVazioException("Você não inseriu valor no campo telefone");
            }


            Cliente cliente = new Cliente(contId, nome, dtNascimento, telefone);
            lista.incluirNoFim(cliente);
            contId++;

            //System.out.println(cliente.toString());

        } catch (ValorVazioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            execute(lista);
        }

    }

}
