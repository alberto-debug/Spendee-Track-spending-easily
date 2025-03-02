package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.Task;
import com.example.loginauthapi.domain.user.TaskStatus;
import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> createTasks(@RequestBody Task task, @AuthenticationPrincipal User user){
        task.setUser(user);
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/user")
    public ResponseEntity<List<Task>> getUserTasks(@AuthenticationPrincipal User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(taskService.getUserTasks(user.getId()));
    }

    // Change the status of a task
    @PatchMapping("/{taskId}/status")
    public ResponseEntity<Task> changeTaskStatus(@PathVariable Long taskId, @RequestParam TaskStatus newStatus) {
        Task updatedTask = taskService.changeTaskStatus(taskId, newStatus);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id, @AuthenticationPrincipal User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não autenticado.");
        }

        taskService.deletetask(id, user.getEmail());
        return ResponseEntity.ok().body("Transação removida com sucesso.");
    }

}