package component.generator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangjianjun on 2017/7/10.
 */
public class IDCardNoGenerator {



    /**
     * 生成身份证号
     * @return
     */
    public static String getIDCardNo(){
        return getRandomID();
    }

    /**
     * 批量生成身份证号
     * @param howMany
     * @return
     */
    public static List getIDCardNos(int howMany){
        List<String> stringList = new ArrayList<>();
        for (int i=0;i<howMany;i++){
            stringList.add(getRandomID());
        }

        return stringList;
    }

    private static String getRandomID() {
        String id = "";
        // 随机生成省、自治区、直辖市代码 1-2
        String provinces[] = { "11", "12", "13", "14", "15", "21", "22", "23",
                "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
                "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
                "63", "64", "65", "71", "81", "82" };
        String province = provinces[new Random().nextInt(provinces.length - 1)];
        // 随机生成地级市、盟、自治州代码 3-4
        String citys[] = { "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "21", "22", "23", "24", "25", "26", "27", "28" };
        String city = citys[new Random().nextInt(citys.length - 1)];
        // 随机生成县、县级市、区代码 5-6
        String countys[] = { "01", "02", "03", "04", "05", "06", "07", "08",
                "09", "10", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31", "32", "33", "34", "35", "36", "37", "38" };
        String county = countys[new Random().nextInt(countys.length - 1)];
        // 随机生成出生年月 7-14
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE,
                date.get(Calendar.DATE) - new Random().nextInt(365 * 100));
        String birth = dft.format(date.getTime());
        // 随机生成顺序号 15-17
        String no = ((new Random().nextInt(999) + 1000)+"").substring(1);
        // 随机生成校验码 18
//        String checks[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
//                "X" };
//        String check = checks[new Random().nextInt(checks.length)];
        String check = genCheckCode(province + city + county + birth + no);
        // 拼接身份证号码
        id = province + city + county + birth + no + check;
        return id;
    }

    private static String genCheckCode(String preChk){
        int TotalmulAiWi = 0;
        String[] ValCodeArr = { "1", "0", "X", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(preChk.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];

        return strVerifyCode;
    }

    public static void main(String[] args) throws ParseException {

//        IdCardChk cardChk = new IdCardChk();
        for (int i = 0; i < 100; i++) {
            String idCard = getIDCardNo();
            //System.out.println(idCard+":"+cardChk.IDCardValidate(idCard));
        }
    }


}
