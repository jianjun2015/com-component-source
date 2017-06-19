package component.poi.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangjianjun on 2017/5/5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { java.lang.annotation.ElementType.FIELD })
public @interface ExcelVOAttribute {

    /**
     * 字段名
     * @return
     */
    String name() default "";

    /**
     *  配置列的名称,对应A,B,C,D....
     * @return
     */
    String column();

    /**
     * 提示信息
     * @return
     */
    String prompt() default "";

    boolean isExport() default true;
}
