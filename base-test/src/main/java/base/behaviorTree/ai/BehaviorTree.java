package base.behaviorTree.ai;

import base.behaviorTree.ai.ifs.IBehaviour;

public class BehaviorTree {
    private IBehaviour root;

    public BehaviorTree(IBehaviour root) {
        this.root = root;
    }

    public void tick() {
        root.tick();
    }

    public boolean haveRoot() {
        return root != null;
    }

    public void setRoot(IBehaviour inNode) {
        root = inNode;
    }

    public void release() {
        root.release();
    }

}