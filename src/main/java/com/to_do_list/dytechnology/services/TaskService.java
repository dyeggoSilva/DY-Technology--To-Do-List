package com.to_do_list.dytechnology.services;

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

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskDoneRepository taskDoneRepository;

    public String creatTasks(TaskDto dataTask){
        Task newTask = new Task();
        newTask.setName(dataTask.name());
        newTask.setDescription(dataTask.description());
        newTask.setDone(dataTask.done());
        newTask.setPriority(dataTask.priority());
        taskRepository.save(newTask);
        return"Task created! (Tarefa Criada!)";
    }

    public List<Task> searchTasks(){
        return taskRepository.findAll();
    }
    public Optional<Task> searchTasksById(Long id){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return taskRepository.findById(id);
        }else {
            throw new TaskNotFound();
        }
    }
    public String updateTasksById(long id, TaskDto dataTask) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task updateTask = task.get();

            if (dataTask.done() == true) {
                transferTaskDone(id);
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
                taskRepository.save(updateTask);
                return "dados alterados!";
            }
        } else{
            throw new TaskNotFound();
        }
        return null;
    }

    public String deleteTasks(long id) {
        Optional task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.deleteById(id);
            return "Task deletada!";
        } else {
            throw new TaskNotFound();
        }
    }

    private void transferTaskDone(Long id){
        Optional<Task> task = taskRepository.findById(id);
        Task updateTask = task.get();
        TaskDone taskDone = new TaskDone(updateTask);
        taskDone.setDone(true);
        taskDoneRepository.save(taskDone);
        taskRepository.deleteById(id);

    }
}
