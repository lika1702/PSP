package classPackage;

public class ConstructionKit extends Toy {
    private int quantity;

    //Constructors
    public ConstructionKit() {
        super();
        quantity = 0;
    }
    public ConstructionKit(String title, String type, float cost, int quantity) {
        super(title, type, cost);
        this.quantity = quantity;
    }

    @Override
    public void printInf() {
        System.out.println(getType() + " \"" + getTitle() + "\" (" + quantity + " дет.) " + getCost() + " BYN");
    }

    @Override
    public String toString() {
        return "Construction kit \"" + getTitle() + "\" number of parts: " + quantity + " (" + getCost() + " BYN)";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(obj instanceof ConstructionKit) {
            ConstructionKit temp = (ConstructionKit) obj;
            return  this.quantity == temp.quantity &&
                    this.getCost() == temp.getCost() &&
                    this.getTitle().equals(temp.getTitle()) &&
                    this.getType().equals(temp.getType());
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.getTitle() != null ? this.getTitle().hashCode() : 0);
        return hash;
    }
}
