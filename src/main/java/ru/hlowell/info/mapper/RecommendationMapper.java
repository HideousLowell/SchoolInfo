package ru.hlowell.info.mapper;

import ru.hlowell.info.model.dto.RecommendationDto;
import ru.hlowell.info.model.entity.Peer;
import ru.hlowell.info.model.entity.Recommendation;
import ru.hlowell.info.service.PeerService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class RecommendationMapper extends GenericMapper<Recommendation, RecommendationDto> {

    private final PeerService peerService;

    public RecommendationMapper(PeerService peerService) {
        super(Recommendation.class, RecommendationDto.class);
        this.peerService = peerService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Recommendation.class, RecommendationDto.class)
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(RecommendationDto.class, Recommendation.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(RecommendationDto source, Recommendation destination) throws EntityNotFoundException {

        Peer peer = peerService.getByNicknameOrElseThrow(source.getPeer());
        destination.setPeer(peer);

        String nickname = source.getRecommendedPeer();
//        if (nickname != null && !nickname.isEmpty()) {
            Peer recommended = peerService.getByNicknameOrElseThrow(nickname);
            destination.setRecommendedPeer(recommended);
//        }
    }

    @Override
    void mapSpecificFields(Recommendation source, RecommendationDto destination) {
        destination.setPeer(source.getPeer().getNickname());

        Peer recommendedPeer = source.getRecommendedPeer();
        destination.setRecommendedPeer(recommendedPeer.getNickname());
    }

}
