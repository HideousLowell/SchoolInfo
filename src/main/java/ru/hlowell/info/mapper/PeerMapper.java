package ru.hlowell.info.mapper;

import ru.hlowell.info.model.dto.PeerDto;
import ru.hlowell.info.model.entity.Peer;
import org.springframework.stereotype.Component;

@Component
public class PeerMapper extends GenericMapper<Peer, PeerDto> {

    public PeerMapper() {
        super(Peer.class, PeerDto.class);
    }

}
