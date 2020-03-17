package com.metis.function.behaviorTree;

import com.metis.function.behaviorTree.ai.BehaviorTree;
import com.metis.function.behaviorTree.ai.BehaviorTreeBuilder;
import com.metis.function.behaviorTree.ai.common.EPolicy;
import com.metis.function.behaviorTree.ai.impl.action.ActionAttack;
import com.metis.function.behaviorTree.ai.impl.action.ActionPatrol;
import com.metis.function.behaviorTree.ai.impl.action.ActionRunaway;
import com.metis.function.behaviorTree.ai.impl.composite.ParallelImpl;
import com.metis.function.behaviorTree.ai.impl.composite.SelectorImpl;
import com.metis.function.behaviorTree.ai.impl.composite.SequenceImpl;
import com.metis.function.behaviorTree.ai.impl.condition.ConditionIsEnemyDead;
import com.metis.function.behaviorTree.ai.impl.condition.ConditionIsHealthLow;
import com.metis.function.behaviorTree.ai.impl.condition.ConditionIsSeeEnemy;
import com.metis.function.behaviorTree.ai.impl.decorator.Repeat;
import com.metis.function.behaviorTree.siki.AStar;
import com.metis.function.behaviorTree.siki.Point;

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
