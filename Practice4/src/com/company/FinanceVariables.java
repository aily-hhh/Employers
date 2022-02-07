package com.company;
import java.util.ArrayList;

public class FinanceVariables
{
    public static void financeVariables(Worker worker, Task task){
        worker.salary += task.time * 3700;
    }
}

