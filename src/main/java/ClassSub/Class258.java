package ClassSub;

import net.minecraft.client.multiplayer.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import java.lang.invoke.*;

public final class Class258
{
    public static String username;
    public static String password;
    public static boolean active;
    private static WorldClient worldChange;
    public static boolean isGameInit;
    public static boolean sleep;
    private static final long a;
    
    public Class258() {
        super();
    }
    
    public static void onGameLoop() {
        final int[] b = Class139.b();
        Class258.isGameInit = true;
        final WorldClient field_71441_e = Minecraft.func_71410_x().field_71441_e;
        WorldClient worldChange2;
        WorldClient worldChange;
        final WorldClient worldClient = worldChange = (worldChange2 = Class258.worldChange);
        if (b == null) {
            if (worldClient == null) {
                Class258.worldChange = field_71441_e;
                return;
            }
            final WorldClient worldClient2;
            worldChange = (worldClient2 = (worldChange2 = field_71441_e));
        }
        if (b == null) {
            if (worldClient == null) {
                Class258.worldChange = null;
                return;
            }
            worldChange2 = (worldChange = Class258.worldChange);
        }
        if (b == null) {
            if (worldChange == field_71441_e) {
                return;
            }
            worldChange2 = field_71441_e;
        }
        Class258.worldChange = worldChange2;
        final Class263 aes_UTILS = Class139.AES_UTILS;
        final String hwid_VERIFY = Class139.HWID_VERIFY;
        try {
            final boolean contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
            if (b == null) {
                if (!contains) {
                    FMLCommonHandler.instance().exitJava(0, true);
                }
            }
        }
        catch (Exception ex) {
            FMLCommonHandler.instance().exitJava(0, true);
        }
        EventManager.call(new EventWorldChange());
    }
    
    public static void doLogin() {
        final Class125 class125 = new Class125();
        final int[] b = Class139.b();
        class125.init();
        final int[] array = b;
        while (class125.isVisible()) {
            final long n = 100L;
            try {
                Thread.sleep(n);
                continue;
            }
            catch (InterruptedException ex) {
                if (array == null) {
                    continue;
                }
            }
            break;
        }
    }
    
    static {
        Class169.a(7676787706614599327L, 4474354279517515582L, MethodHandles.lookup().lookupClass()).a(63761574905394L);
        Class258.isGameInit = false;
    }
    
    private static Exception a(final Exception ex) {
        return ex;
    }
    
    private static boolean lllIIIIIIllI(final Object o, final Object o2) {
        return o != o2;
    }
}
