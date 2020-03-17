package com.metis.function.behaviorTree.ai.impl.action;

import com.metis.function.behaviorTree.ai.abs.BaseAction;
import com.metis.function.behaviorTree.ai.common.EStatus;
import com.metis.function.behaviorTree.ai.ifs.IBehaviour;

public class ActionRunaway extends BaseAction {

    @Override
    public EStatus update() {
        System.out.println("ActionRunaway 跑路");
        return EStatus.Success;
    }

    @Override
    public void addChild(IBehaviour child) {
    }
}
