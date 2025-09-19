package br.universidade.biblio;

public class Livro {
  private String titulo;
  private String autor;
  private int ano;
  private boolean disponivel;
  private int quantidade;

  private void validarDados(String titulo, String autor, int ano, int quantidade) {
    if (titulo == null || titulo.trim().isEmpty())
      throw new IllegalArgumentException("Título não pode ser nulo ou vazio");
    if (autor == null || autor.trim().isEmpty())
      throw new IllegalArgumentException("Autor não pode ser nulo ou vazio");
    if (ano <= 0)
      throw new IllegalArgumentException("Ano deve ser um valor positivo");
    if (quantidade < 0)
      throw new IllegalArgumentException("Quantidade deve ser um valor não negativo");
  }

  public Livro(String titulo, String autor, int ano, boolean disponivel, int quantidade) {
    validarDados(titulo, autor, ano, quantidade);

    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
    this.disponivel = disponivel;
    this.quantidade = quantidade;
  }

  public Livro(String titulo, String autor, int ano) {
    this(titulo, autor, ano, true, 0);
  }
  
  public Livro() {
    this("Título Padrão", "Autor Padrão", 2000, true, 0);
  }

  public void setTitulo(String titulo) {
    if (titulo == null || titulo.trim().isEmpty())
      throw new IllegalArgumentException("Título não pode ser nulo ou vazio");
    this.titulo = titulo;
  }

  public void setAutor(String autor) {
    if (autor == null || autor.trim().isEmpty())
      throw new IllegalArgumentException("Autor não pode ser nulo ou vazio");
    this.autor = autor;
  }

  public void setAno(int ano) {
    if (ano <= 0)
      throw new IllegalArgumentException("Ano deve ser um valor positivo");
    this.ano = ano;
  }

    public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    if (quantidade < 0)
      throw new IllegalArgumentException("Quantidade não pode ser negativa");
    this.quantidade = quantidade;
  }

  public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public int getAno() {
    return ano;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  @Override
  public String toString() {
      return titulo + " - " + autor;
  }

}
