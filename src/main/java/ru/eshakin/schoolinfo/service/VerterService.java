package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.VerterRepository;
import ru.eshakin.schoolinfo.model.entity.Verter;
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
