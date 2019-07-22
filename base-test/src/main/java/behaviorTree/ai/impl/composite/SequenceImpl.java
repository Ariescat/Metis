package behaviorTree.ai.impl.composite;

import behaviorTree.ai.abs.BaseComposite;
import behaviorTree.ai.common.EStatus;
import behaviorTree.ai.ifs.IBehaviour;
import behaviorTree.ai.ifs.composite.ISequence;

import java.util.Iterator;

public class SequenceImpl extends BaseComposite implements ISequence {

    private IBehaviour currChild;

    @Override
    public EStatus update() {
        Iterator<IBehaviour> iterator = getChildren().iterator();
        if (iterator.hasNext()) {
            while (true) {
                currChild = iterator.next();
                EStatus s = currChild.tick();
                //如果执行成功了就继续执行，否则返回
                if (s != EStatus.Success)
                    return s;
                if (!iterator.hasNext())
                    return EStatus.Success;
            }
        }
        return EStatus.Invalid;  //循环意外终止
    }
}
