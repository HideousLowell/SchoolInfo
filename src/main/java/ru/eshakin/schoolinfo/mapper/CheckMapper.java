package ru.eshakin.schoolinfo.mapper;

import ru.eshakin.schoolinfo.service.PeerService;
import ru.eshakin.schoolinfo.service.TaskService;
import ru.eshakin.schoolinfo.model.dto.CheckDto;
import ru.eshakin.schoolinfo.model.entity.Check;
import ru.eshakin.schoolinfo.model.entity.Peer;
import ru.eshakin.schoolinfo.model.entity.Task;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CheckMapper extends GenericMapper<Check, CheckDto> {

    private final PeerService peerService;
    private final TaskService taskService;

    public CheckMapper(PeerService peerService, TaskService taskService) {
        super(Check.class, CheckDto.class);
        this.peerService = peerService;
        this.taskService = taskService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Check.class, CheckDto.class).setPostConverter(toDtoConverter());
        mapper.createTypeMap(CheckDto.class, Check.class).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(CheckDto source, Check destination)
            throws EntityNotFoundException {

        String nickname = source.getPeer();
        Peer peer = peerService.getByNicknameOrElseThrow(nickname);
        destination.setPeer(peer);

        String title = source.getTask();
        Task task = taskService.getByTitleOrElseThrow(title);
        destination.setTask(task);

    }

    @Override
    void mapSpecificFields(Check source, CheckDto destination) {
        destination.setPeer(source.getPeer().getNickname());
        destination.setTask(source.getTask().getTitle());
    }

}
