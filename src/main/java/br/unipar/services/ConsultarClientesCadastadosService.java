package br.unipar.services;

import br.unipar.domain.Cliente;
import br.unipar.domain.Lista;
import br.unipar.domain.Node;
import br.unipar.exceptions.InputNuloExcepetion;
import br.unipar.exceptions.ListaVaziaException;
import br.unipar.exceptions.ObjetoNaoEncontradoException;
import br.unipar.exceptions.ValorVazioException;

import javax.swing.*;

public class ConsultarClientesCadastadosService {

    public void listarClientes(Lista<Cliente> lista){
        try {
            if (lista.isEmpty()){
                throw new ListaVaziaException();
            }

            String msg = "";
            for (Node<Cliente> node = lista.getPrimeiroNode();
                 node != null;
                 node = node.getProximo())
            {
                Cliente cliente = node.getObj();
                msg += "\n\nCliente: " + cliente.getId() + " - " + cliente.getNome() +
                        "\nData de Nascimento: " + cliente.getDtNasc() +
                        "\nTelefone: " + cliente.getTelefone();
            }

            JOptionPane.showMessageDialog(null, msg);

        }catch (ListaVaziaException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Cliente consultarClienteNaLista(Lista<Cliente> lista, boolean mostrarClienteNaTela) throws InputNuloExcepetion {
        try {
            String cod = JOptionPane.showInputDialog("Insira o Codigo do cliente");
            if (cod == null) {
                throw new InputNuloExcepetion();
            } else if (cod.isBlank()) {
                throw new ValorVazioException("Você não inseriu valor no campo codigo");
            }

            Integer id = Integer.parseInt(cod);
            Cliente cliente = encontrarClienteNaListaPeloId(id, lista);

            if (mostrarClienteNaTela && cliente != null) {
                JOptionPane.showMessageDialog(null,
                        "Cliente cod " + cliente.getId() +
                                "\n\nNome: " + cliente.getNome() +
                                "\nData de Nascimento: " + cliente.getDtNasc() +
                                "\nTelefone: " + cliente.getTelefone()
                );
            }

            return cliente;

        } catch (ValorVazioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            consultarClienteNaLista(lista, mostrarClienteNaTela);

        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Você não digitou um valor válido para o codigo");
            consultarClienteNaLista(lista, mostrarClienteNaTela);
        } catch (ObjetoNaoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            consultarClienteNaLista(lista, mostrarClienteNaTela);

        }

        throw new InputNuloExcepetion();

    }

    public Cliente encontrarClienteNaListaPeloId(Integer id, Lista<Cliente> lista) throws ObjetoNaoEncontradoException {
        Node<Cliente> node = lista.getPrimeiroNode();

        while (node != null) {
            if (node.getObj().getId().equals(id)) {
                return node.getObj();
            }
            node = node.getProximo();
        }

        throw new ObjetoNaoEncontradoException("Não encontrado cliente codigo digitado");
    }


}
