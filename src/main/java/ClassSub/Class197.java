package ClassSub;

import javax.swing.*;
import java.awt.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

abstract class Class197 implements Class52
{
    String value;
    private String name;
    private static final long a;
    private static final String[] lIlllIIIIII;
    
    public Class197(final String name, final String value) {
        super();
        this.value = value;
        this.name = name;
    }
    
    @Override
    public final void setString(final String value) {
        this.value = value;
    }
    
    @Override
    public final String getString() {
        return this.value;
    }
    
    @Override
    public final String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        final int[] b = Class139.b();
        final String value = this.value;
        if (b == null) {
            if (value == null) {
                return Class197.lIlllIIIIII[0];
            }
            this.value.toString();
        }
        return value;
    }
    
    public final boolean showValueDialog(final JComponent component, final String s) {
        final Class227 class227;
        (class227 = new Class227(component, this.name, s)).setTitle(this.name);
        class227.setLocationRelativeTo(null);
        EventQueue.invokeLater(new Class173(component));
        class227.setVisible(true);
        return class227.okPressed;
    }
    
    static {
        llllllIlllll();
        Class169.a(8381932649263021775L, 1987422613712876603L, MethodHandles.lookup().lookupClass()).a(84412799696818L);
    }
    
    private static RuntimeException b(final RuntimeException ex) {
        return ex;
    }
    
    private static void llllllIlllll() {
        (lIlllIIIIII = new String[] { null })[0] = "";
    }
    
    private static String llllllIllllI(final String s, final String s2) {
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
