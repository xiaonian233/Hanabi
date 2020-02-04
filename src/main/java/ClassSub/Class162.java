package ClassSub;

import javax.swing.*;
import java.lang.invoke.*;

final class Class162 extends Class197
{
    private float val$currentValue;
    private float val$min;
    private float val$max;
    private String val$description;
    private static final long b;
    
    Class162(final String s, final String s2, final float val$currentValue, final float val$min, final float val$max, final String val$description) {
        this.val$currentValue = val$currentValue;
        this.val$min = val$min;
        this.val$max = val$max;
        this.val$description = val$description;
        super(s, s2);
    }
    
    @Override
    public final void showDialog() {
        final int[] b = Class139.b();
        final JSpinner spinner = new JSpinner(new SpinnerNumberModel(this.val$currentValue, this.val$min, this.val$max, 0.10000000149011612));
        final int[] array = b;
        Class162 class162 = this;
        Object value;
        final JSpinner spinner2 = (JSpinner)(value = spinner);
        if (array == null) {
            if (!this.showValueDialog(spinner2, this.val$description)) {
                return;
            }
            class162 = this;
            value = spinner.getValue();
        }
        class162.value = String.valueOf((float)value);
    }
    
    @Override
    public final Object getObject() {
        return Float.valueOf(this.value);
    }
    
    static {
        Class169.a(6904610098006711039L, 5667217877819709274L, MethodHandles.lookup().lookupClass()).a(69088065629453L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
