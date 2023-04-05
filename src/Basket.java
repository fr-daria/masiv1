import java.io.*;

public class Basket {

    private String[] productsInBasket; //продукты
    //    private int[] sumProduct; //количество того или иного продукта
    private int[] prices; //цены на товар
    private int[] count; //оличество


    public Basket(int[] priсes, String[] productsInBasket) {
        this.prices = priсes;
        this.productsInBasket = productsInBasket;
        this.count = new int[productsInBasket.length];
    }

    public void addToCart(int productNum, int amount) { // добавления amount штук продукта номер productNum в корзину
        count[productNum - 1] += amount;
    }

    public void printCart() { //вывода на экран покупательской корзины
        int allprise = 0;
        for (int i = 0; i < productsInBasket.length; i++) {
            if (count[i] > 0) {
                int pprise = prices[i] * count[i];
                allprise += pprise;
                System.out.println("Корзина покупок " + productsInBasket[i] + prices[i] + count[i] + pprise);
            }
            System.out.println("Итого " + allprise);
        }
    }

    public void saveTxt(File textFile) { // сохранения корзины в текстовый файл;
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

    public static Basket loadFromTxtFile(File textFile) throws IOException, ClassNotFoundException {
        Basket b1;
        try (FileInputStream fis = new FileInputStream(textFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            b1 = (Basket) ois.readObject();
        }
        return b1;
    }

    public void saveBin(File file) {
    }

    public static Basket loadFromBinFile(File file) {
    }
}


