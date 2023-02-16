package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.TaskRepository;
import ru.eshakin.schoolinfo.model.entity.Task;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService extends GenericService<Task, String> {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository repository) {
        super(repository);
        taskRepository = repository;
    }

    public Optional<Task> getByTitle(String title) {
        return taskRepository.getTaskByTitle(title);
    }

    public Task getByTitleOrElseThrow(String title) {
        return taskRepository.getTaskByTitle(title).orElseThrow(() -> new EntityNotFoundException(
                String.format("Task with title '%s' not found", title)));
    }
}
