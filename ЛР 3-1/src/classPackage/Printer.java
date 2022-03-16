package classPackage;

import java.util.ArrayList;

public class Printer {
    public void printer(ArrayList<Furniture> obj) {
        for(int i = 0; i < obj.size(); i++) {
            obj.get(i).print();
        }
    }
}
