package ClassSub;

import cn.Hanabi.modules.*;
import java.lang.invoke.*;

final class Class93 extends Class339
{
    private Class68 this$0;
    private static final long a;
    
    Class93(final Class68 this$0, final String s, final boolean b) {
        this.this$0 = this$0;
        super(s, b);
    }
    
    @Override
    public final void onPress() {
        final int[] b = Class139.b();
        final Mod mod = this.this$0.mod;
        final boolean state = this.this$0.mod.state;
        if (b == null && state) {}
        mod.setState(state, true);
        this.this$0.mod.modButton.toggle();
        super.onPress();
    }
    
    static {
        Class169.a(7994940165959281664L, 5456192134997696637L, MethodHandles.lookup().lookupClass()).a(220838605065535L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
