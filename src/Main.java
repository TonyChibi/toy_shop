import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RandomFiller filler= new RandomFiller();
        List <Toy> toys= new ArrayList<>();
        filler.fill(toys);
        Shop shop= new Shop(toys);
        System.out.println(shop.path);
        for(Toy toy: shop.toys){
            System.out.println(toy.toString());
        }


        shop.shuffle_prizes();
        Game game=new Game();
        Toy prize=game.play(shop.toys);
        System.out.println("prize: "+prize);
        System.out.println(shop.sold);
    }
}