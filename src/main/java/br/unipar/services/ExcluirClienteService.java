package br.unipar.services;

import br.unipar.domain.Cliente;
import br.unipar.domain.Lista;
import br.unipar.exceptions.InputNuloExcepetion;
import br.unipar.exceptions.ListaVaziaException;
import br.unipar.exceptions.ObjetoNaoEncontradoException;
import br.unipar.exceptions.ValorVazioException;

import javax.swing.*;

public class ExcluirClienteService {
    private ConsultarClientesCadastadosService consultarClientes = new ConsultarClientesCadastadosService();

    public void execute(Lista<Cliente> lista) {

        try {

            Cliente cliente = consultarClientes.consultarClienteNaLista(lista, true);
            Cliente cliExcluido = lista.removeDaLista(cliente);

            JOptionPane.showMessageDialog(null,
                    "Cliente " + cliExcluido.getId() + " - " + cliExcluido.getNome() + " Removido da lista"
            );


        } catch (InputNuloExcepetion e) {
            return;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


}
