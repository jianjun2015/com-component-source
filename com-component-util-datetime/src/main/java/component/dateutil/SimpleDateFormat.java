package component.dateutil;

import java.text.ParseException;
import java.util.Date;

/**
 * @author: wangjianjun
 * @description:
 * @date: 2018/4/12 14:29
 * @version: V1.0
 */
public class SimpleDateFormat {

    private final String formatPatten;

    public SimpleDateFormat(String patten) {

        formatPatten=patten;
    }


    public Date parse(String source) throws ParseException {

        return new SimpleDateFormat(formatPatten).parse(source);
    }

    public  String format(Date date){
        return new SimpleDateFormat(formatPatten).format(date);
    }

}
