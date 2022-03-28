package innertest;

public class InnerClassTest {
    private int outerPrivField;
    public int outerPubField;
    int outerDefaultField;

    private static int outerStaticPrivField;
    public static int outerStaticPubField;
    static int outerStaticDefaultField;

    private int getOuterPrivField() {
        return outerPrivField;
    }

    public int getOuterPubField() {
        return outerPubField;
    }

    int getOuterDefaultField() {
        return outerDefaultField;
    }


    public void testInner() {
        Inner inner = new Inner();
        // 外部类可以访问内部类所有的成员变量和成员方法，不管该成员是public private还是default
        int defaultField = inner.defaultField;
        // 外部类也可以在非静态的方法内去创建静态内部类对象
        StaticInner staticInner = new StaticInner();
    }

    class Inner {
        int defaultField;
        public int publicField;
        private int field;
        public Inner() {
            field = 200;
        }

        private int getField() {
            // 非静态内部类的可以访问外部类的非静态成员
            // 非静态内部类可以访问外部类的静态成员
            int staticOuterMember = 2 * outerStaticPubField;
            return field * outerPrivField;
        }
    }

    static class StaticInner{
        private int field;

        public StaticInner() {
            field = 200;
        }

        private int getField() {
            // 静态内部类可以访问外部类的静态成员，但是不能访问非静态的静态成员
            return field * outerStaticPubField;
        }
    }

    public void testAnonymousClass() {
        // 匿名内部类主要用于设定回调函数，例如View.OnClickListener，不用匿名内部类也可以，直接new AnonymousClass()也是一样的效果
        // 但显然匿名内部类更简单一些
        // 为什么不允许在匿名内部类中改变外部的变量？
        // 因为如果不是final的匿名内部类中修改不能反映到外部，会造成数据不一致。
        final int a = 0;
        AnonymousClass anonymousClass = new AnonymousClass();
        new Listener(){
            @Override
            public void onListen() {
                int b = a;
                System.out.println("Heard of it!!");
            }
        };
    }

    class AnonymousClass implements Listener{
        private int field;
        public AnonymousClass() {
            field = 0;
        }

        @Override
        public void onListen() {
            System.out.println("Heard of it!");
        }
    }

    interface Listener {
        void onListen();
    }
}
