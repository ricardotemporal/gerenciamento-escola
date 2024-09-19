import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Turma {
    private String horario;
    private String codigo;
    private int capacidadeMaxima;
    private String codigoDisciplina;
    private int numeroMatriculaProfessor;

    private static Map<String, Turma> turmas = new HashMap<>();

    public Turma(String horario, String codigo, int capacidadeMaxima, String codigoDisciplina, int numeroMatriculaProfessor) {
        if (horario == null || codigo == null || codigoDisciplina == null) {
            throw new IllegalArgumentException("Horário, código, código da disciplina e matrícula do professor não podem ser nulos");
        }
        this.horario = horario;
        this.codigo = codigo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.codigoDisciplina = codigoDisciplina;
        this.numeroMatriculaProfessor = numeroMatriculaProfessor;
        turmas.put(codigo, this);
    }

    public String getHorario() {
        return horario;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public String codigoDisciplina() {
        return codigoDisciplina;
    }

    public int getNumeroMatriculaProfessor() {
        return numeroMatriculaProfessor;
    }

    public static void adicionarTurma(Turma turma) {
        if (turma == null || !Professor.existeProfessor(turma.getNumeroMatriculaProfessor())) {
            throw new IllegalArgumentException("Turma inválida ou professor não encontrado");
        }
        turmas.put(turma.getCodigo(), turma);
    }

    public static void removerTurma(String codigo) {
        if (!turmas.containsKey(codigo)) {
            throw new IllegalArgumentException("Turma com esse código não existe");
        }
        turmas.remove(codigo);
    }

    public static Turma obterTurma(String codigo) {
        Turma turma = turmas.get(codigo);
        if (turma == null) {
            throw new IllegalArgumentException("Turma com esse código não encontrada");
        }
        return turma;
    }

    public static void atualizarTurma(String codigo, Turma turma) {
        if (turma == null || !turmas.containsKey(codigo)) {
            throw new IllegalArgumentException("Turma inválida ou código não encontrado");
        }
        turmas.put(codigo, turma);
    }

    public static void listarTurmas() {
        for (Turma turma : turmas.values()) {
            System.out.println("Código: " + turma.getCodigo() + ", Horário: " + turma.getHorario());
        }
    }

    public static boolean existeTurma(String codigoTurma) {
        return turmas.containsKey(codigoTurma);
    }

    public static List<Turma> obterTurmasPorProfessor(int numeroMatriculaProfessor) {
        List<Turma> turmasDoProfessor = new ArrayList<>();
        for (Turma turma : turmas.values()) {
            if (turma.getNumeroMatriculaProfessor() == numeroMatriculaProfessor) {
                turmasDoProfessor.add(turma);
            }
        }
        return turmasDoProfessor;
    }
}

