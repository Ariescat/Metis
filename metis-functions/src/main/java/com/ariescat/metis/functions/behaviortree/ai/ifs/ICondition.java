package com.ariescat.metis.functions.behaviortree.ai.ifs;

/************************************************************************/
/* 条件基类
/* 具体执行动作                                   */

/************************************************************************/
public interface ICondition extends IBehaviour {

    boolean isNegation();

    void setNegation(boolean negation);
}
