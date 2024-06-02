package br.unipar.domain;

public class Node<E>{

    private E obj;
    private Node<E> anterior;

    private Node<E> proximo;

    public Node(E obj){
        this.obj = obj;
    }

    public E getObj() {
        return obj;
    }

    public void setObj(E obj){
        this.obj = obj;
    }

    public Node<E> getAnterior() {
        return anterior;
    }

    public Node<E> getProximo() {
        return proximo;
    }

    public void setAnterior(Node<E> anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Node<E> proximo) {
        this.proximo = proximo;
    }
}
