package br.unipar.domain;

import br.unipar.exceptions.ListaVaziaException;
import br.unipar.exceptions.ObjetoNaoEncontradoException;

public class Lista <E>{
    private Node<E> primeiro;
    private Node<E> ultimo;

    public E getPrimeiro() {
        return primeiro.getObj();
    }

    public E getUltimo() {
        return ultimo.getObj();
    }

    public Node<E> getPrimeiroNode(){
        return primeiro;
    }
    

    public void incluirNoFim(E obj){
        Node<E> novoNode = new Node<>(obj);
        if (isEmpty()){
            primeiro = novoNode;
            ultimo = novoNode;
        }else {
            ultimo.setProximo(novoNode);
            novoNode.setAnterior(ultimo);
            ultimo = novoNode;
        }

    }

    public void incluirNoInicio(E obj){
        Node<E> novoNode = new Node<>(obj);
        if (isEmpty()){
            primeiro = novoNode;
            ultimo = novoNode;
        }else {
            novoNode.setProximo(primeiro);
            primeiro.setProximo(novoNode);
            primeiro = novoNode;
        }
    }

    public E excluirDoInicio() throws ListaVaziaException {
        if (isEmpty()){
            throw new ListaVaziaException();
        }

        E objExluido = primeiro.getObj();

        if(primeiro == ultimo){
            primeiro = null;
            ultimo = null;
        }else primeiro = primeiro.getProximo();

        return objExluido;
    }

    public E excluirDoFim() throws ListaVaziaException{
        if (isEmpty()){
            throw new ListaVaziaException();
        }

        E objExluido = ultimo.getObj();

        if(primeiro == ultimo){
            primeiro = null;
            ultimo = null;

        }else
            ultimo = ultimo.getProximo();

        return objExluido;
    }

    public E excluir(Node<E> node) throws ListaVaziaException{

        if (isEmpty()){
            throw new ListaVaziaException();
        }

        E objExcluido = node.getObj();
        Node<E> proximo = node.getProximo();
        Node<E> anterior = node.getAnterior();

        if (anterior == null){
            primeiro = proximo;
        }else {
            anterior.setProximo(proximo);
            node.setAnterior(null);
        }

        if (proximo == null){
            ultimo = anterior;
        }else {
            proximo.setAnterior(anterior);
            node.setProximo(null);
        }

        node.setObj(null);
        return objExcluido;

    }

    public E removeDaLista(E obj) throws ListaVaziaException, ObjetoNaoEncontradoException {
        if (isEmpty()){
            throw new ListaVaziaException();
        }

        for (Node<E> node = primeiro;
             node != null;
             node = node.getProximo())
        {
            if (node.getObj().equals(obj)){
                E objEcluido = excluir(node);
                return objEcluido;
            }
        }

        throw new ObjetoNaoEncontradoException("Objeto não encontado");
    }

    public boolean isEmpty(){ return primeiro == null; }
}
