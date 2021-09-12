package com.ariescat.metis.functions.behaviortree.ai.impl.condition;

import com.ariescat.metis.functions.behaviortree.ai.abs.BaseCondition;
import com.ariescat.metis.functions.behaviortree.ai.ifs.IBehaviour;
import com.ariescat.metis.functions.behaviortree.ai.common.EStatus;

public class ConditionIsEnemyDead extends BaseCondition {

    public ConditionIsEnemyDead(boolean b) {
        setNegation(b);
    }

    @Override
    public EStatus update() {
        int random = getRandom();
        if (random < 60) {
            System.out.println("Enemy Is Dead");
            return !isNegation() ? EStatus.Success : EStatus.Failure;
        } else {
            System.out.println("Enemy is Not Dead");
            return !isNegation() ? EStatus.Failure : EStatus.Success;
        }

    }

    @Override
    public void addChild(IBehaviour child) {
    }

}
