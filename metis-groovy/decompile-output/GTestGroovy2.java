/**
 * arthas jad 反编译文件
 * <p>
 * jad com.metis.groovy.withJava.TestGroovy2 > ./GTestGroovy2.java
 */

ClassLoader:                                                                                                                                                                           
+-groovy.lang.GroovyClassLoader$InnerLoader@672872e1                                                                                                                                   
  +-groovy.lang.GroovyClassLoader@5b05955c                                                                                                                                             
    +-sun.misc.Launcher$AppClassLoader@18b4aac2                                                                                                                                        
      +-sun.misc.Launcher$ExtClassLoader@5234cbc8                                                                                                                                      

Location:                                                                                                                                                                              
/C:/LQZ_Projects/Idea_Projects/Metis/base-test/src/main/java/script/groovy/withJava/TestGroovy2.java                                                                                   

/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  base.math.round.Main
 *  com.metis.groovy.withJava.ITestGroovy2
 */
package script.groovy.withJava;

import base.math.round.Main;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.transform.Generated;
import groovy.transform.Internal;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import script.groovy.withJava.ITestGroovy2;

public class TestGroovy2
implements ITestGroovy2,
GroovyObject {
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static transient /* synthetic */ boolean __$stMC;
    private transient /* synthetic */ MetaClass metaClass;
    private static /* synthetic */ SoftReference $callSiteArray;

    @Generated
    public TestGroovy2() {
        MetaClass metaClass;
        CallSite[] arrcallSite = TestGroovy2.$getCallSiteArray();
        this.metaClass = metaClass = this.$getStaticMetaClass();
    }

    public void print(String msg) {
        CallSite[] arrcallSite = TestGroovy2.$getCallSiteArray();
        arrcallSite[0].call(arrcallSite[1].callGetProperty(System.class), msg);
        arrcallSite[2].call((Object)Main.class, (Object)null);
    }

    private void testCall() {
        CallSite[] arrcallSite = TestGroovy2.$getCallSiteArray();
        throw (Throwable)arrcallSite[3].callConstructor(RuntimeException.class, "testCall");
    }

    protected /* synthetic */ MetaClass $getStaticMetaClass() {
        if (this.getClass() != TestGroovy2.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            $staticClassInfo = classInfo = ClassInfo.getClassInfo(this.getClass());
        }
        return classInfo.getMetaClass();
    }

    @Generated
    @Internal
    @Override
    public /* synthetic */ MetaClass getMetaClass() {
        if (this.metaClass != null) {
            MetaClass metaClass;
            return metaClass;
        }
        this.metaClass = this.$getStaticMetaClass();
        return this.metaClass;
    }

    @Generated
    @Internal
    @Override
    public /* synthetic */ void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    @Generated
    @Internal
    @Override
    public /* synthetic */ Object invokeMethod(String string, Object object) {
        return this.getMetaClass().invokeMethod((Object)this, string, object);
    }

    @Generated
    @Internal
    @Override
    public /* synthetic */ Object getProperty(String string) {
        return this.getMetaClass().getProperty(this, string);
    }

    @Generated
    @Internal
    @Override
    public /* synthetic */ void setProperty(String string, Object object) {
        this.getMetaClass().setProperty(this, string, object);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] arrstring) {
        arrstring[0] = "println";
        arrstring[1] = "out";
        arrstring[2] = "main";
        arrstring[3] = "<$constructor$>";
    }

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] arrstring = new String[4];
        TestGroovy2.$createCallSiteArray_1(arrstring);
        return new CallSiteArray(TestGroovy2.class, arrstring);
    }

    private static /* synthetic */ CallSite[] $getCallSiteArray() {
        CallSiteArray callSiteArray;
        if ($callSiteArray == null || (callSiteArray = (CallSiteArray)$callSiteArray.get()) == null) {
            callSiteArray = TestGroovy2.$createCallSiteArray();
            $callSiteArray = new SoftReference<CallSiteArray>(callSiteArray);
        }
        return callSiteArray.array;
    }
}

Affect(row-cnt:1) cost in 250 ms.
