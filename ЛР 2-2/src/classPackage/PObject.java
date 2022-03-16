package classPackage;

abstract public class PObject {
    protected String name;
    protected String marque;
    protected String gender;
    protected float cost;

    //Constructors
    public PObject() {
        name = new String();
        marque = new String();
        gender = new String();
        cost = 0;
    }
    public PObject(String name, String marque, String gender, float cost) {
        this.name = name;
        this.marque = marque;
        this.gender = gender;
        this.cost = cost;
    }

    //Abstract-method
    abstract public PObject get();
}
