package behaviorTree.ai.impl.condition;

import behaviorTree.ai.abs.BaseCondition;
import behaviorTree.ai.common.EStatus;
import behaviorTree.ai.ifs.IBehaviour;

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
