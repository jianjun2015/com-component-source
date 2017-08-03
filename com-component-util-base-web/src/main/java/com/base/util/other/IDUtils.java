/**
 *
 */
package com.base.util.other;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.IdGenerator;

/**
 * @author houjun
 */
public class IDUtils {

    private volatile static IdGenerator idGen;
    private static final String SYSTEM_ID = "044";

    public static String genID() {
        initIdGen();
        return SYSTEM_ID.concat(idGen.generateId().toString().concat("0000").concat(RandomStringUtils.randomNumeric(5)));
    }

    private static void initIdGen() {
        if (idGen == null) {
            synchronized (IDUtils.class) {
                if (idGen == null) {
                    idGen = AppCtxUtils.getBean("ins-zkIdGenerator", null);
                }
            }
        }
    }

    private IDUtils() {
    }

}
