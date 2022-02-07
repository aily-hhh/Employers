package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class SaveLoadWorkers
{
    public static void SaveInFile(){
        try(FileWriter fileWriter = new FileWriter("Workers.txt", false)){
            if (!Company.workerArrayList.isEmpty()){
                for(int i = 0; i < Company.workerArrayList.size(); i++){
                    fileWriter.write(Company.workerArrayList.get(i).getInfo()+"\n");
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
