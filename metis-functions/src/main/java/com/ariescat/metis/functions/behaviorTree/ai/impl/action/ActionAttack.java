package com.ariescat.metis.functions.behaviorTree.ai.impl.action;

import com.ariescat.metis.functions.behaviorTree.ai.abs.BaseAction;
import com.ariescat.metis.functions.behaviorTree.ai.common.EStatus;
import com.ariescat.metis.functions.behaviorTree.ai.ifs.IBehaviour;

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
