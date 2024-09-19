import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Gerenciamento Escolar");
            System.out.println("1 - Gerenciar Professores");
            System.out.println("2 - Gerenciar Disciplinas");
            System.out.println("3 - Gerenciar Turmas");
            System.out.println("4 - Gerenciar Alunos");
            System.out.println("5 - Gerenciar Matrículas");
            System.out.println("6 - Emitir Declaração de Matrícula");
            System.out.println("7 - Emitir Declaração de Vínculo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                  int opcaoProfessor;
                  do {
                    System.out.println("\nGerenciamento de Professores:");
                    System.out.println("1 - Adicionar Professor");
                    System.out.println("2 - Remover Professor");
                    System.out.println("3 - Atualizar Professor");
                    System.out.println("4 - Listar Professores");
                    System.out.println("0 - Voltar ao Menu Principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoProfessor = scanner.nextInt();

                    switch (opcaoProfessor) {
                        case 1:
                          try {
                            System.out.println("Adicionando um novo professor...");
                            System.out.print("Nome Completo: ");
                            String nome = scanner.next();
                            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                            String dataNascimento = scanner.next();
                            System.out.print("Endereço: ");
                            String endereco = scanner.next();
                            System.out.print("Telefone: ");
                            String telefone = scanner.next();
                            System.out.print("CPF: ");
                            String cpf = scanner.next();
                            System.out.print("Número de Matrícula: ");
                            int numeroMatricula = scanner.nextInt();
                            Professor.adicionarProfessor(new Professor(nome, dataNascimento, endereco, telefone, cpf, numeroMatricula));
                          } catch (IllegalArgumentException e) {
                              System.out.println("Erro ao adicionar professor: " + e.getMessage());
                          }
                            break;
                        case 2:
                            System.out.println("Removendo um professor...");
                            System.out.print("Número de Matrícula: ");
                            int matriculaParaRemover = scanner.nextInt();
                            Professor.removerProfessor(matriculaParaRemover);
                            break;
                        case 3:
                            System.out.println("Atualizando um professor...");
                            System.out.print("Número de Matrícula do Professor a ser atualizado: ");
                            int matriculaParaAtualizar = scanner.nextInt();

                            Professor professorExistente = Professor.obterProfessor(matriculaParaAtualizar);

                            if (professorExistente != null) {
                                System.out.print("Novo Nome Completo: ");
                                String novoNome = scanner.next();
                                System.out.print("Nova Data de Nascimento (dd/MM/yyyy): ");
                                String novaDataNascimento = scanner.next();
                                System.out.print("Novo Endereço: ");
                                String novoEndereco = scanner.next();
                                System.out.print("Novo Telefone: ");
                                String novoTelefone = scanner.next();
                                System.out.print("Novo CPF: ");
                                String novoCpf = scanner.next();

                                Professor professorAtualizado = new Professor(novoNome, novaDataNascimento, novoEndereco, novoTelefone, novoCpf, matriculaParaAtualizar);

                                Professor.atualizarProfessor(matriculaParaAtualizar, professorAtualizado);

                                System.out.println("Professor atualizado com sucesso.");
                            } else {
                                System.out.println("Professor não encontrado com o número de matrícula fornecido.");
                            }
                            break;
                        case 4:
                            System.out.println("Listando professores...");
                            Professor.listarProfessores();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcaoProfessor != 0);
                  break;
                case 2:
                  int opcaoDisciplina;
                  do {
                    System.out.println("\nGerenciamento de Disciplinas:");
                    System.out.println("1 - Adicionar Disciplina");
                    System.out.println("2 - Remover Disciplina");
                    System.out.println("3 - Atualizar Disciplina");
                    System.out.println("4 - Listar Disciplinas");
                    System.out.println("0 - Voltar ao Menu Principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoDisciplina = scanner.nextInt();

                    switch (opcaoDisciplina) {
                        case 1:
                            System.out.println("Adicionando uma nova disciplina...");
                            System.out.print("Nome da Disciplina: ");
                            String nomeDisciplina = scanner.next();
                            System.out.print("Código da Disciplina: ");
                            String codigoDisciplina = scanner.next();
                            System.out.print("Carga Horária da Disciplina: ");
                            int cargaHoraria = scanner.nextInt();
                            Disciplina.adicionarDisciplina(new Disciplina(nomeDisciplina, codigoDisciplina, cargaHoraria));
                            break;
                        case 2:
                            System.out.println("Removendo uma disciplina...");
                            System.out.print("Código da Disciplina a ser removida: ");
                            String codigoParaRemover = scanner.next();
                            Disciplina.removerDisciplina(codigoParaRemover);
                            break;
                        case 3:
                            System.out.println("Atualizando uma disciplina...");
                            System.out.print("Código da Disciplina a ser atualizada: ");
                            String codigoParaAtualizar = scanner.next();
                            Disciplina disciplinaExistente = Disciplina.obterDisciplina(codigoParaAtualizar);
                            if (disciplinaExistente != null) {
                                System.out.print("Novo Nome da Disciplina: ");
                                String novoNomeDisciplina = scanner.next();
                                System.out.print("Nova Carga Horária da Disciplina: ");
                                int novaCargaHoraria = scanner.nextInt();
                                Disciplina disciplinaAtualizada = new Disciplina(novoNomeDisciplina, codigoParaAtualizar, novaCargaHoraria);
                                Disciplina.atualizarDisciplina(codigoParaAtualizar, disciplinaAtualizada);
                                System.out.println("Disciplina atualizada com sucesso.");
                            } else {
                                System.out.println("Disciplina não encontrada com o código fornecido.");
                            }
                            break;
                        case 4:
                            System.out.println("Listando disciplinas...");
                            Disciplina.listarDisciplinas();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcaoDisciplina != 0);
                    break;
                case 3:
                int opcaoTurma;
                do {
                    System.out.println("\nGerenciamento de Turmas:");
                    System.out.println("1 - Adicionar Turma");
                    System.out.println("2 - Remover Turma");
                    System.out.println("3 - Atualizar Turma");
                    System.out.println("4 - Listar Turmas");
                    System.out.println("0 - Voltar ao Menu Principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoTurma = scanner.nextInt();

                    switch (opcaoTurma) {
                        case 1:
                            System.out.println("Adicionando uma nova turma...");
                            System.out.print("Horário da Turma: ");
                            String horarioTurma = scanner.next();
                            System.out.print("Código da Turma: ");
                            String codigoTurma = scanner.next();
                            System.out.print("Capacidade Máxima da Turma: ");
                            int capacidadeMaxima = scanner.nextInt();
                            System.out.print("Código da Disciplina: ");
                            String codigoDisciplina = scanner.next(); 
                            System.out.print("Número de Matrícula do Professor: ");
                            int numeroMatriculaProfessor = scanner.nextInt(); 
                            Turma.adicionarTurma(new Turma(horarioTurma, codigoTurma, capacidadeMaxima, codigoDisciplina, numeroMatriculaProfessor));
                            break;
                        case 2:
                            System.out.println("Removendo uma turma...");
                            System.out.print("Código da Turma a ser removida: ");
                            String codigoParaRemover = scanner.next();
                            Turma.removerTurma(codigoParaRemover);
                            break;
                        case 3:
                            System.out.println("Atualizando uma turma...");
                            System.out.print("Código da Turma a ser atualizada: ");
                            String codigoParaAtualizar = scanner.next();
                            Turma turmaExistente = Turma.obterTurma(codigoParaAtualizar);
                            if (turmaExistente != null) {
                                System.out.print("Novo Horário da Turma: ");
                                String novoHorarioTurma = scanner.next();
                                System.out.print("Nova Capacidade Máxima da Turma: ");
                                int novaCapacidadeMaxima = scanner.nextInt();
                                System.out.print("Código da Disciplina: ");
                                String novoCodigoDisciplina = scanner.next(); 
                                System.out.print("Número de Matrícula do Professor: ");
                                int novoNumeroMatriculaProfessor = scanner.nextInt(); 
                                Turma turmaAtualizada = new Turma(novoHorarioTurma, codigoParaAtualizar, novaCapacidadeMaxima, novoCodigoDisciplina, novoNumeroMatriculaProfessor);
                                Turma.atualizarTurma(codigoParaAtualizar, turmaAtualizada);
                                System.out.println("Turma atualizada com sucesso.");
                      } else {
                          System.out.println("Turma não encontrada com o código fornecido.");
                      }
                      break;
                        case 4:
                            System.out.println("Listando turmas...");
                            Turma.listarTurmas();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcaoTurma != 0);
                    break;
                case 4:
                  int opcaoAluno;
                  do {
                    System.out.println("\nGerenciamento de Alunos:");
                    System.out.println("1 - Adicionar Aluno");
                    System.out.println("2 - Remover Aluno");
                    System.out.println("3 - Atualizar Aluno");
                    System.out.println("4 - Listar Alunos");
                    System.out.println("0 - Voltar ao Menu Principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoAluno = scanner.nextInt();

                    switch (opcaoAluno) {
                        case 1:
                            System.out.println("Adicionando um novo aluno...");
                            System.out.print("Nome Completo do Aluno: ");
                            String nomeAluno = scanner.next();
                            System.out.print("Data de Nascimento do Aluno (dd/MM/yyyy): ");
                            String dataNascimentoAluno = scanner.next();
                            System.out.print("Endereço do Aluno: ");
                            String enderecoAluno = scanner.next();
                            System.out.print("Telefone do Aluno: ");
                            String telefoneAluno = scanner.next();
                            System.out.print("CPF do Aluno: ");
                            String cpfAluno = scanner.next();
                            System.out.print("Número de Matrícula do Aluno: ");
                            int numeroMatriculaAluno = scanner.nextInt();
                            Aluno.adicionarAluno(new Aluno(nomeAluno, dataNascimentoAluno, enderecoAluno, telefoneAluno, cpfAluno, numeroMatriculaAluno));
                            break;
                        case 2:
                            System.out.println("Removendo um aluno...");
                            System.out.print("Número de Matrícula do Aluno a ser removido: ");
                            int matriculaParaRemover = scanner.nextInt();
                            Aluno.removerAluno(matriculaParaRemover);
                            break;
                        case 3:
                            System.out.println("Atualizando um aluno...");
                            System.out.print("Número de Matrícula do Aluno a ser atualizado: ");
                            int matriculaParaAtualizar = scanner.nextInt();
                            Aluno alunoExistente = Aluno.obterAluno(matriculaParaAtualizar);
                            if (alunoExistente != null) {
                                System.out.print("Novo Nome Completo do Aluno: ");
                                String novoNomeAluno = scanner.next();
                                System.out.print("Nova Data de Nascimento do Aluno (dd/MM/yyyy): ");
                                String novaDataNascimentoAluno = scanner.next();
                                System.out.print("Novo Endereço do Aluno: ");
                                String novoEnderecoAluno = scanner.next();
                                System.out.print("Novo Telefone do Aluno: ");
                                String novoTelefoneAluno = scanner.next();
                                System.out.print("Novo CPF do Aluno: ");
                                String novoCpfAluno = scanner.next();
                                Aluno alunoAtualizado = new Aluno(novoNomeAluno, novaDataNascimentoAluno, novoEnderecoAluno, novoTelefoneAluno, novoCpfAluno, matriculaParaAtualizar);
                                Aluno.atualizarAluno(matriculaParaAtualizar, alunoAtualizado);
                                System.out.println("Aluno atualizado com sucesso.");
                            } else {
                                System.out.println("Aluno não encontrado com o número de matrícula fornecido.");
                            }
                            break;
                        case 4:
                            System.out.println("Listando alunos...");
                            Aluno.listarAlunos();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcaoAluno != 0);
                    break;
                case 5:
                  int opcaoMatricula;
                  do {
                    System.out.println("\nGerenciamento de Matrículas:");
                    System.out.println("1 - Matricular Aluno em Disciplina");
                    System.out.println("2 - Desmatricular Aluno de Disciplina");
                    System.out.println("3 - Listar Matrículas");
                    System.out.println("0 - Voltar ao Menu Principal");
                    System.out.print("Escolha uma opção: ");
                    opcaoMatricula = scanner.nextInt();

                    switch (opcaoMatricula) {
                        case 1:
                            System.out.println("Matriculando um aluno em uma disciplina...");
                            System.out.print("Número de Matrícula do Aluno: ");
                            int numeroMatriculaAluno = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Código da Disciplina: ");
                            String codigoDisciplina = scanner.nextLine();
                            System.out.print("Código da Turma: ");
                            String codigoTurma = scanner.nextLine();
                            Matricula.matricularAluno(numeroMatriculaAluno, codigoDisciplina, codigoTurma);
                            break;
                        case 2:
                            System.out.println("Desmatriculando um aluno de uma disciplina...");
                            System.out.print("Número de Matrícula do Aluno: ");
                            int matriculaParaDesmatricular = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Código da Disciplina: ");
                            String codigoDisciplinaParaDesmatricular = scanner.nextLine();
                            System.out.print("Código da Turma: ");
                            String codigoTurmaParaDesmatricular = scanner.nextLine();
                            Matricula.desmatricularAluno(matriculaParaDesmatricular, codigoDisciplinaParaDesmatricular, codigoTurmaParaDesmatricular);
                            break;
                        case 3:
                            System.out.println("Listando matrículas...");
                            Matricula.listarMatriculas();
                            break;
                        case 0:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcaoMatricula != 0);
                    break;
                case 6:
                    System.out.println("\nEmitir Declaração de Matrícula:");
                    System.out.print("Número de Matrícula do Aluno: ");
                    int numeroMatriculaAluno = scanner.nextInt();
                    Aluno aluno = Aluno.obterAluno(numeroMatriculaAluno);
                    if (aluno != null) {
                        aluno.emitirDeclaracaoDeMatricula();
                    } else {
                        System.out.println("Aluno não encontrado com o número de matrícula fornecido.");
                    }
                      break;
                case 7:
                    System.out.println("\nEmitir Declaração de Vínculo:");
                    System.out.print("Número de Matrícula do Professor: ");
                    int numeroMatriculaProfessor = scanner.nextInt();
                    Professor professor = Professor.obterProfessor(numeroMatriculaProfessor);
                    if (professor != null) {
                        professor.emitirDeclaracaoDeVinculo();
                    } else {
                        System.out.println("Professor não encontrado com o número de matrícula fornecido.");
                    }
                      break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
