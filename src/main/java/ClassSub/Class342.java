package ClassSub;

import java.awt.event.*;
import net.minecraftforge.fml.common.*;

final class Class342 extends WindowAdapter
{
    private Class125 this$0;
    
    Class342() {
        super();
    }
    
    @Override
    public final void windowClosing(final WindowEvent windowEvent) {
        FMLCommonHandler.instance().exitJava(0, true);
    }
}
