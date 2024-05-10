import java.util.Scanner;

public class shopAPI implements IshopAPI{
    Contents contents=new Contents();
    Shop shop;

    boolean on;
    shopAPI(Shop shop){
        this.shop=shop;

    }

    @Override
    public void run(){
        this.on=true;
        while (on){
            this.menu();
        }
    }
    @Override
    public void menu() {
        for(int i=0;i<contents.menu.length; i++){
            if(i==0 || i==contents.menu.length-1){
                System.out.println(contents.menu[i]);
            }
            else{
                System.out.println(i+")"+contents.menu[i]);
            }
        }

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
    public void exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(contents.confirm);
        String answer= scanner.nextLine();

    }

}
