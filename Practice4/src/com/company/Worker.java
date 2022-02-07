package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Worker
{
    Random random = new Random();
    public String name;
    public String lastName;
    private String birthday;
    public String post;
    public long salary;
    public String city;
    public ArrayList<Task> tasksList = new ArrayList<Task>();
    public int countClosedTasks = 0;

    public Worker() {
        int rnd = random.nextInt(156) % 2;

        if (rnd == 0)
        {
            name = GenerateLogic.getNameForMale();
            lastName = GenerateLogic.getLastNameForMale();
        } else
        {
            name = GenerateLogic.getNameForFemale();
            lastName = GenerateLogic.getLastNameForFemale();
        }

        int day = random.nextInt(28) + 1;
        int month = random.nextInt(11) + 1;
        int year = random.nextInt(28) + 1975;
        birthday = day + "." + month + "." + year;

        post = GenerateLogic.getPost();
        city = GenerateLogic.getCity();
        int count = random.nextInt(3) + 1;
        for (int i = 0; i < count; i++)
        {
            GenerateLogic.getTask(tasksList);
            tasksList.get(i).worker = Worker.this;
        }

        Company.workerArrayList.add(Worker.this);
    }

    public Worker(String name, String lastName, String birthday, String post, String city)
    {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.post = post;
        this.city = city;

        Company.workerArrayList.add(Worker.this);
    }

    public String getInfo () {
        return "Name : " + name + "\nLast name : " + lastName + "\nAge : " + birthday +
                "\nPost : " + post + "\nCity : " + city + "\nClosed Tasks : " + countClosedTasks +
                "\nSalary : " + salary + "\n";
    }
}
