/**
 * 版权所有(C)，洛哈网络，2015，所有权利保留。
 * <p/>
 * 项目名：	yqc-core
 * 文件名：	Utils.java
 * 模块说明：
 * 修改历史：
 * 2015-7-23 - houjun - 创建。
 */
package com.base.util.other;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author houjun
 */
public class Utils {

    public static void main(String[] args) throws Exception {

//        System.out.println("===============resultMap=============");
//        resultMap(Event.class);
//        System.out.println("===============insertSql=============");
//        insertSql(Event.class);
//        System.out.println("===============updateSql=============");
//        updateSql(Event.class);

//        assignValue(CheckResultDetail.class, "detail", "source");
//		System.out.println("000900000000020160105161310008001".length());
        genEnumJudgeMethods(HandleResult.class);
    }

    public static void resultMap(Class clazz) {

        for (Field f : getFields(clazz)) {
            if (f.getName().equals("id"))
                System.out.println(String.format(
                        "<id column=\"%s\" property=\"%s\"/>",
                        toUnderScoreCase(f.getName()), f.getName()));
            else if (f.getName().equals("version"))
                System.out.println(String.format(
                        "<result column=\"%s\" property=\"%s\"/>",
                        "f" + f.getName(), f.getName()));
            else if (f.getName().equals("createInfo")) {
                System.out
                        .println("<association property=\"createInfo\" javaType=\"com.luoha.crm.base.OperateInfo\">");
                System.out
                        .println("  <result property=\"operId\" column=\"CREATEOPERID\" />");
                System.out
                        .println("  <result property=\"operName\" column=\"CAREATEOPERNAME\" />");
                System.out
                        .println("  <result property=\"operTime\" column=\"CREATETIME\" />");
                System.out.println("</association>");
            } else if (f.getName().equals("lastModifyInfo")) {
                System.out
                        .println("<association property=\"lastModifyInfo\" javaType=\"com.luoha.crm.base.OperateInfo\">");
                System.out
                        .println("  <result property=\"operId\" column=\"LASTMODIFIEDOPERID\" />");
                System.out
                        .println("  <result property=\"operName\" column=\"LASTMODIFIEDOPERNAME\" />");
                System.out
                        .println("  <result property=\"operTime\" column=\"LASTMODIFIEDTIME\" />");
                System.out.println("</association>");
            } else
                System.out.println(String.format(
                        "<result column=\"%s\" property=\"%s\"/>",
                        toUnderScoreCase(f.getName()), f.getName()));
        }
    }

    private static Object toUnderScoreCase(String s) {
        if (s == null)
            return null;
        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i >= 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    if (i > 0)
                        sb.append("_");
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    public static void assignValue(Class clazz, String target, String source) {
        for (Field f : getFields(clazz)) {
            if (source != null)
                System.out.println(String.format("%s.set%s(%s.get%s());",
                        target, StringUtils.capitalize(f.getName()), source,
                        StringUtils.capitalize(f.getName())));
            else
                System.out.println(String.format("%s.set%s();", target,
                        StringUtils.capitalize(f.getName())));
        }
    }

    public static void updateSql(Class clazz) {

        for (Field f : getFields(clazz)) {
            if (f.getName().equals("createInfo")) {
                continue;
            }
            if (f.getName().equals("lastModifyInfo")) {
                System.out
                        .println("o.lastModifiedOperId=#{lastModifyInfo.operId},");
                System.out
                        .println("o.lastModifiedOperName=#{lastModifyInfo.operName},");
                System.out
                        .println("o.lastModifiedTime=#{lastModifyInfo.operTime},");
                continue;
            }

            if (f.getName().equals("version"))
                System.out.println(String.format("o.%s=#{%s},",
                        "f" + f.getName(), f.getName()));
            else
                System.out.println(String.format("o.%s=#{%s},",
                        toUnderScoreCase(f.getName()), f.getName()));
        }
    }

    public static void insertSql(Class clazz) {
        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getSimpleName() + "(");
        List<Field> fields = getFields(clazz);
        for (Field f : fields) {
            String name = f.getName();
            if (name.equals("version"))
                name = "f" + name;

            if (name.equals("createInfo")) {
                sb.append("createOperId,careateOperName,createTime,");
                continue;
            }
            if (name.equals("lastModifyInfo")) {
                sb.append("lastModifiedOperId,lastModifiedOperName,lastModifiedTime,");
                continue;
            }
            sb.append(toUnderScoreCase(name) + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        sb.append("\r\n");
        sb.append("values(");
        for (Field f : fields) {
            if (f.getName().equals("createInfo")) {
                sb.append("#{createInfo.operId},#{createInfo.operName},#{createInfo.operTime},");
                continue;
            }
            if (f.getName().equals("lastModifyInfo")) {
                sb.append("#{lastModifyInfo.operId},#{lastModifyInfo.operName},#{lastModifyInfo.operTime},");
                continue;
            }

            sb.append(String.format("#{%s}", f.getName()) + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        System.out.println(sb.toString());
    }

    public static List<Field> getFields(Class clazz) {
        List<Field> list = new ArrayList();
        do {
            Field[] dfs = clazz.getDeclaredFields();
            if (dfs != null) {
                for (Field f : dfs) {
                    if (Modifier.isPrivate(f.getModifiers())
                            && Modifier.isStatic(f.getModifiers()) == false)
                        list.add(f);
                }
            }
            clazz = clazz.getSuperclass();
        } while (clazz != null
                && clazz.getSimpleName().equals("Object") == false); //NOSONAR
        return list;
    }

    public static void genEnumJudgeMethods(Class<? extends Enum> enumClazz) {
        StringBuilder sb = new StringBuilder();
        Enum[] enums = enumClazz.getEnumConstants();
        for (Enum e : enums) {
            //字符串参数
            if (isExistsMethod(enumClazz, "is" + StringUtils.capitalize(e.name()), String.class) == false) {
                System.out.println(String.format("public static boolean is%s(String value) {", StringUtils.capitalize(e.name())));
                System.out.println(String.format("return %s.name().equals(value);", e.name()));
                System.out.println("}");
                System.out.println("");
            }
            //枚举参数
            if (isExistsMethod(enumClazz, "is" + StringUtils.capitalize(e.name()), enumClazz) == false) {
                System.out.println(String.format("public static boolean is%s(%s value) {", StringUtils.capitalize(e.name()), enumClazz.getSimpleName()));
                System.out.println(String.format("return %s.equals(value);", e.name()));
                System.out.println("}");
                System.out.println("");
            }
        }
    }

    public static boolean isExistsMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            if (clazz.getDeclaredMethod(methodName, parameterTypes) != null)
                return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
        return false;
    }
}
