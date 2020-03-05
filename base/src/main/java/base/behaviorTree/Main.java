package base.behaviorTree;

import base.behaviorTree.ai.BehaviorTree;
import base.behaviorTree.ai.BehaviorTreeBuilder;
import base.behaviorTree.ai.common.EPolicy;
import base.behaviorTree.ai.impl.action.ActionAttack;
import base.behaviorTree.ai.impl.action.ActionPatrol;
import base.behaviorTree.ai.impl.action.ActionRunaway;
import base.behaviorTree.ai.impl.composite.ParallelImpl;
import base.behaviorTree.ai.impl.composite.SelectorImpl;
import base.behaviorTree.ai.impl.composite.SequenceImpl;
import base.behaviorTree.ai.impl.condition.ConditionIsEnemyDead;
import base.behaviorTree.ai.impl.condition.ConditionIsHealthLow;
import base.behaviorTree.ai.impl.condition.ConditionIsSeeEnemy;
import base.behaviorTree.ai.impl.decorator.Repeat;
import base.behaviorTree.siki.AStar;
import base.behaviorTree.siki.Point;

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
