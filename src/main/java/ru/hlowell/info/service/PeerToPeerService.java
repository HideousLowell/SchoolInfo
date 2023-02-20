package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.PeerToPeer;
import ru.hlowell.info.repository.PeerToPeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeerToPeerService extends GenericService<PeerToPeer, Long> {

    private final PeerToPeerRepository peerToPeerRepository;

    @Autowired
    public PeerToPeerService(PeerToPeerRepository p2pRepo) {
        super(p2pRepo);
        this.peerToPeerRepository = p2pRepo;
    }
}
