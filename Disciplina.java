import java.util.HashMap;
import java.util.Map;

public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    private static Map<String, Disciplina> disciplinas = new HashMap<>();

    public Disciplina(String nome, String codigo, int cargaHoraria) {
        if (nome == null || codigo == null) {
            throw new IllegalArgumentException("Nome e código não podem ser nulos");
        }
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        disciplinas.put(codigo, this);
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public static void adicionarDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }
        disciplinas.put(disciplina.getCodigo(), disciplina);
    }

    public static void removerDisciplina(String codigo) {
        if (!disciplinas.containsKey(codigo)) {
            throw new IllegalArgumentException("Disciplina com esse código não existe");
        }
        disciplinas.remove(codigo);
    }

    public static Disciplina obterDisciplina(String codigo) {
        Disciplina disciplina = disciplinas.get(codigo);
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina com esse código não encontrada");
        }
        return disciplina;
    }

    public static void atualizarDisciplina(String codigo, Disciplina disciplina) {
        if (disciplina == null || !disciplinas.containsKey(codigo)) {
            throw new IllegalArgumentException("Disciplina inválida ou código não encontrado");
        }
        disciplinas.put(codigo, disciplina);
    }

    public static boolean existeDisciplina(String codigoDisciplina) {
        return disciplinas.containsKey(codigoDisciplina);
    }

    public static void listarDisciplinas() {
        for (Disciplina disciplina : disciplinas.values()) {
            System.out.println(disciplina.getNome() + " - " + disciplina.getCodigo());
        }
    }
}


