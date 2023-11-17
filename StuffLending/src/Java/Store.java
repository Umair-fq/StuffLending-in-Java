package Java;

import Java.*;

import java.util.Objects;
public class Store {
    MembersFunctions members=new MembersFunctions();
    itemsFunctions items=new itemsFunctions();
    contractsFunctions contracts=new contractsFunctions();

    Store(){}

    public void addcontracts(String itemName,String lenderName,int days,int Starting) {
        item item=items.getItem(itemName);
        Member owner=item.Owner;
        Member lender=members.returnMemberbyName(lenderName);

        if(lender==null){
            System.out.println("Wrong input");
            storeWindow store=new storeWindow();
            store.show();
        }
        int cost=item.getCost()*days;

        if(cost> Objects.requireNonNull(lender).getCredits())
        {
            System.out.println("Lender does not have enough credits");
        }
        else {
            boolean bool=contracts.addcontract( days, item, owner, lender,cost,Starting);
            if(bool){
                owner.setCredits(owner.getCredits()+cost);
                lender.setCredits(lender.getCredits()-cost);
                System.out.println("Java.Contract added");}
            else {
                System.out.println("Item not available");
            }
        }
    }
}
