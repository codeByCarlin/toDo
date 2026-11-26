package com.toDo.ToDo.controller;

import com.toDo.ToDo.model.TaskEntity;
import com.toDo.ToDo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskEntity> save(@RequestBody TaskEntity task) {
        TaskEntity save = this.taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> findAll() {
        return ResponseEntity.ok().body(this.taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> findById(@PathVariable Long id) {
        TaskEntity task = this.taskService.findById(id);
        return ResponseEntity.ok().body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> update(@RequestBody TaskEntity taskRequest,
                                             @PathVariable Long id) {
        TaskEntity task = this.taskService.update(taskRequest, id);
        return ResponseEntity.ok().body(task);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TaskEntity> complete(@RequestBody TaskEntity taskRequest, @PathVariable Long id) {
        TaskEntity task = this.taskService.updateToCompleted(taskRequest, id);
        return ResponseEntity.ok().body(task);
    }
}
