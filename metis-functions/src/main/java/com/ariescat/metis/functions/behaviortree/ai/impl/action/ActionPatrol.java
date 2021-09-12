package com.ariescat.metis.functions.behaviortree.ai.impl.action;

import com.ariescat.metis.functions.behaviortree.ai.abs.BaseAction;
import com.ariescat.metis.functions.behaviortree.ai.common.EStatus;
import com.ariescat.metis.functions.behaviortree.ai.ifs.IBehaviour;

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
