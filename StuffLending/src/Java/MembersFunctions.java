package Java;

import Java.Member;
import Java.contractsFunctions;
import Java.item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class MembersFunctions {

    public static ArrayList<Member> members=new ArrayList<>();
    Store s;
    storeWindow store;
    Scanner sc = new Scanner(System.in);
    MembersFunctions(){}

    public ArrayList<Member> returnAllMembers(){
        return members;
    }

    public Member returnMember(String email){
        Member m;
        for(Member member:members)
        {
            if(member.getEmail().equalsIgnoreCase(email))
            {
                m=member;
                return m;
            }
        }
        return null;
    }

    public Member returnMemberbyName(String name){
        for(Member member:members)
        {
            if(member.getName().equalsIgnoreCase(name))
            {
                return member;
            }
        }
        return null;
    }

    public boolean deleteAccount(String email){
        for(int i=0;i<members.size();i++)
        {
            if(members.get(i).getEmail().equalsIgnoreCase(email))
            {
                members.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean addMember(String name,String surname,String Email,String number){
        for (Member member : members) {
            if (member.getEmail().equalsIgnoreCase(Email)) {
                return false;
            }
            if (member.getPhoneNumber().equalsIgnoreCase(number)) {
                return false;
            }
        }

        Random rnd = new Random();
        int id= rnd.nextInt(999999);
        int cr=0;
        String date= String.valueOf((LocalDateTime.now()));
        Member m=new Member(id, name, surname, Email, number, cr, date);
        members.add(m);
        return true;
    }

    public boolean UpdateMembersInfo(String oldemail,String name,String surname,String Email,String number){
        for (Member member : members) {
            if (member.getEmail().equalsIgnoreCase(oldemail)) {
                member.setName(name);
                member.setSurname(surname);
                member.setEmail(Email);
                member.setPhoneNumber(number);
                return true;
            }
        }
        return false;
    }

    public void AddMember() {
        String email, name, surname, number;
        System.out.println("\n\nEnter Name ");
        name=sc.next();
        System.out.println("Enter Surname ");
        surname=sc.next();
        System.out.println("Enter Email ");
        email=sc.next();
        System.out.println("Enter Number");
        number=sc.next();
        boolean bool;
        bool=this.addMember(name, surname, email, number);

        if(bool){
            System.out.println("\nJava.Member added Successfully.\n");
            store=new storeWindow();
            store.show();
        }

        else{
            System.out.println("Email or Password already taken");
            store=new storeWindow();
            store.show();
        }
    }

    public void ShowMembers(){
        ArrayList<Member> members=this.returnAllMembers();
        System.out.println("ID\t\t\tName\t\t\tSurname\t\t\tEmail\t\t\t\tCredits\t\t\tOwned Items");

        for (Member member : members)
            System.out.println(member.getId() + "\t\t" + member.getName() + "\t\t\t"
                    + member.getSurname() + "\t\t\t" + member.getEmail() + "\t\t\t"
                    + member.getCredits() + "\t\t\t\t" + member.ownedItems.size());

        int option;
        System.out.println("Press:\n\t1. See Full details.\t\t2. See a specific member's full Information\n\t0. Go back");
        option=sc.nextInt();

        if(option==1) {
            this.MemberDetails();
        }

        else if(option==2) {
            System.out.println("\nEnter Java.Member's Email ");
            String email=sc.next();
            Member m=this.returnMember(email);
            if(m==null){
                System.out.println("Wrong input");
                store.show();
            }
            System.out.println("\nID\t\t\tName\t\tEmail\t\tNumber\t\tCredit");
            assert m != null;
            System.out.println(m.getId()+"\t\t"+m.getName()+"\t\t"+m.getEmail()
                    +"\t\t"+m.getPhoneNumber()+"\t\t"+m.getCredits() );
            System.out.println("Number of items owned : "+m.ownedItems.size());

            for(int n=0;n<m.ownedItems.size();n++)
                System.out.println(m.ownedItems.get(n).getName());

            System.out.println();
            store=new storeWindow();
            store.show();
        }

        else {
            store=new storeWindow();
            store.show();
        }
    }
    public void MemberDetails(){

        ArrayList<Member> members=this.returnAllMembers();

        for (Member member : members) {
            System.out.println("Name\t\t\tEmail\t\t\t\tCredits\t\t\tOwned Items");
            System.out.println(member.getName() + "\t\t\t" + member.getEmail() + "\t\t\t"
                    + member.getCredits() + "\t\t\t\t" + member.ownedItems.size());
            System.out.println("Owned Items Information");
            System.out.println("Name\t\tCategory\t\tPrice\t\tDescription\t\tLent to");

            for (int i = 0; i < member.ownedItems.size(); i++) {
                item item = member.ownedItems.get(i);
                String lender = null;

                for (int j = 0; j < contractsFunctions.contracts.size(); j++) {
                    if (contractsFunctions.contracts.get(j).getItem().equals(item)) {
                        lender = contractsFunctions.contracts.get(j).getBorrower().getName();
                    }
                }
                System.out.println(item.getName() + "\t\t" + item.getCategory() + "\t\t" + item.getCost() + "\t\t" + item.getDescription() + "\t\t" + lender);
            }
            System.out.println("\n");
        }

        System.out.println("\nPress:\n\t0. To go back");
        int option=sc.nextInt();

        if(option!=0)
            System.out.println("\nInvalid Input. Going back to Java.Store");
        store=new storeWindow();
        store.show();
    }

    public void UpdateMember(){
        System.out.println("ID\t\tName\t\t\tEmail");
        ArrayList<Member> members=this.returnAllMembers();

        for (Member member : members)
            System.out.println(member.getId() + "\t\t" + member.getName() + "\t\t\t" + member.getEmail());

        System.out.println("Enter member's Email to update information : ");
        String oldEmail=sc.next();
        Member m=this.returnMember(oldEmail);

        if(m==null) {
            System.out.println("Wrong input");
            store=new storeWindow();
            store.show();
        }
        else{
            updateInfo(oldEmail);
            store=new storeWindow();
            store.show();
        }
    }

    public void updateInfo(String oldemail) {

        System.out.println("\nEnter new Information:");
        String email,name,number, surname;
        System.out.println("\nEnter Name ");
        name=sc.next();
        System.out.println("\nEnter Surname ");
        surname=sc.next();
        System.out.println("Enter Email ");
        email=sc.next();
        System.out.println("Enter Number");
        number=sc.next();
        boolean bool=this.UpdateMembersInfo(oldemail, name, surname, email, number);

        if(bool)
            System.out.println("\nJava.Member Updated Successfully\n");
        else
            System.out.println("\nThere is a problem in updating the member's information.\n");
    }

    public void DeleteMember() {
        ArrayList<Member> members = this.returnAllMembers();

        for (Member member : members)
            System.out.println("\n" + member.getName() + "\t\t\t" + member.getEmail());

        deleteMember();
        store=new storeWindow();
        store.show();
    }

    public void deleteMember() {
        System.out.println("\nEnter Java.Member's Email: ");
        String name = sc.next();
        Member m = this.returnMember(name);

        if (m == null) {
            System.out.println("Wrong Input");
            storeWindow store = new storeWindow();
            store.show();
        }

        while (Objects.requireNonNull(m).ownedItems.size() != 0) {
            s=new Store();
            s.items.DeleteItem(m.ownedItems.get(0).getName(), m.getName());
        }
        boolean bool = this.deleteAccount(name);

        if (bool)
            System.out.println("\nJava.Member Deleted Successfully\n");
        else
            System.out.println("\nJava.Member does not exist/ Invalid Input(Enter Email)\n");
    }
}