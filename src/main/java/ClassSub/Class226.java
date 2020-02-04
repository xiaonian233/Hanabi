package ClassSub;

import cn.Hanabi.events.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.entity.player.*;

public final class Class226 extends Thread
{
    private EventAttack val$e;
    private TPHit this$0;
    
    private Class226(final TPHit this$0, final EventAttack val$e) {
        this.this$0 = this$0;
        this.val$e = val$e;
        super();
    }
    
    @Override
    public final void run() {
        final long n = 175L;
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.this$0.aacState = 2;
        TPHit.access$3500().field_71442_b.func_78764_a((EntityPlayer)TPHit.access$3400().field_71439_g, this.val$e.entity);
        TPHit.access$3600().field_71439_g.func_71038_i();
    }
}
