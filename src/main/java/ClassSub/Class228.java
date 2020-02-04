package ClassSub;

import cn.Hanabi.value.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import java.io.*;
import org.lwjgl.input.*;
import java.awt.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class228 extends Class230<Value>
{
    private boolean isValueChanging;
    private static final long a;
    private static final String b;
    private static final String[] lllIlIlI;
    
    public Class228(final Value value) {
        super(0, 0, value);
        this.isValueChanging = false;
    }
    
    @Override
    public final void draw() {
        GL11.glPushMatrix();
        final int[] b = Class139.b();
        GL11.glTranslatef((float)this.x, (float)this.y, 0.0f);
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        final int[] array = b;
        final Rectangle rectangle = new Rectangle(this.x, this.y, this.getWidth(), this.getHeight());
        GL11.glTranslatef(2.0f, 2.0f, 0.0f);
        final int field_78288_b = this.fontRenderer.field_78288_b;
        Class300.setColor(Color.white);
        this.fontRenderer.func_78276_b(this.getValue().name.split(Class228.lllIlIlI[0])[1], 0, 0, Class300.toRGBA(Color.white));
        Serializable s = null;
        final T value = this.getValue().value;
        Label_0235: {
            if (array == null) {
                Label_0154: {
                    if (!(value instanceof Integer)) {
                        boolean b3;
                        final boolean b2 = b3 = (this.getValue().value instanceof Long);
                        if (array == null) {
                            if (b2) {
                                break Label_0154;
                            }
                            final boolean b4;
                            b3 = (b4 = (this.getValue().value instanceof Float));
                        }
                        Label_0208: {
                            if (array == null) {
                                if (b2) {
                                    break Label_0208;
                                }
                                b3 = (this.getValue().value instanceof Double);
                            }
                            if (!b3) {
                                break Label_0235;
                            }
                        }
                        s = String.format("%.2f", (Number)this.getValue().value);
                        break Label_0235;
                    }
                }
                final T value2 = this.getValue().value;
            }
            s = value.toString();
        }
        Object value3;
        final String s2 = (String)(value3 = s);
        if (array == null) {
            if (s2 != null) {
                Class300.setColor(Color.white);
                this.fontRenderer.func_78276_b((String)s, this.getWidth() - this.fontRenderer.func_78256_a((String)s) - 3, 0, Class300.toRGBA(Color.white));
            }
            Class300.setColor(Class144.PANEL_MAIN_COLOR);
            GL11.glLineWidth(0.9f);
            value3 = this.getValue().value;
        }
        final double n = (((Number)value3).doubleValue() - ((Class230<Value<Number>>)this).getValue().getValueMin().doubleValue()) / (((Class230<Value<Number>>)this).getValue().getValueMax().doubleValue() - ((Class230<Value<Number>>)this).getValue().getValueMin().doubleValue());
        Class300.setColor(Class144.PANEL_SECONDARY_COLOR);
        Gui.func_73734_a(0, field_78288_b + 2, (int)(rectangle.width * n) - 2, rectangle.height - 4, Class144.PANEL_SECONDARY_COLOR.getRGB());
        Class300.drawRect(2, 0, field_78288_b + 2, (int)(rectangle.width * n) - 2, rectangle.height - 4, Class144.PANEL_MAIN_COLOR.getRGB());
        GL11.glPopMatrix();
    }
    
    @Override
    public final boolean onMouseClick(final int n, final int n2, final int n3) {
        final int[] b = Class139.b();
        final boolean contains = new Rectangle(this.getX(), this.fontRenderer.field_78288_b + 2 + this.getY(), this.getWidth(), this.getHeight() - this.fontRenderer.field_78288_b).contains(n, n2);
        if (b == null) {
            if (contains) {
                if (b == null) {
                    if (n3 == 0) {
                        final boolean buttonDown;
                        final boolean b2 = buttonDown = Mouse.isButtonDown(0);
                        final boolean isValueChanging;
                        Label_0107: {
                            if (b == null) {
                                if (b2) {
                                    isValueChanging = this.isValueChanging;
                                    if (b != null) {
                                        break Label_0107;
                                    }
                                    if (!isValueChanging) {
                                        this.isValueChanging = true;
                                        if (b == null) {
                                            return isValueChanging;
                                        }
                                    }
                                }
                                Mouse.isButtonDown(0);
                            }
                        }
                        if (b == null) {
                            if (!b2) {
                                final boolean isValueChanging2 = this.isValueChanging;
                                if (b == null) {
                                    if (isValueChanging2) {
                                        this.isValueChanging = false;
                                    }
                                }
                            }
                        }
                        return isValueChanging;
                    }
                }
            }
        }
        return contains;
    }
    
    @Override
    public final void update() {
        final int[] b = Class139.b();
        Class228 class228 = this;
        Label_0361: {
            if (b == null) {
                Label_0321: {
                    if (this.isValueChanging) {
                        final Point calculateMouseLocation = Class0.calculateMouseLocation();
                        if (b == null) {
                            Label_0059: {
                                if (Mouse.isButtonDown(0)) {
                                    int n;
                                    final boolean b2 = (n = (new Rectangle(this.getX(), 0, this.getWidth(), Integer.MAX_VALUE).contains(calculateMouseLocation) ? 1 : 0)) != 0;
                                    if (b == null) {
                                        if (!b2) {
                                            break Label_0059;
                                        }
                                        calculateMouseLocation.translate(-this.getX(), -this.getY());
                                        n = calculateMouseLocation.x;
                                    }
                                    final double n2 = Math.round((((Class230<Value<Number>>)this).getValue().getValueMin().doubleValue() - n / this.getWidth() * (((Class230<Value<Number>>)this).getValue().getValueMin().doubleValue() - ((Class230<Value<Number>>)this).getValue().getValueMax().doubleValue())) * (1.0 / this.getValue().step)) / (1.0 / this.getValue().step);
                                    boolean b5;
                                    boolean b4;
                                    final boolean b3 = b4 = (b5 = (this.getValue().value instanceof Integer));
                                    if (b == null) {
                                        if (b3) {
                                            this.getValue().value = (T)(int)Math.round(n2);
                                        }
                                        final boolean b6;
                                        b4 = (b6 = (b5 = (this.getValue().value instanceof Float)));
                                    }
                                    if (b == null) {
                                        if (b3) {
                                            this.getValue().value = (T)(float)n2;
                                        }
                                        b5 = (b4 = (this.getValue().value instanceof Double));
                                    }
                                    if (b == null) {
                                        if (b4) {
                                            this.getValue().value = (T)n2;
                                        }
                                        class228 = this;
                                        if (b != null) {
                                            break Label_0361;
                                        }
                                        b5 = (this.getValue().value instanceof Long);
                                    }
                                    if (b5) {
                                        this.getValue().value = (T)(long)n2;
                                    }
                                    break Label_0321;
                                }
                            }
                            this.isValueChanging = false;
                        }
                        return;
                    }
                }
                this.width = Math.max(100, this.fontRenderer.func_78256_a(((Value)this.value).name.split(Class228.lllIlIlI[1])[1]) + 25);
                class228 = this;
            }
        }
        class228.height = 12 + this.fontRenderer.field_78288_b;
    }
    
    static {
        lIlIIlIlIl();
        Class169.a(3987088010846776183L, 6383764796921468106L, MethodHandles.lookup().lookupClass()).a(131662224753553L);
        final Cipher instance = Cipher.getInstance(Class228.lllIlIlI[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class228.lllIlIlI[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(92399467847540L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class228.lllIlIlI[4].getBytes(Class228.lllIlIlI[5]))).intern();
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
    
    private static void lIlIIlIlIl() {
        (lllIlIlI = new String[6])[0] = "_";
        Class228.lllIlIlI[1] = "_";
        Class228.lllIlIlI[2] = "DES/CBC/PKCS5Padding";
        Class228.lllIlIlI[3] = "DES";
        Class228.lllIlIlI[4] = "XÀäø°MÐé";
        Class228.lllIlIlI[5] = "ISO-8859-1";
    }
    
    private static String lIlIIlIIlI(String s, final String s2) {
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
    
    private static String lIlIIlIIIl(final String s, final String s2) {
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
    
    private static String lIlIIlIIll(final String s, final String s2) {
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
}
