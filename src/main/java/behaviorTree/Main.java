package behaviorTree;

import behaviorTree.ai.BehaviorTree;
import behaviorTree.ai.BehaviorTreeBuilder;
import behaviorTree.ai.common.EPolicy;
import behaviorTree.ai.impl.action.ActionAttack;
import behaviorTree.ai.impl.action.ActionPatrol;
import behaviorTree.ai.impl.action.ActionRunaway;
import behaviorTree.ai.impl.composite.ParallelImpl;
import behaviorTree.ai.impl.composite.SelectorImpl;
import behaviorTree.ai.impl.composite.SequenceImpl;
import behaviorTree.ai.impl.condition.ConditionIsEnemyDead;
import behaviorTree.ai.impl.condition.ConditionIsHealthLow;
import behaviorTree.ai.impl.condition.ConditionIsSeeEnemy;
import behaviorTree.ai.impl.decorator.Repeat;
import behaviorTree.siki.AStar;
import behaviorTree.siki.Point;

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
