import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

// TODO: SOLID (LSP)
// L-принцип замены Барбары Лисков (Liskov Substitution Principle)
// Наследуй только тогда, когда можешь играть роль за предка.
// для примера в данном случае наследуемся от интерфейса Product

// TODO: SOLID (ISP)
// I- принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)
// Много интерфейсов, специально предназначенных для клиентов, лучше, чем один интерфейс общего назначения.
// для примера в данном случае наследуемся от интерфейса PrintConsole

public class Fruit implements PrintConsole, Product {

    private Integer num;
    private String name;
    private String brand;
    private Integer cost;

    Fruit(Integer num, String name, String brand, Integer cost) {
        this.num = num;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
    }

    public static void printProductList(Stream<Fruit> productStream) {
        System.out.println();
        System.out.printf("%-4s %-18s %-15s %-4s%n", "№", "Название", "Производитель", "Цена");
        System.out.println();
        productStream.forEach(Fruit::printConsole);
    }

    public static void chooseAndAddToBasket(Stream<Fruit> products, Basket basket) {
        Scanner scanner = new Scanner(System.in);
        List<Fruit> fruit1List = products.toList();
        first:
        while (true) {
            System.out.println("\nВыберите номер товара, чтобы положить в корзину (0 - для выхода в меню): ");
            String productNum = scanner.nextLine();
            for (Fruit p : fruit1List) {
                if (IsInteger.isInteger(productNum)) {
                    if (Integer.parseInt(productNum) == p.num) {
                        basket.putIntoBasket(p);
                        System.out.println("Товар добавлен в корзину");
                    }
                    if (Integer.parseInt(productNum) == 0) {
                        break first;
                    }
                }
            }
        }
    }

    @Override
    public void printConsole() {
        System.out.printf("%-4s %-18s %-15s %-4s%n", num, name, brand, cost);
    }

    @Override
    public List<Fruit> getFruitList(Stream<Fruit> productStream) {
        List<Fruit> in = productStream.toList();
        return productStream
                .filter(p -> in.contains(new Fruit(123, "Яблоки Голден", "Фрутомикс", 100)))
                .toList();
    }

    @Override
    public String toString() {
        return String.format("%-4s %-18s %-15s %-4s", num, name, brand, cost);
    }

}
