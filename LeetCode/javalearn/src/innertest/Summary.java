package innertest;

public class Summary {
    public static void main(String[] args) {
        /**
         * 内部类与外界的关系
         */
        // 创建的时候，访问控制的策略与其他成员变量和成员方法相同，例如如果内部类不是public而是default的，那么别的包访问不到，自己这个包可以访问到
        // 非静态内部类的创建方法：new 外部类().new 内部类()
        InnerClassTest.Inner inner = new InnerClassTest().new Inner();
        // 静态内部类的创建方法：new 外部类.内部类()
        InnerClassTest.StaticInner staticInner = new InnerClassTest.StaticInner();


        /**
         * 内部类与外部类的关系
         * 1. 外部类访问内部类
         * a.外部类可以访问所有的内部类的成员变量和成员方法，不管是public private 还是default
         * b.外部类也可以在非静态的方法内去创建静态内部类对象
         * c.但是外部类不能在静态方法中去访问非静态内部类，原因和普通类不能在静态方法里访问非静态成员一样，因为初始化的时候非静态成员变量还未出现，
         *   而static的成员方法已经出现了
         * 2. 内部类访问外部类
         * a. 非静态内部类可以访问外部类的成员变量，非静态和静态的成员变量都可以
         * b. 静态内部类不能访问外部类的非静态成员变量
         * 3. 为什么内部类可以访问外部类的成员？
         * 因为java默认为内部类对象添加了外部类对象的引用
         * 4. 为什么需要内部类
         * a.首先讨论非静态内部类：因为内部类可以实现多继承，由于外部类和内部类互相是联通的，可以互相访问成员，比如我外部类A，已经继承了B，但还有C和D要继承
         * 这个时候我可以在A里实现A1和A2两个内部类，让A1继承C，让A2继承D，这样就实现了间接的多继承
         * 参考https://www.zhihu.com/question/26954130
         * b.再讨论静态内部类：这里主要是为了代码的可读性，如果A只用在B中，那么把A定义成 B的内部类可以增强代码可读性
         * c.此外不建议序列化拥有内部类的类
         */
        //

    }
}
