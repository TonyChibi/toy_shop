import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Shop {
    List <Toy> toys=new ArrayList<>();
    List <Toy> sold=new ArrayList<>();

    String path;
    Shop(List <Toy> toys, String path){

        this.toys.addAll(toys);
        this.path=path;
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(path)))){
            String str= reader.readLine();
            while (str!=null) {
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(str);
                sold.add(new Toy((String) json.get("name"),((Long)json.get("weight")).intValue(),((Long)json.get("id")).intValue()));
                str= reader.readLine();
            }
        }catch (IOException | ParseException e){
            System.out.println("cant read or parse the sold");
        }


    }

    Shop (List <Toy> toys){
        this(toys,"sold.txt");
    }

    Shop(){
        this(new ArrayList<Toy>(), "sold.txt");
        RandomFiller filler= new RandomFiller();
        List <Toy> toys= new ArrayList<>();
        filler.fill(toys);
        this.toys.addAll(toys);
    }

    public void sell(Toy toy){
        this.sold.add(toy);
        this.toys.remove(toy);
        JSONObject json=new JSONObject(toy.maped());
        try(Writer writer=new FileWriter(this.path, true)) {
            writer.write(json.toJSONString()+"\n");
        }catch (IOException e){

        }
        sold.sort(null);

    }

    public Toy shuffle_prizes(){
        Game game=new Game();
        Toy prize=game.play(this.toys);
        sell(prize);
        return prize;
    }

    public void extract(Toy toy){
        this.sold.remove(toy);
        this.sold.sort(null);
        try(Writer writer = new FileWriter(path, false)) {
            for(Toy item: this.sold) {
                writer.write((new JSONObject(item.maped())).toJSONString()+"\n");
            }
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }



}
