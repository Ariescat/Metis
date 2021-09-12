package com.ariescat.metis.functions.behaviortree.ai.impl.action;

import com.ariescat.metis.functions.behaviortree.ai.abs.BaseAction;
import com.ariescat.metis.functions.behaviortree.ai.common.EStatus;
import com.ariescat.metis.functions.behaviortree.ai.ifs.IBehaviour;

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
