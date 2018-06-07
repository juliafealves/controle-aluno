import controle.ControleAluno;

import java.util.Scanner;

/**
 * Classe Menu responsável pela interface com usuário a fim de permitir gerenciar o Controle de Alunos e Grupos.
 *
 * @author Júlia Fernandes Alves (julia.alves@ccc.ufcg.edu.br)
 */
public class Menu {
    private static ControleAluno controleAluno;

    /**
     * Método principal para execução do programa. Existe as seguintes opções:
     *
     * (C)adastrar Aluno
     * (E)xibir Aluno
     * (N)ovo Grupo
     * (A)locar Aluno no Grupo e Imprimir Grupos
     * (R)egistrar Aluno que Respondeu
     * (I)mprimir Alunos que Responderam
     * (O)ra, vamos fechar o programa!
     *
     * Opção
     *
     * Os caracteres entre parenteses indicam a opção a ser escolhida.
     *
     * @param args Não aceita argumentos via console.
     */
    public static void main(String[] args){
        try {
            Menu.controleAluno = new ControleAluno();
            String opcao = "";
            Scanner scanner = new Scanner(System.in);

            do {
                Menu.exibeMenu();
                opcao = scanner.nextLine().trim().toUpperCase();

                if (opcao == null || opcao.equals(""))
                    throw new RuntimeException("Opção nula ou vazia.");

                if (opcao.equals("C")) {
                    Menu.cadastraAluno(scanner);
                } else if (opcao.equals("E")) {
                    Menu.exibeAluno(scanner);
                } else if (opcao.equals("N")) {
                    Menu.cadastraGrupo(scanner);
                } else if (opcao.equals("R")) {
                    Menu.registraParticipacao(scanner);
                } else if (opcao.equals("I")) {
                    Menu.exibeAlunosParticipantes();
                } else if (opcao.equals("A")) {
                    System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
                    opcao = scanner.nextLine().trim().toUpperCase();

                    if (opcao.equals("A")) {
                        Menu.alocaAluno(scanner);
                    } else if (opcao.equals("I")) {
                        Menu.imprimeGrupo(scanner);
                    } else if (opcao == null || opcao.equals("")){
                        throw new RuntimeException("Opção nula ou vazia.");
                    } else {
                        System.out.println("OPÇÃO INVÁLIDA");
                        opcao = "";
                    }
                } else if (!opcao.equals("O")) {
                    System.out.println("OPÇÃO INVÁLIDA");
                }
            } while (!opcao.equals("O"));
        } catch(RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
            System.exit(1);
        }
    }

    /**
     * Exibe os alunos que participaram respondendo as questõe em sala.
     *
     * Alunos:
     * 1. 250 - Gabriel Reyes - Computação
     * 2. 200 - Angela Ziegler - Medicina
     * 3. 250 - Gabriel Reyes - Computação
     * 4. 201 - Torbjorn Lindholm - Engenharia Mecanica
     * 5. 201 - Torbjorn Lindholm - Engenharia Mecanica
     *
     */
    private static void exibeAlunosParticipantes() {
        System.out.println(Menu.controleAluno.listaAlunosParticipantes());
    }

    /**
     * Registra as participações dos alunos durante aos ao responderem questões.
     *
     * Matricula: 250
     *
     * @param scanner
     */
    private static void registraParticipacao(Scanner scanner) {
        try{
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine().trim();

            if (Menu.controleAluno.registraParticipacaoAluno(matricula))
                System.out.println("ALUNO REGISTRADO!");
        }catch (Exception exception){
            System.out.println(exception.getMessage().toUpperCase());
        }
    }

    /**
     * Exibe as informações referente ao grupo de estudos.
     *
     * Grupo: listas
     * Alunos do grupo Listas:
     * * 250 - Gabriel Reyes - Computação
     * * 200 - Angela Ziegler - Medicina
     *
     * @param scanner
     */
    private static void imprimeGrupo(Scanner scanner) {
        try{
            System.out.print("Grupo: ");
            String grupo = scanner.nextLine().trim();
            System.out.println(Menu.controleAluno.listaAlunosAlocados(grupo));
        }catch (Exception exception){
            System.out.println(exception.getMessage().toUpperCase());
        }
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
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine().trim();
            System.out.println(Menu.controleAluno.consultaAluno(matricula));
        }catch (Exception exception){
            System.out.println(exception.getMessage().toUpperCase());
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
                "(A)locar Aluno no Grupo e Imprimir Grupos", "(R)egistrar Aluno que Respondeu",
                "(I)mprimir Alunos que Responderam", "(O)ra, vamos fechar o programa!"};

        for(String opcao: opcoes)
            menu += opcao + System.lineSeparator();

        menu += System.lineSeparator() + "Opção> ";
        System.out.print(menu);
    }
}
