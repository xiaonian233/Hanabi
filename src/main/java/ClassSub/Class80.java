package ClassSub;

import cn.Hanabi.modules.*;
import java.util.*;
import java.lang.invoke.*;

final class Class80 extends Class339
{
    private Mod val$selectedMod;
    private Class338 this$0;
    private static final long a;
    
    Class80(final Class338 this$0, final String s, final boolean b, final Mod val$selectedMod) {
        this.this$0 = this$0;
        this.val$selectedMod = val$selectedMod;
        super(s, b);
    }
    
    @Override
    public final void onPress() {
        final int[] b = Class139.b();
        final Mod val$selectedMod = this.val$selectedMod;
        final boolean state = this.val$selectedMod.state;
        if (b == null && state) {}
        val$selectedMod.setState(state, true);
        for (final Class68 class68 : this.this$0.mods) {
            if (b != null) {
                return;
            }
            final Class68 class69 = class68;
            if (b != null || class69.mod == this.val$selectedMod) {
                class69.button.toggle();
                if (b == null) {
                    break;
                }
            }
            if (b != null) {
                break;
            }
        }
        super.onPress();
    }
    
    static {
        Class169.a(-5543514073227156726L, 6826199686849176433L, MethodHandles.lookup().lookupClass()).a(12663808965583L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIIlIIllIIl(final Object o, final Object o2) {
        return o == o2;
    }
}
