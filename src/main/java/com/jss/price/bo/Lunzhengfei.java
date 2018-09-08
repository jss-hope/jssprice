package com.jss.price.bo;

import javax.persistence.*;

@Entity
public class Lunzhengfei {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long uuid;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }
    private String item;
    private Integer projectId;
    private Integer itemOrder;
    private Integer lRenshu;
    private Integer sRenshu;
    private Integer lCishu;
    private Integer sCishu;
    private Integer lTianshu;
    private Integer sTianshu;
    private Double lShisufei;
    private Double sShisufei;
    private Double lChailufei;
    private Double sChailufei;
    private Double lMoney;
    private Double sMoney;
    private String attachment;
    private String remark;
    private String projectType;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

    public Integer getlRenshu() {
        return lRenshu;
    }

    public void setlRenshu(Integer lRenshu) {
        this.lRenshu = lRenshu;
    }

    public Integer getsRenshu() {
        return sRenshu;
    }

    public void setsRenshu(Integer sRenshu) {
        this.sRenshu = sRenshu;
    }

    public Integer getlCishu() {
        return lCishu;
    }

    public void setlCishu(Integer lCishu) {
        this.lCishu = lCishu;
    }

    public Integer getsCishu() {
        return sCishu;
    }

    public void setsCishu(Integer sCishu) {
        this.sCishu = sCishu;
    }

    public Integer getlTianshu() {
        return lTianshu;
    }

    public void setlTianshu(Integer lTianshu) {
        this.lTianshu = lTianshu;
    }

    public Integer getsTianshu() {
        return sTianshu;
    }

    public void setsTianshu(Integer sTianshu) {
        this.sTianshu = sTianshu;
    }

    public Double getlShisufei() {
        return lShisufei;
    }

    public void setlShisufei(Double lShisufei) {
        this.lShisufei = lShisufei;
    }

    public Double getsShisufei() {
        return sShisufei;
    }

    public void setsShisufei(Double sShisufei) {
        this.sShisufei = sShisufei;
    }

    public Double getlChailufei() {
        return lChailufei;
    }

    public void setlChailufei(Double lChailufei) {
        this.lChailufei = lChailufei;
    }

    public Double getsChailufei() {
        return sChailufei;
    }

    public void setsChailufei(Double sChailufei) {
        this.sChailufei = sChailufei;
    }

    public Double getlMoney() {
        return lMoney;
    }

    public void setlMoney(Double lMoney) {
        this.lMoney = lMoney;
    }

    public Double getsMoney() {
        return sMoney;
    }

    public void setsMoney(Double sMoney) {
        this.sMoney = sMoney;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
}
