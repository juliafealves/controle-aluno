import controle.ControleAluno;

import java.util.Scanner;

public class Menu {
    private static ControleAluno controleAluno;

    public static void main(String[] args){
        Menu.controleAluno = new ControleAluno();
        String opcao = "";
        Scanner scanner = new Scanner(System.in);

        do{
            Menu.exibeMenu();
            opcao = scanner.next().toUpperCase();

            if(opcao.equals("C")){
                Menu.cadastraAluno(scanner);
            } else if(opcao.equals("E")){
                Menu.exibeAluno(scanner);
            } else if(opcao.equals("N")){
                Menu.cadastraGrupo(scanner);
            } else if(opcao.equals("A")){
                System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
                opcao = scanner.next().toUpperCase();

                if(opcao.equals("A")){
                    Menu.alocaAluno(scanner);
                }
            }
        } while (!opcao.equals("S"));
    }

    /**
     * Aloca um aluno em grupo de estudos. Sendo informado a matrícula do aluno e o nome do grupo de estudos.
     * É necessário o cadastro prévio do aluno e grupo no sistema.
     *
     * Matricula: 250
     * Grupo: LISTAS
     *
     * @param scanner
     */
    private static void alocaAluno(Scanner scanner) {
        try{
            scanner.nextLine();
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine().trim();
            System.out.print("Grupo: ");
            String grupo = scanner.nextLine().trim();

            if (Menu.controleAluno.alocaAluno(matricula, grupo))
                System.out.println("ALUNO ALOCADO!");
        }catch (Exception exception){
            System.out.println(exception.getMessage().toUpperCase());
        }
    }

    /**
     * Cadastra um grupo de estudos através do nome. O nome deve ser único, mesmo sendo maiúsculas e minúsculas
     * são indistintas (i.e. o grupo “Listas” é igual ao grupo “listas”).
     *
     * Grupo: Listas
     *
     * @param scanner
     */
    private static void cadastraGrupo(Scanner scanner) {
        try{
            scanner.nextLine();
            System.out.print("Grupo: ");
            String nome = scanner.nextLine().trim();

            if (Menu.controleAluno.cadastraGrupo(nome))
                System.out.println("CADASTRO REALIZADO!");
        }catch (Exception exception){
            System.out.println(exception.getMessage().toUpperCase());
        }
    }

    /**
     * Através da matrícula do aluno é possível visualizar realizar consulta e visualizar as informações básicas.
     *
     * Matrícula: 250
     * Aluno: 250 - Gabriel Reyes - Computação
     *
     * @param scanner
     */
    private static void exibeAluno(Scanner scanner) {
        try{
            scanner.nextLine();
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine().trim();
            System.out.println(Menu.controleAluno.consultaAluno(matricula));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Cadastra um aluno com as informações de matrícula, nome e curso. Todos obrigatórios.
     * Só é permitido o cadastro de um aluno com a mesma matrícula.
     *
     * Matrícula: 250
     * Nome: Gabriel Reyes
     * Curso: Computação
     *
     * @param scanner
     */
    private static void cadastraAluno(Scanner scanner) {
        try{
            scanner.nextLine();
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine().trim();
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();
            System.out.print("Curso: ");
            String curso = scanner.nextLine().trim();

            if (Menu.controleAluno.cadastraAluno(matricula, nome, curso))
                System.out.println("CADASTRO REALIZADO!");
        }catch (Exception exception){
            System.out.println(exception.getMessage().toUpperCase());
        }
    }


    /**
     * Exibe o menu principal da aplicação.
     *
     * (C)adastrar Aluno
     * (E)xibir Aluno
     * (N)ovo Grupo
     * (A)locar Aluno no Grupo e Imprimir Grupos
     * (R)egistrar Aluno que Respondeu
     * (I)mprimir Alunos que Responderam
     * (O)ra, vamos fechar o programa!
     *
     *  Opção>
     */
    private static void exibeMenu(){
        String menu = System.lineSeparator();
        String[] opcoes = {"(C)adastrar Aluno", "(E)xibir Aluno", "(N)ovo Grupo",
                "(A)locar Aluno no Grupo e Imprimir Grupos"};

        for(String opcao: opcoes)
            menu += opcao + System.lineSeparator();

        menu += System.lineSeparator() + "Opção> ";
        System.out.print(menu);
    }
}
