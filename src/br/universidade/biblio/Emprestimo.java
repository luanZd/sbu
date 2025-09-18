package br.universidade.biblio;

import java.util.Date;

public class Emprestimo {
    private Livro livro_emprestado;
    private Usuario usuario_emprestado;
    private Date data_emprestimo;
    private Date data_devolucao;
    private boolean devolvido;

    private Utils utilidade = new Utils();

    public Emprestimo(Usuario usuario, Livro livro, Date dataEmprestimo, Date dataDevolucao) {
        this.usuario_emprestado = usuario;
        this.livro_emprestado = livro;
        this.data_emprestimo = dataEmprestimo;
        this.data_devolucao = dataDevolucao;
        this.devolvido = false;
    }

    public Date getDataEmprestimo() {
        return data_emprestimo;
    }

    public Date getDataDevolucao() {
        return data_devolucao;
    }

    public Livro getLivro() {
        return livro_emprestado;
    }

    public Usuario getUsuario() {
        return usuario_emprestado;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public void registrarEmprestimo(Livro livro, Usuario usr, Date data){
        if(utilidade.validarTipoData(data)){
            data_emprestimo = data;
        } else {
            System.out.println("Data inválida");
            return;
        }
        livro_emprestado = livro;
        usuario_emprestado = usr;
    }

    public void registrarDevolucao(Date data){
        if(utilidade.validarTipoData(data)){
            data_devolucao = data;
        } else {
            System.out.println("Data inválida");
        }
    }

    public void getInfo(){
        System.out.print("Livro emprestado: ");
        System.out.println(livro_emprestado);

        System.out.print("Usuário responsável: ");
        System.out.println(usuario_emprestado);

        System.out.print("Data de Empréstimo: ");
        System.out.println(data_emprestimo);

        if(data_devolucao != null){
            System.out.print("Data de Devolução: ");
            System.out.println(data_devolucao);
        } else {
            System.out.println("Devolução pendente");
        }
    }
}

