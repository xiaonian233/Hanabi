package ClassSub;

import org.lwjgl.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class187 implements Class299
{
    private ArrayList frames;
    private int currentFrame;
    private long nextChange;
    private boolean stopped;
    private long timeLeft;
    private float speed;
    private int stopAt;
    private long lastUpdate;
    private boolean firstUpdate;
    private boolean autoUpdate;
    private int direction;
    private boolean pingPong;
    private boolean loop;
    private Class28 spriteSheet;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIllIlllll;
    
    public Class187() {
        this((byte)0);
    }
    
    private Class187(final Class85[] array, final int n) {
        this(array, n, (byte)0);
    }
    
    private Class187(final Class85[] array, final int[] array2) {
        this(array, array2, (byte)0);
    }
    
    private Class187(final byte b) {
        super();
        this.frames = new ArrayList();
        this.currentFrame = -1;
        this.nextChange = 0L;
        this.stopped = false;
        this.speed = 1.0f;
        this.stopAt = -2;
        this.firstUpdate = true;
        this.autoUpdate = true;
        this.direction = 1;
        this.loop = true;
        this.spriteSheet = null;
        this.currentFrame = 0;
        this.autoUpdate = true;
    }
    
    private Class187(final Class85[] array, final int n, final byte b) {
        super();
        this.frames = new ArrayList();
        final int[] b2 = Class139.b();
        this.currentFrame = -1;
        this.nextChange = 0L;
        final int[] array2 = b2;
        this.stopped = false;
        this.speed = 1.0f;
        this.stopAt = -2;
        this.firstUpdate = true;
        this.autoUpdate = true;
        this.direction = 1;
        this.loop = true;
        this.spriteSheet = null;
        int i = 0;
        while (i < array.length) {
            this.addFrame(array[i], n);
            ++i;
            if (array2 != null) {
                return;
            }
            if (array2 != null) {
                break;
            }
        }
        this.currentFrame = 0;
        this.autoUpdate = true;
    }
    
    private Class187(final Class85[] array, final int[] array2, final byte b) {
        super();
        this.frames = new ArrayList();
        this.currentFrame = -1;
        this.nextChange = 0L;
        this.stopped = false;
        this.speed = 1.0f;
        this.stopAt = -2;
        this.firstUpdate = true;
        this.autoUpdate = true;
        this.direction = 1;
        final int[] b2 = Class139.b();
        this.loop = true;
        final int[] array3 = b2;
        this.spriteSheet = null;
        this.autoUpdate = true;
        final int length = array.length;
        if (array3 == null && length != array2.length) {
            throw new RuntimeException("There must be one duration per frame");
        }
        int i = length;
        while (i < array.length) {
            this.addFrame(array[i], array2[i]);
            ++i;
            if (array3 != null) {
                return;
            }
            if (array3 != null) {
                break;
            }
        }
        this.currentFrame = 0;
    }
    
    private Class187(final Class28 class28, final int n) {
        this(class28, class28.getHorizontalCount() - 1, class28.getVerticalCount() - 1, n);
    }
    
    private Class187(final Class28 class28, final int n, final int n2, final int n3) {
        super();
        final int[] b = Class139.b();
        this.frames = new ArrayList();
        this.currentFrame = -1;
        final int[] array = b;
        this.nextChange = 0L;
        this.stopped = false;
        this.speed = 1.0f;
        this.stopAt = -2;
        this.firstUpdate = true;
        this.autoUpdate = true;
        this.direction = 1;
        this.loop = true;
        this.spriteSheet = null;
        this.autoUpdate = true;
        int n4 = 1;
        if (array == null) {
            n4 = 0;
        }
        int n5 = n4;
    Label_0137_Outer:
        while (lIIIlIIIllII(n5, n2)) {
            int n6 = 0;
            while (true) {
                while (lIIIlIIIllII(n6, n)) {
                    this.addFrame(class28.getSprite(n6, n5), n3);
                    ++n6;
                    if (array == null) {
                        if (array != null) {
                            break;
                        }
                        continue Label_0137_Outer;
                    }
                    else {
                        if (array != null) {
                            break Label_0137_Outer;
                        }
                        continue Label_0137_Outer;
                    }
                }
                ++n5;
                continue;
            }
        }
    }
    
    private Class187(final Class28 spriteSheet, final int[] array, final int[] array2) {
        super();
        final int[] b = Class139.b();
        this.frames = new ArrayList();
        this.currentFrame = -1;
        this.nextChange = 0L;
        this.stopped = false;
        final int[] array3 = b;
        this.speed = 1.0f;
        this.stopAt = -2;
        this.firstUpdate = true;
        this.autoUpdate = true;
        this.direction = 1;
        this.loop = true;
        this.spriteSheet = null;
        this.spriteSheet = spriteSheet;
        int i = 0;
        while (i < array.length / 2) {
            final int n = array[i * 2];
            final int n2 = array[i * 2 + 1];
            final int n3 = array2[i];
            final int n4 = n;
            final int n5 = n2;
            final int n6 = n4;
            final int n7 = n3;
            final int[] b2 = Class139.b();
            final int n8 = n7;
            if (b2 == null) {
                if (n8 == 0) {
                    Class355.error(String.valueOf(new StringBuilder("Invalid duration: ").append(n7)));
                    throw new RuntimeException(String.valueOf(new StringBuilder("Invalid duration: ").append(n7)));
                }
                this.frames.isEmpty();
            }
            if (b2 == null) {
                if (n8 != 0) {
                    this.nextChange = (int)(n7 / this.speed);
                }
                this.frames.add(new Class67(this, n7, n6, n5));
            }
            this.currentFrame = 0;
            ++i;
            if (array3 != null) {
                break;
            }
        }
    }
    
    private void addFrame(final int n, final int n2, final int n3) {
        final int[] b = Class139.b();
        boolean empty = n != 0;
        if (b == null) {
            if (n == 0) {
                Class355.error(String.valueOf(new StringBuilder("Invalid duration: ").append(n)));
                throw new RuntimeException(String.valueOf(new StringBuilder("Invalid duration: ").append(n)));
            }
            empty = this.frames.isEmpty();
        }
        if (b == null) {
            if (empty) {
                this.nextChange = (int)(n / this.speed);
            }
            this.frames.add(new Class67(this, n, n2, n3));
        }
        this.currentFrame = 0;
    }
    
    private void setAutoUpdate(final boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }
    
    private void setPingPong(final boolean pingPong) {
        this.pingPong = pingPong;
    }
    
    private boolean isStopped() {
        return this.stopped;
    }
    
    private void setSpeed(final float speed) {
        if (Class139.b() == null) {
            if (speed <= 0.0f) {
                return;
            }
            this.nextChange = (long)(this.nextChange * this.speed / speed);
        }
        this.speed = speed;
    }
    
    private float getSpeed() {
        return this.speed;
    }
    
    private void stop() {
        final int[] b = Class139.b();
        Class187 class187 = this;
        if (b == null) {
            if (this.frames.size() == 0) {
                return;
            }
            this.timeLeft = this.nextChange;
            class187 = this;
        }
        class187.stopped = true;
    }
    
    private void start() {
        final int[] b = Class139.b();
        int n;
        final boolean b2 = (n = (this.stopped ? 1 : 0)) != 0;
        Class187 class187 = null;
        Label_0037: {
            if (b == null) {
                if (!b2) {
                    return;
                }
                class187 = this;
                if (b != null) {
                    break Label_0037;
                }
                n = this.frames.size();
            }
            if (n == 0) {
                return;
            }
            this.stopped = false;
            class187 = this;
        }
        class187.nextChange = this.timeLeft;
    }
    
    private void restart() {
        final int[] b = Class139.b();
        Class187 class187 = this;
        if (b == null) {
            if (this.frames.size() == 0) {
                return;
            }
            this.stopped = false;
            this.currentFrame = 0;
            this.nextChange = (int)(this.frames.get(0).duration / this.speed);
            this.firstUpdate = true;
            class187 = this;
        }
        class187.lastUpdate = 0L;
    }
    
    private void addFrame(final Class85 class85, final int n) {
        final int[] b = Class139.b();
        boolean empty = n != 0;
        if (b == null) {
            if (n == 0) {
                Class355.error(String.valueOf(new StringBuilder("Invalid duration: ").append(n)));
                throw new RuntimeException(String.valueOf(new StringBuilder("Invalid duration: ").append(n)));
            }
            empty = this.frames.isEmpty();
        }
        if (b == null) {
            if (empty) {
                this.nextChange = (int)(n / this.speed);
            }
            this.frames.add(new Class67(class85, n));
        }
        this.currentFrame = 0;
    }
    
    private void draw() {
        this.draw(0.0f, 0.0f);
    }
    
    @Override
    public final void draw(final float n, final float n2) {
        this.draw(n, n2, this.getWidth(), this.getHeight());
    }
    
    private void draw(final float n, final float n2, final Class286 class286) {
        this.draw(n, n2, this.getWidth(), this.getHeight(), class286);
    }
    
    private void draw(final float n, final float n2, final float n3, final float n4) {
        this.draw(n, n2, n3, n4, Class286.white);
    }
    
    public final void draw(final float n, final float n2, final float n3, final float n4, final Class286 class286) {
        final int[] b = Class139.b();
        final int size = this.frames.size();
        Object value = null;
        Label_0089: {
            if (b == null) {
                if (size == 0) {
                    return;
                }
                value = this;
                if (b != null) {
                    break Label_0089;
                }
                final boolean autoUpdate = this.autoUpdate;
            }
            if (size != 0) {
                final long time;
                long n5 = (time = getTime()) - this.lastUpdate;
                Class187 class287 = this;
                if (b == null) {
                    if (this.firstUpdate) {
                        n5 = 0L;
                        this.firstUpdate = false;
                    }
                    this.lastUpdate = time;
                    class287 = this;
                }
                class287.nextFrame(n5);
            }
            value = this.frames.get(this.currentFrame);
        }
        ((Class67)value).image.draw(n, n2, n3, n4, class286);
    }
    
    private void renderInUse(final int n, int n2) {
        final int[] b = Class139.b();
        final int size = this.frames.size();
        Object value = null;
        Label_0085: {
            if (b == null) {
                if (size == 0) {
                    return;
                }
                value = this;
                if (b != null) {
                    break Label_0085;
                }
                final boolean autoUpdate = this.autoUpdate;
            }
            if (size != 0) {
                final long time;
                long n3 = (time = getTime()) - this.lastUpdate;
                Class187 class187 = this;
                if (b == null) {
                    if (this.firstUpdate) {
                        n3 = 0L;
                        this.firstUpdate = false;
                    }
                    this.lastUpdate = time;
                    class187 = this;
                }
                class187.nextFrame(n3);
            }
            value = this.frames.get(this.currentFrame);
        }
        final Class67 class188 = (Class67)value;
        final Class28 spriteSheet = this.spriteSheet;
        final int n4 = n2;
        final int x = class188.x;
        final int y = class188.y;
        final int n5 = x;
        final int n6 = n4;
        n2 = n;
        final Class28 class189 = spriteSheet;
        spriteSheet.subImages[n5][y].drawEmbedded(n2, n6, class189.tw, class189.th);
    }
    
    public final int getWidth() {
        return this.frames.get(this.currentFrame).image.getWidth();
    }
    
    public final int getHeight() {
        return this.frames.get(this.currentFrame).image.getHeight();
    }
    
    private void drawFlash(final float n, float n2, float n3, float n4) {
        final float n5 = n2;
        final float n6 = n3;
        final float n7 = n4;
        final Class286 white = Class286.white;
        final float n8 = n7;
        n4 = n6;
        n3 = n5;
        n2 = n;
        final int[] b = Class139.b();
        final int size = this.frames.size();
        Object value = null;
        Label_0106: {
            if (b == null) {
                if (size == 0) {
                    return;
                }
                value = this;
                if (b != null) {
                    break Label_0106;
                }
                final boolean autoUpdate = this.autoUpdate;
            }
            if (size != 0) {
                final long time;
                long n9 = (time = getTime()) - this.lastUpdate;
                Class187 class187 = this;
                if (b == null) {
                    if (this.firstUpdate) {
                        n9 = 0L;
                        this.firstUpdate = false;
                    }
                    this.lastUpdate = time;
                    class187 = this;
                }
                class187.nextFrame(n9);
            }
            value = this.frames.get(this.currentFrame);
        }
        ((Class67)value).image.drawFlash(n2, n3, n4, n8, white);
    }
    
    private void drawFlash(final float n, final float n2, final float n3, final float n4, final Class286 class286) {
        final int[] b = Class139.b();
        final int size = this.frames.size();
        Object value = null;
        Label_0089: {
            if (b == null) {
                if (size == 0) {
                    return;
                }
                value = this;
                if (b != null) {
                    break Label_0089;
                }
                final boolean autoUpdate = this.autoUpdate;
            }
            if (size != 0) {
                final long time;
                long n5 = (time = getTime()) - this.lastUpdate;
                Class187 class287 = this;
                if (b == null) {
                    if (this.firstUpdate) {
                        n5 = 0L;
                        this.firstUpdate = false;
                    }
                    this.lastUpdate = time;
                    class287 = this;
                }
                class287.nextFrame(n5);
            }
            value = this.frames.get(this.currentFrame);
        }
        ((Class67)value).image.drawFlash(n, n2, n3, n4, class286);
    }
    
    private void updateNoDraw() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_1       
        //     4: aload_0        
        //     5: aload_1        
        //     6: ifnonnull       15
        //     9: getfield        ClassSub/Class187.autoUpdate:Z
        //    12: ifeq            58
        //    15: pop            
        //    16: invokestatic    ClassSub/Class187.getTime:()J
        //    19: dup2           
        //    20: lstore_2       
        //    21: aload_0        
        //    22: getfield        ClassSub/Class187.lastUpdate:J
        //    25: lsub           
        //    26: lstore          4
        //    28: aload_0        
        //    29: aload_1        
        //    30: ifnonnull       53
        //    33: getfield        ClassSub/Class187.firstUpdate:Z
        //    36: ifeq            47
        //    39: lconst_0       
        //    40: lstore          4
        //    42: aload_0        
        //    43: iconst_0       
        //    44: putfield        ClassSub/Class187.firstUpdate:Z
        //    47: aload_0        
        //    48: lload_2        
        //    49: putfield        ClassSub/Class187.lastUpdate:J
        //    52: aload_0        
        //    53: lload           4
        //    55: invokespecial   ClassSub/Class187.nextFrame:(J)V
        //    58: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0015 (coming from #0012).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2181)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
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
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void update(final long n) {
        this.nextFrame(n);
    }
    
    private int getFrame() {
        return this.currentFrame;
    }
    
    private void setCurrentFrame(final int currentFrame) {
        this.currentFrame = currentFrame;
    }
    
    private Class85 getImage(final int n) {
        return this.frames.get(n).image;
    }
    
    private int getFrameCount() {
        return this.frames.size();
    }
    
    private Class85 getCurrentFrame() {
        return this.frames.get(this.currentFrame).image;
    }
    
    private void nextFrame(final long n) {
        final int[] b = Class139.b();
        int n2;
        final boolean b2 = (n2 = (this.stopped ? 1 : 0)) != 0;
        Class187 class187 = null;
        Class187 class188 = null;
        Label_0032: {
            if (b == null) {
                if (b2) {
                    return;
                }
                class187 = this;
                class188 = this;
                if (b != null) {
                    break Label_0032;
                }
                n2 = this.frames.size();
            }
            if (n2 == 0) {
                return;
            }
            class187 = this;
            class188 = this;
        }
        class187.nextChange = class188.nextChange - n;
        while (this.nextChange < 0L) {
            int stopped;
            int currentFrame;
            final int n3 = currentFrame = (stopped = (this.stopped ? 1 : 0));
            if (b == null) {
                if (n3 != 0) {
                    break;
                }
                stopped = (currentFrame = this.currentFrame);
            }
            final int stopAt = this.stopAt;
            int n4 = 0;
            int pingPong = 0;
            Label_0169: {
                if (b == null) {
                    if (currentFrame == stopAt) {
                        this.stopped = true;
                        if (b == null) {
                            break;
                        }
                    }
                    pingPong = (stopped = (n4 = this.currentFrame));
                    if (b != null) {
                        break Label_0169;
                    }
                    final int n5 = this.frames.size() - 1;
                }
                if (stopped == stopAt) {
                    final int n6 = pingPong = (n4 = (this.loop ? 1 : 0));
                    if (b != null) {
                        break Label_0169;
                    }
                    if (n6 == 0) {
                        final int n7 = pingPong = (n4 = (this.pingPong ? 1 : 0));
                        if (b != null) {
                            break Label_0169;
                        }
                        if (n7 == 0) {
                            this.stopped = true;
                            if (b == null) {
                                break;
                            }
                        }
                    }
                }
                this.currentFrame = (this.currentFrame + this.direction) % this.frames.size();
                n4 = (pingPong = (this.pingPong ? 1 : 0));
            }
            Label_0290: {
                if (b == null) {
                    Label_0266: {
                        if (pingPong != 0) {
                            final int n8 = n4 = this.currentFrame;
                            if (b == null) {
                                if (n8 <= 0) {
                                    this.currentFrame = 0;
                                    this.direction = 1;
                                    final boolean b3 = (n4 = (this.loop ? 1 : 0)) != 0;
                                    if (b != null) {
                                        break Label_0290;
                                    }
                                    if (b3) {
                                        break Label_0266;
                                    }
                                    this.stopped = true;
                                    if (b == null) {
                                        break;
                                    }
                                }
                                final int currentFrame2;
                                n4 = (currentFrame2 = this.currentFrame);
                            }
                            if (b != null) {
                                break Label_0290;
                            }
                            if (lIIIlIIlIlIl(n8, this.frames.size() - 1)) {
                                this.currentFrame = this.frames.size() - 1;
                                this.direction = -1;
                            }
                        }
                    }
                    n4 = (int)(this.frames.get(this.currentFrame).duration / this.speed);
                }
            }
            this.nextChange += n4;
            if (b != null) {
                break;
            }
        }
    }
    
    private void setLooping(final boolean loop) {
        this.loop = loop;
    }
    
    private static long getTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }
    
    private void stopAt(final int stopAt) {
        this.stopAt = stopAt;
    }
    
    private int getDuration(final int n) {
        return this.frames.get(n).duration;
    }
    
    private void setDuration(final int n, final int duration) {
        this.frames.get(n).duration = duration;
    }
    
    private int[] getDurations() {
        final int[] array = new int[this.frames.size()];
        final int[] b = Class139.b();
        int i = 0;
        final int[] array2 = b;
        int[] array3 = null;
        while (i < this.frames.size()) {
            array3 = array;
            if (array2 != null) {
                return array3;
            }
            array3[i] = this.frames.get(i).duration;
            ++i;
            if (array2 != null) {
                break;
            }
        }
        return array3;
    }
    
    @Override
    public final String toString() {
        String s = String.valueOf(new StringBuilder("[Animation (").append(this.frames.size()).append(") "));
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (i < this.frames.size()) {
            s = String.valueOf(new StringBuilder().append(s).append(((Class67)this.frames.get(i)).duration).append(Class187.lIllIlllll[0]));
            ++i;
            if (array != null) {
                return s;
            }
            if (array != null) {
                break;
            }
        }
        s = String.valueOf(new StringBuilder().append(s).append(Class187.lIllIlllll[1]));
        return s;
    }
    
    private Class187 copy() {
        final Class187 class187;
        (class187 = new Class187()).spriteSheet = this.spriteSheet;
        class187.frames = this.frames;
        class187.autoUpdate = this.autoUpdate;
        class187.direction = this.direction;
        class187.loop = this.loop;
        class187.pingPong = this.pingPong;
        class187.speed = this.speed;
        return class187;
    }
    
    static Class28 access$000(final Class187 class187) {
        return class187.spriteSheet;
    }
    
    static {
        lIIIIllllIlI();
        Class169.a(5753341761784831037L, 2458219246339992557L, MethodHandles.lookup().lookupClass()).a(248109301602451L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class187.lIllIlllll[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class187.lIllIlllll[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(14756713723219L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class187.lIllIlllll[4]).length();
        int n4 = 16;
        int n5 = -1;
    Label_0152:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class187.lIllIlllll[6]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class187.lIllIlllll[5]).length();
                            n4 = 40;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0152;
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
        c = new String[5];
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x3980;
        if (Class187.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class187.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class187.lIllIlllll[7]);
                    array[1] = SecretKeyFactory.getInstance(Class187.lIllIlllll[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class187.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class187.lIllIlllll[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class187.c[n3] = a(((Cipher)array[0]).doFinal(Class187.b[n3].getBytes(Class187.lIllIlllll[10])));
        }
        return Class187.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class187.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIIllllIlI() {
        (lIllIlllll = new String[14])[0] = ",";
        Class187.lIllIlllll[1] = "]";
        Class187.lIllIlllll[2] = "DES/CBC/PKCS5Padding";
        Class187.lIllIlllll[3] = "DES";
        Class187.lIllIlllll[4] = "l\u009epö=67¼E´\bØ{Y\u0098\u001f ú@\u0091þî\u0017{A\u0001yi½6ê²/äü\u008b êÓ\u009eàÀ\t_8 .\u008a\u001b@Ò?}\u0019Ðeü\u0006ô¨A¸TâÄ]½\u0082wÔBÜ&Ú@'\u0010L\u00991\u0017ôQFB\u0080èÏ\u008cLÛ\u0012µÞ°Mõè8\u009b<åAÊ/w\u0007^zM\u0098\u000e5\u0080";
        Class187.lIllIlllll[5] = "@\u0085éT\u0006«}L\t\u0093wlß\"\u0010W±ÅÁAì¬« É®\u0016ÄÓ\t\u0002\u001cø\u0018ÔD\u0012\u0082;ù(\u0093+\u0002ý\u0004C\u001fP\u0087ål\u0004$-ëI¼\u00adx\u0019ûÇN\"\u000e/¥!Ö\u0014R:\u0014ð_ZÔS<\u0086";
        Class187.lIllIlllll[6] = "ISO-8859-1";
        Class187.lIllIlllll[7] = "DES/CBC/PKCS5Padding";
        Class187.lIllIlllll[8] = "DES";
        Class187.lIllIlllll[9] = "爹爹警告过你不要一再挑衅我的耐心你不听忠告我给你证据你要吗你以为你爹爹我会为此心情有一丝丝浮动是吗你看看你苟延残喘的啊你是不是莫名其妙怎么就滚了啊就你这窝囊废样子你还想揍倒我吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u200f\u200e\u200b";
        Class187.lIllIlllll[10] = "ISO-8859-1";
        Class187.lIllIlllll[11] = "爹爹警告过你不要一再挑衅我的耐心你不听忠告我给你证据你要吗你以为你爹爹我会为此心情有一丝丝浮动是吗你看看你苟延残喘的啊你是不是莫名其妙怎么就滚了啊就你这窝囊废样子你还想揍倒我吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u200f\u200e\u200b";
        Class187.lIllIlllll[12] = " : ";
        Class187.lIllIlllll[13] = " : ";
    }
    
    private static String lIIIIllllIIl(String s, final String s2) {
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
    
    private static String lIIIIllIllll(final String s, final String s2) {
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
    
    private static String lIIIIlllIIII(final String s, final String s2) {
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
    
    private static boolean lIIIlIIlIlIl(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIlIIIllII(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIIIlIIlIIlI(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIlIIlIlII(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIIlIIlIIII(final int n) {
        return n > 0;
    }
    
    private static boolean lIIIlIIIlIlI(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lIIIlIIIlllI$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIlIIlIIIl$2566aa8(final long n) {
        return lcmp(n, 0L);
    }
}
