# sbu
Sistema de Biblioteca Universitário

## Compilar e executar

O comando abaixo compila todos os arquivos `.java` da pasta **src/** e gera os `.class` dentro da pasta **bin/**, já configurando o classpath para incluir as bibliotecas externas:

```sh
javac -cp "./lib/*" -d ./bin -sourcepath src src/br/universidade/biblio/Main.java
```

Após a compilação, o programa pode ser iniciado com:

```sh
java  -cp "./bin:./lib/*" br.universidade.biblio.Main
```

## Colaboradores
- Diego Luan ([luanZd](github.com/luanZd)) - **Grupo 01: Main**;
- Yasmin Giordano ([minkyzecapagods](github.com/minkyzecapagods)) - **Grupo 02: Livro**;
- Kézia Ketillen ([Kk3tillen](github.com/Kk3tillen)) **Grupo 03: Usuário**;
- Lucas Amorim ([lucasaamorim](github.com/lucasaamorim)) - **Grupo 04: Biblioteca**:
- Ian ([kurokouo](github.com/kurokouo)) - **Grupo 05: Emprestimo**:
- Yuri Maximiliano ([BrasileiroYuri](github.com/BrasileiroYuri)) - **Grupo 06: Relatório**;
- Arthur José ([ArthurJoseAS](github.com/ArthurJoseAS)) - **Grupo 07: Utils**;
- Ana Tereza ([ana-tereza](github.com/ana-tereza)) - **Grupo 08: Gerenciador de Dados**.

---

&copy; DIM0116 - LINGUAGEM DE PROGRAMAÇÃO II
