package com.example.springdemo.DesignMode.template.use;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-08 16:43:58
 */
public class BasePlan {

    private String planType;

    private InnerEntAnnuityInvestmentYieldDo fixedIncome;

    private InnerEntAnnuityInvestmentYieldDo stoker;

    private InnerEntAnnuityInvestmentYieldDo total;

    public InnerEntAnnuityInvestmentYieldDo getFixedIncome() {
        return fixedIncome;
    }

    public void setFixedIncome(InnerEntAnnuityInvestmentYieldDo fixedIncome) {
        this.fixedIncome = fixedIncome;
    }

    public InnerEntAnnuityInvestmentYieldDo getStoker() {
        return stoker;
    }

    public void setStoker(InnerEntAnnuityInvestmentYieldDo stoker) {
        this.stoker = stoker;
    }

    public InnerEntAnnuityInvestmentYieldDo getTotal() {
        return total;
    }

    public void setTotal(InnerEntAnnuityInvestmentYieldDo total) {
        this.total = total;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }
}
