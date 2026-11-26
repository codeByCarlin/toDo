package com.toDo.ToDo.service;

import com.toDo.ToDo.model.TaskEntity;
import com.toDo.ToDo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public TaskEntity findById(Long id) {
        return this.taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found task"));
    }

    public TaskEntity save(TaskEntity task) {
        return this.taskRepository.save(task);
    }

    public void delete(Long id) {
        this.taskRepository.deleteById(id);
    }

    public TaskEntity update(TaskEntity task, Long id) {
        TaskEntity taskEntity = this.taskRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Error while seacrhing title"));
        taskEntity.setCompleted(task.getCompleted());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setTitle(task.getTitle());
        return taskRepository.save(taskEntity);
    }

    public TaskEntity updateToCompleted(TaskEntity task, Long id) {
        TaskEntity taskEntity = this.taskRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Error while seacrhing title"));

        taskEntity.setCompleted(task.getCompleted());
        return this.taskRepository.save(taskEntity);
    }
}
