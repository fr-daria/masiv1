import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
        //       String[] product = {"1. Хлеб", "2. Соль", "3. Вода", "4. Вино"};
        //       int[] price = {60, 45, 24, 340};
        //       for (int i = 0; i < 4; i++) {
        //          System.out.println(product[i] + " " + price[i] + " руб/шт");
//        }
//        int[] lot = new int[4];
        //       while (true) {
        //           System.out.println("Выберите товар и введите количество или введите 'end'");
//            String input = scanner.nextLine();

//            if ("end".equals(input)) {
//                System.out.print("Программа завершена");
//                break;
        //           }

        //           String[] part = input.split(" ");
        //           int size = part.length;
//            if (size != 2) {
        //               continue;
        //           }
        //           try {
//                int productNumber = Integer.parseInt(part[0]) - 1;
//                if (productNumber > 4 || productNumber < 0) {
//                    throw new Exception("Выбрать продукт надо с 1ого по 4ый     мяв<3");
        //               }
        //               int productLot = Integer.parseInt(part[1]);
        //              if (productLot < 0) {
        //                  throw new Exception("Количство продуктов не может быть отрицательным     мяв<3");
        //               }
        //               lot[productNumber] += productLot * price[productNumber];
        //           } catch (NumberFormatException e) {
        //               System.out.println("Надо вводить числа, а не слова");
        //           }
        Basket b = new Basket(new int[]{60, 45, 24, 340}, new String[]{"1. Хлеб", "2. Соль", "3. Вода", "4. Вино"});
        b.addToCart(3, 5);
        b.printCart();
        b.saveTxt(new File("basket.txt"));


    }


//    int sum = 0;
//        for(int i :lot){
  //      sum += i;
 //   }

//        for(int x = 0; x< 4;x++){
  //      System.out.println("Ваша корзина: " + product[x] + " " + " " + price[x] + " руб/шт " + lot[x] + " руб в сумме");
  //  }
   //     System.out.println("Итого "+sum +" руб");}
}