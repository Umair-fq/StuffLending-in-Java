package Java;

import Java.Contract;
import Java.contractsFunctions;
import Java.item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class itemsFunctions {

    public static ArrayList<item> items=new ArrayList<>();
    Store s;
    MembersFunctions m;
    storeWindow store;
    Scanner sc=new Scanner(System.in);

    itemsFunctions(){}

    public static ArrayList<item> returnAllItems(){
        return items;
    }

    public boolean addItem(String Email,String name,String Category,String description,int price) {
        m=new MembersFunctions();
        Member mem=m.returnMember(Email);

        if(mem==null){
            System.out.println("Wrong input");
            store=new storeWindow();
            store.show();
        }

        if(mem==null)
            return false;

        String date=String.valueOf((LocalDateTime.now()));
        item i=new item(name,Category,description,price,date,mem);
        items.add(i);
        mem.ownedItems.add(i);
        mem.setCredits(mem.getCredits()+100);
        return true;
    }

    public boolean DeleteItem(String itemName,String ownerName) {
        m=new MembersFunctions();
        Member mem=m.returnMemberbyName(ownerName);

        if(mem==null){
            System.out.println("Wrong input");
            store=new storeWindow();
            store.show();
        }
        boolean bool1=false;
        boolean bool2=false;

        for(int i=0;i<items.size();i++)
        {
            if(items.get(i).getName().equalsIgnoreCase(itemName)&&items.get(i).Owner.getName().equalsIgnoreCase(ownerName))
            {
                item remove = items.remove(i);
                bool1=true;
            }
            assert mem != null;
            if(i<mem.ownedItems.size()&&mem.ownedItems.get(i).getName().equalsIgnoreCase(itemName))
            {
                item remove=mem.ownedItems.remove(i);
                bool2=true;
            }
        }

        for(int j = 0; j < contractsFunctions.contracts.size(); j++)
        {
            if(contractsFunctions.contracts.get(j).getItem().getName().equalsIgnoreCase(itemName)&& contractsFunctions.contracts.get(j).getOwner().getName().equalsIgnoreCase(ownerName))
            {
                contractsFunctions.contracts.get(j).setStatus("cancelled");
            }
        }
        return bool1 && bool2;
    }

    public void updateItem(String oldname,String itemName,String Category,String description,int price,String ownerName) {
        m=new MembersFunctions();
        Member mem=m.returnMember(ownerName);

        if(mem==null){
            System.out.println("Wrong input");
            store=new storeWindow();
            store.show();
        }

        for(int i=0;i<items.size();i++)
        {
            if(items.get(i).getName().equalsIgnoreCase(oldname)&&items.get(i).Owner.getName().equalsIgnoreCase(ownerName))
            {
                items.get(i).setName(itemName);
                items.get(i).setCategory(Category);
                items.get(i).setDescription(description);
                items.get(i).setCost(price);
            }
            assert mem != null;
            if(i<mem.ownedItems.size()&&mem.ownedItems.get(i).getName().equalsIgnoreCase(oldname))
            {
                mem.ownedItems.get(i).setName(itemName);
                mem.ownedItems.get(i).setCategory(Category);
                mem.ownedItems.get(i).setDescription(description);
                mem.ownedItems.get(i).setCost(price);
            }
        }
    }

    public item getItem(String itemName) {
        for (item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void Additem(){
        m=new MembersFunctions();
        ArrayList<Member> members=m.returnAllMembers();

        for (Member member : members)
            System.out.println("\n" + member.getName() + "\t\t\t" + member.getEmail());

        System.out.println("\nEnter Owner's Email ");
        String Email=sc.next();
        System.out.println("Enter Java.item's name  ");
        String ItemName=sc.next();
        System.out.println("Enter Java.item's category ");
        String Category=sc.next();
        System.out.println("Enter Java.item's description ");
        String description=sc.next();
        System.out.println("Enter Java.item's lending cost");

        int price=sc.nextInt();
        s=new Store();
        boolean bool=s.items.addItem(Email,ItemName,Category,description,price);

        if(bool)
            System.out.println("\nItem added successfully\n");
        else
            System.out.println("\nThere is a problem in adding this Java.item\n");
        store=new storeWindow();
        store.show();
    }

    public void ItemFunctions(){
        s=new Store();
        ArrayList<item> items=s.items.returnAllItems();
        System.out.println("\nItem\t\tOwner");

        for (item value : items)
            System.out.println(value.getName() + "\t\t" + value.Owner.getName());

        System.out.println("\nEnter 1 to proceed.\t0 to go back.");
        int option=sc.nextInt();

        if(option==0){
            store=new storeWindow();
            store.show();
        }
        else {
            System.out.println("Item Name: ");
            String name=sc.next();
            System.out.println("Owner Name: ");
            String Owner=sc.next();
            System.out.println("\nPress: \n\t1. Delete Java.item.\t2. Update Java.item\t3. See information");
            int option1 = sc.nextInt();

            switch(option1)
            {
                case 1:
                    boolean bool=s.items.DeleteItem(name,Owner);
                    if(bool)
                        System.out.println("\nItem deleted Successfully.\n");
                    else
                        System.out.println("\nThere is a problem in deleting this Java.item.\n");
                    store=new storeWindow();
                    store.show();
                    break;
                case 2:
                    this.UpdateItem(name);
                    break;
                case 3:
                    s=new Store();
                    item item=s.items.getItem(name);
                    System.out.println("Name\t\tCategory\t\tPrice\t\tOwner");
                    System.out.println(item.getName()+"\t\t"+item.getCategory()+"\t\t"+item.getCost()+"\t\t"+item.Owner.getName());
                    System.out.println("Description ");
                    System.out.println(item.getDescription());
                    System.out.println("Contracts :");
                    System.out.println("Name\t\tOwner\t\tLender\t\tCost\t\tStartDate\t\tEndDate\t\tTotalDays");

                    for(int i = 0; i< contractsFunctions.contracts.size(); i++)
                    {
                        if(contractsFunctions.contracts.get(i).getItem().getName().equalsIgnoreCase(item.getName()))
                        {
                            Contract c=contractsFunctions.contracts.get(i);
                            System.out.println(c.getItem().getName()+"\t\t"+c.getOwner().getName()+"\t\t"+c.getBorrower().getName()+"\t\t"+c.getTotalcost()+"\t\t"+c.getStartingday()+"\t\t"+c.getStartingday()+c.getTotaldays()+"\t\t"+c.getTotaldays());
                        }
                    }
                    System.out.println();
                    store=new storeWindow();
                    store.show();
                    break;
            }
        }
    }

    public void UpdateItem(String name){
        s=new Store();
        item i=s.items.getItem(name);

        if(i==null){
            System.out.println("\nThere is a problem in retrieving this Java.item\n");
            store=new storeWindow();
            store.show();
        }

        System.out.println("\nName\t\tCategory\t\tPrice\t\tOwner");
        assert i != null;
        System.out.println(i.getName()+"\t\t"+i.getCategory()+"\t\t"+i.getCost()+"\t\t"+i.Owner.getName());
        System.out.println("Description ");
        System.out.println(i.getDescription());
        System.out.println("\nEnter changes to the Java.item:");
        System.out.println("Name ");
        String newname=sc.next();

        s.items.getItem(name);
        System.out.println("Category ");
        String category=sc.next();
        System.out.println("Description ");
        String description=sc.next();
        System.out.println("Lending cost ");
        int cost=sc.nextInt();

        s.items.updateItem(name, newname, category, description, cost, i.Owner.getEmail());
        store=new storeWindow();
        store.show();
    }
}
