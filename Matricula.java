import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matricula {
    private int numeroMatriculaAluno;
    private String codigoDisciplina;
    private String codigoTurma;

    private static Map<Integer, Matricula> matriculas = new HashMap<>();

    public Matricula(int numeroMatriculaAluno, String codigoDisciplina, String codigoTurma) {
        this.numeroMatriculaAluno = numeroMatriculaAluno;
        this.codigoDisciplina = codigoDisciplina;
        this.codigoTurma = codigoTurma;
        matriculas.put(numeroMatriculaAluno, this);
    }

    public int getNumeroMatriculaAluno() {
        return numeroMatriculaAluno;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }



    public static void adicionarMatricula(Matricula matricula) {
        matriculas.put(matricula.getNumeroMatriculaAluno(), matricula);
    }

    public static void removerMatricula(int numeroMatriculaAluno) {
        matriculas.remove(numeroMatriculaAluno);
    }

    public static Matricula obterMatricula(int numeroMatriculaAluno) {
        return matriculas.get(numeroMatriculaAluno);
    }

    public static void listarMatriculas() {
        for (Matricula matricula : matriculas.values()) {
            System.out.println("Matrícula: " + matricula.getNumeroMatriculaAluno() + ", Disciplina: " + matricula.getCodigoDisciplina() + ", Turma: " + matricula.getCodigoTurma());
        }
    }

    public static void matricularAluno(int numeroMatriculaAluno, String codigoDisciplina, String codigoTurma) {
        if (!Aluno.existeAluno(numeroMatriculaAluno) || !Disciplina.existeDisciplina(codigoDisciplina) || !Turma.existeTurma(codigoTurma)) {
            System.out.println("Aluno, disciplina ou turma não encontrados.");
            return;
        }

        if (isAlunoMatriculado(numeroMatriculaAluno, codigoDisciplina)) {
            System.out.println("O aluno já está matriculado nesta disciplina.");
        } else {
            Matricula matricula = new Matricula(numeroMatriculaAluno, codigoDisciplina, codigoTurma);
            System.out.println("Aluno matriculado com sucesso na disciplina " + codigoDisciplina);
        }
    }

    public static void desmatricularAluno(int numeroMatriculaAluno, String codigoDisciplina, String codigoTurma) {
        if (isAlunoMatriculado(numeroMatriculaAluno, codigoDisciplina)) {
            matriculas.remove(numeroMatriculaAluno);
            System.out.println("Aluno desmatriculado com sucesso da disciplina " + codigoDisciplina);
        } else {
            System.out.println("O aluno não está matriculado nesta disciplina.");
        }
    }

    public static boolean isAlunoMatriculado(int numeroMatriculaAluno, String codigoDisciplina) {
        for (Matricula matricula : matriculas.values()) {
            if (matricula.numeroMatriculaAluno == numeroMatriculaAluno &&
                matricula.codigoDisciplina.equals(codigoDisciplina)) {
                return true;
            }
        }
        return false;
    }

    public static List<Matricula> obterMatriculasPorAluno(int numeroMatriculaAluno) {
        List<Matricula> matriculasDoAluno = new ArrayList<>();
        for (Matricula matricula : matriculas.values()) {
            if (matricula.numeroMatriculaAluno == numeroMatriculaAluno) {
                matriculasDoAluno.add(matricula);
            }
        }
        return matriculasDoAluno;
    }
}
