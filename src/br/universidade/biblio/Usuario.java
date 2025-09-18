package br.universidade.biblio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String matricula;
    private String curso;
    private List<Livro> listaDeEmprestimos; 

    public Usuario(String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = gerarMatricula();
        this.listaDeEmprestimos = new ArrayList<>(); 
    }

    private String gerarMatricula() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMddHH");
        String dataFormatada = formatter.format(agora);

        Random random = new Random();
        int numeroAleatorio = 1000 + random.nextInt(9000);

        return dataFormatada + numeroAleatorio;
    }

    public void adicionarEmprestimo(Livro livro) {
        listaDeEmprestimos.add(livro);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Livro> getEmprestimos() {
        return listaDeEmprestimos;
    }
}

