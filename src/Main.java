import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RandomFiller filler= new RandomFiller();
        List <Toy> toys= new ArrayList<>();
        filler.fill(toys);
        Shop shop= new Shop(toys);
        ShopAPI api= new ShopAPI(shop);
        api.run();
    }
}