package behaviorTree.ai.impl.action;

import behaviorTree.ai.abs.BaseAction;
import behaviorTree.ai.common.EStatus;
import behaviorTree.ai.ifs.IBehaviour;

public class ActionAttack extends BaseAction {

    @Override
    public EStatus update() {
        System.out.println("ActionAttack 攻击");
        return EStatus.Success;
    }

    @Override
    public void addChild(IBehaviour child) {
    }
}
