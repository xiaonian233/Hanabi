package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import ClassSub.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import cn.Hanabi.injection.interfaces.*;

public class NoFall extends Mod
{
    private float b;
    private boolean c;
    private int d;
    private Value mode;
    public Class191 timer;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public NoFall() {
        super("NoFall", Category.PLAYER);
        this.b = 1.0f;
        this.c = true;
        this.mode = new Value("NoFall", "Mode", 0);
        this.timer = new Class191();
        this.mode.mode.add("Hypixel");
        this.mode.mode.add("Mineplex");
        this.mode.mode.add("AAC");
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate eventUpdate) {
        if (Class69.username.length() < 1) {
            System.exit(0);
        }
        if (this.mode.isCurrentMode("Hypixel")) {
            this.setDisplayName("Hypixel");
        }
        else if (this.mode.isCurrentMode("Mineplex")) {
            this.setDisplayName("Mineplex");
            if (NoFall.mc.field_71439_g.field_70143_R > 2.5f) {
                NoFall.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer(true));
                NoFall.mc.field_71439_g.field_70143_R = 0.5f;
            }
        }
    }
    
    @EventTarget
    public void onPacket(final EventPacket eventPacket) {
        if (this.mode.isCurrentMode("Hypixel")) {
            this.setDisplayName("Hypixel");
            if (eventPacket.getPacket() instanceof C03PacketPlayer && NoFall.mc.field_71439_g.field_70143_R > 3.0f) {
                ((IC03PacketPlayer)eventPacket.packet).setOnGround(true);
            }
        }
        else if (this.mode.isCurrentMode("AAC") && eventPacket.getPacket() instanceof C03PacketPlayer && NoFall.mc.field_71439_g.field_70143_R > 3.0f && this.timer.isDelayComplete(200L)) {
            NoFall.mc.field_71439_g.field_70143_R = 0.5f;
            this.timer.reset();
            NoFall.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(NoFall.mc.field_71439_g.field_70165_t, Double.NaN, NoFall.mc.field_71439_g.field_70161_v, true));
        }
    }
}
