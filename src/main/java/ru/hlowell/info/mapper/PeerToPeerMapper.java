package ru.hlowell.info.mapper;

import ru.hlowell.info.model.Status;
import ru.hlowell.info.model.dto.PeerToPeerDto;
import ru.hlowell.info.model.entity.Check;
import ru.hlowell.info.model.entity.Peer;
import ru.hlowell.info.model.entity.PeerToPeer;
import ru.hlowell.info.service.CheckService;
import ru.hlowell.info.service.PeerService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PeerToPeerMapper extends GenericMapper<PeerToPeer, PeerToPeerDto> {

    private final CheckService checkService;
    private final PeerService peerService;

    public PeerToPeerMapper(CheckService checkService, PeerService peerService) {
        super(PeerToPeer.class, PeerToPeerDto.class);
        this.checkService = checkService;
        this.peerService = peerService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(PeerToPeer.class, PeerToPeerDto.class).setPostConverter(toDtoConverter());
        mapper.createTypeMap(PeerToPeerDto.class, PeerToPeer.class).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(PeerToPeerDto source, PeerToPeer destination)
            throws EntityNotFoundException, IllegalArgumentException {
        Long id = source.getCheckId();
        Check check = checkService.getByIdOrElseThrow(id);
        destination.setCheck(check);

        String nickname = source.getCheckingPeer();
        Peer peer = peerService.getByNicknameOrElseThrow(nickname);
        destination.setCheckingPeer(peer);

        Status status = Status.valueOf(source.getStatus());
        destination.setStatus(status);
    }

    @Override
    void mapSpecificFields(PeerToPeer source, PeerToPeerDto destination) {
        destination.setCheckId(source.getCheck().getId());
        destination.setCheckingPeer(source.getCheckingPeer().getNickname());
        destination.setStatus(source.getStatus().name());
    }

}
