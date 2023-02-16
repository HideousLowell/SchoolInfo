package ru.eshakin.schoolinfo.controller.data;

import ru.eshakin.schoolinfo.controller.GenericController;
import ru.eshakin.schoolinfo.mapper.TaskMapper;
import ru.eshakin.schoolinfo.model.dto.TaskDto;
import ru.eshakin.schoolinfo.model.entity.Task;
import ru.eshakin.schoolinfo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController extends GenericController<Task, TaskDto, String> {

    public TaskController(TaskService service, TaskMapper mapper) {
        super(service, mapper);
    }

    @Override
    protected Class<TaskDto> getDtoClass() {
        return TaskDto.class;
    }

    @Override
    protected String getEntityName() {
        return "task";
    }
}
