package Java;

import Java.itemsFunctions;

class Main {
    public static void main(String[] args) {
        Store store=new Store();
        MembersFunctions members=new MembersFunctions();
        itemsFunctions items=new itemsFunctions();

        members.addMember("John","Wick", "john@gmail.com","123456789");
        members.addMember("Jack","Adams", "jack@gmail.com","987654321");
        members.addMember("Thomas","Kurt", "thomas@gmail.com","565635634");
        items.addItem("john@gmail.com","Hammer","Tool","Has a metal head and a wooden handle",4);
        items.addItem("jack@gmail.com","X-box","Game","Device to play games",6);
        items.addItem("john@gmail.com","Controller","Game","Device to play games with",3);
        items.addItem("thomas@gmail.com","Laptop","Other","Handy computer device",50);
        items.addItem("thomas@gmail.com","Bike","Vehicle","E-bike that runs 60km per charge",10);
        items.addItem("thomas@gmail.com","Basketball","Sport","Spalding brand for indoors/outdoors",10);
        items.addItem("thomas@gmail.com","Mouse","Other","Device to move cursor on screen",8);
        items.addItem("thomas@gmail.com","Monopoly","Toy","Board game for everyone",7);

        storeWindow s=new storeWindow();
        s.show();
    }
}