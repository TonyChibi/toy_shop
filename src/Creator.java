public class Creator {
    public Toy create(Toys type, int weight){
        Toy toy;
        switch (type){
            case CAR:
                toy=new Toy("car",weight);
                return toy;
            case DOG:
                toy=new Toy("dog", weight);
                return toy;
            case MAN:
                toy =new Toy("man", weight);
                return toy;
            case WIFE:
                toy = new Toy ("wife", weight);
                return toy;
            case BALOON:
                toy = new Toy("baloon", weight);
                return toy;
            case ELECTRICITY:
                toy= new Toy("electricity",weight);
                return toy;
        }

    return new Toy("",0);
    }
}
