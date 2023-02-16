package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends GenericRepository<Task, String> {
    Optional<Task> getTaskByTitle(String title);
}
