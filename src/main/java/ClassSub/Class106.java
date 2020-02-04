package ClassSub;

import javax.swing.*;
import java.lang.invoke.*;

final class Class106 extends Class197
{
    private int val$currentValue;
    private String val$description;
    private static final long b;
    
    Class106(final String s, final String s2, final int val$currentValue, final String val$description) {
        this.val$currentValue = val$currentValue;
        this.val$description = val$description;
        super(s, s2);
    }
    
    @Override
    public final void showDialog() {
        final int[] b = Class139.b();
        final JSpinner spinner = new JSpinner(new SpinnerNumberModel(this.val$currentValue, -32768, 32767, 1));
        final int[] array = b;
        Class106 class106 = this;
        Object value;
        final JSpinner spinner2 = (JSpinner)(value = spinner);
        if (array == null) {
            if (!this.showValueDialog(spinner2, this.val$description)) {
                return;
            }
            class106 = this;
            value = spinner.getValue();
        }
        class106.value = String.valueOf(value);
    }
    
    @Override
    public final Object getObject() {
        return Integer.valueOf(this.value);
    }
    
    static {
        Class169.a(-8554486916582075960L, 5482084271724876499L, MethodHandles.lookup().lookupClass()).a(260738672301024L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
