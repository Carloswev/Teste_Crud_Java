import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaDAO {
    private List<Pessoa> pessoas = new ArrayList<>();
    private int idCounter = 1;

    public Pessoa create(String nome, int idade) {
        Pessoa pessoa = new Pessoa(idCounter++, nome, idade);
        pessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> readAll() {
        return new ArrayList<>(pessoas);
    }

    public Optional<Pessoa> read(int id) {
        return pessoas.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Optional<Pessoa> update(int id, String nome, int idade) {
        Optional<Pessoa> pessoaOpt = read(id);
        if (pessoaOpt.isPresent()) {
            Pessoa pessoa = pessoaOpt.get();
            pessoa.setNome(nome);
            pessoa.setIdade(idade);
            return Optional.of(pessoa);
        }
        return Optional.empty();
    }

    public boolean delete(int id) {
        return pessoas.removeIf(p -> p.getId() == id);
    }
}
