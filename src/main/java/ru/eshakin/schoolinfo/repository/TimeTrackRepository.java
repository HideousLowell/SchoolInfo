package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.TimeTrack;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTrackRepository extends GenericRepository<TimeTrack, Long> {
}
