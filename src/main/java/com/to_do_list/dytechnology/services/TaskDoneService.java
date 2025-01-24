package com.to_do_list.dytechnology.services;

import com.to_do_list.dytechnology.dto.TaskDoneDto;
import com.to_do_list.dytechnology.dto.TaskDto;
import com.to_do_list.dytechnology.exceptions.TaskNotFound;
import com.to_do_list.dytechnology.model.Task;
import com.to_do_list.dytechnology.model.TaskDone;
import com.to_do_list.dytechnology.repositories.TaskDoneRepository;
import com.to_do_list.dytechnology.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskDoneService {
    @Autowired
    private TaskDoneRepository taskDoneRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDone> searchTasks(){
        return taskDoneRepository.findAll();
    }

    public List<TaskDone> updateTasksById(Long id, TaskDoneDto dataTask) {
        Optional<TaskDone> task = taskDoneRepository.findById(id);

        if (task.isPresent()) {
            TaskDone updateTask = task.get();

            if (dataTask.done() == false) {
                transferTask(id);
                throw new TaskNotFound("task ativa");
            } else {

                if (dataTask.name() != null) {
                    updateTask.setName(dataTask.name());
                }
                if (dataTask.description() != null) {
                    updateTask.setDescription(dataTask.description());
                }
                if (dataTask.priority() != 0) {
                    updateTask.setPriority(dataTask.priority());
                }
                taskDoneRepository.save(updateTask);
                return searchTasks();
            }
        } else{
            throw new TaskNotFound();
        }

    }

    private void transferTask(Long id){

        Optional<TaskDone> task = taskDoneRepository.findById(id);

        TaskDone updateTask = task.get();
        boolean done = false;

        Task newTask = new Task();

        newTask.setName(updateTask.getName());
        newTask.setDescription(updateTask.getDescription());
        newTask.setDone(done);
        newTask.setPriority(updateTask.getPriority());
        taskRepository.save(newTask);
        taskDoneRepository.deleteById(id);

    }
}
