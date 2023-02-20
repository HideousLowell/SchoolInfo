package ru.hlowell.info.repository;

import ru.hlowell.info.model.entity.Experience;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends GenericRepository<Experience, Long> {
}
