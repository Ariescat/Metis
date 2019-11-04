package base.behaviorTree.ai.impl.condition;

import base.behaviorTree.ai.abs.BaseCondition;
import base.behaviorTree.ai.ifs.IBehaviour;
import base.behaviorTree.ai.common.EStatus;

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
