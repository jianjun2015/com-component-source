package component.annouse;

import java.io.Serializable;

/**
 * Created by wangjianjun on 2017/6/16.
 */
public class TarResearch implements Serializable {

    @IgnoreProperty
    private static final long serialVersionUID = -4963705773695830754L;

    @IgnoreProperty
    private Integer researchId;

    @IgnoreProperty
    private Integer userId;

    private String version;

    private String grade;

    public void setResearchId(Integer researchId) {
        this.researchId = researchId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getResearchId() {
        return researchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getVersion() {
        return version;
    }

    public String getGrade() {
        return grade;
    }
}
