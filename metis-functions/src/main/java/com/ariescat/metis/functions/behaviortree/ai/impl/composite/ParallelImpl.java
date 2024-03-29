package com.ariescat.metis.functions.behaviortree.ai.impl.composite;

import com.ariescat.metis.functions.behaviortree.ai.abs.BaseComposite;
import com.ariescat.metis.functions.behaviortree.ai.common.EPolicy;
import com.ariescat.metis.functions.behaviortree.ai.common.EStatus;
import com.ariescat.metis.functions.behaviortree.ai.ifs.IBehaviour;
import com.ariescat.metis.functions.behaviortree.ai.ifs.composite.IParallel;

public class ParallelImpl extends BaseComposite implements IParallel {

    EPolicy successPolocy;
    EPolicy failPolocy;

    public ParallelImpl(EPolicy successPolocy, EPolicy failPolocy) {
        this.successPolocy = successPolocy;
        this.failPolocy = failPolocy;
    }

    @Override
    public EStatus update() {
        int successCount = 0, failureCount = 0;
        int childrenSize = getChildren().size();
        for (IBehaviour iBehaviour : getChildren()) {
            //如果行为已经终止则不再执行该行为
            if (!(iBehaviour.getStatus().equals(EStatus.Success) || iBehaviour.getStatus().equals(EStatus.Failure)))
                iBehaviour.tick();

            if (iBehaviour.getStatus().equals(EStatus.Success)) {
                ++successCount;
                if (successPolocy.equals(EPolicy.RequireOne)) {
                    iBehaviour.reset();
                    return EStatus.Success;
                }
            }

            if (iBehaviour.getStatus().equals(EStatus.Failure)) {
                ++failureCount;
                if (failPolocy.equals(EPolicy.RequireOne)) {
                    iBehaviour.reset();
                    return EStatus.Failure;
                }
            }
        }

        if (failPolocy.equals(EPolicy.RequireAll) && failureCount == childrenSize) {
            for (IBehaviour iBehaviour : getChildren()) {
                iBehaviour.reset();
            }
            return EStatus.Failure;
        }
        if (successPolocy.equals(EPolicy.RequireAll) && successCount == childrenSize) {
            for (IBehaviour iBehaviour : getChildren()) {
                iBehaviour.reset();
            }
            return EStatus.Success;
        }

        return EStatus.Running;
    }

    @Override
    public void onTerminate(EStatus Status) {
        for (IBehaviour iBehaviour : getChildren()) {
            if (iBehaviour.getStatus().equals(EStatus.Running)) {
                iBehaviour.abort();
            }

            iBehaviour.reset();
        }
    }
}
