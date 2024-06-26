package br.unipar.domain;


public class Cliente {
    private Integer id;
    private String nome;
    private String dtNasc;
    private String telefone;

    public Cliente(Integer id, String nome, String dtNasc, String telefone) {
        this.id = id;
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dtNasc='" + dtNasc + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
