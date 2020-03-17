package com.metis.function.behaviorTree.ai.impl.condition;

import com.metis.function.behaviorTree.ai.abs.BaseCondition;
import com.metis.function.behaviorTree.ai.ifs.IBehaviour;
import com.metis.function.behaviorTree.ai.common.EStatus;

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
