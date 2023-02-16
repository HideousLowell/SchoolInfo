package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.PeerToPeerRepository;
import ru.eshakin.schoolinfo.model.entity.PeerToPeer;
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
