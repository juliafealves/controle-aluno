# Controle de Aluno e Grupo de Estudos
Mini projeto para **Controle de Alunos e Grupos de Estudos** para a disciplina de Laboratório de Programação II da UFCG
referente ao curso de Ciências da Computação. Desenvolvido em Java 8 e uso da metodologia TDD com JUnit.

## Requisitos do Projeto:

Neste laboratório, construiremos um sistema que será a base do controle de alunos de Programação II. Como sistema, deve ser possível primeiramente cadastrar e consultar alunos. Cada aluno tem uma matrícula, nome e curso (todos strings). Cada consulta deve procurar o aluno a partir de sua matrícula. O aluno é identificado unicamente pela matrícula e não deve ser possível alterar os dados dos alunos uma vez cadastrado.
Os alunos podem se juntar em grupos de estudo. Cada grupo de estudo tem um tema (string, como por exemplo o tema “Coleções”) e é formado por um conjunto de alunos. O aluno pode estar em mais de um grupo de estudo. Deve ser possível colocar alunos em tais grupos a partir de sua matrícula. Cada grupo é identificado unicamente a partir do nome do grupo.
Por fim, durante as aulas, os alunos costumam fazer exercícios em quadro e responder perguntas feitas pelo professor. O professor deseja manter um registro dos alunos que responderam tais perguntas. É possível que o mesmo aluno seja questionado mais que uma vez e preciso registrar a ordem que os mesmos responderam.
O programa deve iniciar com um menu como indicado abaixo.

```
(C)adastrar Aluno
(E)xibir Aluno
(N)ovo Grupo
(A)locar Aluno no Grupo e Imprimir Grupos
(R)egistrar Aluno que Respondeu
(I)mprimir Alunos que Responderam
(O)ra, vamos fechar o programa!

Opção>
```

Ao longo da execução do sistema, caso o usuário passe uma entrada inválida (nula ou vazia) o sistema deve lançar uma exceção e ser encerrado.
Mais detalhes do que deve ser feito neste laboratório abaixo.

### 1. Cadastrar Aluno

Ao selecionar para cadastrar um aluno, o sistema deve pedir informações como a matrícula, nome e curso.
```
Matrícula: 250
Nome: Gabriel Reyes
Curso: Computação
CADASTRO REALIZADO!
```

Quando a matrícula cadastrada já existe, o aluno não deve ser cadastrado e uma mensagem deve ser exibida como mostra o exemplo abaixo.

```
Matrícula: 250
Nome: Mei-Ling Zhou
Curso: Computação
MATRÍCULA JÁ CADASTRADA!
```

Após cada ação do sistema, o menu deve ser novamente impresso e uma opção deve ser novamente selecionada.



## Diagrama de Classe

![Diagrama de Classe](dc_controle_aluno.jpeg)
