package com.company;
import java.util.ArrayList;
import java.util.Random;

public class GenerateLogic
{
    public static Random random = new Random();
    public static String getNameForMale(){
        String[] names = new String[10];
        names[0] = "Nikita";
        names[1] = "Artem";
        names[2] = "Michail";
        names[3] = "Dmitry";
        names[4] = "Konstantin";
        names[5] = "Evgeny";
        names[6] = "Valery";
        names[7] = "Andrey";
        names[8] = "Egor";
        names[9] = "Ivan";

        int rnd = random.nextInt(10);
        return names[rnd];
    }
    public static String getLastNameForMale(){
        String[] lastNames = new String[10];
        lastNames[0] = "Malinovsky";
        lastNames[1] = "Chernyshevsky";
        lastNames[2] = "Tarasov";
        lastNames[3] = "Morozov";
        lastNames[4] = "Derzhavin";
        lastNames[5] = "Bagirov";
        lastNames[6] = "Radishchev";
        lastNames[7] = "Gromov";
        lastNames[8] = "Yusupov";
        lastNames[9] = "Saburov";

        int rnd = random.nextInt(10);
        return lastNames[rnd];
    }
    public static String getNameForFemale(){
        String[] names = new String[10];
        names[0] = "Alina";
        names[1] = "Oksana";
        names[2] = "Irina";
        names[3] = "Valeria";
        names[4] = "Polina";
        names[5] = "Elena";
        names[6] = "Sofia";
        names[7] = "Alexandra";
        names[8] = "Tatyana";
        names[9] = "Natalia";

        int rnd = random.nextInt(10);
        return names[rnd];
    }
    public static String getLastNameForFemale(){
        String[] lastNames = new String[10];
        lastNames[0] = "Illarionova";
        lastNames[1] = "Andreeva";
        lastNames[2] = "Tretyakova";
        lastNames[3] = "Panchenko";
        lastNames[4] = "Sokolova";
        lastNames[5] = "Leonova";
        lastNames[6] = "Polyakova";
        lastNames[7] = "Matveeva";
        lastNames[8] = "Kotova";
        lastNames[9] = "Istomina";

        int rnd = random.nextInt(10);
        return lastNames[rnd];
    }
    public static String getPost(){
        String[] names = new String[4];
        names[0] = "Manager";
        names[1] = "Head of department";
        names[2] = "Secretary";
        names[3] = "Engineer";

        int rnd = random.nextInt(4);
        return names[rnd];
    }
    public static String getCity(){
        String[] names = new String[7];
        names[0] = "Moscow";
        names[1] = "St.Peterburg";
        names[2] = "Kemerovo";
        names[3] = "Saransk";
        names[4] = "Nigniy Novgorod";
        names[5] = "Ekaterenburg";
        names[6] = "Novosibirsk";

        int rnd = random.nextInt(7);
        return names[rnd];
    }
    public static void getTask(ArrayList<Task> tasksList){
        String name = Integer.toString(random.nextInt(64)+1);
        String [] desc = new String[5];
        int time = random.nextInt(15)+1;

        desc[0] = "Work with progA";
        desc[1] = "Work with progB";
        desc[2] = "Work with progC";
        desc[3] = "Work with progD";
        desc[4] = "Work with progE";

        Task task = new Task(name, desc[random.nextInt(5)], time);
        tasksList.add(task);
    }
}
