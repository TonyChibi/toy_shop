import java.util.List;
import java.util.Random;

public class Game {


    Toy play(List <Toy> toys){
        int maxID=0;
        int max=0;
        Random random =new Random();
       for (int i=0; i<toys.size(); i++ ){
            int chance=toys.get(i).weight* random.nextInt(1,10);
            if (chance>max){
                max=chance;
                maxID=i;
            }

       }
       return toys.get(maxID);
    }
}
