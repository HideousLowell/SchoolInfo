package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.TransferredPointsRepository;
import ru.eshakin.schoolinfo.model.entity.TransferredPoints;
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
