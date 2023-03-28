import java.io.*;

public class Basket {

    private String[] productsInBasket; //продукты
    //    private int[] sumProduct; //количество того или иного продукта
    private int[] prices; //цены на товар
    private int check; //сумма чека


    public Basket(int[] priсes, String[] productsInBasket) {
        this.prices = priсes;
        this.productsInBasket = productsInBasket;
    }

    public String[] addToCart(int productNum, int amount) { // добавления amount штук продукта номер productNum в корзину
        for (String c : productsInBasket) {
            c = productsInBasket[productNum - 1];
            //           sumProduct[productNum - 1] = amount;
            for (int p : prices) {
                prices[productNum - 1] = p * amount;
            }
        }
        return productsInBasket;
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
        //Basket b1;
        // try (ObjectInputStream ips = new ObjectInputStream(new FileInputStream(textFile);
        //     FileInputStream fis = new FileInputStream(String.valueOf(ips))) {
        //    b1 = (Basket) ips.readObject();}
        //return b1;
        try (FileInputStream fis = new FileInputStream(textFile);
             FileOutputStream fos = new FileOutputStream(fis)) {
            int i;
            int f;
            while ((i = fis.read()) != -1) {
                char f = (char) i;
                Basket basket = new Basket(f);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveBin(File file) {
    }

    public static Basket loadFromBinFile(File file) {
    }
}
