package component.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangjianjun on 2017/6/16.
 * 字段注解定义
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyFieldAnnotation {

    String url() default "url";
    String desc() default "desc";
}
