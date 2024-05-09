import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    List <Toy> toys=new ArrayList<>();
    List <Toy> sold=new ArrayList<>();

    String path;
    Shop(List <Toy> toys, String path){

        this.toys.addAll(toys);
        this.path=path;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));){
            String str= reader.readLine();
            String name="";
            int id=0;
            int weight=0;
            while(str!=null){

                 if(str.contains("{ name: ")){
                     name=str.replace("{ name: ", "");
                 } else if (str.contains("id: ")) {
                     id=Integer.parseInt(str.replace("id: ",""));
                 } else if (str.contains("weight: ")) {
                     weight=Integer.parseInt(str.replace("weight: ", ""));

                 }else if(str.contains("}")){
                     sold.add(new Toy(name,weight, id));
                 }
                 str=reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("io exception");
            throw new RuntimeException(e);
        }

    }

    Shop (List <Toy> toys){
        this(toys,"sold.txt");
    }

    public void sell(Toy toy){
        this.sold.add(toy);
        this.toys.remove(toy);
        try(Writer writer=new FileWriter(this.path, true);){
            writer.write("{ name: "+toy.name+"\nid: "+toy.id+"\nweight: "+toy.weight+"\n}\n");
        }catch(IOException e) {
            System.out.println("can't write a sold toy: \n"+e);
        }

    }

    public void shuffle_prizes(){
        Game game=new Game();
        Toy prize=game.play(this.toys);
        sell(prize);
    }

    public void extract(Toy toy){
        this.sold.remove(toy);
    }

}
