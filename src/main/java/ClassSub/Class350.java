package ClassSub;

import cn.Hanabi.value.*;
import java.lang.invoke.*;

final class Class350 extends Class339
{
    private Value val$value;
    private Class338 this$0;
    private static final long a;
    
    Class350(final String s, final boolean b, final Value val$value) {
        this.val$value = val$value;
        super(s, b);
    }
    
    @Override
    public final void onPress() {
        final int[] b = Class139.b();
        Class350 class350 = this;
        if (b == null) {
            if (!this.parent.equals(Class68.selectedMod.getName())) {
                return;
            }
            class350 = this;
        }
        final Value val$value = class350.val$value;
        final boolean booleanValue = (boolean)this.val$value.value;
        if (b == null && booleanValue) {}
        val$value.value = (T)booleanValue;
        super.onPress();
    }
    
    static {
        Class169.a(-5669622648562629897L, 5698718218537151482L, MethodHandles.lookup().lookupClass()).a(154594963564879L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
