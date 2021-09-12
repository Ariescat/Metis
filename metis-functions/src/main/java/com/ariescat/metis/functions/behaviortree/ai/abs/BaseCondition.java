package com.ariescat.metis.functions.behaviortree.ai.abs;

import com.ariescat.metis.functions.behaviortree.ai.ifs.ICondition;

public abstract class BaseCondition extends BaseBehavior implements ICondition {
    protected boolean negation = false;

    @Override
    public boolean isNegation() {
        return negation;
    }

    @Override
    public void setNegation(boolean negation) {
        this.negation = negation;
    }

    protected int getRandom() {
        Double random = Math.random() * 100;
        //    int i = random.intValue();
        return random.intValue();
    }
}
