import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.*;
public class Main {
    public static void main(String[] args) {
//        RandomFiller filler= new RandomFiller();
//        List <Toy> toys= new ArrayList<>();
//        filler.fill(toys);
//        Shop shop= new Shop(toys);
//        ShopAPI api= new ShopAPI(shop);
//        api.run();
        try {
            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("sold.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}