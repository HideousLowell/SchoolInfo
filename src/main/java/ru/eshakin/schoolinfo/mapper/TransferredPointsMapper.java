package ru.eshakin.schoolinfo.mapper;

import ru.eshakin.schoolinfo.model.dto.TransferredPointsDto;
import ru.eshakin.schoolinfo.model.entity.Peer;
import ru.eshakin.schoolinfo.model.entity.TransferredPoints;
import ru.eshakin.schoolinfo.service.PeerService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class TransferredPointsMapper extends GenericMapper<TransferredPoints, TransferredPointsDto> {

    private final PeerService peerService;

    public TransferredPointsMapper(PeerService peerService) {
        super(TransferredPoints.class, TransferredPointsDto.class);
        this.peerService = peerService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(TransferredPoints.class, TransferredPointsDto.class)
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(TransferredPointsDto.class, TransferredPoints.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(TransferredPointsDto source, TransferredPoints destination) throws EntityNotFoundException {
        Peer checkedPeer = peerService.getByNicknameOrElseThrow(source.getCheckedPeer());
        Peer checkingPeer = peerService.getByNicknameOrElseThrow(source.getCheckingPeer());
        destination.setCheckedPeer(checkedPeer);
        destination.setCheckingPeer(checkingPeer);
    }

    @Override
    void mapSpecificFields(TransferredPoints source, TransferredPointsDto destination) {
        destination.setCheckedPeer(source.getCheckedPeer().getNickname());
        destination.setCheckingPeer(source.getCheckingPeer().getNickname());
    }

}
