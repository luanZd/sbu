package br.universidade.biblio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Relatorio {

  private GerenciadorDeDados db;

  public Relatorio(GerenciadorDeDados db) {
    this.db = db;
  }

  public List<Emprestimo> consultarTodosLivrosEmprestados() {
    return db.consultarTodosEmprestimosBanco();
  }

  public List<Emprestimo> consultarEmprestimosAtrasados() {
    Date hoje = new Date();
    List<Emprestimo> atrasados = new ArrayList<>();

    for (Emprestimo e : db.consultarTodosEmprestimosBanco()) {
      Date dataDevolucao = e.getDataDevolucao();

      if (dataDevolucao != null && dataDevolucao.before(hoje)) {
        atrasados.add(e);
      }
    }
    return atrasados;
  }


  public List<Usuario> consultarUsuariosComEmprestimosAtrasados() {
    List<Usuario> userList = new ArrayList<>();
    Date hoje = new Date();

    for (Emprestimo e : db.consultarTodosEmprestimosBanco()) {
      Date dataDevolucao = e.getDataDevolucao();

      if (dataDevolucao != null && dataDevolucao.before(hoje)) {
        Usuario u = e.getUsuario();
        if (!userList.contains(u)) {
          userList.add(u);
        }
      }
    }
    return userList;
  }



  void gerarRelatorioEmprestimos() {
    List<Emprestimo> emprestimos = consultarTodosLivrosEmprestados();
    System.out.println("Relatório de Empréstimos:");
    if(emprestimos.isEmpty()) {
      System.out.println("Nenhum empréstimo registrado.");
      return;
    }
    for (Emprestimo e : emprestimos) {
      System.out.println("Usuário: " + e.getUsuario().getNome() +
          " | Livro: " + e.getLivro().getTitulo() +
          " | Data de Empréstimo: " + e.getDataEmprestimo() +
          " | Data de Devolução: " + e.getDataDevolucao());
    }
  }

  void gerarRelatorioAtrasados() {
    List<Emprestimo> atrasados = consultarEmprestimosAtrasados();
    System.out.println("Relatório de Empréstimos Atrasados:");
    if(atrasados.isEmpty()) {
      System.out.println("Nenhum empréstimo atrasado.");
      return;
    }
    for (Emprestimo e : atrasados) {
      System.out.println("Usuário: " + e.getUsuario().getNome() +
          " | Livro: " + e.getLivro().getTitulo() +
          " | Data de Empréstimo: " + e.getDataEmprestimo() +
          " | Data de Devolução: " + e.getDataDevolucao());
    }
  }
}
