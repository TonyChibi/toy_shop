import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFiller {
    public void fill(List <Toy> list){
        Random random = new Random();
        Creator creator= new Creator();
        for (int i=0; i<random.nextInt(20); i++){
            Toys type = Toys.values()[random.nextInt(Toys.values().length-1)];
            Toy toy= creator.create(type,random.nextInt(10));
            if(toy.weight==0 && toy.name==""){
                System.out.println("created empty toy");
            }else{
                list.add(toy);
            }
        }

    }
}
