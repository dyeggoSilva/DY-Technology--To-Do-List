package com.to_do_list.dytechnology.services;

import com.to_do_list.dytechnology.dto.TaskDto;
import com.to_do_list.dytechnology.model.Task;
import com.to_do_list.dytechnology.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public String creatTasks(TaskDto dataTask){
        Task newTask = new Task();

        newTask.setName(dataTask.name());
        newTask.setDescription(dataTask.description());
        newTask.setDone(dataTask.done());
        newTask.setPriority(dataTask.priority());

        taskRepository.save(newTask);

        return"Task created! (Tarefa Criada!)";
    }

    public String searchTasks(){return "";}
    public String searchTasksById(){return "";}
    public String updateTasks(){return "";}
    public String deleteTasks(){return "";}
}
