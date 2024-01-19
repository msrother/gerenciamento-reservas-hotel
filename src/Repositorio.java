public interface Repositorio<T> {
    void adicionar(T item) throws ReservaConflitanteException;
    void remover(T item);
    <R> T buscar(R codigo);
}
