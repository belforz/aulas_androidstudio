package com.example.avaliacao;

public class Filme {
    private int codigo;
    private String filme;
    private String ano;
    private String atores;
    private String diretor;
    private String descricao;
    //  Construtor da classe Filme que recebe como parâmetro todas as variáveis da classe.
    public Filme(int codigo, String filme, String ano, String atores, String diretor, String descricao) {
        this.codigo = codigo;
        this.filme= filme;
        this.ano = ano;
        this.atores = atores;
        this.diretor = diretor;
        this.descricao = descricao;
    }
    // Construtor da classe Filme que recebe como parâmetro todas as variáveis da classe, exceto o código.
    public Filme(String filme, String ano, String atores, String diretor, String descricao) {
        this.codigo = codigo;
        this.filme = filme;
        this.ano = ano;
        this.atores = atores;
        this.diretor = diretor;
        this.descricao = descricao;
    }
    // metodos para definir e rotrnar os valores atribuidos as constantes declaradas
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
