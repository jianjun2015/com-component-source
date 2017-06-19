package component.poi.export;

import component.poi.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by wangjianjun on 2017/6/19.
 */
public class CreateDownload {

    public void createAndDownload(HttpServletResponse response) throws Exception {
        // 创建excel文件
        FileOutputStream fos = null;
        String filePathName = "";

        try {
            fos = new FileOutputStream(new File(filePathName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HSSFWorkbook workbook = new HSSFWorkbook();
        ExcelUtil excelUtil = new ExcelUtil();
//        ExcelUtil<EXDiffHandlerDef> diffExcelUtil = new ExcelUtil<>(EXDiffHandlerDef.class);
//        diffExcelUtil.exportExcel(exDiffHandlerDefs, workbook, "diff_handler", 0);
//
//        ExcelUtil<EXCheckDefRule> ruleExcelUtil = new ExcelUtil<>(EXCheckDefRule.class);
//        ruleExcelUtil.exportExcel(exCheckDefRuleList, workbook, "check_rule", 1);
//
//        ExcelUtil<EXCheckDef> checkDefExcelUtil = new ExcelUtil<>(EXCheckDef.class);
//        checkDefExcelUtil.exportExcel(exCheckDefList, workbook, "check_def", 2);
//
//        ExcelUtil<EXCheckPlan> planExcelUtil = new ExcelUtil<>(EXCheckPlan.class);
//        planExcelUtil.exportExcel(exCheckPlanList, workbook, "check_plan", 3);

        workbook.write(fos);
        workbook.close();
        excelUtil.downLoad(filePathName,response,false);
    }
}
