package ClassSub;

import java.util.*;
import org.lwjgl.*;

public class Class173 implements Class270
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
    private Class13 spriteSheet;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class173() {
        this(true);
    }
    
    public Class173(final Class140[] array, final int n) {
        this(array, n, true);
    }
    
    public Class173(final Class140[] array, final int[] array2) {
        this(array, array2, true);
    }
    
    public Class173(final boolean autoUpdate) {
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
        this.autoUpdate = autoUpdate;
    }
    
    public Class173(final Class140[] array, final int n, final boolean autoUpdate) {
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
        for (int i = 0; i < array.length; ++i) {
            this.addFrame(array[i], n);
        }
        this.currentFrame = 0;
        this.autoUpdate = autoUpdate;
    }
    
    public Class173(final Class140[] array, final int[] array2, final boolean autoUpdate) {
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
        this.autoUpdate = autoUpdate;
        if (array.length != array2.length) {
            throw new RuntimeException("There must be one duration per frame");
        }
        for (int i = 0; i < array.length; ++i) {
            this.addFrame(array[i], array2[i]);
        }
        this.currentFrame = 0;
    }
    
    public Class173(final Class13 class13, final int n) {
        this(class13, 0, 0, class13.getHorizontalCount() - 1, class13.getVerticalCount() - 1, true, n, true);
    }
    
    public Class173(final Class13 class13, final int n, final int n2, final int n3, final int n4, final boolean b, final int n5, final boolean autoUpdate) {
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
        this.autoUpdate = autoUpdate;
        if (!b) {
            for (int i = n; i <= n3; ++i) {
                for (int j = n2; j <= n4; ++j) {
                    this.addFrame(class13.getSprite(i, j), n5);
                }
            }
        }
        else {
            for (int k = n2; k <= n4; ++k) {
                for (int l = n; l <= n3; ++l) {
                    this.addFrame(class13.getSprite(l, k), n5);
                }
            }
        }
    }
    
    public Class173(final Class13 spriteSheet, final int[] array, final int[] array2) {
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
        this.spriteSheet = spriteSheet;
        for (int i = 0; i < array.length / 2; ++i) {
            this.addFrame(array2[i], array[i * 2], array[i * 2 + 1]);
        }
    }
    
    public void addFrame(final int n, final int n2, final int n3) {
        if (n == 0) {
            Class121.error("Invalid duration: " + n);
            throw new RuntimeException("Invalid duration: " + n);
        }
        if (this.frames.isEmpty()) {
            this.nextChange = (int)(n / this.speed);
        }
        this.frames.add(new Class234(n, n2, n3));
        this.currentFrame = 0;
    }
    
    public void setAutoUpdate(final boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }
    
    public void setPingPong(final boolean pingPong) {
        this.pingPong = pingPong;
    }
    
    public boolean isStopped() {
        return this.stopped;
    }
    
    public void setSpeed(final float speed) {
        if (speed > 0.0f) {
            this.nextChange = (long)(this.nextChange * this.speed / speed);
            this.speed = speed;
        }
    }
    
    public float getSpeed() {
        return this.speed;
    }
    
    public void stop() {
        if (this.frames.size() == 0) {
            return;
        }
        this.timeLeft = this.nextChange;
        this.stopped = true;
    }
    
    public void start() {
        if (!this.stopped) {
            return;
        }
        if (this.frames.size() == 0) {
            return;
        }
        this.stopped = false;
        this.nextChange = this.timeLeft;
    }
    
    public void restart() {
        if (this.frames.size() == 0) {
            return;
        }
        this.stopped = false;
        this.currentFrame = 0;
        this.nextChange = (int)(((Class234)this.frames.get(0)).duration / this.speed);
        this.firstUpdate = true;
        this.lastUpdate = 0L;
    }
    
    public void addFrame(final Class140 class140, final int n) {
        if (n == 0) {
            Class121.error("Invalid duration: " + n);
            throw new RuntimeException("Invalid duration: " + n);
        }
        if (this.frames.isEmpty()) {
            this.nextChange = (int)(n / this.speed);
        }
        this.frames.add(new Class234(class140, n));
        this.currentFrame = 0;
    }
    
    public void draw() {
        this.draw(0.0f, 0.0f);
    }
    
    @Override
    public void draw(final float n, final float n2) {
        this.draw(n, n2, this.getWidth(), this.getHeight());
    }
    
    public void draw(final float n, final float n2, final Class278 class278) {
        this.draw(n, n2, this.getWidth(), this.getHeight(), class278);
    }
    
    public void draw(final float n, final float n2, final float n3, final float n4) {
        this.draw(n, n2, n3, n4, Class278.white);
    }
    
    public void draw(final float n, final float n2, final float n3, final float n4, final Class278 class278) {
        if (this.frames.size() == 0) {
            return;
        }
        if (this.autoUpdate) {
            final long time = this.getTime();
            long n5 = time - this.lastUpdate;
            if (this.firstUpdate) {
                n5 = 0L;
                this.firstUpdate = false;
            }
            this.lastUpdate = time;
            this.nextFrame(n5);
        }
        ((Class234)this.frames.get(this.currentFrame)).image.draw(n, n2, n3, n4, class278);
    }
    
    public void renderInUse(final int n, final int n2) {
        if (this.frames.size() == 0) {
            return;
        }
        if (this.autoUpdate) {
            final long time = this.getTime();
            long n3 = time - this.lastUpdate;
            if (this.firstUpdate) {
                n3 = 0L;
                this.firstUpdate = false;
            }
            this.lastUpdate = time;
            this.nextFrame(n3);
        }
        final Class234 class234 = (Class234)this.frames.get(this.currentFrame);
        this.spriteSheet.renderInUse(n, n2, class234.x, class234.y);
    }
    
    public int getWidth() {
        return ((Class234)this.frames.get(this.currentFrame)).image.getWidth();
    }
    
    public int getHeight() {
        return ((Class234)this.frames.get(this.currentFrame)).image.getHeight();
    }
    
    public void drawFlash(final float n, final float n2, final float n3, final float n4) {
        this.drawFlash(n, n2, n3, n4, Class278.white);
    }
    
    public void drawFlash(final float n, final float n2, final float n3, final float n4, final Class278 class278) {
        if (this.frames.size() == 0) {
            return;
        }
        if (this.autoUpdate) {
            final long time = this.getTime();
            long n5 = time - this.lastUpdate;
            if (this.firstUpdate) {
                n5 = 0L;
                this.firstUpdate = false;
            }
            this.lastUpdate = time;
            this.nextFrame(n5);
        }
        ((Class234)this.frames.get(this.currentFrame)).image.drawFlash(n, n2, n3, n4, class278);
    }
    
    public void updateNoDraw() {
        if (this.autoUpdate) {
            final long time = this.getTime();
            long n = time - this.lastUpdate;
            if (this.firstUpdate) {
                n = 0L;
                this.firstUpdate = false;
            }
            this.lastUpdate = time;
            this.nextFrame(n);
        }
    }
    
    public void update(final long n) {
        this.nextFrame(n);
    }
    
    public int getFrame() {
        return this.currentFrame;
    }
    
    public void setCurrentFrame(final int currentFrame) {
        this.currentFrame = currentFrame;
    }
    
    public Class140 getImage(final int n) {
        return ((Class234)this.frames.get(n)).image;
    }
    
    public int getFrameCount() {
        return this.frames.size();
    }
    
    public Class140 getCurrentFrame() {
        return ((Class234)this.frames.get(this.currentFrame)).image;
    }
    
    private void nextFrame(final long n) {
        if (this.stopped) {
            return;
        }
        if (this.frames.size() == 0) {
            return;
        }
        this.nextChange -= n;
        while (this.nextChange < 0L && !this.stopped) {
            if (this.currentFrame == this.stopAt) {
                this.stopped = true;
                break;
            }
            if (this.currentFrame == this.frames.size() - 1 && !this.loop && !this.pingPong) {
                this.stopped = true;
                break;
            }
            this.currentFrame = (this.currentFrame + this.direction) % this.frames.size();
            if (this.pingPong) {
                if (this.currentFrame <= 0) {
                    this.currentFrame = 0;
                    this.direction = 1;
                    if (!this.loop) {
                        this.stopped = true;
                        break;
                    }
                }
                else if (this.currentFrame >= this.frames.size() - 1) {
                    this.currentFrame = this.frames.size() - 1;
                    this.direction = -1;
                }
            }
            this.nextChange += (int)(((Class234)this.frames.get(this.currentFrame)).duration / this.speed);
        }
    }
    
    public void setLooping(final boolean loop) {
        this.loop = loop;
    }
    
    private long getTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }
    
    public void stopAt(final int stopAt) {
        this.stopAt = stopAt;
    }
    
    public int getDuration(final int n) {
        return ((Class234)this.frames.get(n)).duration;
    }
    
    public void setDuration(final int n, final int duration) {
        ((Class234)this.frames.get(n)).duration = duration;
    }
    
    public int[] getDurations() {
        final int[] array = new int[this.frames.size()];
        for (int i = 0; i < this.frames.size(); ++i) {
            array[i] = this.getDuration(i);
        }
        return array;
    }
    
    @Override
    public String toString() {
        String s = "[Animation (" + this.frames.size() + ") ";
        for (int i = 0; i < this.frames.size(); ++i) {
            s = s + ((Class234)this.frames.get(i)).duration + ",";
        }
        return s + "]";
    }
    
    public Class173 copy() {
        final Class173 class173 = new Class173();
        class173.spriteSheet = this.spriteSheet;
        class173.frames = this.frames;
        class173.autoUpdate = this.autoUpdate;
        class173.direction = this.direction;
        class173.loop = this.loop;
        class173.pingPong = this.pingPong;
        class173.speed = this.speed;
        return class173;
    }
    
    static Class13 access$000(final Class173 class173) {
        return class173.spriteSheet;
    }
}
