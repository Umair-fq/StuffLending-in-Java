package Java;

import java.util.Scanner;
public class storeWindow {
    MembersFunctions m;
    contractsFunctions c;
    itemsFunctions i;
    time t;
    Scanner sc=new Scanner(System.in);

    public storeWindow() {}

    public void show()
    {
        System.out.println("Increase day counter by ");
        int count=sc.nextInt();
        t=new time();
        t.counter(count);
        t.check();
        int option;
        System.out.println("Press:\n\t1.Show All Members.\t\t\t2.Add Java.Member.\n\t3.Delete Java.Member\t\t\t\t4.Update Java.Member's Information\n\t5.Add Java.item for member.\t\t6.Make changes to items.\n\t7.Make new contract\t\t\t8.See all Contracts.\n\t9.Exit");
        option=sc.nextInt();

        if(option==0)
            return;

        switch(option)
        {
            case 9:
                System.out.println("\n\nExisting");
                break;
            case 1:
                m=new MembersFunctions();
                m.ShowMembers();
                break;
            case 2:
                m=new MembersFunctions();
                m.AddMember();
                break;
            case 3:
                m=new MembersFunctions();
                m.DeleteMember();
                break;
            case 4:
                m=new MembersFunctions();
                m.UpdateMember();
                break;
            case 5:
                i=new itemsFunctions();
                i.Additem();
                break;
            case 6:
                i=new itemsFunctions();
                i.ItemFunctions();
                break;
            case 7:
                c=new contractsFunctions();
                c.Addcontract();
                break;
            case 8:
                c=new contractsFunctions();
                c.SeeAllContracts();
                break;
            default:
                storeWindow store=new storeWindow();
                store.show();
                break;
        }
    }
}