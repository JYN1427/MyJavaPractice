package com.example.SpringDemosProject.DesignMode.template.use;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-08 17:00:53
 */
public class Main {

    @Autowired
    private CheckStrategyFactory checkStrategyFactory;

    public void template(BasePlan plan) throws Exception {
        BasePlanCheckStrategy strategy = checkStrategyFactory.getStrategyByKey(plan.getPlanType());
        strategy.checkFundNumber();
        strategy.checkFundNumber();
    }
}
