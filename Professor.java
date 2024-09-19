import java.util.HashMap;
import java.util.Map;

public class Professor {
    private String nomeCompleto;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String cpf;
    private int numeroMatricula;

    private static Map<Integer, Professor> professores = new HashMap<>();

    public Professor(String nomeCompleto, String dataNascimento, String endereco, String telefone, String cpf, int numeroMatricula) {
        if (nomeCompleto == null || dataNascimento == null || endereco == null || telefone == null || cpf == null) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo");
        }
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.numeroMatricula = numeroMatricula;
        professores.put(numeroMatricula, this);
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

    public static void adicionarProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor não pode ser nulo");
        }
        professores.put(professor.getNumeroMatricula(), professor);
    }

    public static void removerProfessor(int numeroMatricula) {
        if (!professores.containsKey(numeroMatricula)) {
            throw new IllegalArgumentException("Professor com essa matrícula não existe");
        }
        professores.remove(numeroMatricula);
    }

    public static Professor obterProfessor(int numeroMatricula) {
        Professor professor = professores.get(numeroMatricula);
        if (professor == null) {
            throw new IllegalArgumentException("Professor com essa matrícula não encontrado");
        }
        return professor;
    }

    public static void atualizarProfessor(int numeroMatricula, Professor professor) {
        if (professor == null || !professores.containsKey(numeroMatricula)) {
            throw new IllegalArgumentException("Professor inválido ou matrícula não encontrada");
        }
        professores.put(numeroMatricula, professor);
    }

    public static void listarProfessores() {
        for (Professor professor : professores.values()) {
            System.out.println(professor.getNomeCompleto() + " - " + professor.getNumeroMatricula());
        }
    }

    public static boolean existeProfessor(int numeroMatricula) {
        return professores.containsKey(numeroMatricula);
    }

    public void emitirDeclaracaoDeVinculo() {
        System.out.println("Declaração de Vínculo");
        System.out.println("Professor(a): " + this.nomeCompleto);
        System.out.println("Matrícula: " + this.numeroMatricula);
        System.out.println("Turmas Responsáveis:");
        try {
            for (Turma turma : Turma.obterTurmasPorProfessor(this.numeroMatricula)) {
                System.out.println("- Código da Turma: " + turma.getCodigo() + ", Horário: " + turma.getHorario());
            }
        } catch (Exception e) {
            System.out.println("Nenhuma turma encontrada para este professor.");
        }
    }
}