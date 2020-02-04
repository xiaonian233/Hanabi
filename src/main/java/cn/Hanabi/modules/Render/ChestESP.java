package cn.Hanabi.modules.Render;

import net.minecraft.util.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.block.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class ChestESP extends Mod
{
    private ArrayList<BlockPos> list;
    private static final long b;
    private static final String c;
    private static final String[] llIlllllIIl;
    
    public ChestESP() {
        super("ChestESP", Category.RENDER);
        this.list = new ArrayList<BlockPos>();
    }
    
    @Override
    public final void onEnable() {
        ChestESP.mc.field_71438_f.func_72712_a();
        this.list.clear();
    }
    
    @EventTarget
    private void onRenderBlock(final EventRenderBlock eventRenderBlock) {
        final int[] b = Class139.b();
        final BlockPos blockPos = new BlockPos(eventRenderBlock.x, eventRenderBlock.y, eventRenderBlock.z);
        final int[] array = b;
        final boolean contains = this.list.contains(blockPos);
        if (array == null) {
            if (contains) {
                return;
            }
            final boolean b2 = eventRenderBlock.block instanceof BlockChest;
        }
        if (array == null) {
            if (!contains) {
                final boolean b3 = eventRenderBlock.block instanceof BlockEnderChest;
                if (array != null) {
                    return;
                }
                if (!b3) {
                    return;
                }
            }
            this.list.add(blockPos);
        }
    }
    
    @EventTarget
    private void onRender$1f20be12() {
        final int[] b = Class139.b();
        final Iterator<BlockPos> iterator = this.list.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final BlockPos blockPos = iterator.next();
            final boolean b3;
            final boolean b2 = b3 = (ChestESP.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockChest);
            final int n;
            Label_0094: {
                if (array == null) {
                    if (!b2) {
                        n = ((ChestESP.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockEnderChest) ? 1 : 0);
                        if (array != null) {
                            break Label_0094;
                        }
                        if (n == 0) {
                            this.list.remove(blockPos);
                        }
                    }
                    blockPos.func_177958_n();
                }
            }
            final double n2 = n;
            ChestESP.mc.func_175598_ae();
            final double n3 = blockPos.func_177956_o();
            ChestESP.mc.func_175598_ae();
            final double n4 = blockPos.func_177952_p();
            ChestESP.mc.func_175598_ae();
            Class69.drawSolidBlockESP$51f2a797(n2, n3, n4, 1.0f, 1.0f, 1.0f);
            if (array != null) {
                break;
            }
        }
    }
    
    static {
        lIIllIlllIlIl();
        Class169.a(-3062780315647998508L, 807944022891886891L, MethodHandles.lookup().lookupClass()).a(78729568682103L);
        final Cipher instance = Cipher.getInstance(ChestESP.llIlllllIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(ChestESP.llIlllllIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(17420257947284L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(ChestESP.llIlllllIIl[2].getBytes(ChestESP.llIlllllIIl[3]))).intern();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String b(final byte[] array) {
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
    
    private static void lIIllIlllIlIl() {
        (llIlllllIIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        ChestESP.llIlllllIIl[1] = "DES";
        ChestESP.llIlllllIIl[2] = ">9ö[þª1VÙ±\u000eºA\u0004zz";
        ChestESP.llIlllllIIl[3] = "ISO-8859-1";
    }
    
    private static String lIIllIlllIIlI(final String s, final String s2) {
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
    
    private static String lIIllIlllIlII(String s, final String s2) {
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
