package behaviorTree.ai.abs;

import behaviorTree.ai.ifs.IBehaviour;
import behaviorTree.ai.ifs.IComposite;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComposite extends BaseBehavior implements IComposite {

    protected ArrayList<IBehaviour> children = new ArrayList<>();

    @Override
    public void addChild(IBehaviour child) {
        children.add(child);
    }

    @Override
    public void removeChild(IBehaviour child) {
        children.remove(child);
    }

    @Override
    public void clearChild() {
        children.clear();
    }

    @Override
    public List<IBehaviour> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<IBehaviour> behaviours) {
        this.children = (ArrayList<IBehaviour>) behaviours;
    }
}
