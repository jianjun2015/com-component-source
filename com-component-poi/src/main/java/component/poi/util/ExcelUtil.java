package component.poi.util;

import component.poi.anno.ExcelVOAttribute;
import component.poi.entity.EIExtractRuleDetail;
import component.poi.entity.EIExtratRule;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.omg.CORBA.Object;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.STRING;

/**
 * Created by wangjianjun on 2017/5/8.
 */
public class ExcelUtil<T> {

    Class<T> clazz;

    public ExcelUtil(){

    }

    public ExcelUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> importExcel(String sheetName, HSSFWorkbook workbook) throws Exception{

        int maxCol = 0;
        List<T> list = new ArrayList<>();
        try {

            HSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null){
//                sheet = workbook.getSheetAt(0);
//                if (!sheet.getSheetName().equals(sheetName))
//                    return null;
                throw new Exception("未找到对应的sheetName："+sheetName);
            }

            int rows = sheet.getPhysicalNumberOfRows();

            if (rows > 0){
                List<Field> allFields = getMappedField(clazz,null);
                Map<Integer,Field> fieldMap = new HashMap<>();
                for (Field field:allFields){
                    if (field.isAnnotationPresent(ExcelVOAttribute.class)){
                        ExcelVOAttribute attr = field.getAnnotation(ExcelVOAttribute.class);
                        int col = getExcelCol(attr.column());
                        maxCol = Math.max(col,maxCol);
                        fieldMap.put(col,field);
                    }
                }

                for (int i=1;i<rows;i++){
                    HSSFRow row = sheet.getRow(i);
                    int cellNum = maxCol;
                    T entity = null;
                    for (int j=0;j<=cellNum;j++){
                        HSSFCell cell = row.getCell(j);
                        if (cell == null){
                            continue;
                        }

                        CellType cellType = cell.getCellTypeEnum();
                        String value;
                        switch (cellType){
                            case NUMERIC:
                                cell.setCellType(STRING);
                                value = String.valueOf(cell.getStringCellValue());
                                break;
                            case BOOLEAN:
                                value = String.valueOf(cell.getBooleanCellValue());
                                break;
                            default:
                                value = cell.getStringCellValue();
                                break;
                        }

                        if (value == null || "".equals(value))
                            continue;

                        entity = (entity == null ? clazz.newInstance():entity);
                        Field field = fieldMap.get(j);
                        if (field == null)
                            continue;

                        Class fieldType = field.getType();
                        if (String.class == fieldType)
                            field.set(entity,String.valueOf(value));
                        else if ((Integer.TYPE == fieldType)
                                || (Integer.class == fieldType)) {
                            field.set(entity, Integer.parseInt(value));
                        } else if ((Long.TYPE == fieldType)
                                || (Long.class == fieldType)) {
                            field.set(entity, Long.valueOf(value));
                        } else if ((Float.TYPE == fieldType)
                                || (Float.class == fieldType)) {
                            field.set(entity, Float.valueOf(value));
                        } else if ((Short.TYPE == fieldType)
                                || (Short.class == fieldType)) {
                            field.set(entity, Short.valueOf(value));
                        } else if ((Double.TYPE == fieldType)
                                || (Double.class == fieldType)) {
                            field.set(entity, Double.valueOf(value));
                        } else if (Character.TYPE == fieldType) {
                            if ((value != null) && (value.length() > 0)) {
                                field.set(entity, Character
                                        .valueOf(value.charAt(0)));
                            }
                        }else if (Boolean.TYPE == fieldType){
                            field.set(entity,Boolean.valueOf(value));
                        }
                    }
                    if (entity != null)
                        list.add(entity);
                }
            }

        } catch (InstantiationException e) {
            throw new  Exception(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new  Exception(e.getMessage());
        }

        return list;
    }

    public void exportExcel(List<T> list,HSSFWorkbook workbook,String sheetName,int sheetIx) throws Exception{

        genOneSheet(list,workbook);
        workbook.setSheetName(sheetIx,sheetName);
    }

    private void genOneSheet(List<T> list,HSSFWorkbook workbook) throws Exception{

        List<Field> fields = getMappedField(clazz,null);
        HSSFSheet sheet = workbook.createSheet();

        HSSFRow row;
        HSSFCell cell;
        row = sheet.createRow(0);
        for (int j=0;j<fields.size();j++){
            Field field = fields.get(j);
            ExcelVOAttribute attr = field.getAnnotation(ExcelVOAttribute.class);
            int col = getExcelCol(attr.column());
            cell = row.createCell(col);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(attr.name());
        }

        int startNo = 0;
        int endNo = list.size();
        for (int j=startNo;j<endNo;j++){
            row = sheet.createRow(j+1-startNo);
            T vo = list.get(j);
            for (int k=0;k<fields.size();k++){
                Field field = fields.get(k);
                ExcelVOAttribute attr = field.getAnnotation(ExcelVOAttribute.class);
                try {
                    if (attr.isExport()){
                        cell = row.createCell(getExcelCol(attr.column()));
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(field.get(vo)==null?"":String.valueOf(field.get(vo)));
                    }
                } catch (IllegalAccessException e) {
                    throw new  Exception(e.getMessage());
                }
            }
        }
    }

