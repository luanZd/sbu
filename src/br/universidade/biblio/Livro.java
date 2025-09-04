public class Livro{
    //Atributos
    static private String titulo;
    static private String autor;
    static private int ano;
    private boolean disponivel;

    //Construtor
    public Livro(String titulo, String autor, int ano){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }

    //Métodos
    public void setDisponivel(boolean b){
        disponivel = b;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getAno(){
        return ano;
    }

    public boolean getDisponivel(){
        return disponivel;
    }
}