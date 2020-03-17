package com.metis.function.behaviorTree.ai.abs;

import com.metis.function.behaviorTree.ai.ifs.IBehaviour;
import com.metis.function.behaviorTree.ai.ifs.IDecorator;

public abstract class BaseDecorator extends BaseBehavior implements IDecorator {

    protected IBehaviour child;//装饰器只会有一个子节点

    @Override
    public void addChild(IBehaviour child) {
        this.child = child;
    }

}
