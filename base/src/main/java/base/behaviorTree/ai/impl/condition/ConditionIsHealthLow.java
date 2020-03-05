package base.behaviorTree.ai.impl.condition;

import base.behaviorTree.ai.abs.BaseCondition;
import base.behaviorTree.ai.ifs.IBehaviour;
import base.behaviorTree.ai.common.EStatus;

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
