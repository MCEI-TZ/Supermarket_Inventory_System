package services.generic;

import java.util.List;
import java.util.Optional;

public interface GenericService<T,ID> {
    public List<T> list();
    public Optional<T> get(ID id);
    public T save(T entity);
    public void delete(ID id);
}
