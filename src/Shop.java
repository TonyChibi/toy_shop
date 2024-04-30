import java.io.*;
import java.util.Collection;
import java.util.List;

public class Shop {
    List <Toy> toys;
    List <Toy> sold;
    BufferedWriter writer;

    BufferedReader reader;
    String path;
    Shop(List <Toy> toys, String path){
        try{
            this.toys.addAll(toys);
        }catch(NullPointerException e){
            System.out.println("there is no toys");
        }
        this.path=path;
        try{
            this.writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"utf-8"));
            this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
            String str= this.reader.readLine();
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
                 str=this.reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("io exception");
            throw new RuntimeException(e);
        } finally {
            try{writer.close();}catch(Exception e){ System.out.println("не закрывается");}
        }

    }

    Shop (List <Toy> toys){
        this(toys,"sold.txt");
    }

    public void sell(Toy toy){
        this.sold.add(toy);
        this.toys.remove(toy);
        try{writer.newLine();}catch(IOException e) {
            System.out.println("can't write a sold toy");
        }

    }

    public void extract(Toy toy){
        this.sold.remove(toy);
    }

}
