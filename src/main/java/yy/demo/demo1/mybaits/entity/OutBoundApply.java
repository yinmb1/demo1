package yy.demo.demo1.mybaits.entity;

import java.io.Serializable;

/**
 * 外方申请信息
 *
 * @author zhangype@yonyou.com
 * @version V1.0.0
 * @date 2017/6/21
 */
public class OutBoundApply implements Serializable {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 外访申请编号
     */
    private String applySerialNo;
    /**
     * 外访申请地址
     */
    private String applyLocation;
    /**
     * 地址类型（0：家庭；1：单位；2：新地址）
     */
    private String locationType;

    public String getApplySerialNo() {
        return applySerialNo;
    }

    public void setApplySerialNo(String applySerialNo) {
        this.applySerialNo = applySerialNo;
    }

    public String getApplyLocation() {
        return applyLocation;
    }

    public void setApplyLocation(String applyLocation) {
        this.applyLocation = applyLocation;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}
