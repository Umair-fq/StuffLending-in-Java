package Java;

import Java.contractsFunctions;
import Java.item;

public class time {
    contractsFunctions c;
    public static int daycounter=0;

    public void counter(int count)
    {
        daycounter=daycounter+count;
        System.out.println("new value "+daycounter);
    }

    public void check()
    {
        for(int i = 0; i< c.contracts.size(); i++)
        {
            if(c.contracts.get(i).getStatus().equalsIgnoreCase("active")){
                int starting=c.contracts.get(i).getStartingday();
                int ending=c.contracts.get(i).getTotaldays();
                int total=starting+ending;

                if(total< daycounter) {
                    c.contracts.get(i).setStatus("completed");
                    item item=c.contracts.get(i).getItem();
                    item.setStatus("Available");
                    System.out.println("Java.Contract completed");
                }
            }

            if(c.contracts.get(i).getStartingday()>=daycounter) {
                c.contracts.get(i).setStatus("Active");
                item item=c.contracts.get(i).getItem();
                item.setStatus("reserved");
            }
        }
    }
}
