package component.poi.entity;

import component.poi.anno.ExcelVOAttribute;

/**
 * Created by wangjianjun on 2017/5/5.
 */
public class EIExtractRuleDetail {

    @ExcelVOAttribute(name = "orderNo",column = "A")
    public Integer orderNo;

    @ExcelVOAttribute(name = "ext_rule_name",column = "B")
    public String extRuleName;

    @ExcelVOAttribute(name = "title_name",column = "C")
    public String titleName;

    @ExcelVOAttribute(name = "prepared_sql",column = "D")
    public String prepareSql;

    @ExcelVOAttribute(name = "sql_params",column = "E")
    public String sqlParams;

    @ExcelVOAttribute(name = "data_source",column = "F")
    public String dataSource;

    @ExcelVOAttribute(name = "remark",column = "G")
    public String remark;

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public void setExtRuleName(String extRuleName) {
        this.extRuleName = extRuleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public void setPrepareSql(String prepareSql) {
        this.prepareSql = prepareSql;
    }

    public void setSqlParams(String sqlParams) {
        this.sqlParams = sqlParams;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public String getExtRuleName() {
        return extRuleName;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getPrepareSql() {
        return prepareSql;
    }

    public String getSqlParams() {
        return sqlParams;
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getRemark() {
        return remark;
    }
}
