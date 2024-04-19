public class Toy {
    int  weight;
    Toys name;
    static int ids=0;
    int id;
Toy(Toys name, int weight  ){
    this.weight=weight;
    this.name=name;
    ids++;
    this.id=ids;
}


}
