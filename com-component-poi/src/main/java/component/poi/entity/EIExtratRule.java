package component.poi.entity;

import component.poi.anno.ExcelVOAttribute;

/**
 * Created by wangjianjun on 2017/5/5.
 */
public class EIExtratRule {

    @ExcelVOAttribute(name = "ext_name",column = "A")
    public String extName;

    @ExcelVOAttribute(name = "rule_params",column = "B")
    public String ruleParams;

    @ExcelVOAttribute(name = "remark",column = "C")
    public String remark;

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public void setRuleParams(String ruleParams) {
        this.ruleParams = ruleParams;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtName() {
        return extName;
    }

    public String getRuleParams() {
        return ruleParams;
    }

    public String getRemark() {
        return remark;
    }
}
