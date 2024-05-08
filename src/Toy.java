public class Toy {
    int  weight;
    String name;
    static int ids=0;
    int id;
Toy(String name, int weight  ){
    this.weight=weight;
    this.name=name;
    ids++;
    this.id=ids;
}

Toy( String name, int weight, int id){
    this.name=name;
    this.weight=weight;
    this.id=id;
}
 @Override
    public String toString(){
    return this.id+": "+this.name+" w: "+this.weight;
 }

}
