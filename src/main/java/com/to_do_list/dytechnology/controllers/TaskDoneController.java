package com.to_do_list.dytechnology.controllers;

import com.to_do_list.dytechnology.dto.TaskDoneDto;
import com.to_do_list.dytechnology.dto.TaskDto;
import com.to_do_list.dytechnology.services.TaskDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskDoneController {
    @Autowired
    private TaskDoneService taskDoneService;

    @GetMapping("/done")
    public List allTasks(){
        return taskDoneService.searchTasks();
    }

    @PutMapping("/update-task-done/{id}")
    public Object updateDoneTask(@PathVariable Long id, @RequestBody TaskDoneDto dataTask){
        return ResponseEntity.ok(taskDoneService.updateTasksById(id,dataTask));
    }
}
