package com.mceit_z.Inventory_System.services.generic.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.mceit_z.Inventory_System.services.generic.GenericService;

import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceIImpl<T, ID,R extends JpaRepository<T,ID>> implements GenericService<T, ID> {

    @Autowired
    protected R repository;

    @Override
    public List<T> list() {
        // Implementation for listing entities
        return repository.findAll(); // Placeholder return
    }

    @Override
    public Optional<T> get(ID id) {
        // Implementation for getting an entity by ID
        return repository.findById(id); // Placeholder return
    }

    @Override
    public T save(T entity) {
        // Implementation for saving an entity
        return repository.save(entity); // Placeholder return
    }

    @Override
    public void delete(ID id) {
        // Implementation for deleting an entity by ID
        repository.deleteById(id); // Placeholder return
    }
}
