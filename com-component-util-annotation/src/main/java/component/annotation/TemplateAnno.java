package component.annotation;

import java.lang.annotation.*;

/**
 * Created by wangjianjun on 2017/6/16.
 * 说明:
 * 1、Retention 注解的生命周期 RetentionPolicy枚举(RUNTIME-运行时、CLASS-在class文件、SOURCE-在源文件等)
 * 2、Target 注解作用范围 ElementType枚举(CONSTRUCTOR、FIELD、METHOD、TYPE等)
 * 3、Documented 标记注解，没有成员;作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化
 * 4、Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface TemplateAnno {

    String value() default "";//如果没有成员熟悉，一般默认给出value
}
