package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.TransferredPoints;
import ru.hlowell.info.repository.TransferredPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferredPointsService extends GenericService<TransferredPoints, Long> {

    private final TransferredPointsRepository transferredPointsRepository;

    @Autowired
    public TransferredPointsService(TransferredPointsRepository transferredPointsRepository) {
        super(transferredPointsRepository);
        this.transferredPointsRepository = transferredPointsRepository;
    }
}
