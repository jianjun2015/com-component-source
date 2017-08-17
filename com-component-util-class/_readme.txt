java关键字解释：
    一、保留关键字
        1、const 用于修改字段或局部变量的声明。它指定字段或局部变量的值是常数，不能被修改
        2、goto  指定跳转到标签，找到标签后，程序将处理从下一行开始的命令。
    二、关键字
        1、访问修饰关键字
            public  可跨包，（默认选择）
            protected 当前包内可用
            private 当前类可用
        2、定义类、接口、抽象类和实现接口、继承类的关键字、实例化对象（共6个）
            class
            interface
            abstract
            implements
            extends
            new
        3、包的关键字（共2个）
            import
            package
        4、数据类型的关键字（共12个）
            byte    字节型     8bit
            char    字符型     16bit
            boolean 布尔型     --
            short   短整型     16bit
            int     整型       32bit
            float   浮点型     32bit
            long    长整型     64bit
            double  双精度     64bit
            void
            null
            true
            false
        5、条件循环（流程控制）（共12个）
            if
            else
            while
            for
            switch
            case
            default
            do
            break
            continue
            return
            instanceof  实例  测试它左边的对象是否是它右边的类的实例，返回boolean类型的数据
        6、修饰方法、类、属性和变量（共9个）
            static
            final
            super
            this    当前类的父类的对象
            native  本地  使用native关键字说明这个方法是原生函数，也就是这个方法是用C/C++语言实现的，并且被编译成了DLL，由java去调用。
            strictfp    精确浮点    在Java虚拟机进行浮点运算时，如果没有指定strictfp关键字时，Java的编译器以及运 行环境在对浮点运算的表达式是采取一种近似于我行我素的行为来完成这些操作，以致于得到的结果往往无法令你满意。而一旦使用了strictfp来声明一个 类、接口或者方法时，那么所声明的范围内Java的编译器以及运行环境会完全依照浮点规范IEEE-754来执行。因此如果你想让你的浮点运算更加精确， 而且不会因为不同的硬件平台所执行的结果不一致的话，那就请用关键字strictfp。
            synchronized    线程同步
            transient   短暂  不进行序列号操作
            volatile    易失  volatile关键字已经实现了线程间数据同步，每次都从主存加载
        7、错误处理（共5个）
            catch
            try
            finally
            throw
            throws
        8、不知道是什么（共2个）
            enum
            assert
