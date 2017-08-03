/**
 *
 */
package com.base.util.other;
import com.base.util.entity.HasCreateInfo;
import com.base.util.entity.HasModifyInfo;
import com.base.util.entity.HasVersion;

import java.util.Date;
import java.util.List;

/**
 * @author houjun
 */
public class EntityUtils {

    private EntityUtils() {
    }

    public static void forCreate(Object bean, String operNo) {
        Date date = new Date();
        if (bean instanceof HasCreateInfo) {
            ((HasCreateInfo) bean).setCreateTime(date);
            ((HasCreateInfo) bean).setCreateBy(operNo);
        }

        if (bean instanceof HasModifyInfo) {
            ((HasModifyInfo) bean).setModifyTime(date);
            ((HasModifyInfo) bean).setModifyBy(operNo);
        }

        if (bean instanceof HasVersion) {
            ((HasVersion) bean).setEdition(HasVersion.START_EDITION);
        }


    }

    public static void forModify(Object bean, String operNo) {
        if (bean instanceof HasModifyInfo) {
            ((HasModifyInfo) bean).setModifyTime(new Date());
            ((HasModifyInfo) bean).setModifyBy(operNo);
        }
    }

    public static void forCreateList(List<? extends Object> beans, String operNo) {
        if (beans == null)
            return;
        for (Object bean : beans)
            forCreate(bean, operNo);
    }

    public static void forModifyList(List<? extends Object> beans, String operNo) {
        if (beans == null)
            return;
        for (Object bean : beans)
            forModify(bean, operNo);
    }
}
