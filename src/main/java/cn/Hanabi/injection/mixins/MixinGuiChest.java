package cn.Hanabi.injection.mixins;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.inventory.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.util.*;
import cn.Hanabi.modules.Player.*;
import org.spongepowered.asm.mixin.injection.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

@Mixin({ GuiChest.class })
public final class MixinGuiChest
{
    @Shadow
    private IInventory field_147015_w;
    private static final String[] lllllllIII;
    
    public MixinGuiChest() {
        super();
    }
    
    @Inject(method = { "drawGuiContainerForegroundLayer" }, at = { @At("HEAD") })
    private static void nmsl$64752fb9() {
        if (StatCollector.func_74838_a(MixinGuiChest.lllllllIII[0]).equalsIgnoreCase(null.func_145748_c_().func_150260_c()) || StatCollector.func_74838_a(MixinGuiChest.lllllllIII[1]).equalsIgnoreCase(null.func_145748_c_().func_150260_c())) {
            ChestStealer.isChest = true;
            return;
        }
        ChestStealer.isChest = false;
    }
    
    static {
        lIllIllIllll();
    }
    
    private static void lIllIllIllll() {
        (lllllllIII = new String[2])[0] = "container.chest";
        MixinGuiChest.lllllllIII[1] = "container.chestDouble";
    }
    
    private static String lIllIllIllIl(final String s, final String s2) {
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
    
    private static String lIllIllIlllI(String s, final String s2) {
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
