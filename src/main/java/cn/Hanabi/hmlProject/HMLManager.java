package cn.Hanabi.hmlProject;

import java.util.*;
import java.lang.invoke.*;
import ClassSub.*;

public final class HMLManager
{
    public static ArrayList<HMLHook> hooks;
    private static int a;
    private static final long b;
    
    public HMLManager() {
        super();
    }
    
    private static boolean registerHook(final HMLHook hmlHook) {
        HMLManager.hooks.add(hmlHook);
        return true;
    }
    
    public static void onModuleManagerLoading$1baec85c() {
        final int a = HMLManager.a;
        final Iterator<HMLHook> iterator = HMLManager.hooks.iterator();
        final int n = a;
        while (iterator.hasNext()) {
            iterator.next();
            if (n != 0) {
                break;
            }
        }
    }
    
    public static void onCommandManagerLoading$1aaa72d3() {
        final int c = c();
        final Iterator<HMLHook> iterator = HMLManager.hooks.iterator();
        final int n = c;
        while (iterator.hasNext()) {
            iterator.next();
            if (n == 0) {
                break;
            }
        }
    }
    
    static {
        Class169.a(7534349950165298544L, 1201946715701004807L, MethodHandles.lookup().lookupClass()).a(270636946066758L);
        final boolean a = false;
        HMLManager.hooks = new ArrayList<HMLHook>();
        HMLManager.a = (a ? 1 : 0);
    }
    
    public static void b(final int a) {
        HMLManager.a = a;
    }
    
    public static int b() {
        return HMLManager.a;
    }
    
    public static int c() {
        if (HMLManager.a == 0) {
            return 56;
        }
        return 0;
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
