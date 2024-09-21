package com.to_do_list.dytechnology.controllers;

import com.to_do_list.dytechnology.dto.TaskDto;
import com.to_do_list.dytechnology.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("register-task")
    public Object registerTask(@RequestBody TaskDto dataTask){
        return ResponseEntity.ok(taskService.creatTasks(dataTask));

    }
}