    /**
     * 得到实体类所有通过注解映射了数据表的字段
     * @param clazz
     * @param fields
     * @return
     */
    private List<Field> getMappedField(Class clazz,List<Field> fields){

        if (fields == null){
            fields =  new ArrayList<>();
        }

        Field[] allFields = clazz.getDeclaredFields();
        for (Field field:allFields){
            if (field.isAnnotationPresent(ExcelVOAttribute.class)){
                fields.add(field);
            }
        }

        if (clazz.getSuperclass()!=null && !clazz.getSuperclass().equals(Object.class)){
            getMappedField(clazz.getSuperclass(),fields);
        }

        return fields;
    }

    /**
     * 将EXCEL中A,B,C,D,E列映射成0,1,2,3
     *
     * @param col
     */
    public static int getExcelCol(String col) {
        col = col.toUpperCase();
        // 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。
        int count = -1;
        char[] cs = col.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
        }
        return count;
    }

    public void downLoad(String filePath, HttpServletResponse response,
                         boolean isOnLine) throws Exception {
        File f = new File(filePath);
        /*
         * if (!f.exists()) { response.sendError(404, "File not found!");
         * return; }
         */
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;
        response.reset(); // 非常重要
        // 在线打开方式
        if (isOnLine) {
            URL u = new URL(filePath);
            response.setContentType(u.openConnection().getContentType());
            response.setHeader("Content-Disposition", "inline; filename="
                    + toUTF8(f.getName()));
            // 文件名应该编码成UTF-8
        }
        // 纯下载方式
        else {
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + toUTF8(f.getName()));
        }
        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        out.flush();
        br.close();
        out.close();
    }

    // UTF-8编码
    public String toUTF8(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    public static String genUploadPathName(HttpServletRequest request,String title){
        String unloadPath = request.getSession().getServletContext().getRealPath("/") + "\\download\\"
                + "excel" + "\\";

        // 自动生成日期
        SimpleDateFormat autoDate = new SimpleDateFormat(
                "yyyyMMddHHmmssSSS");
        // excel名为：当前名+日期时间
        //title += autoDate.format(new Date());
        if (title==null || title.equals(""))
            title = "inspectionExport";
        File dirFile = new File(unloadPath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            dirFile.mkdirs();
        }

        return unloadPath+title + ".xls";
    }


    public static void main(String[] args){
        try {
//            InputStream is = new FileInputStream("D:/students.xls");
//            ExcelUtil excelUtilRule = new ExcelUtil(EIExtratRule.class);
//            List<EIExtratRule> list = excelUtilRule.importExcel("extractRule",is);
//
//            is = new FileInputStream("D:/students.xls");
//            ExcelUtil excelUtilDetails = new ExcelUtil(EIExtractRuleDetail.class);
//            List<EIExtractRuleDetail> details = excelUtilDetails.importExcel("extractDetails",is);
//            System.out.println(list.size());
//            System.out.println(details.size());

            List<EIExtratRule>[] lists = new ArrayList[2];

            List<EIExtratRule> list = new ArrayList<>();
            List<EIExtratRule> list1 = new ArrayList<>();

            EIExtratRule vo = new EIExtratRule();
            list.add(vo);
            vo.extName = "zhangsan";
            vo.ruleParams="dfghjkl";
            vo.remark="remarkghjkl";

            EIExtratRule vo1 = new EIExtratRule();
            list1.add(vo1);
            vo1.extName = "zhangsanss";
            vo1.ruleParams="dfghjkl";
            vo1.remark="remarkghjkl";

            List<EIExtractRuleDetail> details = new ArrayList<>();
            EIExtractRuleDetail detail = new EIExtractRuleDetail();
            details.add(detail);
            detail.orderNo=1;

            FileOutputStream fos = null;
            fos = new FileOutputStream("D:/xx.xls");

            lists[0]=list;
            lists[1]=list1;

            ExcelUtil eiExtratRuleExcelUtil = new ExcelUtil<>(EIExtratRule.class);
//            eiExtratRuleExcelUtil.exportExcel(lists,new String[]{"rule","rule1"},fos);

//            ExcelUtil eiExtratRuleDetailsExcelUtil = new ExcelUtil<>(EIExtractRuleDetail.class);
//            eiExtratRuleDetailsExcelUtil.exportExcel(details,new String[]{"details"},fos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
