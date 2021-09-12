package com.ariescat.metis.functions.behaviortree;

import com.ariescat.metis.functions.behaviortree.ai.BehaviorTree;
import com.ariescat.metis.functions.behaviortree.siki.AStar;
import com.ariescat.metis.functions.behaviortree.siki.Point;
import com.ariescat.metis.functions.behaviortree.ai.BehaviorTreeBuilder;
import com.ariescat.metis.functions.behaviortree.ai.common.EPolicy;
import com.ariescat.metis.functions.behaviortree.ai.impl.action.ActionAttack;
import com.ariescat.metis.functions.behaviortree.ai.impl.action.ActionPatrol;
import com.ariescat.metis.functions.behaviortree.ai.impl.action.ActionRunaway;
import com.ariescat.metis.functions.behaviortree.ai.impl.composite.ParallelImpl;
import com.ariescat.metis.functions.behaviortree.ai.impl.composite.SelectorImpl;
import com.ariescat.metis.functions.behaviortree.ai.impl.composite.SequenceImpl;
import com.ariescat.metis.functions.behaviortree.ai.impl.condition.ConditionIsEnemyDead;
import com.ariescat.metis.functions.behaviortree.ai.impl.condition.ConditionIsHealthLow;
import com.ariescat.metis.functions.behaviortree.ai.impl.condition.ConditionIsSeeEnemy;
import com.ariescat.metis.functions.behaviortree.ai.impl.decorator.Repeat;

public class Main {

  public static void main(String[] args) {
//   testBT();
   testAStar();
  }

  //测试行为树
  public static void testBT() {
    BehaviorTreeBuilder builder = new BehaviorTreeBuilder();
    BehaviorTree behaviorTree =
          builder.addBehaviour(new SelectorImpl())
            .addBehaviour(new SequenceImpl())
              .addBehaviour(new ConditionIsSeeEnemy())
                .back()
              .addBehaviour(new SelectorImpl())
                .addBehaviour(new SequenceImpl())
                  .addBehaviour(new ConditionIsHealthLow())
                    .back()
                  .addBehaviour(new ActionRunaway())
                    .back()
                  .back()

                .addBehaviour(new ParallelImpl(EPolicy.RequireAll,EPolicy.RequireOne))
                  .addBehaviour(new ConditionIsEnemyDead(true))
                         .back()
                  .addBehaviour(new Repeat())
                    .addBehaviour(new ActionAttack())
                      .back()
                    .back()
                  .back()
                .back()
              .back()
            .addBehaviour(new ActionPatrol())
        .end();

    //模拟执行行为树
    for (int i = 0; i < 10; ++i){
      behaviorTree.tick();
      System.out.println("--------------" + i + "------------");
    }

    System.out.println("pause ");
  }

  //测试A星算法
  public static void testAStar() {
    AStar aStar = new AStar();

    aStar.initMap();
    Point start = aStar.map[4][4];
    Point end = aStar.map[8][5];

    aStar.findPath(start, end);
    aStar.showPath(start, end);
    aStar.showLoad();
    System.out.println("Hello World! ");
  }

}
