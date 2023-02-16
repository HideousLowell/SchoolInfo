package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.ExperienceRepository;
import ru.eshakin.schoolinfo.model.entity.Experience;
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
