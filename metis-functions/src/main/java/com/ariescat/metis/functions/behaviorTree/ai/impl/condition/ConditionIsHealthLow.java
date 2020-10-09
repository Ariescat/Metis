package com.ariescat.metis.functions.behaviorTree.ai.impl.condition;

import com.ariescat.metis.functions.behaviorTree.ai.abs.BaseCondition;
import com.ariescat.metis.functions.behaviorTree.ai.ifs.IBehaviour;
import com.ariescat.metis.functions.behaviorTree.ai.common.EStatus;

public class ConditionIsHealthLow extends BaseCondition {

    @Override
    public EStatus update() {
        int random = getRandom();
        if (random < 30) {
            System.out.println("Health is low");
            return !isNegation() ? EStatus.Success : EStatus.Failure;
        } else {
            System.out.println("Health is Not low");
            return !isNegation() ? EStatus.Failure : EStatus.Success;
        }

    }

    @Override
    public void addChild(IBehaviour child) {
    }
}
