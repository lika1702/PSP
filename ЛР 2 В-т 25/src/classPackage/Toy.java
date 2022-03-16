package classPackage;

abstract public class Toy {
    private String title;
    private String type;
    private float cost;

    //Constructors
    protected Toy() {
        title = new String();
        type = new String();
        cost = 0;
    }
    protected Toy(String title, String type, float cost) {
        this.title = title;
        this.type = type;
        this.cost = cost;
    }
    protected Toy(Toy obj) {
        this.title = obj.title;
        this.type = obj.type;
        this.cost = obj.cost;
    }

    //Getters
    protected String getTitle() { return title; }
    protected String getType() { return type; }
    protected float getCost() { return cost; }

    //Methods
    abstract public void printInf();
}
