```
package br.universidade.biblio;

import java.util.Scanner;

enum Estados {
    INDEFINIDO,
    NO_MENU_DE_OPCOES,
    EM_ERRO,
    CADASTRANDO_LIVRO,
    CADASTRANDO_USUARIO,
    FAZENDO_EMPRESTIMO,
    DEVOLVENDO_LIVRO,
    IMPRIMINDO_RELATORIO,
    ENCERRANDO;
}

public class Main {

    //=== Atributos.
    private Biblioteca biblioteca;
    private Estados estadoAtual;
    private Scanner scanner;
    private int opcaoDoUsuario;

    //=== Construtor.
    public Main() {

        this.biblioteca = new Biblioteca();
        this.estadoAtual = Estados.INDEFINIDO;
        this.scanner = new Scanner(System.in);
        this.opcaoDoUsuario = 0;

    }

    //=== Métodos core.
    /// @brief Lida com os inputs do usuário.
    public void processar() {

        if (estadoAtual == Estados.NO_MENU_DE_OPCOES) {
            opcaoDoUsuario = scanner.nextInt();
        }

    }

    /// @brief Atualiza estado interno do sistema.
    public void atualizar() {

        if (estadoAtual == Estados.INDEFINIDO) {
            estadoAtual = Estados.NO_MENU_DE_OPCOES;
        }

        if (estadoAtual == Estados.NO_MENU_DE_OPCOES) {
            /// @todo: Validar entrada e alterna estado.

            if (/* cadastra usuário */false) {

            } else if (/* cadastrar livro */false) {

            } else if (/* fazer emprestimo */false) {

            } else if (/* devolver livro */false) {

            } else if (/* imprimir relatorio */false) {

            } else {
                /* alguma outra coisa */
            }

            return;
        }

        if (estadoAtual == Estados.EM_ERRO) {
            estadoAtual = Estados.NO_MENU_DE_OPCOES;
        }

        if (estadoAtual == Estados.CADASTRANDO_USUARIO) {
            /// @todo: Valida entrada e alterna o estado.
        }

        if (estadoAtual == Estados.CADASTRANDO_LIVRO) {
            /// @todo: Valida entrada e alterna o estado.
        }

        if (estadoAtual == Estados.FAZENDO_EMPRESTIMO) {
            /// @todo: Valida entrada e alterna o estado.
        }

        if (estadoAtual == Estados.DEVOLVENDO_LIVRO) {
            /// @todo: Valida entrada e alterna o estado.
        }

        if (estadoAtual == Estados.DEVOLVENDO_LIVRO) {
            /// @todo: Valida entrada e alterna o estado.
        }

    }

    /// @brief Renderiza interfaces.
    public void renderizar() {

        if (estadoAtual == Estados.NO_MENU_DE_OPCOES) {
            /// @todo: Exibir menu de opções.
        }

        if (estadoAtual == Estados.EM_ERRO) {
            /// @todo: Exibir mensagem de erro.
        }
        
        if (estadoAtual == Estados.CADASTRANDO_USUARIO) {
            /// @todo: Exibir tela de cadastro de usuários.
        }
        
        if (estadoAtual == Estados.CADASTRANDO_LIVRO) {
            /// @todo: Exibir tela de cadastro de livros.
        }
        
        if (estadoAtual == Estados.FAZENDO_EMPRESTIMO) {
            /// @todo: Exibir tela de empréstimo.
        }
        
        if (estadoAtual == Estados.DEVOLVENDO_LIVRO) {
            /// @todo: Exibir tela de devolução de livro.
        }
        
        if (estadoAtual == Estados.IMPRIMINDO_RELATORIO) {
            /// @todo: Exibir tela de relatório.
        }

    }

    //=== Loop principal.
    public void executar() {

        while (estadoAtual != Estados.ENCERRANDO) {

            processar();
            atualizar();
            renderizar();

        }

    }

    //=== Método main.
    public static void main(String[] args) {

        Main app = new Main();
        app.executar();

    }

}
```
