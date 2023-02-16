package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.Experience;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends GenericRepository<Experience, Long> {
}
