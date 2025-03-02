package com.example.loginauthapi.services;

import com.example.loginauthapi.domain.user.Task;
import com.example.loginauthapi.domain.user.TaskStatus;
import com.example.loginauthapi.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task){
        task.setStatus(TaskStatus.ONGOING);
        return taskRepository.save(task);
    }


    public List<Task> getUserTasks(Long id){
        return taskRepository.findByUserId(id);
    }

    public Task changeTaskStatus(Long taskId, TaskStatus newStatus) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    public void deletetask(Long id, String userEmail) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        if (!task.getUser().getEmail().equals(userEmail)) {
            throw new RuntimeException("Ação não autorizada");
        }

        taskRepository.delete(task);
    }
}