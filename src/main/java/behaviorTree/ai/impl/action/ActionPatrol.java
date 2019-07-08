package behaviorTree.ai.impl.action;

import behaviorTree.ai.abs.BaseAction;
import behaviorTree.ai.common.EStatus;
import behaviorTree.ai.ifs.IBehaviour;

public class ActionPatrol extends BaseAction {

    @Override
    public EStatus update() {
        System.out.println("ActionPatrol 巡逻");


        return EStatus.Success;
    }

    @Override
    public void addChild(IBehaviour child) {
    }
}
