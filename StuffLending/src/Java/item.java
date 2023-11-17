package Java;

public class item {
    private String Name;
    private String Category;
    private String Description;
    private int Cost;
    private String Date;
    public Member Owner;
    private String Status;

    public item(String name, String category, String description, int cost, String date, Member owner){
        this.Name=name;
        this.Category=category;
        this.Description=description;
        this.Cost=cost;
        this.Date=date;
        this.Owner=owner;
        this.Status="available";
    }

    public String getName() {return Name;}

    public void setName(String name) {
        this.Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        this.Cost = cost;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}
