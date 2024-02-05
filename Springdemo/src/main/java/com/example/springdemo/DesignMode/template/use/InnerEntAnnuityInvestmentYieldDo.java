package com.example.springdemo.DesignMode.template.use;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-08 16:54:57
 */
public class InnerEntAnnuityInvestmentYieldDo {

    /**
     * 计划类型
     */
    private String planClass;


    /**
     * 收益率时间
     */
    private Date yieldDate;

    /**
     * 组合类型
     */
    private String fundClass;

    /**
     * 样本组合数（个）
     */
    private BigDecimal fundNumber;

    /**
     * 样本期末资产金额（亿元）
     */
    private BigDecimal endAssetAmount;

    /**
     * 本季度加权平均收益率(%)
     */
    private BigDecimal quarterAvgYiled;

    public String getPlanClass() {
        return planClass;
    }

    public void setPlanClass(String planClass) {
        this.planClass = planClass;
    }

    public Date getYieldDate() {
        return yieldDate;
    }

    public void setYieldDate(Date yieldDate) {
        this.yieldDate = yieldDate;
    }

    public String getFundClass() {
        return fundClass;
    }

    public void setFundClass(String fundClass) {
        this.fundClass = fundClass;
    }

    public BigDecimal getFundNumber() {
        return fundNumber;
    }

    public void setFundNumber(BigDecimal fundNumber) {
        this.fundNumber = fundNumber;
    }

    public BigDecimal getEndAssetAmount() {
        return endAssetAmount;
    }

    public void setEndAssetAmount(BigDecimal endAssetAmount) {
        this.endAssetAmount = endAssetAmount;
    }

    public BigDecimal getQuarterAvgYiled() {
        return quarterAvgYiled;
    }

    public void setQuarterAvgYiled(BigDecimal quarterAvgYiled) {
        this.quarterAvgYiled = quarterAvgYiled;
    }

    @Override
    public String toString() {
        return "InnerEntAnnuityInvestmentYieldDo{" +
                "planClass='" + planClass + '\'' +
                ", yieldDate=" + yieldDate +
                ", fundClass='" + fundClass + '\'' +
                ", fundNumber='" + fundNumber + '\'' +
                ", endAssetAmount=" + endAssetAmount +
                ", quarterAvgYiled=" + quarterAvgYiled +
                '}';
    }
}

