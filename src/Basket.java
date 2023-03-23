import java.io.*;
import java.util.Scanner;

public class Basket {

    private String[] productsInBasket; //продукты
    private int[] sumProduct; //количество того или иного продукта
    private int[] prices; //цены на товар
    private int check; //сумма чека


    public Basket(int[] priсes, String[] productsInBasket) {
        this.prices = priсes;
        this.productsInBasket = productsInBasket;
    }

    public void addToCart(int productNum, int amount) { // добавления amount штук продукта номер productNum в корзину
        String s = productsInBasket[productNum - 1];
        sumProduct[productNum - 1] = amount;
    }

    public void printCart() { //вывода на экран покупательской корзины
        System.out.println(productsInBasket);
    }

    public void saveTxt(File textFile) { // сохранения корзины в текстовый файл; использовать встроенные сериализаторы нельзя
        try (FileOutputStream fos = new FileOutputStream(textFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Basket loadFromTxtFile(File textFile) throws IOException, ClassNotFoundException { // восстановления объекта корзины из текстового файла, в который ранее была она сохранена
        Basket b1;
        try (ObjectInputStream ips = new ObjectInputStream(new FileInputStream(textFile)) {
            b1 = ips.readObject();
        }
        return b1;
    }
    // геттеры по усмотрению

}
