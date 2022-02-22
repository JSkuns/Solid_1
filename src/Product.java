import java.util.List;
import java.util.stream.Stream;

public interface Product {

    List<Fruit> getFruitList (Stream<Fruit> productStream);

}
