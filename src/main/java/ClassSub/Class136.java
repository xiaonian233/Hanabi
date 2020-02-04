package ClassSub;

import javax.swing.*;
import java.lang.invoke.*;
import java.util.*;
import java.nio.charset.*;

final class Class136 extends Class197
{
    private String[][] val$options;
    private String val$currentValue;
    private String val$description;
    private static final long b;
    private static final String[] llIlIlIlIll;
    
    Class136(final String s, final String s2, final String[][] val$options, final String val$currentValue, final String val$description) {
        this.val$options = val$options;
        this.val$currentValue = val$currentValue;
        this.val$description = val$description;
        super(s, s2);
    }
    
    @Override
    public final void showDialog() {
        final int[] b = Class139.b();
        int selectedIndex = -1;
        final DefaultComboBoxModel<Object> defaultComboBoxModel = new DefaultComboBoxModel<Object>();
        int i = 0;
        final int[] array = b;
        while (i < this.val$options.length) {
            defaultComboBoxModel.addElement(this.val$options[i][0]);
            if (array == null) {
                if (this.getValue(i).equals(this.val$currentValue)) {
                    selectedIndex = i;
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        final JComboBox comboBox;
        (comboBox = new JComboBox<Object>(defaultComboBoxModel)).setSelectedIndex(selectedIndex);
        Class136 class136 = this;
        if (array == null) {
            if (!this.showValueDialog(comboBox, this.val$description)) {
                return;
            }
            class136 = this;
        }
        class136.value = this.getValue(comboBox.getSelectedIndex());
    }
    
    private String getValue(final int n) {
        final int[] b = Class139.b();
        final String[] array = this.val$options[n];
        if (b == null) {
            if (array.length == 1) {
                return this.val$options[n][0];
            }
            final String[] array2 = this.val$options[n];
        }
        return array[1];
    }
    
    @Override
    public final String toString() {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (i < this.val$options.length) {
            final String value;
            final String s = value = this.getValue(i);
            if (array == null) {
                if (array == null) {
                    if (s.equals(this.value)) {
                        this.val$options[i][0].toString();
                    }
                    else {
                        ++i;
                        if (array != null) {
                            break;
                        }
                        continue;
                    }
                }
                return s;
            }
            return value;
        }
        return Class136.llIlIlIlIll[0];
    }
    
    @Override
    public final Object getObject() {
        return this.value;
    }
    
    static {
        lIIlIIlllIlll();
        Class169.a(7072866199940254791L, 1730995910816241165L, MethodHandles.lookup().lookupClass()).a(63530879970205L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static void lIIlIIlllIlll() {
        (llIlIlIlIll = new String[] { null })[0] = "";
    }
    
    private static String lIIlIIlllIllI(String s, final String s2) {
        s = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        final char[] charArray = s2.toCharArray();
        int n = 0;
        char[] charArray2;
        for (int length = (charArray2 = s.toCharArray()).length, i = 0; i < length; ++i) {
            sb.append((char)(charArray2[i] ^ charArray[n % charArray.length]));
            ++n;
        }
        return String.valueOf(sb);
    }
}
