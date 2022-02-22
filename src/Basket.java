import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Basket implements PrintConsole {

    private List<Product> productList = new ArrayList<>();

    // TODO: SOLID (SRP)
    // S - принцип единственной ответственности (Single Responsibility Principle)
    // Класс должен выполнять только те функции, для которых он логически предназначен.
    // данный класс работает только с продуктовой корзиной

    // TODO: SOLID (OCP)
    // O - принцип открытости/закрытости (Open Closed Principle)
    // Программные сущности должны быть открыты для расширения, но закрыты для модификации.
    // List<Product> productList - имеет приватный модификатор доступа, поэтому закрыт для модификации вне пользовательского интерфейса
    // Есть метод getProductList() - который позволяет расширить данный класс

    public List<Product> getProductList() {
        return productList;
    }

    public void putIntoBasket(Product product) {
        productList.add(product);
    }

    @Override
    public void printConsole() {
        StringJoiner sj = new StringJoiner("\n");
        System.out.println("\nСписок товаров в корзине:");
        for (Product p : productList) {
            sj.add(p.toString());
        }
        System.out.println(sj);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        for (Product p : productList) {
            sj.add(p.toString());
        }
        return sj.toString();
    }

}