package cn.Hanabi.hmlProject;

import cn.Hanabi.modules.*;
import java.util.*;
import java.lang.invoke.*;
import ClassSub.*;

final class HML_ModManager
{
    private Class4 manager;
    private static final long a;
    
    public HML_ModManager() {
        super();
        final int c = HMLManager.c();
        final Class139 instance = Class139.INSTANCE;
        HMLManager.onModuleManagerLoading$1baec85c();
        int n = c;
        if (Mod.b() == null) {
            HMLManager.b(++n);
        }
    }
    
    private static Mod getMod(final String s) {
        return Class4.getModule(s);
    }
    
    private static List<Mod> getModList() {
        return Class4.getModList();
    }
    
    private static boolean getModState(final Mod mod) {
        return mod.state;
    }
    
    static {
        Class169.a(7500660753717739776L, 9096683300699658410L, MethodHandles.lookup().lookupClass()).a(25548532237054L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
