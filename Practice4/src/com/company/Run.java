package com.company;

import java.util.Random;

public class Run implements Runnable
{
    Random random = new Random();
    int count; int num;
    static boolean isActive = true;

    public Run(){
        isActive = true;
    }
    @Override
    public void run()
    {
        while (isActive)
        {
            if (!Company.workerArrayList.isEmpty())
            {
                count = random.nextInt(Company.workerArrayList.size());
                if (Company.workerArrayList.get(count).tasksList.isEmpty())
                    continue;
                num = random.nextInt(Company.workerArrayList.get(count).tasksList.size());
                if (Company.workerArrayList.get(count).tasksList.get(num).isOpen())
                {
                    Company.workerArrayList.get(count).tasksList.get(num).time++;
                    if (Company.workerArrayList.get(count).tasksList.get(num).time ==
                            Company.workerArrayList.get(count).tasksList.get(num).executionTime)
                    {
                        Log.writeInto(Company.workerArrayList.get(count).name + " " + Company.workerArrayList.get(count).lastName +
                                " closed the task");
                        Company.workerArrayList.get(count).countClosedTasks++;
                        Company.workerArrayList.get(count).tasksList.get(num).open = false;
                        FinanceVariables.financeVariables(Company.workerArrayList.get(count),Company.workerArrayList.get(count).tasksList.get(num));
                    }
                }
            }
            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
