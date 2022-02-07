package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class View
{
    public static void closeTasks(){
        if(!Company.workerArrayList.isEmpty()){
            for (var worker: Company.workerArrayList)
            {
                if (!worker.tasksList.isEmpty()){
                    System.out.println("\nTask(s) is closed : ");
                    for (var task: worker.tasksList)
                    {
                        if (!task.isOpen())
                            System.out.print(task.getInfo());
                        else
                            System.out.println("\nNull 1");
                    }
                }
                else
                    System.out.println("\nNull 2");
            }
        }
        else
            System.out.println("\nNull 3");
    }
    public static void openTasks(){
        if(!Company.workerArrayList.isEmpty()){
            for (var worker: Company.workerArrayList)
            {
                if (!worker.tasksList.isEmpty()){
                    System.out.println("\nTask(s) is open : ");
                    for (var task: worker.tasksList)
                    {
                        if (task.isOpen())
                            System.out.print(task.getInfo());
                        else
                            System.out.println("\nNull 1");
                    }
                }
                else
                    System.out.println("\nNull 2");
            }
        }
        else
            System.out.println("\nNull 3");
    }
    public static void taskWithMaxPremium(){
        if (!Company.workerArrayList.isEmpty())
        {
            ArrayList<Task> arrayTask = new ArrayList<Task>();
            System.out.println("\nTask with max premium : ");
            for (var worker: Company.workerArrayList)
            {
                if (!worker.tasksList.isEmpty()){
                    for (var task: worker.tasksList)
                    {
                        arrayTask.add(task);
                    }
                }
                else
                    continue;
            }
            if (!arrayTask.isEmpty())
            {
                arrayTask.stream().sorted(new Comparator<Task>()
                {
                    @Override
                    public int compare(Task o1, Task o2)
                    {
                        return o1.executionTime - o2.executionTime;
                    }
                }).skip(arrayTask.size() - 1).forEach(p -> System.out.print(p.getInfo()+"\n"));
            }
        }
    }
    public static void top3Workers(){
        if (!Company.workerArrayList.isEmpty() && Company.workerArrayList.size() > 2)
            Company.workerArrayList.stream().sorted(new Comparator<Worker>()
            {
                @Override
                public int compare(Worker o1, Worker o2)
                {
                    return o1.countClosedTasks - o2.countClosedTasks;
                }
            }).skip(Company.workerArrayList.size()-3).forEach(s->System.out.print(s.getInfo() + "\n"));
    }
    public static void newWorker(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a name : ");
        String name = scanner.next();
        System.out.print("\nEnter a lastName : ");
        String lastName = scanner.next();
        System.out.print("\nEnter a birthday: ");
        String day = scanner.next();
        System.out.print("\nEnter a post : ");
        String post = scanner.next();
        System.out.print("\nEnter a city : ");
        String city = scanner.next();

        Worker wr = new Worker(name, lastName, day, post, city);
    }
    public static void newTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a name : ");
        String name = scanner.next();
        System.out.print("\nEnter a description : ");
        String description = scanner.next();
        int executionTime = -1;
        System.out.print("\nEnter a time : ");
        try
        {
            executionTime = scanner.nextInt();
        } catch (Exception e)
        {
            System.out.println("Incorrect data");
            return;
        }

        System.out.println("Count workers : " + Company.workerArrayList.size() + "\nEnter a worker's number : ");
        int num = 0;
        try
        {
            num = scanner.nextInt();
        } catch (Exception e)
        {
            System.out.println("Incorrect data");
            return;
        }

        if (num <= Company.workerArrayList.size() && num > 0 && executionTime >= 0)
        {
            Worker a = Company.workerArrayList.get(num - 1);
            Task task = new Task(name, description, executionTime, a);
            a.tasksList.add(task);
        }
        else
        {
            System.out.println("Incorrect data");
        }
    }
    
    public static void start()
    {
        Log.writeInto("Start program");
        Thread thread = new Thread(new Run());
        thread.start();
        Thread log = new Thread(new AutoSaveLog());
        log.start();
        while (true)
        {
            System.out.println("\nSelect an action : \n\t1 - ввести нового сотрудника \n\t2 - добавить задание" +
                    "\n\t3 - просмотр списка выполненных заданий \n\t4 - просмотр списка открытых заданий" +
                            "\n\t5 - топ-3 сотрудников" +
                    "\n\t6 - просмотр задания с наибольшим гонораром" +
                    "\n\t7 - формирование отчета за месяц \n\t8 - сохранение списка сотрудников в файл" +
                            "\n\t9 - выйти" );
            Scanner scanner = new Scanner(System.in);
            String c = scanner.next();
            c = c.trim();

            if (c.equals("1"))
            {
                Log.writeInto("Created new worker");
                newWorker();
            }
            if (c.equals("2"))
            {
                Log.writeInto("Created new task");
                newTask();
            }
            if (c.equals("3"))
                closeTasks();
            if (c.equals("4"))
                openTasks();
            if (c.equals("5"))
                top3Workers();
            if (c.equals("6"))
                taskWithMaxPremium();
            if (c.equals("7"))
            {
                Log.writeInto("Created new report");
                Report.SaveClosedTasksInFile();
            }
            if (c.equals("8"))
            {
                Log.writeInto("Created new list of worker");
                SaveLoadWorkers.SaveInFile();
            }
            if (c.equals("9"))
                break;
        }
        Log.writeInto("Finish program");
        Run.isActive = false;
        log.isInterrupted();
    }

    public static void beginProgram(){
        Thread view = new Thread(new ThreadForUser());
        view.start();
    }
}
