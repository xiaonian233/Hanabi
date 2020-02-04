package ClassSub;

import org.lwjgl.opengl.*;
import java.lang.invoke.*;

public abstract class Class308
{
    private static Class71 lastUsed;
    private static boolean inSafe;
    private static final long a;
    
    public Class308() {
        super();
    }
    
    public static void enterSafeBlock() {
        final int[] b = Class139.b();
        final boolean inSafe = Class308.inSafe;
        if (b == null) {
            if (inSafe) {
                return;
            }
            Class110.get().flush();
            Class308.lastUsed = Class154.getLastBind();
            Class154.bindNone();
            GL11.glPushAttrib(1048575);
            GL11.glPushClientAttrib(-1);
            GL11.glMatrixMode(5888);
            GL11.glPushMatrix();
            GL11.glMatrixMode(5889);
            GL11.glPushMatrix();
            GL11.glMatrixMode(5888);
        }
        Class308.inSafe = inSafe;
    }
    
    public static void leaveSafeBlock() {
        final int[] b = Class139.b();
        final boolean inSafe = Class308.inSafe;
        if (b == null) {
            if (!inSafe) {
                return;
            }
            GL11.glMatrixMode(5889);
            GL11.glPopMatrix();
        }
        GL11.glMatrixMode((int)(inSafe ? 1 : 0));
        GL11.glPopMatrix();
        GL11.glPopClientAttrib();
        GL11.glPopAttrib();
        final Class71 lastUsed = Class308.lastUsed;
        Label_0062: {
            Label_0059: {
                if (b == null) {
                    if (lastUsed == null) {
                        break Label_0059;
                    }
                    final Class71 lastUsed2 = Class308.lastUsed;
                }
                lastUsed.bind();
                if (b == null) {
                    break Label_0062;
                }
            }
            Class154.bindNone();
        }
        Class308.inSafe = false;
    }
    
    private static void call() throws Class119 {
        enterSafeBlock();
        leaveSafeBlock();
    }
    
    protected abstract void performGLOperations() throws Class119;
    
    static {
        Class169.a(1753314366215739399L, 8796439994793505918L, MethodHandles.lookup().lookupClass()).a(265342337715692L);
        Class308.inSafe = false;
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
