package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.Peer;
import ru.hlowell.info.repository.PeerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeerService extends GenericService<Peer, String> {

    private final PeerRepository peerRepository;

    @Autowired
    protected PeerService(PeerRepository repository) {
        super(repository);
        peerRepository = repository;
    }

    public Peer getByNicknameOrElseThrow(String nickname) {
        return peerRepository.findPeerByNickname(nickname)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Peer with nickname '%s' not found", nickname)));
    }

    public List<String> getAllNicknames() {
        return peerRepository.findAllNicknames();
    }
}
