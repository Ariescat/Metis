package com.ariescat.metis.functions.behaviortree.ai.impl.composite;

import com.ariescat.metis.functions.behaviortree.ai.abs.BaseComposite;
import com.ariescat.metis.functions.behaviortree.ai.ifs.composite.ISequence;
import com.ariescat.metis.functions.behaviortree.ai.common.EStatus;
import com.ariescat.metis.functions.behaviortree.ai.ifs.IBehaviour;

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
