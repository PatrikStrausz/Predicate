import java.util.function.Predicate;

public class FromItaly<E> implements Predicate<City> {
    @Override
    public boolean test(City city) {
        return city.getCode().equals("ITA");
    }
}
