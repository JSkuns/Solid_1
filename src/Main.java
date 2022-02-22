import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    // TODO: правило Magic
    // Правило Magic: не используй числа напрямую в коде
    private static final int DELIVERY = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Basket> listOfOrders = new ArrayList<>();
        Basket basket = new Basket();

        exit:
        while (true) {
            System.out.print("\n" +
                    "Главное меню (доставка гарантируется в течении " + DELIVERY + " часов)\n" +
                    "1. Каталог товаров\n" +
                    "2. Посмотреть товары в корзине\n" +
                    "3. Отправить в заказ\n" +
                    "4. Посмотреть заказы\n" +
                    "5. Отменить заказ\n" +
                    "6. Добавить 'НЕКТАРИН СУПЕР' в корзину\n" +
                    "0. Выход\n" +
                    "Выберите пункт: ");
            String input = scanner.nextLine();

            if (IsInteger.isInteger(input)) {
                int inputInt = Integer.parseInt(input);
                switch (inputInt) {
                    case 1:
                        Fruit.printProductList(sourceOfProducts());
                        Fruit.chooseAndAddToBasket(sourceOfProducts(), basket);
                        break;
                    case 2:
                        basket.printConsole();
                        break;
                    case 3:
                        listOfOrders.add(basket);
                        basket = new Basket();
                        System.out.println("\nСоздан новый заказ");
                        break;
                    case 4:
                        if (listOfOrders.isEmpty()) {
                            System.out.println("Заказов нет");
                        }
                        for (Basket b : listOfOrders) {
                            System.out.println("\nТрек код: " + b.hashCode());
                            System.out.println(b);
                        }
                        break;
                    case 5:
                        System.out.println("Введите трек-код, чтобы отменить заказ: ");
                        String trackNum = scanner.nextLine();
                        listOfOrders.removeIf(b -> IsInteger.isInteger(trackNum)
                                && Integer.parseInt(trackNum) == b.hashCode());
                        break;
                    case 6:
                        // TODO: SOLID (DIP)
                        // D- принцип инверсии зависимостей (Dependency Inversion Principle)
                        // Всё зависит от абстракций (интерфейсов), а не от деталей реализации друг друга.
                        // здесь - интерфейс Product, а объект Fruit
                        Product product = new Fruit(777, "НЕКТАРИН СУПЕР", "Фрукты СУПЕР", 222);
                        basket.putIntoBasket(product);
                        break;
                    case 0:
                        System.out.println("\nВыход");
                        break exit;
                    default:
                        System.out.println("\nТакого пункта нет! Попробуйте ещё...");
                }
            } else {
                throw new IllegalArgumentException("Вы ввели неверное значение (в меню нет такого пункта)");
            }
        }
    }

    private static Stream<Fruit> sourceOfProducts() {
        return Stream.of(
                new Fruit(123, "Яблоки Голден", "Фрутомикс", 100),
                new Fruit(541, "Яблоки Айдаред", "Fresh Greens", 76),
                new Fruit(144, "Груша Конференция", "ВЛ-Фуд", 220),
                new Fruit(744, "Бананы", "Экофрукт", 90),
                new Fruit(621, "Лимон", "Fresh Greens", 60),
                new Fruit(129, "Киви", "Экофрукт", 65),
                new Fruit(432, "Манадрин", "Петробарс-М", 140),
                new Fruit(881, "Дыня Колхозница", "ВЛ-Фуд", 26),
                new Fruit(256, "Авокадо", "Кубанские поля", 479),
                new Fruit(21, "Виноград", "Фрутомикс", 150),
                new Fruit(344, "Груша Аббат", "ВкусВилл", 195)
        );
    }

}