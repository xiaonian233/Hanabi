package ClassSub;

import javax.swing.*;
import java.lang.invoke.*;

final class Class173 implements Runnable
{
    private JComponent val$component;
    private Class197 this$0;
    private static final long a;
    
    Class173(final JComponent val$component) {
        this.val$component = val$component;
        super();
    }
    
    @Override
    public final void run() {
        final int[] b = Class139.b();
        JComponent component = this.val$component;
        final int[] array = b;
        final boolean b2 = component instanceof JSpinner;
        if (array == null) {
            if (b2) {
                component = ((JSpinner.DefaultEditor)((JSpinner)this.val$component).getEditor()).getTextField();
            }
            component.requestFocusInWindow();
        }
    }
    
    static {
        Class169.a(410573320312386152L, 1444478221905083353L, MethodHandles.lookup().lookupClass()).a(180612600874134L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
