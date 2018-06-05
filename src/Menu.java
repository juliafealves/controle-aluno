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
            }
        } while (!opcao.equals("S"));
    }

    private static void cadastraAluno(Scanner scanner) {
        try{
            scanner.nextLine();
            System.out.print("MATRÍCULA: ");
            String matricula = scanner.nextLine().trim();
            System.out.print("NOME: ");
            String nome = scanner.nextLine().trim();
            System.out.print("CURSO: ");
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
        String[] opcoes = {"(C)adastrar Aluno"};

        for(String opcao: opcoes)
            menu += opcao + System.lineSeparator();

        menu += System.lineSeparator() + "Opção> ";
        System.out.print(menu);
    }
}
