package com.ariescat.metis.functions.behaviortree.ai.impl.decorator;

import com.ariescat.metis.functions.behaviortree.ai.abs.BaseDecorator;
import com.ariescat.metis.functions.behaviortree.ai.ifs.IBehaviour;
import com.ariescat.metis.functions.behaviortree.ai.common.EStatus;

public class Repeat extends BaseDecorator {

    private int limited = 3;
    private volatile int count = 0;

    @Override
    public EStatus update() {
        while (true) {
            child.tick();
            switch (child.getStatus()) {
                case Running:
                    return EStatus.Success;
                case Failure:
                    return EStatus.Failure;
                default:
                    break;
            }
            if (++count > limited)
                return EStatus.Success;
            child.reset();
        }
    }

    @Override
    public void onInitialize() {
        count = 0;
    }

    @Override
    public void addChild(IBehaviour child) {
        super.addChild(child);
    }
}
