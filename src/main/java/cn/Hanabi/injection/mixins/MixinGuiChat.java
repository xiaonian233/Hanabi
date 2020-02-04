package cn.Hanabi.injection.mixins;

import net.minecraftforge.fml.relauncher.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.jetbrains.annotations.*;
import ClassSub.*;
import org.spongepowered.asm.mixin.injection.*;
import cn.Hanabi.modules.Player.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

@SideOnly(Side.CLIENT)
@Mixin({ GuiChat.class })
public abstract class MixinGuiChat
{
    @Shadow
    private boolean field_146414_r;
    private static final String[] lllIIllll;
    
    public MixinGuiChat() {
        super();
    }
    
    @Shadow
    public abstract void func_146406_a$3231c38a();
    
    @Inject(method = { "sendAutocompleteRequest" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/network/NetHandlerPlayClient;addToSendQueue(Lnet/minecraft/network/Packet;)V", shift = At.Shift.BEFORE) }, cancellable = true)
    private static void autocomplete$2f02e33b(final String s, @NotNull final CallbackInfo callbackInfo) {
        if (s.startsWith(MixinGuiChat.lllIIllll[0]) && !Class4.getModule(MixinGuiChat.lllIIllll[1]).state) {
            final String[] array;
            if ((array = Class139.INSTANCE.commandManager.autoComplete(s).toArray(new String[0])).length != 0) {
                final String lowerCase = s.toLowerCase();
                final String[] array2 = array;
                if (!lowerCase.endsWith(array2[array2.length - 1].toLowerCase())) {
                    callbackInfo.cancel();
                }
            }
        }
    }
    
    @Inject(method = { "drawScreen" }, at = { @At("HEAD") })
    private static void mouse$1051f9bd(final int n, final int n2) {
        if (Class4.getModule(MixinGuiChat.lllIIllll[2]).state && StaffAnalyzer.ui != null) {
            StaffAnalyzer.ui.mouseListener(n, n2);
        }
        if (Class139.INSTANCE.sbm != null) {
            Class139.INSTANCE.sbm.moveWindow(n, n2);
        }
    }
    
    static {
        lIlIIIlIlIl();
    }
    
    private static void lIlIIIlIlIl() {
        (lllIIllll = new String[3])[0] = ".";
        MixinGuiChat.lllIIllll[1] = "NoCommand";
        MixinGuiChat.lllIIllll[2] = "StaffAnalyzer";
    }
    
    private static String lIlIIIlIIlI(final String s, final String s2) {
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
    
    private static String lIlIIIlIIll(final String s, final String s2) {
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
}
