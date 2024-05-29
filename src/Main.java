import java.io.*;
import java.util.*;

import org.json.simple.*;
public class Main {
    public static void main(String[] args) {

        Shop shop= new Shop();
//ToDo:
//     make priority queue and comparator for shop sold and toys
        Queue queue = new PriorityQueue();

        ShopAPI shopAPI=new ShopAPI(shop);
        queue.addAll(shop.sold);
        System.out.println(queue);
        shopAPI.run();


        try {
            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("sold.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}