package ru.eshakin.schoolinfo.mapper;

import ru.eshakin.schoolinfo.model.dto.PeerDto;
import ru.eshakin.schoolinfo.model.entity.Peer;
import org.springframework.stereotype.Component;

@Component
public class PeerMapper extends GenericMapper<Peer, PeerDto> {

    public PeerMapper() {
        super(Peer.class, PeerDto.class);
    }

}
