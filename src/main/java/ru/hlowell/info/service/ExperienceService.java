package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.Experience;
import ru.hlowell.info.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService extends GenericService<Experience, Long> {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        super(experienceRepository);
        this.experienceRepository = experienceRepository;
    }
}
