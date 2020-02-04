package ClassSub;

import cn.Hanabi.modules.Combat.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public final class Class201 extends Thread
{
    private TPHit this$0;
    
    private Class201() {
        super();
    }
    
    @Override
    public final void run() {
        final long n = 1430L;
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        TPHit.access$4300().func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(TPHit.access$4000().field_71439_g.field_70165_t + 0.08, TPHit.access$4100().field_71439_g.field_70163_u, TPHit.access$4200().field_71439_g.field_70161_v, false));
    }
}
