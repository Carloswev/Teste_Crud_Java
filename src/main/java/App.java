public class App {
    public static void main(String[] args) {
        PessoaDAO dao = new PessoaDAO();

        // Criar
        Pessoa p1 = dao.create("João", 30);
        Pessoa p2 = dao.create("Maria", 25);

        // Ler todos
        System.out.println("Todas as pessoas:");
        dao.readAll().forEach(System.out::println);

        // Atualizar
        dao.update(p1.getId(), "João Silva", 31);

        // Ler uma pessoa
        System.out.println("\nPessoa com ID " + p1.getId() + ":");
        dao.read(p1.getId()).ifPresent(System.out::println);

        // Deletar
        dao.delete(p2.getId());

        // Ler todos após deletar
        System.out.println("\nTodas as pessoas após deletar Maria:");
        dao.readAll().forEach(System.out::println);
    }
}
