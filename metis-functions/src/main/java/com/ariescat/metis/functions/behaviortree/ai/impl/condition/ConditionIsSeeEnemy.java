package com.ariescat.metis.functions.behaviortree.ai.impl.condition;

import com.ariescat.metis.functions.behaviortree.ai.abs.BaseCondition;
import com.ariescat.metis.functions.behaviortree.ai.ifs.IBehaviour;
import com.ariescat.metis.functions.behaviortree.ai.common.EStatus;

public class ConditionIsSeeEnemy extends BaseCondition {

    @Override
    public EStatus update() {
        int random = getRandom();
        if (random < 50) {
            System.out.println("SeeEnemy");
            return !isNegation() ? EStatus.Success : EStatus.Failure;
        } else {
            System.out.println("Not SeeEnemy");
            return !isNegation() ? EStatus.Failure : EStatus.Success;
        }

    }

    @Override
    public void addChild(IBehaviour child) {
    }
}
