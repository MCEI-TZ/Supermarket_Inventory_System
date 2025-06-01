package com.mceit_z.Inventory_System.services.generic.Impl;

import com.mceit_z.Inventory_System.config.exceptions.EntityNotFoundException;
import com.mceit_z.Inventory_System.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceIImpl<T, ID, R extends JpaRepository<T, ID>> implements GenericService<T, ID> {

    @Autowired
    protected R repository;

    @Override
    public List<T> list() {
        // Implementation for listing entities
        List<T> entities = repository.findAll(); // Placeholder return
        if (entities.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No entities of type %s found", getEntityClassName())
            );
        } else {
            return entities; // Return the list of entities
        }
    }

    @Override
    public Optional<T> get(ID id) {

        Optional<T> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("Entity of type %s with ID %s not found", getEntityClassName(), id)
            );
        }
        return entity;
    }

    @Override
    public T save(T entity) {
        // Implementation for saving an entity
        return repository.save(entity); // Placeholder return
    }

    @Override
    public void delete(ID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    String.format("Entity of type %s with ID %s not found for deletion", getEntityClassName(), id)
            );
        }
        // Implementation for deleting an entity by ID
        repository.deleteById(id); // Placeholder return
    }

    private String getEntityClassName() {
        return ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0])
                .getSimpleName();
    }
}
