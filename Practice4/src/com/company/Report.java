package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Report
{
    public static void SaveClosedTasksInFile(){
        try(FileWriter fileWriter = new FileWriter("Closed tasks.txt",false))
        {
            for (int i = 0; i < Company.workerArrayList.size(); i++)
            {
                for (int j = 0; j < Company.workerArrayList.get(i).tasksList.size(); j++)
                {
                    if (!Company.workerArrayList.get(i).tasksList.get(j).isOpen())
                        fileWriter.write(Company.workerArrayList.get(i).tasksList.get(j).getInfo()+"\n");
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
