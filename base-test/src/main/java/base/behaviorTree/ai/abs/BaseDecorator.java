package base.behaviorTree.ai.abs;

import base.behaviorTree.ai.ifs.IBehaviour;
import base.behaviorTree.ai.ifs.IDecorator;

public abstract class BaseDecorator extends BaseBehavior implements IDecorator {

    protected IBehaviour child;//装饰器只会有一个子节点

    @Override
    public void addChild(IBehaviour child) {
        this.child = child;
    }

}
