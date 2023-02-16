package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.TimeTrackRepository;
import ru.eshakin.schoolinfo.model.entity.TimeTrack;
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
