package com.company;

import static com.company.GenerateLogic.random;

public class Task
{
    public String name;
    public String description;
    public int executionTime;
    public int time;
    public Worker worker;
    public boolean open = true;

    public boolean isOpen() // открыт ли таск
    {
        if (executionTime > time)
            return open = true;
        else
            return open = false;
    }

    public Task(String name, String description, int executionTime){
        this.name = name;
        this.description = description;
        this. executionTime = executionTime;
    }

    public Task(String name, String description, int executionTime, Worker worker){
        this.name = name;
        this.description = description;
        this. executionTime = executionTime;
        this.worker = worker;
    }

    public String getInfo(){
       return "Name : " + name + "\n\tDescription : " + description + "\n\tExecution Time : " + executionTime
        + "\n\tWorker : " + worker.name + " " + worker.lastName + "\n\tTime : " + time + "\n";
    }
}
