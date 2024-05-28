import java.util.Scanner;

public class ShopAPI implements IshopAPI{
    Contents contents=new Contents();
    Shop shop;

    boolean on;
    ShopAPI(Shop shop){
        this.shop=shop;
        this.on=true;


    }

    @Override
    public void run(){
        while (on){
           int option= this.menu();
           switch (option){
               case 1:
                   showToys();
                   break;
               case 2:
                   showSold();
                   break;
               case 3:
                   play();
                   break;
               case 4:
                   extract();
                   break;
               case 5:
                   this.exit();
                   break;
           }

        }
    }
    @Override
    public int menu() {
        for(int i=0;i<contents.menu.length; i++){
            if(i==0 || i==contents.menu.length-1){
                System.out.println(contents.menu[i]);
            }
            else{
                System.out.println(i+")"+contents.menu[i]);
            }
        }
        Scanner scanner = new Scanner(System.in);
        int option= scanner.nextInt();
        return option;
    }

    @Override
    public int pickNumber(){
        System.out.println(this.contents.pickNumber);
        Scanner scanner = new Scanner(System.in);
        int num= scanner.nextInt();
        return num;
    }

    @Override
    public void play() {
        System.out.println(contents.shuffle);
        Toy prize=this.shop.shuffle_prizes();
        System.out.println(contents.congrats+prize.name);

    }

    @Override
    public void showToys() {
        for (Toy toy: shop.toys){
            System.out.println(toy);
        }

    }

    @Override
    public void showSold() {
        for (Toy toy: shop.sold){
            System.out.println(toy);
        }
    }

    @Override
    public Toy extract(){
        System.out.println(contents.extract);
        this.showSold();
        int num = this.pickNumber();
        Toy prize=this.shop.sold.get(num);
        this.shop.extract(prize);
        return prize;
    }

    @Override
    public void exit() {

        System.out.println(contents.confirm);
        Scanner scanner = new Scanner(System.in);
        String answer= scanner.nextLine().toLowerCase();
        if(answer.equals("yes")) {
            this.on = false;
            System.out.println("See ya!");
        }
    }

}
