package com.to_do_list.dytechnology.controllers;

import com.to_do_list.dytechnology.services.TaskDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskDoneController {
    @Autowired
    private TaskDoneService taskDoneService;

    @GetMapping("/done")
    public List allTasks(){
        return taskDoneService.searchTasks();
    }
}
