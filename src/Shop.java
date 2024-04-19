import java.util.Collection;
import java.util.List;

public class Shop {
    List <Toy> toys;
    List <Toy> sold;

    String path;
    Shop(List <Toy> toys, String path){
        this.toys.addAll(toys);
        this.path=path;
        

    }

    public void sell(Toy toy){
        this.sold.add(toy);
        this.toys.remove(toy);
    }

    public void extract(Toy toy){
        this.sold.remove(toy);
    }

}
