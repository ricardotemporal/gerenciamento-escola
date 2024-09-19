import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aluno {
    private String nomeCompleto;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String cpf;
    private int numeroMatricula;

    private static Map<Integer, Aluno> alunos = new HashMap<>();

    public Aluno(String nomeCompleto, String dataNascimento, String endereco, String telefone, String cpf, int numeroMatricula) {
        if (nomeCompleto == null || dataNascimento == null || endereco == null || telefone == null || cpf == null) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo");
        }
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.numeroMatricula = numeroMatricula;
        alunos.put(numeroMatricula, this);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }  

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public static void adicionarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo");
        }
        alunos.put(aluno.getNumeroMatricula(), aluno);
    }

    public static void removerAluno(int numeroMatricula) {
        if (!alunos.containsKey(numeroMatricula)) {
            throw new IllegalArgumentException("Aluno com essa matrícula não existe");
        }
        alunos.remove(numeroMatricula);
    }

    public static Aluno obterAluno(int numeroMatricula) {
        Aluno aluno = alunos.get(numeroMatricula);
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno com essa matrícula não encontrado");
        }
        return aluno;
    }

    public static void atualizarAluno(int numeroMatricula, Aluno aluno) {
        if (aluno == null || !alunos.containsKey(numeroMatricula)) {
            throw new IllegalArgumentException("Aluno inválido ou matrícula não encontrada");
        }
        alunos.put(numeroMatricula, aluno);
    }

    public static void listarAlunos() {
        for (Aluno aluno : alunos.values()) {
            System.out.println("Nome: " + aluno.getNomeCompleto() + ", Matrícula: " + aluno.getNumeroMatricula());
        }
    }

    public static boolean existeAluno(int numeroMatriculaAluno) {
        return alunos.containsKey(numeroMatriculaAluno);
    }

    public void emitirDeclaracaoDeMatricula() {
        List<Matricula> matriculasDoAluno = Matricula.obterMatriculasPorAluno(this.numeroMatricula);
        System.out.println("Declaração de Matrícula");
        System.out.println("Aluno: " + this.nomeCompleto);
        System.out.println("Matrícula: " + this.numeroMatricula);
        System.out.println("Disciplinas Matriculadas:");
        for (Matricula matricula : matriculasDoAluno) {
            Disciplina disciplina = Disciplina.obterDisciplina(matricula.getCodigoDisciplina());
            System.out.println("- " + disciplina.getNome() + " (Código: " + disciplina.getCodigo() + ")");
        }
    }
}