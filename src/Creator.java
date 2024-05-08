public class Creator {
    public Toy create(Toys type, int weight){
        Toy toy;
        switch (type){
            case CAR: toy=new Toy("car",weight);
            case DOG: toy=new Toy("dog", weight);
            case MAN: toy =new Toy("man", weight);
            case WIFE: toy = new Toy ("wife", weight);
            case BALOON: toy = new Toy("baloon", weight);
            case ELECTRICITY: toy= new Toy("electricity",weight);
            default: toy = new Toy("",0);
        }
        return toy;

    }
}
