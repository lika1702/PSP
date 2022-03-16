package classPackage;

public class SoftToy extends Toy{
    private String stuffing;

    public SoftToy() {
        super();
        stuffing = new String();
    }
    public SoftToy(String title, String type, float cost, String stuffing) {
        super(title, type, cost);
        this.stuffing = stuffing;
    }

    @Override
    public void printInf() {
        System.out.println(getType() + " \"" + getTitle() + "\" (наполнитель: " + stuffing + ") " + getCost() + " BYN");
    }

    @Override
    public String toString() {
        return "Soft toy \"" + getTitle() + "\" stuffing: " + stuffing + " (" + getCost() + " BYN)";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(obj instanceof SoftToy) {
            SoftToy temp = (SoftToy) obj;
            return  this.getCost() == temp.getCost() &&
                    this.getTitle().equals(temp.getTitle()) &&
                    this.getType().equals(temp.getType()) &&
                    this.stuffing.equals(temp.stuffing);
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.getTitle() != null ? this.getTitle().hashCode() : 0);
        return hash;
    }
}
