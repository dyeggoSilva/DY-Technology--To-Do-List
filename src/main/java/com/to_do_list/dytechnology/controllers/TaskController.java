package com.to_do_list.dytechnology.controllers;

import com.to_do_list.dytechnology.dto.TaskDto;
import com.to_do_list.dytechnology.model.Task;
import com.to_do_list.dytechnology.services.TaskService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/tasks")
    public List allTasks(){
        return taskService.searchTasks();
    }
    @GetMapping("/task/{id}")
    public Optional tasksById(@PathVariable Long id){
        return taskService.searchTasksById(id);
    }


    @PostMapping("/register-task")
    public Object registerTask(@RequestBody TaskDto dataTask){
        return ResponseEntity.ok(taskService.creatTasks(dataTask));
    }
    @PutMapping("/update-task/{id}")
    public Object updateTask(@PathVariable Long id, @RequestBody TaskDto dataTask){
        return ResponseEntity.ok(taskService.updateTasksById(id,dataTask));
    }
    @DeleteMapping("/delete-task/{id}")
    public Object deleterTask(@PathVariable Long id){
        return ResponseEntity.ok(taskService.deleteTasks(id));
    }
}
