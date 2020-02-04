package ClassSub;

import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import java.lang.invoke.*;

public final class Class177
{
    public Minecraft mc;
    private static final long a;
    
    public Class177() {
        super();
        this.mc = Minecraft.func_71410_x();
    }
    
    private void onPre$3a3d1cb1() {
        final int[] b = Class139.b();
        final boolean field_70122_E;
        final boolean b2 = field_70122_E = this.mc.field_71439_g.field_70122_E;
        final boolean movementInput;
        Label_0102: {
            Label_0099: {
                Label_0069: {
                    if (b == null) {
                        if (b2) {
                            movementInput = Class333.MovementInput();
                            if (b != null) {
                                break Label_0069;
                            }
                            if (movementInput) {
                                final boolean func_70090_H = this.mc.field_71439_g.func_70090_H();
                                if (b != null) {
                                    break Label_0069;
                                }
                                if (!func_70090_H) {
                                    Class94.getTimer();
                                    this.mc.field_71439_g.func_70664_aZ();
                                    if (b == null) {
                                        break Label_0099;
                                    }
                                }
                            }
                        }
                        Class333.MovementInput();
                    }
                }
                if (b != null) {
                    break Label_0102;
                }
                if (b2) {
                    final boolean func_70090_H2 = this.mc.field_71439_g.func_70090_H();
                    if (b != null) {
                        break Label_0102;
                    }
                    if (!func_70090_H2) {
                        Class333.setSpeed(0.8);
                    }
                }
            }
            Class333.MovementInput();
        }
        if (!movementInput) {
            final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
            final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
            final double n = 0.0;
            field_71439_g2.field_70179_y = n;
            field_71439_g.field_70159_w = n;
        }
    }
    
    static {
        Class169.a(5188023419375237275L, 5414631673979831480L, MethodHandles.lookup().lookupClass()).a(254910273914846L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
