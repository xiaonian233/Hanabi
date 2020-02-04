package ClassSub;

import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class181 implements Class311
{
    private static Class79 GL;
    private static final int DISPLAY_LIST_CACHE_SIZE;
    private static final int MAX_CHAR;
    private boolean displayListCaching;
    private Class85 fontImage;
    private Class88[] chars;
    private int lineHeight;
    private int baseDisplayListID;
    private int eldestDisplayListID;
    private Class310 eldestDisplayList;
    private final LinkedHashMap displayLists;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIllIlll;
    
    private Class181(final String s, final Class85 fontImage) throws Class119 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class202(this);
        this.fontImage = fontImage;
        this.parseFnt(Class5.getResourceAsStream(s));
    }
    
    public Class181(final String s, final String s2) throws Class119 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class202(this);
        this.fontImage = new Class85(s2);
        this.parseFnt(Class5.getResourceAsStream(s));
    }
    
    private Class181(final String s, final Class85 fontImage, final boolean displayListCaching) throws Class119 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class202(this);
        this.fontImage = fontImage;
        this.displayListCaching = displayListCaching;
        this.parseFnt(Class5.getResourceAsStream(s));
    }
    
    private Class181(final String s, final String s2, final boolean displayListCaching) throws Class119 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class202(this);
        this.fontImage = new Class85(s2);
        this.displayListCaching = displayListCaching;
        this.parseFnt(Class5.getResourceAsStream(s));
    }
    
    private Class181(final String s, final InputStream inputStream, final InputStream inputStream2) throws Class119 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class202(this);
        this.fontImage = new Class85(inputStream2, s);
        this.parseFnt(inputStream);
    }
    
    private Class181(final String s, final InputStream inputStream, final InputStream inputStream2, final boolean displayListCaching) throws Class119 {
        super();
        this.displayListCaching = true;
        this.baseDisplayListID = -1;
        this.displayLists = new Class202(this);
        this.fontImage = new Class85(inputStream2, s);
        this.displayListCaching = displayListCaching;
        this.parseFnt(inputStream);
    }
    
    private void parseFnt(final InputStream inputStream) throws Class119 {
        final int[] b = Class139.b();
        int n;
        final boolean b2 = (n = (this.displayListCaching ? 1 : 0)) != 0;
        Label_0043: {
            Class181 class181 = null;
            Label_0039: {
                if (b == null) {
                    if (!b2) {
                        break Label_0043;
                    }
                    this.baseDisplayListID = Class181.GL.glGenLists$134621();
                    class181 = this;
                    if (b != null) {
                        break Label_0039;
                    }
                    n = this.baseDisplayListID;
                }
                if (n != 0) {
                    break Label_0043;
                }
                class181 = this;
            }
            class181.displayListCaching = false;
        }
        try {
            final BufferedReader bufferedReader;
            (bufferedReader = new BufferedReader(new InputStreamReader(inputStream))).readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            final HashMap<Object, List<Short>> hashMap = new HashMap<Object, List<Short>>(64);
            final ArrayList<Class88> list = new ArrayList<Class88>(255);
            int max = 0;
            int i = 0;
            while (true) {
            Label_0804_Outer:
                while (i == 0) {
                    final String line = bufferedReader.readLine();
                    if (b != null) {
                        Object o = list.iterator();
                        while (true) {
                            while (((Iterator)o).hasNext()) {
                                final Class88 class182 = ((Iterator<Class88>)o).next();
                                this.chars[class182.id] = class182;
                                if (b != null) {
                                Label_0930:
                                    while (((Iterator)o).hasNext()) {
                                        final Map.Entry entry;
                                        final short shortValue = (short)(entry = (Map.Entry)((Iterator<Class88>)o).next()).getKey();
                                        final List<Short> list2;
                                        final short[] kerning = new short[(list2 = entry.getValue()).size()];
                                        int n2 = 0;
                                        if (b == null) {
                                            final Iterator<Short> iterator = list2.iterator();
                                            while (true) {
                                                while (iterator.hasNext()) {
                                                    kerning[n2] = iterator.next();
                                                    ++n2;
                                                    if (b == null) {
                                                        if (b != null) {
                                                            break;
                                                        }
                                                        continue Label_0804_Outer;
                                                    }
                                                    else {
                                                        if (b != null) {
                                                            break Label_0930;
                                                        }
                                                        continue Label_0804;
                                                    }
                                                }
                                                this.chars[shortValue].kerning = kerning;
                                                continue;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                if (b != null) {
                                    break;
                                }
                            }
                            o = hashMap.entrySet().iterator();
                            continue;
                        }
                    }
                    final String s = line;
                    Label_0724: {
                        if (b == null && s == null) {
                            i = 1;
                            if (b != null) {
                                goto Label_0133;
                            }
                        }
                        else {
                            boolean b4;
                            boolean startsWith;
                            final boolean b3 = startsWith = (b4 = s.startsWith("chars c"));
                            Label_0568: {
                                Label_0561: {
                                    if (b == null) {
                                        if (b3) {
                                            break Label_0561;
                                        }
                                        final boolean b5;
                                        startsWith = (b5 = (b4 = line.startsWith("char")));
                                    }
                                    if (b != null) {
                                        break Label_0568;
                                    }
                                    if (b3) {
                                        final String s2 = line;
                                        final Class88 class183 = new Class88(this, (byte)0);
                                        final StringTokenizer stringTokenizer = new StringTokenizer(s2, " =");
                                        final int[] b6 = Class139.b();
                                        stringTokenizer.nextToken();
                                        final int[] array = b6;
                                        stringTokenizer.nextToken();
                                        class183.id = Short.parseShort(stringTokenizer.nextToken());
                                        short n4;
                                        final short n3 = n4 = class183.id;
                                        final Class88 class186;
                                        Label_0528: {
                                            if (array == null) {
                                                if (n3 < 0) {
                                                    break Label_0528;
                                                }
                                                final short id;
                                                n4 = (id = class183.id);
                                            }
                                            short n5 = 255;
                                            if (array == null) {
                                                if (n3 > 255) {
                                                    throw new Class119(String.valueOf(new StringBuilder("Invalid character '").append(class183.id).append("': AngelCodeFont does not support characters above 255")));
                                                }
                                                stringTokenizer.nextToken();
                                                class183.x = Short.parseShort(stringTokenizer.nextToken());
                                                stringTokenizer.nextToken();
                                                class183.y = Short.parseShort(stringTokenizer.nextToken());
                                                stringTokenizer.nextToken();
                                                class183.width = Short.parseShort(stringTokenizer.nextToken());
                                                stringTokenizer.nextToken();
                                                class183.height = Short.parseShort(stringTokenizer.nextToken());
                                                stringTokenizer.nextToken();
                                                class183.xoffset = Short.parseShort(stringTokenizer.nextToken());
                                                stringTokenizer.nextToken();
                                                class183.yoffset = Short.parseShort(stringTokenizer.nextToken());
                                                stringTokenizer.nextToken();
                                                class183.xadvance = Short.parseShort(stringTokenizer.nextToken());
                                                final Class88 class185;
                                                final Class88 class184 = class185 = class183;
                                                class184.image = class184.this$0.fontImage.getSubImage(class185.x, class185.y, class185.width, class185.height);
                                                class186 = class183;
                                                if (array != null) {
                                                    break Label_0528;
                                                }
                                                n4 = class186.id;
                                                n5 = 32;
                                            }
                                            if (n4 != n5) {
                                                this.lineHeight = Math.max(class183.height + class183.yoffset, this.lineHeight);
                                            }
                                        }
                                        final Class88 class187 = class186;
                                        if (b == null) {
                                            if (class187 == null) {
                                                break Label_0561;
                                            }
                                            max = Math.max(max, class187.id);
                                        }
                                        list.add(class187);
                                    }
                                }
                                b4 = (startsWith = line.startsWith("kernings c"));
                            }
                            if (b == null) {
                                if (startsWith) {
                                    break Label_0724;
                                }
                                b4 = line.startsWith("kerning");
                            }
                            if (b4) {
                                final StringTokenizer stringTokenizer2;
                                (stringTokenizer2 = new StringTokenizer(line, " =")).nextToken();
                                stringTokenizer2.nextToken();
                                final short short1 = Short.parseShort(stringTokenizer2.nextToken());
                                stringTokenizer2.nextToken();
                                final int int1 = Integer.parseInt(stringTokenizer2.nextToken());
                                stringTokenizer2.nextToken();
                                final int int2 = Integer.parseInt(stringTokenizer2.nextToken());
                                List<Short> list5;
                                List<Short> list4;
                                final List<Short> list3 = list4 = (list5 = hashMap.get(short1));
                                if (b == null) {
                                    if (list3 == null) {
                                        list4 = new ArrayList<Short>();
                                        hashMap.put(short1, list4);
                                    }
                                    list5 = list4;
                                }
                                list5.add(new Short((short)(int2 << 8 | int1)));
                            }
                        }
                    }
                    if (b != null) {
                        break;
                    }
                }
                this.chars = new Class88[max + 1];
                continue;
            }
        }
        catch (IOException ex) {
            Class355.error(ex);
            throw new Class119(String.valueOf(new StringBuilder("Failed to parse font file: ").append(inputStream)));
        }
    }
    
    private Class88 parseChar(final String s) throws Class119 {
        final Class88 class88 = new Class88(this, (byte)0);
        final StringTokenizer stringTokenizer = new StringTokenizer(s, " =");
        final int[] b = Class139.b();
        stringTokenizer.nextToken();
        final int[] array = b;
        stringTokenizer.nextToken();
        class88.id = Short.parseShort(stringTokenizer.nextToken());
        short n2;
        final short n = n2 = class88.id;
        if (array == null) {
            if (n < 0) {
                return null;
            }
            final short id;
            n2 = (id = class88.id);
        }
        short n3 = 255;
        final Class88 class91;
        if (array == null) {
            if (n > 255) {
                throw new Class119(String.valueOf(new StringBuilder("Invalid character '").append(class88.id).append("': AngelCodeFont does not support characters above 255")));
            }
            stringTokenizer.nextToken();
            class88.x = Short.parseShort(stringTokenizer.nextToken());
            stringTokenizer.nextToken();
            class88.y = Short.parseShort(stringTokenizer.nextToken());
            stringTokenizer.nextToken();
            class88.width = Short.parseShort(stringTokenizer.nextToken());
            stringTokenizer.nextToken();
            class88.height = Short.parseShort(stringTokenizer.nextToken());
            stringTokenizer.nextToken();
            class88.xoffset = Short.parseShort(stringTokenizer.nextToken());
            stringTokenizer.nextToken();
            class88.yoffset = Short.parseShort(stringTokenizer.nextToken());
            stringTokenizer.nextToken();
            class88.xadvance = Short.parseShort(stringTokenizer.nextToken());
            final Class88 class90;
            final Class88 class89 = class90 = class88;
            class89.image = class89.this$0.fontImage.getSubImage(class90.x, class90.y, class90.width, class90.height);
            class91 = class88;
            if (array != null) {
                return class91;
            }
            n2 = class91.id;
            n3 = 32;
        }
        if (n2 != n3) {
            this.lineHeight = Math.max(class88.height + class88.yoffset, this.lineHeight);
        }
        return class91;
    }
    
    @Override
    public final void drawString(final float n, final float n2, final String s) {
        this.drawString(n, n2, s, Class286.white);
    }
    
    @Override
    public final void drawString(final float n, final float n2, final String s, final Class286 class286) {
        this.drawString$6c4abf1d(n, n2, s, class286, s.length() - 1);
    }
    
    @Override
    public final void drawString$6c4abf1d(final float n, final float n2, final String text, final Class286 class286, final int n3) {
        this.fontImage.bind();
        final int[] b = Class139.b();
        class286.bind();
        Class181.GL.glTranslatef(n, n2, 0.0f);
        final int[] array = b;
        Class181 class287 = this;
        Label_0230: {
            if (array == null) {
                Label_0223: {
                    if (this.displayListCaching) {
                        int n5;
                        final int n4 = n5 = 0;
                        if (array == null) {
                            if (n4 != 0) {
                                break Label_0223;
                            }
                            n5 = n3;
                        }
                        if (n5 == text.length() - 1) {
                            Class310 class290;
                            Class310 class289;
                            final Class310 class288 = class289 = (class290 = this.displayLists.get(text));
                            Label_0218: {
                                if (array == null) {
                                    if (class288 != null) {
                                        Class181.GL.glCallList(class289.id);
                                        if (array == null) {
                                            break Label_0218;
                                        }
                                    }
                                    class290 = (class289 = new Class310((byte)0));
                                }
                                class290.text = text;
                                final int size = this.displayLists.size();
                                Label_0177: {
                                    if (array == null) {
                                        if (size < 200) {
                                            class289.id = this.baseDisplayListID + size;
                                            if (array == null) {
                                                break Label_0177;
                                            }
                                        }
                                        class289.id = this.eldestDisplayListID;
                                    }
                                    this.displayLists.remove(this.eldestDisplayList.text);
                                }
                                this.displayLists.put(text, class289);
                                Class181.GL.glNewList(class289.id, 4865);
                                this.render$44bd8e9f(text, n3);
                                Class181.GL.glEndList();
                            }
                            if (array == null) {
                                break Label_0230;
                            }
                        }
                    }
                }
                class287 = this;
            }
            class287.render$44bd8e9f(text, n3);
        }
        Class181.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    private void render$44bd8e9f(final String s, final int n) {
        final int[] b = Class139.b();
        Class181.GL.glBegin(7);
        int n2 = 0;
        int n3 = 0;
        Class88 class88 = null;
        final int[] array = b;
        final char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            final char c = charArray[i];
            if (array != null) {
                return;
            }
            final char c2 = c;
            int length;
            final int n4 = length = 10;
            Label_0185: {
                if (array == null) {
                    if (c2 == n4) {
                        n2 = 0;
                        n3 += this.lineHeight;
                        if (array == null) {
                            break Label_0185;
                        }
                    }
                    length = this.chars.length;
                }
                if (!lIIlllIlIll(c2, length) || array != null) {
                    Class88 class92;
                    Class88 class91;
                    final Class88 class90;
                    final Class88 class89 = class90 = (class91 = (class92 = this.chars[c]));
                    if (array == null) {
                        if (class89 == null && array == null) {
                            break Label_0185;
                        }
                        class92 = (class91 = class88);
                    }
                    if (array == null) {
                        if (class91 != null) {
                            n2 += class88.getKerning(c);
                        }
                        class92 = class90;
                    }
                    class88 = class92;
                    final int n5 = i;
                    final int n6 = 0;
                    Label_0182: {
                        if (array == null) {
                            if (lIIlllIlIll(n5, n6)) {
                                final int n7 = i;
                                if (array != null) {
                                    break Label_0182;
                                }
                                if (lIIlllIllII(n7, n)) {
                                    class90.draw(n2, n3);
                                }
                            }
                            final short xadvance = class90.xadvance;
                        }
                    }
                    n2 = n5 + n6;
                }
            }
            ++i;
            if (array != null) {
                break;
            }
        }
        Class181.GL.glEnd();
    }
    
    private int getYOffset(final String s) {
        final int[] b = Class139.b();
        Class310 class310 = null;
        final int[] array = b;
        Object value = this;
        Label_0056: {
            if (array == null) {
                if (!this.displayListCaching) {
                    break Label_0056;
                }
                value = this.displayLists.get(s);
            }
            Class310 class312;
            final Class310 class311 = class310 = (class312 = (Class310)value);
            if (array == null) {
                if (class311 == null) {
                    break Label_0056;
                }
                class312 = class310;
            }
            final Short yOffset = class312.yOffset;
            if (array == null) {
                if (yOffset == null) {
                    break Label_0056;
                }
                final Short yOffset2 = class310.yOffset;
            }
            return yOffset;
        }
        int index;
        int length = index = s.indexOf(10);
        if (array == null) {
            if (length == -1) {
                length = s.length();
            }
            index = 10000;
        }
        int min = index;
        int i = 0;
        while (i < length) {
            final Class88 class313 = this.chars[s.charAt(i)];
            if (array != null) {
                return min;
            }
            final Class88 class314 = class313;
            if (array != null || (class314 != null || array != null)) {
                min = Math.min(class314.yoffset, min);
            }
            ++i;
            if (array != null) {
                break;
            }
        }
        final Class310 class315 = class310;
        if (array == null && class315 == null) {
            return min;
        }
        class315.yOffset = new Short((short)min);
        return min;
    }
    
    @Override
    public final int getHeight(final String s) {
        final int[] b = Class139.b();
        Class310 class310 = null;
        final int[] array = b;
        Object value = this;
        Label_0056: {
            if (array == null) {
                if (!this.displayListCaching) {
                    break Label_0056;
                }
                value = this.displayLists.get(s);
            }
            Class310 class312;
            final Class310 class311 = class310 = (class312 = (Class310)value);
            if (array == null) {
                if (class311 == null) {
                    break Label_0056;
                }
                class312 = class310;
            }
            final Short height = class312.height;
            if (array == null) {
                if (height == null) {
                    break Label_0056;
                }
                final Short height2 = class310.height;
            }
            return height;
        }
        int n = 0;
        int max = 0;
        int i = 0;
        while (true) {
            while (i < s.length()) {
                final int char1;
                int n4;
                final int n3;
                final int n2 = n3 = (n4 = (char1 = s.charAt(i)));
                final int n7;
                int n6;
                final int n5 = n6 = (n7 = 10);
                if (array != null) {
                    final int n8 = char1 + n7;
                    if (array == null) {
                        final int n9 = n8;
                        if (class310 != null) {
                            class310.height = new Short((short)n9);
                        }
                    }
                    return n8;
                }
                Label_0156: {
                    if (array == null) {
                        if (n2 == n5) {
                            ++n;
                            max = 0;
                            if (array == null) {
                                break Label_0156;
                            }
                        }
                        n4 = n3;
                        n6 = 32;
                    }
                    if (n4 != n6 || array != null) {
                        Class88 class315;
                        final Class88 class314;
                        final Class88 class313 = class314 = (class315 = this.chars[n3]);
                        if (array == null) {
                            if (class313 == null && array == null) {
                                break Label_0156;
                            }
                            class315 = class314;
                        }
                        max = Math.max(class315.height + class314.yoffset, max);
                    }
                }
                ++i;
                if (array != null) {
                    break;
                }
            }
            int char1 = max;
            int n7 = n * this.lineHeight;
            continue;
        }
    }
    
    @Override
    public final int getWidth(final String s) {
        final int[] b = Class139.b();
        Class310 class310 = null;
        final int[] array = b;
        Object value = this;
        Label_0056: {
            if (array == null) {
                if (!this.displayListCaching) {
                    break Label_0056;
                }
                value = this.displayLists.get(s);
            }
            Class310 class312;
            final Class310 class311 = class310 = (class312 = (Class310)value);
            if (array == null) {
                if (class311 == null) {
                    break Label_0056;
                }
                class312 = class310;
            }
            final Short width = class312.width;
            if (array == null) {
                if (width == null) {
                    break Label_0056;
                }
                final Short width2 = class310.width;
            }
            return width;
        }
        int max = 0;
        int n = 0;
        Class88 class313 = null;
        int i = 0;
        final int length = s.length();
        while (i < length) {
            final int char1;
            int n4;
            final int n3;
            final int n2 = n3 = (n4 = (char1 = s.charAt(i)));
            if (array != null) {
                return char1;
            }
            int length2;
            final int n5 = length2 = 10;
            Label_0219: {
                if (array == null) {
                    if (n2 == n5) {
                        n = 0;
                        if (array == null) {
                            break Label_0219;
                        }
                    }
                    n4 = n3;
                    length2 = this.chars.length;
                }
                if (!lIIlllIlIll(n4, length2) || array != null) {
                    Class88 class317;
                    Class88 class316;
                    final Class88 class315;
                    final Class88 class314 = class315 = (class316 = (class317 = this.chars[n3]));
                    if (array == null) {
                        if (class314 == null && array == null) {
                            break Label_0219;
                        }
                        class317 = (class316 = class313);
                    }
                    if (array == null) {
                        if (class316 != null) {
                            n += class313.getKerning(n3);
                        }
                        class317 = class315;
                    }
                    class313 = class317;
                    final int n6 = i;
                    final int n7 = length - 1;
                    Label_0210: {
                        if (array == null) {
                            if (n6 < n7) {
                                n += class315.xadvance;
                                if (array == null) {
                                    break Label_0210;
                                }
                            }
                            final short width3 = class315.width;
                        }
                        n = n6 + n7;
                    }
                    max = Math.max(max, n);
                }
            }
            ++i;
            if (array != null) {
                break;
            }
        }
        final Class310 class318 = class310;
        if (array != null || class318 != null) {
            class318.width = new Short((short)max);
        }
        return max;
    }
    
    @Override
    public final int getLineHeight() {
        return this.lineHeight;
    }
    
    static Class310 access$002(final Class181 class181, final Class310 eldestDisplayList) {
        return class181.eldestDisplayList = eldestDisplayList;
    }
    
    static int access$102(final Class181 class181, final int eldestDisplayListID) {
        return class181.eldestDisplayListID = eldestDisplayListID;
    }
    
    static Class310 access$000(final Class181 class181) {
        return class181.eldestDisplayList;
    }
    
    static Class85 access$400(final Class181 class181) {
        return class181.fontImage;
    }
    
    static {
        lIIlllIIIIl();
        Class169.a(4845090156244976238L, 1068293715076168193L, MethodHandles.lookup().lookupClass()).a(128344195311854L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class181.llIllIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class181.llIllIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(3494979531452L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[9];
        int n2 = 0;
        String s;
        int n3 = (s = Class181.llIllIlll[2]).length();
        int n4 = 48;
        int n5 = -1;
    Label_0150:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class181.llIllIlll[4]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class181.llIllIlll[3]).length();
                            n4 = 16;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0150;
                        }
                    }
                    ++n5;
                    final String s4 = s;
                    final int n8 = n5;
                    s3 = s4.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        b = b2;
        c = new String[9];
        Class181.GL = Class110.get();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1A17;
        if (Class181.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class181.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class181.llIllIlll[5]);
                    array[1] = SecretKeyFactory.getInstance(Class181.llIllIlll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class181.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class181.llIllIlll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class181.c[n3] = a(((Cipher)array[0]).doFinal(Class181.b[n3].getBytes(Class181.llIllIlll[8])));
        }
        return Class181.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class181.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIlllIIIIl() {
        (llIllIlll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class181.llIllIlll[1] = "DES";
        Class181.llIllIlll[2] = "uÕý¾\u008cåKøÂfKè\u0091rd4\u0019\u0010`i²Ña¢¬ìç³\u0088É\u0003\u0093¼·¢A;Àú£¨z\u009d\u0012´\u0081\u0084ì\u0010¿ÂµqG³\u0086Trú\u0017ü\u009bYÂÇ(E\u009f\u0093²Ä\u0000\u0003f<\u0014\u0090yÇÊ\"\u0093\u0092Ó}\u009b@JH~¶Lö\u001cJ*\u0093®¤«ª^²Ï\u009eá\u0010;×ùúH¬\u008crÚ,[¹r,QcXR\u000bTC\tÈ¹FcÄ\u0002Ö\u0090»º¯¢u÷å3¡\u008fa|¢\u008cÎ¨ø>[f¸Ü\u000eù»¨ê~\u001f\u007f\u000b\u007f\"\u0017.\u001apÎ=§¥\u0019c\u0099¸£g\\Qµ\u008fÁ\u0006ô\u0093F¼n\u0016ýu»GÆ|\u00190a}\u0082\u009dyâ¶\u0088\u0010»P\u0003\u0082\u001d0\u009cÊ\\HëË{Ö4\u0084 \u0000ä\u009c\u0082ñG \u0088]Þ\t&9õnÌ\u009aKBå\tÌ\u0003Ìb\u00065Z³÷\u00adì";
        Class181.llIllIlll[3] = "÷\tÚR\u008f©Ê{«Úe4Ö\u001c»í\u0010Æ¨~ÍVé\u008cÐx®^#j6NM";
        Class181.llIllIlll[4] = "ISO-8859-1";
        Class181.llIllIlll[5] = "DES/CBC/PKCS5Padding";
        Class181.llIllIlll[6] = "DES";
        Class181.llIllIlll[7] = "非想闹个笑话给网络上的人看看你如何的自导自演你就是死皮赖脸的小伙子是不是这样你告诉我你的心是否正在狂速的跳动你那破烂程序能打出象样的华丽唠嗑吗我知道无论用多么华丽的NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003 \u2002\u200a";
        Class181.llIllIlll[8] = "ISO-8859-1";
        Class181.llIllIlll[9] = "非想闹个笑话给网络上的人看看你如何的自导自演你就是死皮赖脸的小伙子是不是这样你告诉我你的心是否正在狂速的跳动你那破烂程序能打出象样的华丽唠嗑吗我知道无论用多么华丽的NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003 \u2002\u200a";
        Class181.llIllIlll[10] = " : ";
        Class181.llIllIlll[11] = " : ";
    }
    
    private static String lIIllIIlIIl(final String s, final String s2) {
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
    
    private static String lIIllIIlIII(String s, final String s2) {
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
    
    private static String lIIllIlllII(final String s, final String s2) {
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
    
    private static boolean lIIlllIlIll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIlllIllII(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIIlllIIlll$255f299(final int n) {
        return n > 255;
    }
    
    private static boolean lIIlllIIllI(final int n) {
        return n < 0;
    }
    
    private static boolean lIIlllIlIII(final int n, final int n2) {
        return n != n2;
    }
}
