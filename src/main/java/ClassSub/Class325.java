package ClassSub;

import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class325 extends Gui
{
    private final FontRenderer fontRenderer;
    private final int xPos;
    private final int yPos;
    private final int width;
    private final int height;
    private String text;
    private int maxStringLength;
    int cursorCounter;
    private boolean enableBackgroundDrawing;
    private boolean canLoseFocus;
    public boolean isFocused;
    private boolean isEnabled;
    private int field_73816_n;
    private int cursorPosition;
    private int selectionEnd;
    private int enabledColor;
    private int disabledColor;
    private boolean field_73823_s;
    private static final long a;
    private static final String b;
    private static final String[] lIIIlIIIlII;
    
    public Class325(final FontRenderer fontRenderer, final int xPos) {
        super();
        this.text = Class325.lIIIlIIIlII[0];
        this.maxStringLength = 50;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isFocused = false;
        this.isEnabled = true;
        this.field_73816_n = 0;
        this.cursorPosition = 0;
        this.selectionEnd = 0;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.field_73823_s = true;
        this.fontRenderer = fontRenderer;
        this.xPos = xPos;
    }
    
    private void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public final void setText(final String text) {
        Label_0044: {
            Label_0039: {
                final int[] b;
                if ((b = Class139.b()) == null) {
                    if (!llIIIlIllIIl(text.length(), this.maxStringLength)) {
                        break Label_0039;
                    }
                    this.text = text.substring(0, this.maxStringLength);
                }
                if (b == null) {
                    break Label_0044;
                }
            }
            this.text = text;
        }
        this.setCursorPositionEnd();
    }
    
    public final String getText() {
        return this.text.replaceAll(Class325.lIIIlIIIlII[1], Class325.lIIIlIIIlII[2]);
    }
    
    private String getSelectedtext() {
        final int[] b = Class139.b();
        Class325 class325 = this;
        int n = 0;
        Label_0030: {
            if (b == null) {
                if (this.cursorPosition < this.selectionEnd) {
                    n = this.cursorPosition;
                    break Label_0030;
                }
                class325 = this;
            }
            n = class325.selectionEnd;
        }
        final int n2 = n;
        Class325 class326 = this;
        if (b == null) {
            if (this.cursorPosition < this.selectionEnd) {
                final int n3 = this.selectionEnd;
                return this.text.substring(n2, n3);
            }
            class326 = this;
        }
        final int n3 = class326.cursorPosition;
        return this.text.substring(n2, n3);
    }
    
    private void writeText(final String s) {
        String s2 = Class325.lIIIlIIIlII[3];
        final int[] b = Class139.b();
        final String func_71565_a = ChatAllowedCharacters.func_71565_a(s);
        final int[] array = b;
        Class325 class325 = this;
        int n = 0;
        Label_0042: {
            if (array == null) {
                if (this.cursorPosition < this.selectionEnd) {
                    n = this.cursorPosition;
                    break Label_0042;
                }
                class325 = this;
            }
            n = class325.selectionEnd;
        }
        final int n2 = n;
        Class325 class326 = this;
        int n3 = 0;
        Label_0070: {
            if (array == null) {
                if (this.cursorPosition < this.selectionEnd) {
                    n3 = this.selectionEnd;
                    break Label_0070;
                }
                class326 = this;
            }
            n3 = class326.cursorPosition;
        }
        final int n4 = n3;
        int n5 = this.maxStringLength - this.text.length() - (n2 - this.selectionEnd);
        int n7;
        final int n6 = n7 = this.text.length();
        if (array == null) {
            if (n6 > 0) {
                s2 = String.valueOf(new StringBuilder().append(s2).append(this.text.substring(0, n2)));
            }
            final int n8;
            n7 = (n8 = n5);
        }
        Label_0211: {
            if (array == null) {
                if (n6 < func_71565_a.length()) {
                    s2 = String.valueOf(new StringBuilder().append(s2).append(func_71565_a.substring(0, n5)));
                    if (array == null) {
                        break Label_0211;
                    }
                }
                s2 = String.valueOf(new StringBuilder().append(s2).append(func_71565_a));
                n7 = func_71565_a.length();
            }
            n5 = n7;
        }
        Class325 class327 = this;
        if (array == null) {
            if (this.text.length() > 0 && n4 < this.text.length()) {
                s2 = String.valueOf(new StringBuilder().append(s2).append(this.text.substring(n4)));
            }
            this.text = s2.replaceAll(Class325.lIIIlIIIlII[4], Class325.lIIIlIIIlII[5]);
            class327 = this;
        }
        class327.func_73784_d(n2 - this.selectionEnd + n5);
    }
    
    private void func_73779_a(final int n) {
        final int[] b = Class139.b();
        final int length = this.text.length();
        Class325 class325 = null;
        Label_0051: {
            if (b == null) {
                if (length == 0) {
                    return;
                }
                class325 = this;
                if (b != null) {
                    break Label_0051;
                }
                final int selectionEnd = this.selectionEnd;
            }
            if (llIIIlIllllI(length, this.cursorPosition)) {
                this.writeText(Class325.lIIIlIIIlII[6]);
                if (b == null) {
                    return;
                }
            }
            class325 = this;
        }
        class325.deleteFromCursor(this.getNthWordFromPos$255f288(n) - this.cursorPosition);
    }
    
    private void deleteFromCursor(final int n) {
        final int[] b = Class139.b();
        int n6;
        int n5;
        int n4;
        int n3;
        final int n2 = n3 = (n4 = (n5 = (n6 = this.text.length())));
        if (b == null) {
            if (n2 == 0) {
                return;
            }
            final int n7;
            n3 = (n7 = (n4 = (n5 = (n6 = this.selectionEnd))));
        }
        if (b == null) {
            if (llIIIlIllllI(n2, this.cursorPosition)) {
                this.writeText(Class325.lIIIlIIIlII[7]);
                if (b == null) {
                    return;
                }
            }
            n6 = n;
            n5 = n;
            n4 = n;
            n3 = n;
        }
        if (b == null) {
            if (n3 < 0) {
                n5 = (n4 = (n6 = 1));
            }
            else {
                n5 = (n4 = (n6 = 0));
            }
        }
        final int n8 = n4;
        if (b == null) {
            if (n5 != 0) {
                n6 = this.cursorPosition + n;
            }
            else {
                n6 = this.cursorPosition;
            }
        }
        final int n9 = n6;
        final int n10 = n8;
        int cursorPosition = 0;
        Label_0116: {
            if (b == null) {
                if (n10 != 0) {
                    cursorPosition = this.cursorPosition;
                    break Label_0116;
                }
                final int cursorPosition2 = this.cursorPosition;
            }
            cursorPosition = n10 + n;
        }
        final int n11 = cursorPosition;
        String text = Class325.lIIIlIIIlII[8];
        int n13;
        final int n12 = n13 = n9;
        if (b == null) {
            if (n12 >= 0) {
                text = this.text.substring(0, n9);
            }
            final int n14;
            n13 = (n14 = n11);
        }
        Class325 class325 = null;
        Label_0215: {
            if (b == null) {
                if (n12 < this.text.length()) {
                    text = String.valueOf(new StringBuilder().append(text).append(this.text.substring(n11)));
                }
                class325 = this;
                if (b != null) {
                    break Label_0215;
                }
                this.text = text;
                n13 = n8;
            }
            if (n13 == 0) {
                return;
            }
            class325 = this;
        }
        class325.func_73784_d(n);
    }
    
    private int getNthWordFromCursor(final int n) {
        return this.getNthWordFromPos$255f288(n);
    }
    
    private int getNthWordFromPos$255f288(final int n) {
        return this.func_73798_a$486912d2(n, this.cursorPosition);
    }
    
    private int func_73798_a$486912d2(int abs, final int n) {
        final int[] b = Class139.b();
        int n2 = n;
        final int[] array = b;
        final int n3 = abs;
        if (array == null && n3 >= 0) {}
        final int n4 = n3;
        abs = Math.abs(abs);
        int n5 = 0;
        do {
            char c = '\0';
            int n6 = 0;
            int n8;
            int n7;
            int length;
            int index;
            int n9;
            char char1;
            int n10;
            int n11 = 0;
            char char2;
            char c2;
            char char3;
            char c3;
            int n12;
            Label_0092_Outer:Label_0184_Outer:
            while (c < n6) {
                n7 = (n8 = n4);
                if (array != null) {
                    return n8;
                }
                if (array == null && n7 == 0) {
                    length = this.text.length();
                    n9 = (n2 = (index = this.text.indexOf(32, n2)));
                    Label_0130: {
                        while (true) {
                            Label_0093: {
                                if (array != null) {
                                    break Label_0093;
                                }
                                if (n9 == -1) {
                                    n2 = length;
                                    if (array == null) {
                                        break Label_0130;
                                    }
                                }
                                index = 1;
                            }
                            if (index != 0) {
                                c = (char1 = (char)n2);
                                n6 = (n10 = length);
                                if (array != null) {
                                    continue Label_0092_Outer;
                                }
                                if (array == null) {
                                    if (c >= n6) {
                                        break Label_0130;
                                    }
                                    char1 = this.text.charAt(n2);
                                    n10 = 32;
                                }
                                if (char1 == n10) {
                                    ++n2;
                                    if (array == null) {
                                        continue;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    if (array != null) {
                        goto Label_0134;
                    }
                }
                else {
                    if (n7 != 0) {
                        n11 = n2;
                        if (array == null && array == null) {
                            if (n11 > 0) {
                                c2 = (char2 = this.text.charAt(n2 - 1));
                                if (array == null) {
                                    if (c2 == ' ') {
                                        --n2;
                                        if (array == null) {
                                            goto Label_0134;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    while (true) {
                        if (n11 > 0) {
                            c3 = (char3 = this.text.charAt(n2 - 1));
                            n12 = 32;
                            if (array != null) {
                                continue Label_0184_Outer;
                            }
                            if (llIIIlIllllI(c3, n12)) {
                                --n2;
                                if (array == null) {
                                    continue;
                                }
                            }
                        }
                        break;
                    }
                }
                ++n5;
            }
            break;
        } while (array == null);
        return n2;
    }
    
    private void func_73784_d(final int n) {
        this.setCursorPosition(this.selectionEnd + n);
    }
    
    private void setCursorPosition(final int cursorPosition) {
        final int[] b = Class139.b();
        this.cursorPosition = cursorPosition;
        final int[] array = b;
        final int length = this.text.length();
        final int cursorPosition2 = this.cursorPosition;
        Class325 class325 = null;
        Label_0062: {
            if (array == null) {
                if (cursorPosition2 < 0) {
                    this.cursorPosition = 0;
                }
                class325 = this;
                if (array != null) {
                    break Label_0062;
                }
                final int cursorPosition3 = this.cursorPosition;
            }
            if (llIIIlIllIIl(cursorPosition2, length)) {
                this.cursorPosition = length;
            }
            class325 = this;
        }
        class325.func_73800_i(this.cursorPosition);
    }
    
    private void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    private void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public final boolean textboxKeyTyped(final char c, final int n) {
        final int[] b = Class139.b();
        final boolean isEnabled = this.isEnabled;
        if (b == null && isEnabled) {
            int isFocused;
            int func_71566_a;
            int n4;
            int n3;
            final int n2 = n3 = (n4 = (func_71566_a = (isFocused = (this.isFocused ? 1 : 0))));
            if (b == null) {
                if (n2 == 0) {
                    goto Label_0026;
                }
                isFocused = c;
                func_71566_a = c;
                n4 = c;
                n3 = c;
            }
            if (b == null) {
                switch (n3) {
                    case 1: {
                        this.setCursorPositionEnd();
                        this.func_73800_i(0);
                        return true;
                    }
                    case 3: {
                        GuiScreen.func_146275_d(this.getSelectedtext());
                        return true;
                    }
                    case 22: {
                        this.writeText(GuiScreen.func_146277_j());
                        return true;
                    }
                    case 24: {
                        GuiScreen.func_146275_d(this.getSelectedtext());
                        this.writeText(Class325.lIIIlIIIlII[9]);
                        return true;
                    }
                    default: {
                        isFocused = n;
                        func_71566_a = n;
                        n4 = n;
                        break;
                    }
                }
            }
            if (b == null) {
                switch (n4) {
                    case 14: {
                        if (GuiScreen.func_146271_m()) {
                            this.func_73779_a(-1);
                            if (b == null) {
                                return true;
                            }
                        }
                        this.deleteFromCursor(-1);
                        return true;
                    }
                    case 199: {
                        if (GuiScreen.func_146272_n()) {
                            this.func_73800_i(0);
                            if (b == null) {
                                return true;
                            }
                        }
                        this.setCursorPosition(0);
                        return true;
                    }
                    case 203: {
                        final boolean func_146272_n = GuiScreen.func_146272_n();
                        if (b == null) {
                            if (func_146272_n) {
                                if (GuiScreen.func_146271_m()) {
                                    this.func_73800_i(this.getNthWordFromPos$255f288(-1));
                                    if (b == null) {
                                        return true;
                                    }
                                }
                                this.func_73800_i(this.selectionEnd - 1);
                                if (b == null) {
                                    return true;
                                }
                            }
                            GuiScreen.func_146271_m();
                        }
                        if (func_146272_n) {
                            this.setCursorPosition(this.getNthWordFromPos$255f288(-1));
                            if (b == null) {
                                return true;
                            }
                        }
                        this.func_73784_d(-1);
                        return true;
                    }
                    case 205: {
                        final boolean func_146272_n2 = GuiScreen.func_146272_n();
                        if (b == null) {
                            if (func_146272_n2) {
                                if (GuiScreen.func_146271_m()) {
                                    this.func_73800_i(this.getNthWordFromPos$255f288(1));
                                    if (b == null) {
                                        return true;
                                    }
                                }
                                this.func_73800_i(this.selectionEnd + 1);
                                if (b == null) {
                                    return true;
                                }
                            }
                            GuiScreen.func_146271_m();
                        }
                        if (func_146272_n2) {
                            this.setCursorPosition(this.getNthWordFromPos$255f288(1));
                            if (b == null) {
                                return true;
                            }
                        }
                        this.func_73784_d(1);
                        return true;
                    }
                    case 207: {
                        if (GuiScreen.func_146272_n()) {
                            this.func_73800_i(this.text.length());
                            if (b == null) {
                                return true;
                            }
                        }
                        this.setCursorPositionEnd();
                        return true;
                    }
                    case 211: {
                        if (GuiScreen.func_146271_m()) {
                            this.func_73779_a(1);
                            if (b == null) {
                                return true;
                            }
                        }
                        this.deleteFromCursor(1);
                        return true;
                    }
                    default: {
                        isFocused = (func_71566_a = (ChatAllowedCharacters.func_71566_a(c) ? 1 : 0));
                        break;
                    }
                }
            }
            if (b == null) {
                if (func_71566_a != 0) {
                    this.writeText(Character.toString(c));
                    return true;
                }
                isFocused = (false ? 1 : 0);
            }
            return isFocused != 0;
        }
        return isEnabled;
    }
    
    public final void mouseClicked(int n, int n2, final int n3) {
        final int[] b = Class139.b();
        int n6;
        int n5;
        final int n4 = n5 = (n6 = n);
        int xPos;
        int n8;
        final int n7 = n8 = (xPos = this.xPos);
        int n11 = 0;
        Label_0068: {
            Label_0067: {
                if (b == null) {
                    if (!llIIIllIIIll(n4, n7)) {
                        break Label_0067;
                    }
                    final int n9;
                    n5 = (n9 = (n6 = n));
                    final int n10;
                    n8 = (n10 = (xPos = this.xPos + 200));
                }
                if (b == null) {
                    if (n4 >= n7) {
                        break Label_0067;
                    }
                    n6 = (n5 = n2);
                    xPos = (n8 = 100);
                }
                Label_0064: {
                    if (b == null) {
                        if (!llIIIllIIIll(n5, n8)) {
                            break Label_0067;
                        }
                        n11 = (n6 = n2);
                        if (b != null) {
                            break Label_0064;
                        }
                        xPos = 120;
                    }
                    if (n6 >= xPos) {
                        break Label_0067;
                    }
                    n11 = 1;
                }
                break Label_0068;
            }
            n11 = 0;
        }
        n2 = n11;
        int n14;
        int n13;
        final int n12 = n13 = (n14 = (this.canLoseFocus ? 1 : 0));
        if (b == null) {
            if (n12 != 0) {
                int isEnabled;
                boolean b3;
                final boolean b2 = b3 = ((isEnabled = (this.isEnabled ? 1 : 0)) != 0);
                Label_0108: {
                    Label_0107: {
                        if (b == null) {
                            if (!b2) {
                                break Label_0107;
                            }
                            isEnabled = ((b3 = (n2 != 0)) ? 1 : 0);
                        }
                        if (b == null) {
                            if (!b3) {
                                break Label_0107;
                            }
                            isEnabled = 1;
                        }
                        break Label_0108;
                    }
                    isEnabled = 0;
                }
                this.setFocused(isEnabled != 0);
            }
            final boolean b4;
            n13 = ((b4 = ((n14 = (this.isFocused ? 1 : 0)) != 0)) ? 1 : 0);
        }
        if (b == null) {
            if (n12 == 0) {
                return;
            }
            n14 = n3;
            n13 = n3;
        }
        if (b == null) {
            if (n13 != 0) {
                return;
            }
            n14 = n - this.xPos;
        }
        n = n14;
        Class325 class325 = this;
        if (b == null) {
            if (this.enableBackgroundDrawing) {
                n -= 4;
            }
            class325 = this;
        }
        this.setCursorPosition(this.fontRenderer.func_78269_a(class325.fontRenderer.func_78269_a(this.text.substring(this.field_73816_n), this.getWidth()), n).length() + this.field_73816_n);
    }
    
    public final void drawTextBox() {
        final int[] b = Class139.b();
        boolean b3;
        final boolean b2 = b3 = this.field_73823_s;
        if (b == null) {
            if (!b2) {
                return;
            }
            final boolean enableBackgroundDrawing;
            b3 = (enableBackgroundDrawing = this.enableBackgroundDrawing);
        }
        int n = 0;
        Label_0094: {
            Class325 class325 = null;
            Label_0091: {
                if (b == null) {
                    if (b2) {
                        Gui.func_73734_a(this.xPos - 1, 99, this.xPos + 200 + 1, 121, -6250336);
                        Gui.func_73734_a(this.xPos, 100, this.xPos + 200, 120, -16777216);
                    }
                    class325 = this;
                    if (b != null) {
                        break Label_0091;
                    }
                    b3 = this.isEnabled;
                }
                if (b3) {
                    n = this.enabledColor;
                    break Label_0094;
                }
                class325 = this;
            }
            n = class325.disabledColor;
        }
        final int n2 = n;
        final int n3 = this.cursorPosition - this.field_73816_n;
        int length = this.selectionEnd - this.field_73816_n;
        final String func_78269_a = this.fontRenderer.func_78269_a(this.text.substring(this.field_73816_n), this.getWidth());
        int n5;
        final int n4 = n5 = n3;
        Label_0177: {
            Label_0176: {
                if (b == null) {
                    if (n4 < 0) {
                        break Label_0176;
                    }
                    final int n6;
                    n5 = (n6 = n3);
                }
                if (b == null) {
                    if (!llIIIllIIlII(n4, func_78269_a.length())) {
                        break Label_0176;
                    }
                    n5 = 1;
                }
                break Label_0177;
            }
            n5 = 0;
        }
        final int n7 = n5;
        int isFocused;
        int n10;
        int n9;
        final int n8 = n9 = (n10 = (isFocused = (this.isFocused ? 1 : 0)));
        Label_0221: {
            Label_0220: {
                if (b == null) {
                    if (n8 == 0) {
                        break Label_0220;
                    }
                    n10 = (n9 = (isFocused = this.cursorCounter / 6 % 2));
                }
                if (b == null) {
                    if (n9 != 0) {
                        break Label_0220;
                    }
                    isFocused = (n10 = n7);
                }
                if (b == null) {
                    if (n10 == 0) {
                        break Label_0220;
                    }
                    isFocused = 1;
                }
                break Label_0221;
            }
            isFocused = 0;
        }
        final int n11 = isFocused;
        Class325 class326 = this;
        int xPos = 0;
        Label_0248: {
            if (b == null) {
                if (this.enableBackgroundDrawing) {
                    xPos = this.xPos + 4;
                    break Label_0248;
                }
                class326 = this;
            }
            xPos = class326.xPos;
        }
        final int n12 = xPos;
        final int n13 = (b == null && this.enableBackgroundDrawing) ? 106 : 100;
        int n14 = n12;
        int length2;
        int cursorPosition;
        final int n15 = cursorPosition = (length2 = length);
        if (b == null) {
            if (llIIIlIllIIl(n15, func_78269_a.length())) {
                length = func_78269_a.length();
            }
            final int n16;
            cursorPosition = (n16 = (length2 = func_78269_a.length()));
        }
        if (b == null) {
            if (n15 > 0) {
                final int n17 = n7;
                if (b == null) {
                    if (n17 != 0) {
                        func_78269_a.substring(0, n3);
                    }
                    Minecraft.func_71410_x().field_71466_p.func_175063_a(this.text.replaceAll("(?s).", Class325.lIIIlIIIlII[10]), (float)n12, (float)n13, n2);
                }
                n14 = n17;
            }
            cursorPosition = this.cursorPosition;
        }
        final int length3;
        if (b == null) {
            if (llIIIllIIIll(cursorPosition, this.text.length())) {
                length3 = this.text.length();
                if (b == null) {
                    if (llIIIllIIIll(length3, this.maxStringLength)) {}
                }
            }
        }
        final int n18 = length3;
        int n19 = n14;
        int length4;
        int n23;
        int n22;
        int n21;
        final int n20 = n21 = (n22 = (n23 = (length4 = n7)));
        Label_0488: {
            Label_0483: {
                if (b == null) {
                    if (n20 == 0) {
                        final int n24 = n3;
                        if (b == null && n24 <= 0) {}
                        n19 = n24;
                        if (b == null) {
                            break Label_0483;
                        }
                    }
                    final int n25;
                    n21 = (n25 = (n22 = (n23 = (length4 = n18))));
                }
                if (b != null) {
                    break Label_0488;
                }
                if (n20 != 0) {
                    n19 = n14 - 1;
                    --n14;
                }
            }
            n21 = (n23 = (length4 = func_78269_a.length()));
        }
        final int n26;
        final int n27;
        Label_0550: {
            if (b == null) {
                if (n21 > 0) {
                    n26 = (n23 = (length4 = n7));
                    if (b != null) {
                        break Label_0550;
                    }
                    if (n26 != 0) {
                        n27 = (length4 = n3);
                        if (b != null) {
                            break Label_0550;
                        }
                        if (n27 < func_78269_a.length()) {
                            Minecraft.func_71410_x().field_71466_p.func_175063_a(func_78269_a.substring(n3), (float)n14, (float)n13, n2);
                        }
                    }
                }
                length4 = n11;
            }
        }
        if (b == null) {
            Label_0620: {
                if (n26 != 0) {
                    final int n28 = n18;
                    if (b == null) {
                        if (n28 != 0) {
                            Gui.func_73734_a(n19, n13 - 1, n19 + 1, n13 + 1 + this.fontRenderer.field_78288_b, -3092272);
                            if (b == null) {
                                break Label_0620;
                            }
                        }
                        Minecraft.func_71410_x().field_71466_p.func_175063_a(Class325.lIIIlIIIlII[11], (float)n19, (float)n13, n2);
                    }
                }
            }
            length4 = (n23 = length);
        }
        final int n29 = n3;
        if (b == null) {
            if (!llIIIlIllllI(n27, n29)) {
                return;
            }
            length4 = n12;
            this.fontRenderer.func_78256_a(func_78269_a.substring(0, length));
        }
        final int n30 = length4 + n29;
        final int n31 = n19;
        final int n32 = n13 - 1;
        final int n33 = n30 - 1;
        int n34 = n13 + 1 + this.fontRenderer.field_78288_b;
        int n35 = n33;
        int n36 = n32;
        int n37 = n31;
        final int[] b4 = Class139.b();
        final int n38 = n37;
        final int n39 = n35;
        Label_0722: {
            int n41 = 0;
            Label_0713: {
                if (b4 == null) {
                    if (n38 < n39) {
                        final int n40 = n37;
                        n37 = n35;
                        n35 = n40;
                    }
                    final int n42;
                    n41 = (n42 = n36);
                    if (b4 != null) {
                        break Label_0713;
                    }
                }
                if (n38 >= n39) {
                    break Label_0722;
                }
                n41 = n36;
            }
            final int n43 = n41;
            n36 = n34;
            n34 = n43;
        }
        final Tessellator func_178181_a;
        final WorldRenderer func_178180_c = (func_178181_a = Tessellator.func_178181_a()).func_178180_c();
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b((double)n37, (double)n34, 0.0);
        func_178180_c.func_181662_b((double)n35, (double)n34, 0.0);
        func_178180_c.func_181662_b((double)n35, (double)n36, 0.0);
        func_178180_c.func_181662_b((double)n37, (double)n36, 0.0);
        func_178181_a.func_78381_a();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }
    
    private static void drawCursorVertical(int n, int n2, int n3, int n4) {
        final int[] b = Class139.b();
        final int n5 = n;
        final int n6 = n3;
        Label_0041: {
            int n8 = 0;
            Label_0034: {
                if (b == null) {
                    if (n5 < n6) {
                        final int n7 = n;
                        n = n3;
                        n3 = n7;
                    }
                    final int n9;
                    n8 = (n9 = n2);
                    if (b != null) {
                        break Label_0034;
                    }
                }
                if (n5 >= n6) {
                    break Label_0041;
                }
                n8 = n2;
            }
            final int n10 = n8;
            n2 = n4;
            n4 = n10;
        }
        final Tessellator func_178181_a;
        final WorldRenderer func_178180_c = (func_178181_a = Tessellator.func_178181_a()).func_178180_c();
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b((double)n, (double)n4, 0.0);
        func_178180_c.func_181662_b((double)n3, (double)n4, 0.0);
        func_178180_c.func_181662_b((double)n3, (double)n2, 0.0);
        func_178180_c.func_181662_b((double)n, (double)n2, 0.0);
        func_178181_a.func_78381_a();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }
    
    private void setMaxStringLength(final int maxStringLength) {
        final int[] b = Class139.b();
        this.maxStringLength = maxStringLength;
        final int[] array = b;
        Class325 class325 = this;
        if (array == null) {
            if (!llIIIlIllIIl(this.text.length(), maxStringLength)) {
                return;
            }
            class325 = this;
        }
        class325.text = this.text.substring(0, maxStringLength);
    }
    
    private int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    private int getCursorPosition() {
        return this.cursorPosition;
    }
    
    private boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    private void setEnableBackgroundDrawing(final boolean enableBackgroundDrawing) {
        this.enableBackgroundDrawing = enableBackgroundDrawing;
    }
    
    private void func_73794_g(final int enabledColor) {
        this.enabledColor = enabledColor;
    }
    
    public final void setFocused(final boolean isFocused) {
        final int[] b;
        if ((b = Class139.b()) == null) {
            Class325 class325 = null;
            Label_0029: {
                if (isFocused) {
                    class325 = this;
                    if (b != null) {
                        break Label_0029;
                    }
                    if (!this.isFocused) {
                        this.cursorCounter = 0;
                    }
                }
                class325 = this;
            }
            class325.isFocused = isFocused;
        }
    }
    
    private boolean isFocused() {
        return this.isFocused;
    }
    
    private int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    private int getWidth() {
        if (Class139.b() == null && this.enableBackgroundDrawing) {
            return 192;
        }
        return 200;
    }
    
    private void func_73800_i(int selectionEnd) {
        final int[] b = Class139.b();
        final int length = this.text.length();
        final int[] array = b;
        int n2;
        final int n = n2 = selectionEnd;
        if (array == null) {
            if (llIIIlIllIIl(n, length)) {
                selectionEnd = length;
            }
            final int n3;
            n2 = (n3 = selectionEnd);
        }
        Label_0044: {
            if (array == null) {
                if (n >= 0) {
                    break Label_0044;
                }
                n2 = 0;
            }
            selectionEnd = n2;
        }
        this.selectionEnd = selectionEnd;
        Class325 class325 = this;
        if (array == null) {
            if (this.fontRenderer == null) {
                return;
            }
            class325 = this;
        }
        final int field_73816_n = class325.field_73816_n;
        if (array == null) {
            if (llIIIlIllIIl(field_73816_n, length)) {
                this.field_73816_n = length;
            }
            this.getWidth();
        }
        final int n4 = field_73816_n;
        final int n5 = this.fontRenderer.func_78269_a(this.text.substring(this.field_73816_n), n4).length() + this.field_73816_n;
        int n7;
        final int n6 = n7 = selectionEnd;
        int n9;
        final int n8 = n9 = this.field_73816_n;
        if (array == null) {
            if (n6 == n8) {
                this.field_73816_n -= this.fontRenderer.func_78262_a(this.text, n4, true).length();
            }
            final int n10;
            n7 = (n10 = selectionEnd);
            final int n11;
            n9 = (n11 = n5);
        }
        int field_73816_n3 = 0;
        int field_73816_n2 = 0;
        Label_0218: {
            Label_0214: {
                if (array == null) {
                    if (llIIIlIllIIl(n6, n8)) {
                        this.field_73816_n += selectionEnd - n5;
                        if (array == null) {
                            break Label_0214;
                        }
                    }
                    field_73816_n2 = (n7 = (field_73816_n3 = selectionEnd));
                    if (array != null) {
                        break Label_0218;
                    }
                    n9 = this.field_73816_n;
                }
                if (llIIIllIIlII(n7, n9)) {
                    this.field_73816_n -= this.field_73816_n - selectionEnd;
                }
            }
            field_73816_n3 = (field_73816_n2 = this.field_73816_n);
        }
        Class325 class326 = null;
        Label_0254: {
            if (array == null) {
                if (field_73816_n2 < 0) {
                    this.field_73816_n = 0;
                }
                class326 = this;
                if (array != null) {
                    break Label_0254;
                }
                field_73816_n3 = this.field_73816_n;
            }
            if (!llIIIlIllIIl(field_73816_n3, length)) {
                return;
            }
            class326 = this;
        }
        class326.field_73816_n = length;
    }
    
    private void setCanLoseFocus(final boolean canLoseFocus) {
        this.canLoseFocus = canLoseFocus;
    }
    
    private boolean func_73778_q() {
        return this.field_73823_s;
    }
    
    private void func_73790_e(final boolean field_73823_s) {
        this.field_73823_s = field_73823_s;
    }
    
    static {
        llIIIlIlIIIl();
        Class169.a(5601315930882918873L, 5891808364720919793L, MethodHandles.lookup().lookupClass()).a(175289925759060L);
        final Cipher instance = Cipher.getInstance(Class325.lIIIlIIIlII[12]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class325.lIIIlIIIlII[13]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(50596402403838L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class325.lIIIlIIIlII[14].getBytes(Class325.lIIIlIIIlII[15]))).intern();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String a(final byte[] array) {
        int n = 0;
        final int length;
        final char[] array2 = new char[length = array.length];
        for (int i = 0; i < length; ++i) {
            final int n2;
            if ((n2 = (0xFF & array[i])) < 192) {
                array2[n++] = (char)n2;
            }
            else if (n2 < 224) {
                array2[n++] = (char)((char)((char)(n2 & 0x1F) << 6) | (char)(array[++i] & 0x3F));
            }
            else if (i < length - 2) {
                array2[n++] = (char)((char)((char)((char)(n2 & 0xF) << 12) | (char)(array[++i] & 0x3F) << 6) | (char)(array[++i] & 0x3F));
            }
        }
        return new String(array2, 0, n);
    }
    
    private static void llIIIlIlIIIl() {
        (lIIIlIIIlII = new String[16])[0] = "";
        Class325.lIIIlIIIlII[1] = " ";
        Class325.lIIIlIIIlII[2] = "";
        Class325.lIIIlIIIlII[3] = "";
        Class325.lIIIlIIIlII[4] = " ";
        Class325.lIIIlIIIlII[5] = "";
        Class325.lIIIlIIIlII[6] = "";
        Class325.lIIIlIIIlII[7] = "";
        Class325.lIIIlIIIlII[8] = "";
        Class325.lIIIlIIIlII[9] = "";
        Class325.lIIIlIIIlII[10] = "*";
        Class325.lIIIlIIIlII[11] = "_";
        Class325.lIIIlIIIlII[12] = "DES/CBC/PKCS5Padding";
        Class325.lIIIlIIIlII[13] = "DES";
        Class325.lIIIlIIIlII[14] = "=FÝÅn\u0010\u001d¥";
        Class325.lIIIlIIIlII[15] = "ISO-8859-1";
    }
    
    private static String llIIIlIlIIII(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String llIIIlIIlllI(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String llIIIlIIllll(String s, final String s2) {
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
    
    private static boolean llIIIllIIIll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean llIIIllIIlII(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean llIIIlIllIIl(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean llIIIllIIIII(final int n) {
        return n >= 0;
    }
    
    private static boolean llIIIlIlllll(final int n) {
        return n < 0;
    }
    
    private static boolean llIIIlIlllII(final int n) {
        return n > 0;
    }
    
    private static boolean llIIIlIllllI(final int n, final int n2) {
        return n != n2;
    }
}
