package behaviorTree.ai.common;

//Parallel节点成功与失败的要求，是全部成功/失败，还是一个成功/失败
public enum EPolicy {
    RequireOne, RequireAll,
};