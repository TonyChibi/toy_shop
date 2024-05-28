import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.*;
public class Main {
    public static void main(String[] args) {

        Shop shop= new Shop();
//ToDo:
//     make priority queue and comparator for shop sold and toys

        ShopAPI shopAPI=new ShopAPI(shop);
        shopAPI.run();


        try {
            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("sold.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}