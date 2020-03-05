package base.behaviorTree.ai.ifs;

import base.behaviorTree.ai.common.EStatus;

/**
 * Behavior接口是所有行为树节点的核心，且我规定所有节点的构造和析构方法都必须是protected，以防止在栈上创建对象，
 * 所有的节点对象通过Create()静态方法在堆上创建，通过Release()方法销毁
 * 由于Behavior是个抽象接口，故没有提供Create()方法，本接口满足如下契约
 * 在Update方法被首次调用前，调用一次OnInitialize函数，负责初始化等操作
 * Update（）方法在行为树每次更新时调用且仅调用一次。
 * 当行为不再处于运行状态时，调用一次OnTerminate（），并根据返回状态不同执行不同的逻辑
 */
public interface IBehaviour {
    //
    //  //创建对象请调用Create()释放对象请调用Release()
    //  protected Behavior() {
    //    setStatus(EStatus.Invalid);
    //  }

    EStatus tick();//设置调用顺序，onInitialize--update--onTerminate

    void onInitialize();//当节点调用前

    EStatus update();//节点操作的具体实现

    void onTerminate(EStatus Status); //节点调用后执行

    void release();//释放对象所占资源

    void addChild(IBehaviour child);

    void setStatus(EStatus status);

    EStatus getStatus();

    void reset();

    void abort();

}