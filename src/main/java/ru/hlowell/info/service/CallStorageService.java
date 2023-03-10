package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.CallBody;
import ru.hlowell.info.repository.RequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallStorageService extends GenericService<CallBody, Long> {

    private final RequestRepository repository;

    @Autowired
    public CallStorageService(RequestRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public CallBody getOneOrThrow(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                String.format("Procedure with id %d not found", id)));
    }
}