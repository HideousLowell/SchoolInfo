package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.TimeTrack;
import ru.hlowell.info.repository.TimeTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTrackService extends GenericService<TimeTrack, Long> {

    private final TimeTrackRepository timeTrackRepository;

    @Autowired
    public TimeTrackService(TimeTrackRepository timeTrackRepository) {
        super(timeTrackRepository);
        this.timeTrackRepository = timeTrackRepository;
    }
}
