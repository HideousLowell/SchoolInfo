package ru.hlowell.info.mapper;

import ru.hlowell.info.model.dto.TimeTrackDto;
import ru.hlowell.info.model.entity.Peer;
import ru.hlowell.info.model.entity.TimeTrack;
import ru.hlowell.info.service.PeerService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class TimeTrackMapper extends GenericMapper<TimeTrack, TimeTrackDto> {

    private final PeerService peerService;

    public TimeTrackMapper(PeerService peerService) {
        super(TimeTrack.class, TimeTrackDto.class);
        this.peerService = peerService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(TimeTrack.class, TimeTrackDto.class)
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(TimeTrackDto.class, TimeTrack.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(TimeTrackDto source, TimeTrack destination)
            throws EntityNotFoundException, IllegalArgumentException {
        String nickname = source.getPeer();
        Peer peer = peerService.getByNicknameOrElseThrow(nickname);
        destination.setPeer(peer);
    }

    @Override
    void mapSpecificFields(TimeTrack source, TimeTrackDto destination) {
        destination.setPeer(source.getPeer().getNickname());
    }

}
