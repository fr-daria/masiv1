import java.io.*;
import java.util.Arrays;

public class Basket implements Serializable {

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
                System.out.println("Корзина покупок " + productsInBasket[i] + " " + prices[i] + " " + count[i] + " " + pprise);
            }
            System.out.println("Итого " + allprise);
        }
    }

    public void saveTxt(File textFile) { // сохранения корзины в текстовый файл;
        try (FileOutputStream fos = new FileOutputStream(textFile)) {
            for (String product : productsInBasket) {
                fos.write(product.getBytes());
            }
            System.out.println();
            for (int price : prices) {
                fos.write(price);
            }
            System.out.println();
            for (int ct : count) {
                fos.write(ct);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Basket loadFromTxtFile(File textFile) throws IOException {
        Basket b  = null;
        int i;
        try (BufferedReader ips = new BufferedReader(new FileReader(textFile))) {
            //int product = fis.read();
            //b1 = Character.toChars(Integer.parseInt(product, '\n'));
            //String b2 = String.copyValueOf(b1);
            String p = ips.readLine();
            String z = ips.readLine();
            String c = ips.readLine();

            b.productsInBasket = p.split(" ");
            b.prices = Arrays.stream(z.split(" "))
                    .map(Integer :: parseInt)
                    .mapToInt(Integer :: intValue)
                    .toArray();
            b.count = Arrays.stream(z.split(" "))
                    .map(Integer :: parseInt)
                    .mapToInt(Integer :: intValue)
                    .toArray();
        }
        return b;
    }

    public void saveBin(File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
            oos.flush();
        }
    }

    public static Basket loadFromBinFile(File file) throws IOException, ClassNotFoundException {
        Basket b1 = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            b1 = (Basket) ois.readObject();
        }
        return b1;
    }
}


