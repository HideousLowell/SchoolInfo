package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.Task;
import ru.hlowell.info.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<String> getAllTitles() {
        return taskRepository.findAllTitles();
    }

    public Optional<Task> getFirstTask() {
        return taskRepository.findTaskByParentTaskIsNull();
    }

    public List<String> getAllAvailableParentTasks() {
        List<String> titles = taskRepository.findAllTitles();
        if (!getFirstTask().isPresent())
            titles.add("");
        return titles;
    }
}
