package com.example.SpringDemosProject.DesignMode.template.use;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-08 17:02:50
 */
abstract class BasePlanCheckStrategy {

    private String key;

    public BasePlanCheckStrategy() {
        setKey();
    }

    private void setKey() {
        key = "plan=" + getPlanType();
    }

    public String getKey() {
        return key;
    }

    public abstract String getPlanType();


    public abstract void checkFundNumber() throws Exception;

    public abstract void checkAssetAmount() throws Exception;


}
