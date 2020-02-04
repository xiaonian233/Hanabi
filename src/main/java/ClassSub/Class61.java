package ClassSub;

import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class61
{
    int fontSize;
    boolean bold;
    boolean italic;
    int paddingTop;
    int paddingLeft;
    int paddingBottom;
    int paddingRight;
    int paddingAdvanceX;
    int paddingAdvanceY;
    int glyphPageWidth;
    int glyphPageHeight;
    final List effects;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIIIlIIlll;
    
    public Class61() {
        super();
        this.fontSize = 12;
        this.bold = false;
        this.italic = false;
        this.glyphPageWidth = 512;
        this.glyphPageHeight = 512;
        this.effects = new ArrayList();
    }
    
    public Class61(final String s) throws Class119 {
        this(Class5.getResourceAsStream(s));
    }
    
    private Class61(final InputStream inputStream) throws Class119 {
        final int[] b = Class139.b();
        super();
        final int[] array = b;
        this.fontSize = 12;
        this.bold = false;
        this.italic = false;
        this.glyphPageWidth = 512;
        this.glyphPageHeight = 512;
        this.effects = new ArrayList();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
        Label_0085_Outer:
            while ((line = bufferedReader.readLine()) != null) {
                String trim;
                final String s = trim = line.trim();
                Label_0616: {
                    Class218 class218 = null;
                    List values = null;
                Label_0085:
                    while (true) {
                        Label_0089: {
                            if (array != null) {
                                break Label_0089;
                            }
                            final int n = s.length();
                            if (n == 0) {
                                continue Label_0085_Outer;
                            }
                            trim = s;
                        }
                        final String[] split;
                        String s2 = (split = trim.split(Class61.lIIIIlIIlll[0], 2))[0].trim();
                        final String string = split[1];
                        boolean b12;
                        boolean equals;
                        boolean b11;
                        boolean b10;
                        boolean b9;
                        boolean b8;
                        boolean b7;
                        boolean b6;
                        boolean b5;
                        boolean b4;
                        boolean b3;
                        final boolean b2 = b3 = (b4 = (b5 = (b6 = (b7 = (b8 = (b9 = (b10 = (b11 = (equals = (b12 = s2.equals("font.size")))))))))));
                        if (array == null) {
                            if (b2) {
                                this.fontSize = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            final boolean b13;
                            b3 = (b13 = (b4 = (b5 = (b6 = (b7 = (b8 = (b9 = (b10 = (b11 = (equals = (b12 = s2.equals("font.bold"))))))))))));
                        }
                        if (array == null) {
                            if (b2) {
                                this.bold = Boolean.valueOf(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b4 = (b3 = (b5 = (b6 = (b7 = (b8 = (b9 = (b10 = (b11 = (equals = (b12 = s2.equals("font.italic")))))))))));
                        }
                        if (array == null) {
                            if (b3) {
                                this.italic = Boolean.valueOf(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b5 = (b4 = (b6 = (b7 = (b8 = (b9 = (b10 = (b11 = (equals = (b12 = s2.equals("pad.top"))))))))));
                        }
                        if (array == null) {
                            if (b4) {
                                this.paddingTop = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b6 = (b5 = (b7 = (b8 = (b9 = (b10 = (b11 = (equals = (b12 = s2.equals("pad.right")))))))));
                        }
                        if (array == null) {
                            if (b5) {
                                this.paddingRight = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b7 = (b6 = (b8 = (b9 = (b10 = (b11 = (equals = (b12 = s2.equals("pad.bottom"))))))));
                        }
                        if (array == null) {
                            if (b6) {
                                this.paddingBottom = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b8 = (b7 = (b9 = (b10 = (b11 = (equals = (b12 = s2.equals("pad.left")))))));
                        }
                        if (array == null) {
                            if (b7) {
                                this.paddingLeft = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b9 = (b8 = (b10 = (b11 = (equals = (b12 = s2.equals("pad.advance.x"))))));
                        }
                        if (array == null) {
                            if (b8) {
                                this.paddingAdvanceX = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b10 = (b9 = (b11 = (equals = (b12 = s2.equals("pad.advance.y")))));
                        }
                        if (array == null) {
                            if (b9) {
                                this.paddingAdvanceY = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b11 = (b10 = (equals = (b12 = s2.equals("glyph.page.width"))));
                        }
                        if (array == null) {
                            if (b10) {
                                this.glyphPageWidth = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            equals = (b11 = (b12 = s2.equals("glyph.page.height")));
                        }
                        if (array == null) {
                            if (b11) {
                                this.glyphPageHeight = Integer.parseInt(string);
                                if (array == null) {
                                    break Label_0616;
                                }
                            }
                            b12 = (equals = s2.equals("effect.class"));
                        }
                        Object value = null;
                        Label_0525: {
                            if (array == null) {
                                if (equals) {
                                    try {
                                        this.effects.add(Class.forName(string).newInstance());
                                        break Label_0616;
                                    }
                                    catch (Exception ex) {
                                        throw new Class119(String.valueOf(new StringBuilder("Unable to create effect instance: ").append(string)), ex);
                                    }
                                }
                                final String s3 = (String)(value = s2);
                                if (array != null) {
                                    break Label_0525;
                                }
                                b12 = s3.startsWith("effect.");
                            }
                            if (!b12) {
                                break Label_0616;
                            }
                            s2 = s2.substring(7);
                            value = this.effects.get(this.effects.size() - 1);
                        }
                        for (Class52 class220 : values = (class218 = (Class218)value).getValues()) {
                            final Class52 class219 = class220;
                            Label_0603: {
                                if (array == null) {
                                    final int n;
                                    final boolean b14 = (n = (class219.getName().equals(s2) ? 1 : 0)) != 0;
                                    if (array != null) {
                                        continue Label_0085;
                                    }
                                    if (!b14) {
                                        break Label_0603;
                                    }
                                    class220 = class219;
                                }
                                class220.setString(string);
                                if (array == null) {
                                    break;
                                }
                            }
                            if (array != null) {
                                break;
                            }
                        }
                        break;
                    }
                    class218.setValues(values);
                }
                if (array != null) {
                    break;
                }
            }
            bufferedReader.close();
        }
        catch (Exception ex2) {
            throw new Class119("Unable to load Hiero font file", ex2);
        }
    }
    
    private int getPaddingTop() {
        return this.paddingTop;
    }
    
    private void setPaddingTop(final int paddingTop) {
        this.paddingTop = paddingTop;
    }
    
    private int getPaddingLeft() {
        return this.paddingLeft;
    }
    
    private void setPaddingLeft(final int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }
    
    private int getPaddingBottom() {
        return this.paddingBottom;
    }
    
    private void setPaddingBottom(final int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }
    
    private int getPaddingRight() {
        return this.paddingRight;
    }
    
    private void setPaddingRight(final int paddingRight) {
        this.paddingRight = paddingRight;
    }
    
    private int getPaddingAdvanceX() {
        return this.paddingAdvanceX;
    }
    
    private void setPaddingAdvanceX(final int paddingAdvanceX) {
        this.paddingAdvanceX = paddingAdvanceX;
    }
    
    private int getPaddingAdvanceY() {
        return this.paddingAdvanceY;
    }
    
    private void setPaddingAdvanceY(final int paddingAdvanceY) {
        this.paddingAdvanceY = paddingAdvanceY;
    }
    
    private int getGlyphPageWidth() {
        return this.glyphPageWidth;
    }
    
    private void setGlyphPageWidth(final int glyphPageWidth) {
        this.glyphPageWidth = glyphPageWidth;
    }
    
    private int getGlyphPageHeight() {
        return this.glyphPageHeight;
    }
    
    private void setGlyphPageHeight(final int glyphPageHeight) {
        this.glyphPageHeight = glyphPageHeight;
    }
    
    private int getFontSize() {
        return this.fontSize;
    }
    
    private void setFontSize(final int fontSize) {
        this.fontSize = fontSize;
    }
    
    private boolean isBold() {
        return this.bold;
    }
    
    private void setBold(final boolean bold) {
        this.bold = bold;
    }
    
    private boolean isItalic() {
        return this.italic;
    }
    
    private void setItalic(final boolean italic) {
        this.italic = italic;
    }
    
    private List getEffects() {
        return this.effects;
    }
    
    private void save(final File file) throws IOException {
        final PrintStream printStream = new PrintStream(new FileOutputStream(file));
        final int[] b = Class139.b();
        printStream.println(String.valueOf(new StringBuilder("font.size=").append(this.fontSize)));
        printStream.println(String.valueOf(new StringBuilder("font.bold=").append(this.bold)));
        printStream.println(String.valueOf(new StringBuilder("font.italic=").append(this.italic)));
        printStream.println();
        printStream.println(String.valueOf(new StringBuilder("pad.top=").append(this.paddingTop)));
        final int[] array = b;
        printStream.println(String.valueOf(new StringBuilder("pad.right=").append(this.paddingRight)));
        printStream.println(String.valueOf(new StringBuilder("pad.bottom=").append(this.paddingBottom)));
        printStream.println(String.valueOf(new StringBuilder("pad.left=").append(this.paddingLeft)));
        printStream.println(String.valueOf(new StringBuilder("pad.advance.x=").append(this.paddingAdvanceX)));
        printStream.println(String.valueOf(new StringBuilder("pad.advance.y=").append(this.paddingAdvanceY)));
        printStream.println();
        printStream.println(String.valueOf(new StringBuilder("glyph.page.width=").append(this.glyphPageWidth)));
        printStream.println(String.valueOf(new StringBuilder("glyph.page.height=").append(this.glyphPageHeight)));
        printStream.println();
    Label_0438_Outer:
        for (final Class218 class218 : this.effects) {
            printStream.println(String.valueOf(new StringBuilder("effect.class=").append(class218.getClass().getName())));
            if (array == null) {
                while (true) {
                    for (final Class52 class219 : class218.getValues()) {
                        printStream.println(String.valueOf(new StringBuilder("effect.").append(class219.getName()).append(Class61.lIIIIlIIlll[1]).append(class219.getString())));
                        if (array == null) {
                            if (array != null) {
                                break;
                            }
                            continue Label_0438_Outer;
                        }
                        else {
                            if (array != null) {
                                break Label_0438_Outer;
                            }
                            continue Label_0438_Outer;
                        }
                    }
                    printStream.println();
                    continue;
                }
            }
            return;
        }
        printStream.close();
    }
    
    static {
        llIIIIIIlIIl();
        Class169.a(4561042998700140821L, 6494996245728760228L, MethodHandles.lookup().lookupClass()).a(41725678194504L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class61.lIIIIlIIlll[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class61.lIIIIlIIlll[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(30040789962665L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[28];
        int n2 = 0;
        final String s = "´²\u000eý\túíÌ\u0096sX0®½«£ <ië}5\u000e\u0081_´Z+Ø\u0000ü>µ>\u0091ù¸1'Ú^ß\u0016vË«t-H\u0010*JIa)¼K`\u0082ýuöYÔDS n\u0014ÄÝ´·Xº¦ßëè\u0092P*S\u008d\f\u007fä0fízP)¿ÑMXÒë }tÅ\u0084\u001d²qF«\u0002Û¯¦fG\u0087@\u0006:æý\u0018\u000e8î¿f!ñË¿R ¾µÂLMt\u0083ú\u009c¿ÿóSº)\u008d\u001dL\u009aí\u0006å°cèµg\u000fz¦\u0018W(ßÙ\u001fþf\b\u0019Os4ò.Q>\\k\u00ad:tDújþ3\u0099¯|\u0099µ<\u0089ú:´¶ûú+ôa wß>\u009bá|\u009d×'0¢Pqr%ï¿t\u0084\u0091yÓlr\u00804±\u0004\u0003Ìúþ\u0018j¢¥ì\u0088v\u0086\u0096%£ì\\\u009c¥îj&\u0086\u0006*¬\u0096nq(óâ\u0086\u0082Ñ».(mÀìK\\ÜPL¨NÎ\u008eÓ\u0096TÙ»èE³]K\u0087\rF\u0014\u0082\\©*\u00ad\u0080\u0018jÂ¶âM\u000e\u009b \u0088íÕÆ\u009cÓ6\u0086¬\u009b\u0014Ç7\u0082ý\b \u0003Û×[\r\u0004y\u008f)\u0003)ù-¶\u008cR¥ÔÜÛ\u0014mólË\u0019Þ-\u0012\u0010F<\u0018\u0085<;·¹\u0004Ò«@\u0011Äï\u0015ùÐ×°óAÀ/õäI0O\u00059$¼ór»ZY\u001dn\u0007íj\u0006\u0003É\u0006\u0007\u0012ZíëÙj)êi\"ü\u0087\u001e©¢g1C\u0019¹Á[ÌÓOLûî8¤Á\u001fÉ#\u0099 \u0016\u0010õÁ\u0082\u001eÏ\u0091ÓÏf-þS\u000b\u0091áIç.7CÛôMÐ5ÝMjµù\u008bm\u0015\u009b\u0092¨lþ%!`è)\u001fÏ±B \u0097¼ãÌ\u0086\u0007\f:\u0092\u0014ËLà\u001f?\u0007\u0095\u0001\u001c\b\u009e.;ýS\bêãèIÅ©\u0018\u00154Ó\u000bâ2ª\u007fëïø]§C:q^®Fº½ª\u001d\u001e µtË\u0099çH\"Ý\u0000¶S\u008c&-ú[\u0018ß²HC\u009c_\u0004hf\u0083\u0096\u0083ÿ_¾ ,\u008d8\u007f¸øÂ+ëoê£ü\u0086í3û`8\u0095ÿ\u0087\u0080U=¦ÙVW\u0085\u0007\u0081 V|\u0005\u009e\u0092\u0087î.\u0083¹Q»·\u0014ý-§_Ú\u0095\u000b`\u009eõ\u0080\rÈu\u008bºÁÆ \u0097\u009eH4\u0002\u009c»\u0002É\n8j¶ø/\u0006\u001bP¾?ä\u001a»üW*H]\u0097Êj\u008c \u009c\u0081ý>{\u0014&\u0006ëÔ;DöºR£+\u001dGe\rnJ\tP\u0004qæÒÒ¢Õ\u0018=ód\u0014ñ-J:Æ°ÊÉC-7\u001cö\u0090_ø\u0017«×Ã\u0010½Ù[¿\rØ\u001a?\u0001Ð¯\\u¶¤\u0017\u0018m½i\u0014ÆÜ#Ùj{\u0095\u0004\u0002}(\u009b'¡¾\u0094Ï\u0086¾_(¾µF¾Ê\u0019ùó,ÞëQ\u009bn\u008fk*Â`ªCý\u0005¹\u0013\u0007,Oruz\u0089\u0091äÒ#°\u0007\u0001§";
        String s2 = "´²\u000eý\túíÌ\u0096sX0®½«£ <ië}5\u000e\u0081_´Z+Ø\u0000ü>µ>\u0091ù¸1'Ú^ß\u0016vË«t-H\u0010*JIa)¼K`\u0082ýuöYÔDS n\u0014ÄÝ´·Xº¦ßëè\u0092P*S\u008d\f\u007fä0fízP)¿ÑMXÒë }tÅ\u0084\u001d²qF«\u0002Û¯¦fG\u0087@\u0006:æý\u0018\u000e8î¿f!ñË¿R ¾µÂLMt\u0083ú\u009c¿ÿóSº)\u008d\u001dL\u009aí\u0006å°cèµg\u000fz¦\u0018W(ßÙ\u001fþf\b\u0019Os4ò.Q>\\k\u00ad:tDújþ3\u0099¯|\u0099µ<\u0089ú:´¶ûú+ôa wß>\u009bá|\u009d×'0¢Pqr%ï¿t\u0084\u0091yÓlr\u00804±\u0004\u0003Ìúþ\u0018j¢¥ì\u0088v\u0086\u0096%£ì\\\u009c¥îj&\u0086\u0006*¬\u0096nq(óâ\u0086\u0082Ñ».(mÀìK\\ÜPL¨NÎ\u008eÓ\u0096TÙ»èE³]K\u0087\rF\u0014\u0082\\©*\u00ad\u0080\u0018jÂ¶âM\u000e\u009b \u0088íÕÆ\u009cÓ6\u0086¬\u009b\u0014Ç7\u0082ý\b \u0003Û×[\r\u0004y\u008f)\u0003)ù-¶\u008cR¥ÔÜÛ\u0014mólË\u0019Þ-\u0012\u0010F<\u0018\u0085<;·¹\u0004Ò«@\u0011Äï\u0015ùÐ×°óAÀ/õäI0O\u00059$¼ór»ZY\u001dn\u0007íj\u0006\u0003É\u0006\u0007\u0012ZíëÙj)êi\"ü\u0087\u001e©¢g1C\u0019¹Á[ÌÓOLûî8¤Á\u001fÉ#\u0099 \u0016\u0010õÁ\u0082\u001eÏ\u0091ÓÏf-þS\u000b\u0091áIç.7CÛôMÐ5ÝMjµù\u008bm\u0015\u009b\u0092¨lþ%!`è)\u001fÏ±B \u0097¼ãÌ\u0086\u0007\f:\u0092\u0014ËLà\u001f?\u0007\u0095\u0001\u001c\b\u009e.;ýS\bêãèIÅ©\u0018\u00154Ó\u000bâ2ª\u007fëïø]§C:q^®Fº½ª\u001d\u001e µtË\u0099çH\"Ý\u0000¶S\u008c&-ú[\u0018ß²HC\u009c_\u0004hf\u0083\u0096\u0083ÿ_¾ ,\u008d8\u007f¸øÂ+ëoê£ü\u0086í3û`8\u0095ÿ\u0087\u0080U=¦ÙVW\u0085\u0007\u0081 V|\u0005\u009e\u0092\u0087î.\u0083¹Q»·\u0014ý-§_Ú\u0095\u000b`\u009eõ\u0080\rÈu\u008bºÁÆ \u0097\u009eH4\u0002\u009c»\u0002É\n8j¶ø/\u0006\u001bP¾?ä\u001a»üW*H]\u0097Êj\u008c \u009c\u0081ý>{\u0014&\u0006ëÔ;DöºR£+\u001dGe\rnJ\tP\u0004qæÒÒ¢Õ\u0018=ód\u0014ñ-J:Æ°ÊÉC-7\u001cö\u0090_ø\u0017«×Ã\u0010½Ù[¿\rØ\u001a?\u0001Ð¯\\u¶¤\u0017\u0018m½i\u0014ÆÜ#Ùj{\u0095\u0004\u0002}(\u009b'¡¾\u0094Ï\u0086¾_(¾µF¾Ê\u0019ùó,ÞëQ\u009bn\u008fk*Â`ªCý\u0005¹\u0013\u0007,Oruz\u0089\u0091äÒ#°\u0007\u0001§";
        int n3 = s.length();
        int n4 = 16;
        int n5 = -1;
    Label_0149:
        while (true) {
            while (true) {
                ++n5;
                final String s3 = s2;
                final int n6 = n5;
                String s4 = s3.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s4.getBytes(Class61.lIIIIlIIlll[5]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                continue Label_0149;
                            }
                            n3 = (s2 = Class61.lIIIIlIIlll[4]).length();
                            n4 = 32;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                break;
                            }
                            break Label_0149;
                        }
                    }
                    ++n5;
                    final String s5 = s2;
                    final int n8 = n5;
                    s4 = s5.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        b = b2;
        c = new String[28];
    }
    
    private static Exception a(final Exception ex) {
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x27B7;
        if (Class61.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class61.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class61.lIIIIlIIlll[6]);
                    array[1] = SecretKeyFactory.getInstance(Class61.lIIIIlIIlll[7]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class61.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class61.lIIIIlIIlll[8], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class61.c[n3] = a(((Cipher)array[0]).doFinal(Class61.b[n3].getBytes(Class61.lIIIIlIIlll[9])));
        }
        return Class61.c[n3];
    }
    
    private static Object a$dd29b59(final MutableCallSite mutableCallSite, final Object[] array) {
        final String a = a((int)array[0], (long)array[1]);
        mutableCallSite.setTarget(MethodHandles.dropArguments(MethodHandles.constant(String.class, a), 0, Integer.TYPE, Long.TYPE));
        return a;
    }
    
    private static CallSite a(final MethodHandles.Lookup p0, final String p1, final MethodType p2) {
        // 
        // This method could not be decompiled.
        // 
        // Could not show original bytecode, likely due to the same error.
        // 
        // The error that occurred was:
        // 
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class61.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
        //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:65)
        //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
        //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // Caused by: java.lang.ClassCastException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void llIIIIIIlIIl() {
        (lIIIIlIIlll = new String[13])[0] = "=";
        Class61.lIIIIlIIlll[1] = "=";
        Class61.lIIIIlIIlll[2] = "DES/CBC/PKCS5Padding";
        Class61.lIIIIlIIlll[3] = "DES";
        Class61.lIIIIlIIlll[4] = "·à\u009a\u0019\u0083¨B¼´Öçk\u00055T4¥3\u0082K»ä\u0097X´\u001fZ|\u000e)\u001cý@Ó\u0003¶Êî:\u0085°ì=<0\u0005gFþ\u000f·M0\bZ@xÑ«M%î¦×É;äSSf\u0093PIÖ¼¦-{3ó:=.Ìrkþ$\u0096\u0090\u0081ZPxÂm\u0093";
        Class61.lIIIIlIIlll[5] = "ISO-8859-1";
        Class61.lIIIIlIIlll[6] = "DES/CBC/PKCS5Padding";
        Class61.lIIIIlIIlll[7] = "DES";
        Class61.lIIIIlIIlll[8] = "你为什么总是生活在黑暗中是不是你就是你爹娘的失败之作你才这样没用的心跳加快畏惧你爹爹了是不是你这个不肖子孙啊请你不要用那泛滥的语言攻击我了你看看你残缺不全的词汇上气不接下气的打字告诉我你没有苦苦硬撑NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2001\u2006\u200f";
        Class61.lIIIIlIIlll[9] = "ISO-8859-1";
        Class61.lIIIIlIIlll[10] = "你为什么总是生活在黑暗中是不是你就是你爹娘的失败之作你才这样没用的心跳加快畏惧你爹爹了是不是你这个不肖子孙啊请你不要用那泛滥的语言攻击我了你看看你残缺不全的词汇上气不接下气的打字告诉我你没有苦苦硬撑NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2001\u2006\u200f";
        Class61.lIIIIlIIlll[11] = " : ";
        Class61.lIIIIlIIlll[12] = " : ";
    }
    
    private static String llIIIIIIIIlI(final String s, final String s2) {
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
    
    private static String llIIIIIIIlIl(final String s, final String s2) {
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
    
    private static String llIIIIIIIIll(String s, final String s2) {
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
