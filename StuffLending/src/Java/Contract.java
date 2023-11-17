package Java;

public class Contract {
    private int totaldays;
    private item item;
    private Member owner;
    private Member borrower;
    private int totalcost;
    private String status;
    private int Startingday;

    public Contract(int totaldays, item item, Member owner, Member borrower, int totalcost, int starting, String status)
    {
        this.totaldays=totaldays;
        this.item=item;
        this.owner=owner;
        this.borrower=borrower;
        this.totalcost=totalcost;
        this.status=status;
        this.Startingday=starting;
    }

    public int getTotalcost() {
        return totalcost;
    }

    public int getTotaldays() {
        return totaldays;
    }

    public item getItem() {
        return item;
    }

    public void setItem(item item) {
        this.item = item;
    }

    public Member getOwner() {
        return owner;
    }

    public Member getBorrower() {
        return borrower;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStartingday() {
        return Startingday;
    }

}

