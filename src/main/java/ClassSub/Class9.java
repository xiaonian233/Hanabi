package ClassSub;

import cn.Hanabi.modules.*;
import cn.Hanabi.*;
import java.awt.*;
import org.lwjgl.input.*;

public class Class9
{
    public Class146 thisTrack;
    public int windowWidth;
    public int windowHeight;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class9(final Class146 thisTrack, final int windowWidth, final int windowHeight) {
        super();
        this.thisTrack = thisTrack;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }
    
    public void draw(final int n, final int n2) {
        final Class218 class218 = (Class218)ModManager.getModule("HUD");
        class218.drawRoundedRect(n, n2, n + this.windowWidth - 8, n2 + 15, Class59.GREY.c, Class59.GREY.c);
        Hanabi.INSTANCE.fontManager.wqy18.drawString(this.thisTrack.getName(), n + 30.0f, n2 + 2, -1);
        class218.drawRoundedRect(n + this.windowWidth - 34, n2, n + this.windowWidth - 8, n2 + 15, new Color(Class59.GREY.c).brighter().getRGB(), new Color(Class59.GREY.c).brighter().getRGB());
        Hanabi.INSTANCE.fontManager.wqy18.drawString("播放", n + this.windowWidth - 30.0f, n2 + 2, -1);
    }
    
    public void onClick(final int n, final int n2, final int n3, final int n4) {
        if (Mouse.isButtonDown(0) && this.isHovering(n, n2, n3 + this.windowWidth - 34, n4, n3 + this.windowWidth - 8, n4 + 15)) {
            Hanabi.INSTANCE.musicMgr.play(this.thisTrack);
        }
    }
    
    private boolean isHovering(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return n > n3 && n < n5 && n2 > n4 && n2 < n6;
    }
}
