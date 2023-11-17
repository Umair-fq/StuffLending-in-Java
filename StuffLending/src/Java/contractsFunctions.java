package Java;

import Java.Contract;

import java.util.ArrayList;
import java.util.Scanner;

public class contractsFunctions {

    public static ArrayList<Contract> contracts=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    Store s;
    storeWindow s1;
    itemsFunctions i=new itemsFunctions();
    MembersFunctions m=new MembersFunctions();

    public void Addcontract(){
        ArrayList<item> items=i.returnAllItems();
        System.out.println("\nName"+"\t\t"+"Category"+"\t\t"+"Cost"+"\t\t"+"Owner");

        for (item item : items) {
            System.out.println(item.getName()+"\t\t"+item.getCategory()+"\t\t"+item.getCost()+"\t\t"+item.Owner.getName());
            System.out.println("Description : "+item.getDescription());
            System.out.println();
        }
        MakeContract();
        s1=new storeWindow();
        s1.show();
    }

    public void MakeContract()
    {
        System.out.println("\nEnter contract details:");
        System.out.println("Enter Item name: ");
        String name=sc.next();
        item item=i.getItem(name);

        if(item==null) {
            System.out.println("\nNo such Java.item exists\n");
            s1=new storeWindow();
            s1.show();
        }

        System.out.println("Enter Owner name: ");
        String owner=sc.next();
        Member mem=m.returnMemberbyName(owner);

        if(mem==null) {
            System.out.println("\nNo such member exists\n");
            s1=new storeWindow();
            s1.show();
        }

        System.out.println("Enter lender name: ");
        String lender=sc.next();
        mem=m.returnMemberbyName(lender);

        if(mem==null)
        {
            System.out.println("\nNo such member exists\n");
            s1=new storeWindow();
            s1.show();
        }
        System.out.println("Enter starting day: ");
        System.out.println("Press\n\t1.For automatically get the current day.\n\tElse enter your starting day.");
        int starting=sc.nextInt();

        if(starting==1)
            starting= time.daycounter;
        else{
            while(starting< time.daycounter){
                System.out.println("Starting day cannot be less than current day.Enter again");
                starting=sc.nextInt();
            }}

        System.out.println("Enter days: ");
        int days=sc.nextInt();
        s=new Store();
        s.addcontracts(name, lender, days, starting);
    }
    public boolean addcontract(int days, item item, Member owner, Member borrower, int totalcost, int starting)
    {
        if(item.getStatus().equalsIgnoreCase("available")) {
            for (Contract contract : contracts) {
                if (contract.getItem()==item && contract.getStatus().equalsIgnoreCase("Pending")) {
                    int day=starting+days;
                    if (day>=contract.getStartingday()) {
                        System.out.println("Item not available for these days.");
                        return false;
                    }
                }
            }
            Contract c=new Contract(days,item,owner,borrower,totalcost,starting,"Active");
            contracts.add(c);
            item.setStatus("reserved");
            return true;
        }

        else if (!item.getStatus().equalsIgnoreCase("reserved")){
            for (int i=0; i<contracts.size(); i++)
            {
                if (contracts.get(i).getItem()==item)
                {
                    int day=contracts.get(i).getStartingday()+contracts.get(i).getTotaldays();
                    if(day<starting)
                    {
                        Contract c=new Contract(days,item,owner,borrower,totalcost,starting,"Pending");
                        contracts.add(c);
                        item.setStatus("reserved");
                        return true;
                    }
                    else
                        return false;
                }
            }
            return false;
        }
        else
            return false;
    }
    public void SeeAllContracts()
    {
        Contract c;
        System.out.println("Name\t\tOwner\t\tLender\t\tCost\t\tStartingDay\t\tEndingDay\t\tTotalDays\t\tStatus");

        for(int i = 0; i< this.contracts.size(); i++)
        {
            c = this.contracts.get(i);
            int Ending = c.getTotaldays() + c.getStartingday();
            System.out.println(c.getItem().getName()+"\t\t"+c.getOwner().getName()+"\t\t"+c.getBorrower().getName()+"\t\t"+c.getTotalcost()+"\t\t\t"+c.getStartingday()+"\t\t\t\t"+Ending+"\t\t\t\t"+c.getTotaldays()+"\t\t\t\t"+c.getStatus());
        }

        s1=new storeWindow();
        s1.show();
    }
}
