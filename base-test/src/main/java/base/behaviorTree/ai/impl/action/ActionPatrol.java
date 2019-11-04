package base.behaviorTree.ai.impl.action;

import base.behaviorTree.ai.abs.BaseAction;
import base.behaviorTree.ai.common.EStatus;
import base.behaviorTree.ai.ifs.IBehaviour;

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
