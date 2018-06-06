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
            }
        } while (!opcao.equals("S"));
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
        String[] opcoes = {"(C)adastrar Aluno", "(E)xibir Aluno"};

        for(String opcao: opcoes)
            menu += opcao + System.lineSeparator();

        menu += System.lineSeparator() + "Opção> ";
        System.out.print(menu);
    }
}
