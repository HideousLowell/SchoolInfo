package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.CheckRepository;
import ru.eshakin.schoolinfo.model.entity.Check;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckService extends GenericService<Check, Long> {

    private final CheckRepository checkRepository;

    @Autowired
    public CheckService(CheckRepository repository) {
        super(repository);
        this.checkRepository = repository;
    }

    public Check getByIdOrElseThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Check with id '%d' not found", id)));
    }

    public Page<Check> listAllPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Check> searchByPeerNickName(String peerNickName) {
        return checkRepository.findAllByPeer(peerNickName);
    }
}
