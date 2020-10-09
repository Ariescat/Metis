package com.ariescat.metis.functions.behaviorTree.ai.ifs;
/************************************************************************/
/* 组合结点
 */

import java.util.List;

/************************************************************************/
public interface IComposite extends IBehaviour {

    void addChild(IBehaviour child);

    void removeChild(IBehaviour child);

    void clearChild();

    List<IBehaviour> getChildren();

    void setChildren(List<IBehaviour> behaviours);
}