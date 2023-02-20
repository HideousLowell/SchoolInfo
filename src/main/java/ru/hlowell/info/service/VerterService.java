package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.Verter;
import ru.hlowell.info.repository.VerterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerterService extends GenericService<Verter, Long> {

    private final VerterRepository verterRepository;

    @Autowired
    public VerterService(VerterRepository verterRepository) {
        super(verterRepository);
        this.verterRepository = verterRepository;
    }
}
