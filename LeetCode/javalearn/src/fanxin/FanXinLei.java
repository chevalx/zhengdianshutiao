package fanxin;

public class FanXinLei<T> {
    private T field;

    public T getField() {
        return field;
    }

    public T fanXinMethod(T arg) {
        String instance = ObjectFactory.getInstance(String.class);

        return arg;
    }

    public static <T> T finXinStatic(T arg) {
        return arg;
    }
}
