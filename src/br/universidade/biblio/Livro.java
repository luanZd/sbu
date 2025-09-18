package br.universidade.biblio;

public class Livro {
  // Atributos
  private String titulo;
  private String autor;
  private int ano;
  private boolean disponivel;
  private int quantidade;

  // Validação de dados
  private void validarDados(String titulo, String autor, int ano) {
    if (titulo == null || titulo.trim().isEmpty())
      throw new IllegalArgumentException("Título não pode ser nulo ou vazio");
    if (autor == null || autor.trim().isEmpty())
      throw new IllegalArgumentException("Autor não pode ser nulo ou vazio");
    if (ano <= 0)
      throw new IllegalArgumentException("Ano deve ser um valor positivo");
  }

  // Construtores
  public Livro(String titulo, String autor, int ano, boolean disponivel) {
    validarDados(titulo, autor, ano);

    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
    this.disponivel = disponivel;
  }

  public Livro(String titulo, String autor, int ano) {
    this(titulo, autor, ano, true);
  }
  
  //Parte do código que me forçaram a adicionar mas eu discordo intrinsecamente
  public Livro() {
    this("Título Padrão", "Autor Padrão", 2000, true);
  }

  public setTitulo(String titulo) {
    if (titulo == null || titulo.trim().isEmpty())
      throw new IllegalArgumentException("Título não pode ser nulo ou vazio");
    this.titulo = titulo;
  }

  public setAutor(String autor) {
    if (autor == null || autor.trim().isEmpty())
      throw new IllegalArgumentException("Autor não pode ser nulo ou vazio");
    this.autor = autor;
  }

  public setAno(int ano) {
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

  // Getters e Setters
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
}