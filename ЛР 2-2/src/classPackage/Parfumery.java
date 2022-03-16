package classPackage;

public class Parfumery extends PObject {
    protected String flavour;

    //Constructors
    public Parfumery() {
        super();
        flavour = new String();
    }
    public Parfumery(String name, String marque, String gender, float cost, String flavour) {
        super(name, marque, gender, cost);
        this.flavour = flavour;
    }

    @Override
    public PObject get() { return this;}

}
