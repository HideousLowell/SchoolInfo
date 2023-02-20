package ru.hlowell.info.repository;

import ru.hlowell.info.model.entity.TimeTrack;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTrackRepository extends GenericRepository<TimeTrack, Long> {
}
