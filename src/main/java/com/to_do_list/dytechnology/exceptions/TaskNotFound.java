package com.to_do_list.dytechnology.exceptions;

public class TaskNotFound extends RuntimeException{
    public TaskNotFound(){
        super("Task Not Found (Tarefa não encontrada)");
    }

    public TaskNotFound(String msg){
        super(msg);
    }
}
