package ru.eshakin.schoolinfo.mapper;

import ru.eshakin.schoolinfo.service.TaskService;
import ru.eshakin.schoolinfo.model.dto.TaskDto;
import ru.eshakin.schoolinfo.model.entity.Task;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper extends GenericMapper<Task, TaskDto> {

    private final TaskService taskService;

    public TaskMapper(TaskService taskService) {
        super(Task.class, TaskDto.class);
        this.taskService = taskService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Task.class, TaskDto.class)
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(TaskDto.class, Task.class)
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(TaskDto source, Task destination) throws EntityNotFoundException {
        String parentName = source.getParentTask();
        if (parentName == null || parentName.isEmpty()) {
            destination.setParentTask(null);
        } else {
            Task parentTask = new Task();
            parentTask.setTitle(parentName);
            destination.setParentTask(parentTask);
        }

    }

    @Override
    void mapSpecificFields(Task source, TaskDto destination) {
        Task parentTask = source.getParentTask();
        if (parentTask != null) {
            destination.setParentTask(parentTask.getTitle());
        }
    }

}
