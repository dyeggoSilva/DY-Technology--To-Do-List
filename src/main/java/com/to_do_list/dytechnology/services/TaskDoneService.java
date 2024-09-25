package com.to_do_list.dytechnology.services;

import com.to_do_list.dytechnology.model.Task;
import com.to_do_list.dytechnology.model.TaskDone;
import com.to_do_list.dytechnology.repositories.TaskDoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskDoneService {
    @Autowired
    private TaskDoneRepository taskDoneRepository;

    public List<TaskDone> searchTasks(){
        return taskDoneRepository.findAll();
    }
}
