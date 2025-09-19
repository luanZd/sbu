package br.universidade.biblio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/// @brief Define os diferentes estados possíveis da aplicação.
enum Estados {
    INDEFINIDO,
    MENU_OPCOES,
    ERRO,
    SUCESSO,
    CADASTRO_USUARIO,
    CADASTRO_LIVRO,
    EMPRESTIMO,
    DEVOLUCAO,
    LISTA_USUARIOS,
    LISTA_LIVROS,
    RELATORIO,
    ENCERRADO;

}

/// @brief Motor da aplicação.
public class Main {

    // === Atributos.
    private Biblioteca biblioteca; // !< Principal interface com o sistema.
    private Estados estadoAtual; // !< Estado atual da máquina.
    private Scanner scanner; // !< Mecanismo de leitura de estrada.
    private int opcaoDoUsuario; // !< Opção escolhida no menu de opções.
    private String entrada; // !< Linha de entrada do usuário contendo informações da funcionalidade
    // escolhida.
    private String mensagemDeErro;
    private List<Livro> livrosTemp = new ArrayList<>();
    private List<Usuario> usuariosTemp = new ArrayList<>();

    private boolean ehNumeroInteiro(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
//!< Método deve ir para o UTILS, revisar implementação

    // === Construtor.
    public Main() {

        this.biblioteca = new Biblioteca();
        this.estadoAtual = Estados.INDEFINIDO;
        this.scanner = new Scanner(System.in);
        this.opcaoDoUsuario = 0;
        this.entrada = "";
        this.mensagemDeErro = "";

    }

    // === Métodos core.
    /// @brief Responsável por receber as entradas do usuário.
    public void processar() {

        if (estadoAtual == Estados.MENU_OPCOES) {
            opcaoDoUsuario = scanner.nextInt();
            scanner.nextLine(); // consome o ENTER que sobrou
        }

        if (estadoAtual == Estados.ERRO || estadoAtual == Estados.SUCESSO) {
            scanner.nextLine();
        }

        if (estadoAtual == Estados.CADASTRO_USUARIO) {
            entrada = scanner.nextLine();
        }
        if (estadoAtual == Estados.CADASTRO_LIVRO) {
            entrada = scanner.nextLine();
        }
        if (estadoAtual == Estados.LISTA_USUARIOS) {
            entrada = scanner.nextLine();
        }
        if (estadoAtual == Estados.LISTA_LIVROS) {
            entrada = scanner.nextLine();
        }

    }

    /// @brief Responsável por tratar as entradas e atualizar estado interno do
    /// sistema.
    public void atualizar() {

        if (estadoAtual == Estados.INDEFINIDO) {
            estadoAtual = Estados.MENU_OPCOES;
            return;
        }

        if (estadoAtual == Estados.MENU_OPCOES) {
            if (opcaoDoUsuario == 1 /* cadastrar usuário */) {

                estadoAtual = Estados.CADASTRO_USUARIO;

            } else if (opcaoDoUsuario == 2 /* cadastrar livro */) {

                estadoAtual = Estados.CADASTRO_LIVRO;

            } else if (opcaoDoUsuario == 3 /* emprestimo */) {

                estadoAtual = Estados.EMPRESTIMO;

            } else if (opcaoDoUsuario == 4 /* devolução */) {

                estadoAtual = Estados.DEVOLUCAO;

            } else if (opcaoDoUsuario == 5 /* listar usuários */) {

                estadoAtual = Estados.LISTA_USUARIOS;

            } else if (opcaoDoUsuario == 6 /* listar livros */) {

                estadoAtual = Estados.LISTA_LIVROS;

            } else if (opcaoDoUsuario == 7 /* imprimir relatorio */) {

                estadoAtual = Estados.RELATORIO;

            } else if (opcaoDoUsuario == 0 /* encerrando aplicação */) {

                estadoAtual = Estados.ENCERRADO;

            } else {

                estadoAtual = Estados.ERRO;

            }

            return; // <-- Evita que a validação do estado das transições acima
            // seja executada antes da renderização da interface.
        }

        if (estadoAtual == Estados.ERRO) {
            mensagemDeErro = "";
            estadoAtual = Estados.MENU_OPCOES;
        }

        if (estadoAtual == Estados.SUCESSO) {
            entrada = "";
            estadoAtual = Estados.MENU_OPCOES;
        }

        if (estadoAtual == Estados.CADASTRO_USUARIO) {
            String[] partes = entrada.split(",");

            if (partes.length != 2) {
                mensagemDeErro = "Entrada inválida! Formato esperado: nome, curso.";
                estadoAtual = Estados.ERRO;
                return;
            }

            biblioteca.adicionarUsuario(new Usuario(partes[0].trim(), partes[1].trim()));

            estadoAtual = Estados.SUCESSO;
        }
        if (estadoAtual == Estados.CADASTRO_LIVRO) {
            String[] partes = entrada.split(",");

            if (partes.length != 3) {
                mensagemDeErro = "Entrada inválida! Formato esperado: titulo, autor, ano.";
                estadoAtual = Estados.ERRO;
                return;
            }

            String titulo = partes[0].trim();
            String autor = partes[1].trim();
            String anoStr = partes[2].trim();

            if (!ehNumeroInteiro(anoStr)) {
                mensagemDeErro = "O ano deve ser um número inteiro válido.";
                estadoAtual = Estados.ERRO;
                return;
            }

            int ano = Integer.parseInt(anoStr);

            if (biblioteca.adicionarLivro(new Livro(titulo, autor, ano))) {
                estadoAtual = Estados.SUCESSO;
            } else {
                mensagemDeErro = "Falha ao registrar livro. Verifique se ele já foi adicionado.";
                estadoAtual = Estados.ERRO;
            }

            return;
        }

        if (estadoAtual == Estados.EMPRESTIMO) {

        
        /// @todo: Valida entrada e alterna o estado.
        }

        if (estadoAtual == Estados.DEVOLUCAO) {

        
        /// @todo: Valida entrada e alterna o estado.
        }

    if (estadoAtual == Estados.LISTA_USUARIOS) {
            usuariosTemp = biblioteca.listarUsuarios(); // garante que a lista seja preenchida

            renderizar();
            estadoAtual = Estados.MENU_OPCOES;
            return;
        }
        if (estadoAtual == Estados.LISTA_LIVROS) {
            livrosTemp = biblioteca.listarLivros(); // garante que a lista seja preenchida

            renderizar();
            estadoAtual = Estados.MENU_OPCOES;
            return;
        }

        if (estadoAtual == Estados.RELATORIO) {

        

    
    /// @todo: Valida entrada e alterna o estado.
        }

    }

    /// @brief Responsável por desenhar e atualizar os elementos da interface
    /// gráfica.
    public void renderizar() {

        if (estadoAtual == Estados.MENU_OPCOES) {
            System.out.println("Menu de Opções:");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Fazer Empréstimo");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Listar usuários");
            System.out.println("6. Listar livros");
            System.out.println("7. Imprimir Relatório");
            System.out.println("0. Encerrar\n");
            System.out.print(">  ");
        }

        if (estadoAtual == Estados.ERRO) {
            System.out.println("\n" + mensagemDeErro);
            System.out.println("Pressione ENTER para continuar...");
        }

        if (estadoAtual == Estados.CADASTRO_USUARIO) {
            System.out.println("\nDigite os dados do usuário a ser cadastrado (nome, curso):");
            System.out.print(">  ");
        }

        if (estadoAtual == Estados.CADASTRO_LIVRO) {
            System.out.println("Digite os dados do livro a ser cadastrado (título, autor, ano):");
            System.out.print("->  ");
        }
        if (estadoAtual == Estados.LISTA_USUARIOS) {
            System.out.println("\n=== Lista de Usuários ===");
            for (Usuario u : usuariosTemp) {
                System.out.println("- " + u.getNome()
                        + " | Curso: " + u.getCurso()
                        + " | Matrícula: " + u.getMatricula());
            }
            System.out.println("\nPressione ENTER para continuar...");
        }
               if (estadoAtual == Estados.LISTA_LIVROS) {
            System.out.println("\n=== Lista de Livros ===");
            for (Livro u : livrosTemp) {
                System.out.println("- " + u.getTitulo()
                        + " | Autor: " + u.getAutor()
                        + " | Ano: " + u.getAno());
            }
            System.out.println("\nPressione ENTER para continuar...");
        }

        if (estadoAtual == Estados.EMPRESTIMO) {

        
        /// @todo: Exibir tela de empréstimo.
        }

        if (estadoAtual == Estados.DEVOLUCAO) {

        
        /// @todo: Exibir tela de devolução de livro.
        }

        if (estadoAtual == Estados.RELATORIO) {

        
        /// @todo: Exibir tela de relatório.
        }

        if (estadoAtual == Estados.SUCESSO) {
            System.out.println("\nOperação realizada com sucesso!");
            System.out.println("Pressione ENTER para continuar...");
        }

    }

    // === Loop principal.
    public void executar() {

        while (estadoAtual != Estados.ENCERRADO) {

            processar();
            atualizar();
            renderizar();

        }

    }

    // === Método main.
    public static void main(String[] args) {

        Main app = new Main();
        app.executar();

    }

}
