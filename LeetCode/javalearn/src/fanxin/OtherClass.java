package fanxin;

public class OtherClass {
    public static void main(String[] args) {
        FanXinLei<Number> fanXinLei = new FanXinLei<>();
        Number number = fanXinLei.fanXinMethod(new Integer(3));
        System.out.println(number.intValue());
        Character c = FanXinLei.finXinStatic(new Character('c'));
        System.out.printf(""+c);

    }
}
