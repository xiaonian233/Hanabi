package cn.Hanabi.hmlProject;

import cn.Hanabi.modules.*;
import java.lang.invoke.*;
import ClassSub.*;

public final class HMLHook
{
    private static int HML_VERSION;
    private String name;
    private int version;
    private String author;
    private static final long a;
    
    private HMLHook() {
        super();
        if (HMLManager.b() != 0) {
            Mod.b(new Mod[5]);
        }
    }
    
    private static void onModuleManagerLoading$1baec85c() {
    }
    
    private static void onCommandManagerLoading$1aaa72d3() {
    }
    
    static {
        Class169.a(5190319351954785328L, 6365306340810716441L, MethodHandles.lookup().lookupClass()).a(237723928012437L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
