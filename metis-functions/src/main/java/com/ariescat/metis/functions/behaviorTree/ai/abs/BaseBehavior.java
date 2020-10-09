package com.ariescat.metis.functions.behaviorTree.ai.abs;

import com.ariescat.metis.functions.behaviorTree.ai.common.EStatus;
import com.ariescat.metis.functions.behaviorTree.ai.ifs.IBehaviour;

/**
 * Behavior接口是所有行为树节点的核心，且我规定所有节点的构造和析构方法都必须是protected，以防止在栈上创建对象，
 * 所有的节点对象通过Create()静态方法在堆上创建，通过Release()方法销毁
 * 由于Behavior是个抽象接口，故没有提供Create()方法，本接口满足如下契约
 * 在Update方法被首次调用前，调用一次OnInitialize函数，负责初始化等操作
 * Update（）方法在行为树每次更新时调用且仅调用一次。
 * 当行为不再处于运行状态时，调用一次OnTerminate（），并根据返回状态不同执行不同的逻辑
 */
public abstract class BaseBehavior implements IBehaviour {

    protected EStatus status;

    //创建对象请调用Create()释放对象请调用Release()
    protected BaseBehavior() {
        setStatus(EStatus.Invalid);
    }

    //包装函数，防止打破调用契约
    public EStatus tick() {
        //update方法被首次调用前执行OnInitlize方法，每次行为树更新时调用一次update方法
        //当刚刚更新的行为不再运行时调用OnTerminate方法
        if (status != EStatus.Running) {
            onInitialize();
        }

        status = update();

        if (status != EStatus.Running) {
            onTerminate(status);
        }

        return status;
    }

    //  //释放对象所占资源
    public void release() {
    }

    ;

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public EStatus getStatus() {
        return status;
    }

    @Override
    public void onInitialize() {
    }

    @Override
    public void onTerminate(EStatus Status) {
    }

    @Override
    public void reset() {
        setStatus(EStatus.Invalid);
    }

    @Override
    public void abort() {
        onTerminate(EStatus.Aborted);
        setStatus(EStatus.Aborted);
    }
}