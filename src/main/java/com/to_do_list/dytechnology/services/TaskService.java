package com.to_do_list.dytechnology.services;

import com.to_do_list.dytechnology.dto.TaskDto;
import com.to_do_list.dytechnology.model.Task;
import com.to_do_list.dytechnology.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Task> searchTasks(){
        return taskRepository.findAll();
    }
    public Optional<Task> searchTasksById(Long id){
        return taskRepository.findById(id);
    }
    public String updateTasksById(long id, TaskDto dataTask){

        Optional<Task> task = taskRepository.findById(id);

        if(task.isPresent()){
            Task updateTask = task.get();
            if(dataTask.name()!= null){
                updateTask.setName(dataTask.name());
            }if(dataTask.done() == true){
                updateTask.setDone(dataTask.done());
            }if(dataTask.description() != null){
                updateTask.setDescription(dataTask.description());
            }if(dataTask.priority() != 0){
                updateTask.setPriority(dataTask.priority());
            }
            taskRepository.save(updateTask);
            return "dados alterados!";
        }else { return "Task não encontrada!";}
    }
    public String deleteTasks(long id) {
        Task deleteTask = new Task();

        Optional task = taskRepository.findById(id);

        if (task.isPresent()) {
            taskRepository.deleteById(id);
            return "Task deletada!";
        } else {
            return "Task não encontrada!";
        }

    }
}
