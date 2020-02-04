package cn.Hanabi.modules.World;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.client.entity.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.item.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.client.*;
import net.minecraft.client.multiplayer.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Scaffold extends Mod
{
    private Value<Boolean> tower;
    private Value<Boolean> noswing;
    public static Value<String> mode;
    private static float yaw;
    private static float pitch;
    public static List<Block> blacklistedBlocks;
    private Class220 timer;
    public static ItemStack currentlyHolding;
    private Class220 tDelay;
    private Class357 blockdata;
    private double y;
    private boolean sneaking;
    private int count;
    private boolean isSneaking;
    private int theSlot;
    private int slot;
    private Class220 timer2;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIllllllIl;
    
    private static List<Block> getBlacklistedBlocks() {
        return Scaffold.blacklistedBlocks;
    }
    
    public Scaffold() {
        super("Scaffold", Category.WORLD);
        this.tower = new Value<Boolean>("Scaffold_Tower", Boolean.TRUE);
        this.noswing = new Value<Boolean>("Scaffold_NoSwing", Boolean.TRUE);
        this.timer = new Class220();
        this.tDelay = new Class220();
        this.theSlot = -1;
        this.timer2 = new Class220();
        Scaffold.mode.addValue("HypixelCN");
        Scaffold.mode.addValue("HypixelGlobal");
        Scaffold.mode.addValue("AAC");
        Scaffold.blacklistedBlocks = Arrays.asList(Blocks.field_150350_a, Blocks.field_150355_j, Blocks.field_150358_i, Blocks.field_150353_l, Blocks.field_150356_k, Blocks.field_150381_bn, Blocks.field_150404_cg, Blocks.field_150410_aZ, Blocks.field_150397_co, Blocks.field_150411_aY, Blocks.field_150431_aC, Blocks.field_150432_aD, Blocks.field_150403_cj, Blocks.field_150365_q, Blocks.field_150482_ag, Blocks.field_150412_bA, Blocks.field_150486_ae, Blocks.field_150447_bR, Blocks.field_150478_aa, Blocks.field_150467_bQ, Blocks.field_150447_bR, Blocks.field_150323_B, Blocks.field_150421_aI, Blocks.field_150335_W, Blocks.field_150352_o, Blocks.field_150366_p, Blocks.field_150369_x, Blocks.field_150439_ay, Blocks.field_150449_bY, Blocks.field_150450_ax, Blocks.field_150452_aw, Blocks.field_150456_au, Blocks.field_150445_bS, Blocks.field_150443_bT, Blocks.field_150430_aB, Blocks.field_150471_bO, Blocks.field_150442_at, Blocks.field_150329_H, Blocks.field_150473_bD, Blocks.field_150479_bC, Blocks.field_150448_aq, Blocks.field_150392_bi, Blocks.field_150328_O, Blocks.field_150337_Q, Blocks.field_150338_P, Blocks.field_150395_bd, Blocks.field_150415_aT, Blocks.field_150327_N, Blocks.field_150468_ap, Blocks.field_150460_al, Blocks.field_150354_m, Blocks.field_150434_aF, Blocks.field_150367_z, Blocks.field_150323_B, Blocks.field_150409_cd, Blocks.field_150462_ai, Blocks.field_150321_G, Blocks.field_150423_aK, Blocks.field_150345_g, Blocks.field_150463_bK, Blocks.field_180407_aO, Blocks.field_150429_aA);
    }
    
    @Override
    public final void onEnable() {
        final int[] b = Class139.b();
        this.tDelay.lastMs = System.currentTimeMillis();
        final int[] array = b;
        this.count = 1;
        if (array == null) {
            if (Scaffold.mc.field_71439_g != null) {
                this.y = Scaffold.mc.field_71439_g.field_70163_u;
            }
            this.sneaking = true;
            this.timer2.lastMs = System.currentTimeMillis();
            super.onEnable();
        }
    }
    
    @Override
    public final void onDisable() {
        final int[] b = Class139.b();
        Class94.getTimer();
        final boolean sneaking = this.sneaking;
        final EntityPlayerSP field_71439_g;
        Label_0107: {
            Label_0078: {
                if (b == null) {
                    if (sneaking) {
                        final boolean func_70093_af = Scaffold.mc.field_71439_g.func_70093_af();
                        if (b != null) {
                            break Label_0078;
                        }
                        if (!func_70093_af) {
                            Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)Scaffold.mc.field_71439_g, C0BPacketEntityAction$Action.STOP_SNEAKING));
                        }
                    }
                    field_71439_g = Scaffold.mc.field_71439_g;
                    if (b != null) {
                        break Label_0107;
                    }
                    final boolean field_82175_bq = field_71439_g.field_82175_bq;
                }
            }
            if (!sneaking) {
                return;
            }
            Scaffold.mc.field_71439_g.field_70733_aJ = 0.0f;
            Scaffold.mc.field_71439_g.field_110158_av = 0;
            final EntityPlayerSP field_71439_g2 = Scaffold.mc.field_71439_g;
        }
        field_71439_g.field_82175_bq = false;
    }
    
    @EventTarget
    private void onPre(final EventPreMotion eventPreMotion) {
        final int[] b = Class139.b();
        boolean b3;
        boolean press;
        int n;
        final boolean b2 = (n = ((press = (b3 = (getBlockCount() != 0))) ? 1 : 0)) != 0;
        if (b == null) {
            if (!b2) {
                return;
            }
            final int[] b4 = Class139.b();
            final int blockCount;
            final int n2 = blockCount = getBlockCount();
            Label_0313: {
                int func_75216_d = 0;
                if (b4 == null) {
                    if (n2 == 0) {
                        break Label_0313;
                    }
                    final int[] b5 = Class139.b();
                    int i = 36;
                    final int[] array = b5;
                    while (i < 45) {
                        final Slot func_75139_a = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                        Label_0132: {
                            Label_0129: {
                                if (array == null) {
                                    func_75216_d = (func_75139_a.func_75216_d() ? 1 : 0);
                                    if (array != null) {
                                        break;
                                    }
                                    if (func_75216_d == 0) {
                                        break Label_0129;
                                    }
                                    Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                                }
                                final Item func_77973_b = func_75139_a.func_75211_c().func_77973_b();
                                if (array != null) {
                                    break Label_0132;
                                }
                                if (func_77973_b instanceof ItemBlock) {
                                    final boolean valid = isValid(func_77973_b);
                                    if (array != null || valid) {
                                        break;
                                    }
                                }
                            }
                            ++i;
                        }
                        if (array != null) {
                            break;
                        }
                    }
                }
                if (b4 != null || n2 != 0) {
                    int j = func_75216_d;
                    while (j < 36) {
                        final Slot func_75139_a2 = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(j);
                        Label_0305: {
                            if (b4 == null) {
                                if (!func_75139_a2.func_75216_d()) {
                                    break Label_0305;
                                }
                                Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(j);
                            }
                            final ItemBlock func_77973_b2;
                            boolean contains;
                            final boolean b6 = contains = ((func_77973_b2 = (ItemBlock)func_75139_a2.func_75211_c().func_77973_b()) instanceof ItemBlock);
                            if (b4 == null) {
                                if (!b6) {
                                    break Label_0305;
                                }
                                final boolean contains2;
                                contains = (contains2 = Scaffold.blacklistedBlocks.contains(func_77973_b2.func_179223_d()));
                            }
                            if (b4 == null) {
                                if (b6) {
                                    break Label_0305;
                                }
                                contains = func_77973_b2.func_179223_d().func_149732_F().toLowerCase().contains("chest");
                            }
                            if (!contains) {
                                Scaffold.mc.field_71442_b.func_78753_a(Scaffold.mc.field_71439_g.field_71069_bz.field_75152_c, j, 7, 2, (EntityPlayer)Scaffold.mc.field_71439_g);
                                if (b4 == null) {
                                    break;
                                }
                            }
                        }
                        ++j;
                        if (b4 != null) {
                            break;
                        }
                    }
                }
            }
            final boolean b7;
            n = ((b7 = (press = (b3 = this.sneaking))) ? 1 : 0);
        }
        Label_0393: {
            if (b == null) {
                if (b2) {
                    final boolean b8 = (n = ((press = (b3 = Scaffold.mc.field_71439_g.func_70093_af())) ? 1 : 0)) != 0;
                    if (b != null) {
                        break Label_0393;
                    }
                    if (!b8) {
                        Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)Scaffold.mc.field_71439_g, C0BPacketEntityAction$Action.STOP_SNEAKING));
                        final boolean sneaking = this.sneaking;
                        if (b == null && sneaking) {}
                        this.sneaking = sneaking;
                    }
                }
                press = ((n = ((b3 = hotbarContainBlock()) ? 1 : 0)) != 0);
            }
        }
        if (b == null) {
            if (n == 0) {
                return;
            }
            b3 = (press = ((IKeyBinding)Scaffold.mc.field_71474_y.field_74311_E).getPress());
        }
        Label_0455: {
            Label_0450: {
                if (b == null) {
                    if (!press) {
                        break Label_0450;
                    }
                    b3 = Class333.MovementInput();
                }
                if (b3) {
                    Class333.setSpeed(Class333.getBaseMoveSpeed() * 0.6);
                    this.isSneaking = true;
                    if (b == null) {
                        break Label_0455;
                    }
                }
            }
            this.isSneaking = false;
        }
        double n3 = Scaffold.mc.field_71439_g.field_70165_t;
        double n4 = Scaffold.mc.field_71439_g.field_70161_v;
        final double n5 = Scaffold.mc.field_71439_g.field_71158_b.field_78900_b;
        final double n6 = Scaffold.mc.field_71439_g.field_71158_b.field_78902_a;
        final float field_70177_z = Scaffold.mc.field_71439_g.field_70177_z;
        if (!Scaffold.mc.field_71439_g.field_70123_F) {
            final double[] expandCoords;
            n3 = (expandCoords = getExpandCoords(n3, n4, n5, n6, field_70177_z))[0];
            n4 = expandCoords[1];
        }
        if (isAirBlock(Scaffold.mc.field_71441_e.func_180495_p(new BlockPos(Scaffold.mc.field_71439_g.field_70165_t, Scaffold.mc.field_71439_g.field_70163_u - 1.0 - (this.isSneaking ? 0.01 : 0.0), Scaffold.mc.field_71439_g.field_70161_v)).func_177230_c())) {
            n3 = Scaffold.mc.field_71439_g.field_70165_t;
            n4 = Scaffold.mc.field_71439_g.field_70161_v;
        }
        this.y = Scaffold.mc.field_71439_g.field_70163_u;
        final BlockPos blockPos = new BlockPos(n3, this.y - 1.0 - (this.isSneaking ? 0.01 : 0.0), n4);
        final Block func_177230_c = Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        final Class357 blockData = this.getBlockData(blockPos);
        boolean b9;
        boolean moving2;
        final int n7 = (moving2 = (b9 = (getBlockCount() != 0))) ? 1 : 0;
        Label_1641: {
            if (b == null) {
                if (n7 <= 0) {
                    break Label_1641;
                }
                final boolean b10;
                moving2 = (b10 = (b9 = this.tower.value));
            }
            if (b == null) {
                if (n7 == 0) {
                    break Label_1641;
                }
                b9 = (moving2 = Class333.isMoving2());
            }
            if (b == null) {
                if (moving2) {
                    break Label_1641;
                }
                b9 = Class333.isMoving2();
            }
            if (!b9) {
                final String s = "Hypixel";
                final BlockPos blockPos2 = new BlockPos(Scaffold.mc.field_71439_g.field_70165_t, Scaffold.mc.field_71439_g.field_70163_u - 1.0, Scaffold.mc.field_71439_g.field_70161_v);
                final int[] b11 = Class139.b();
                final Block func_177230_c2 = Scaffold.mc.field_71441_e.func_180495_p(blockPos2).func_177230_c();
                final Class357 blockData2 = this.getBlockData(blockPos2);
                final int[] array2 = b11;
                boolean b14;
                boolean delayComplete;
                boolean b13;
                final boolean b12 = b13 = (delayComplete = (b14 = ((IKeyBinding)Scaffold.mc.field_71474_y.field_74314_A).getPress()));
                if (array2 == null) {
                    if (!b12) {
                        double n13;
                        int n12;
                        double n11;
                        int n10;
                        int n9;
                        final int n8 = n9 = (n10 = (int)(n11 = (n12 = (int)(n13 = (Class333.isMoving2() ? 1 : 0)))));
                        Label_1155: {
                            if (array2 == null) {
                                if (n8 == 0) {
                                    break Label_1155;
                                }
                                final double n14;
                                n9 = (int)(n14 = (n10 = (int)(n11 = (n12 = (int)(n13 = (s.equalsIgnoreCase("Hypixel") ? 1 : 0))))));
                            }
                            if (array2 == null) {
                                if (n8 == 0) {
                                    break Label_1155;
                                }
                                n9 = (int)(n11 = (n12 = (int)(n13 = (Class33.isOnGround(0.76) ? 1 : 0))));
                            }
                            final int n16;
                            final double n17;
                            Label_1022: {
                                if (array2 == null) {
                                    if (n9 != 0) {
                                        final double n15 = n10 = (int)(n11 = (n12 = (int)(n13 = (Class33.isOnGround(0.75) ? 1 : 0))));
                                        if (array2 != null) {
                                            break Label_1022;
                                        }
                                        if (n15 == 0) {
                                            n16 = (int)(n11 = (n12 = (int)(n13 = dcmpl(Scaffold.mc.field_71439_g.field_70181_x, 0.23))));
                                            if (array2 != null) {
                                                break Label_1022;
                                            }
                                            if (n16 > 0) {
                                                n17 = (n12 = (int)(n13 = dcmpg(Scaffold.mc.field_71439_g.field_70181_x, 0.25)));
                                                if (array2 != null) {
                                                    break Label_1022;
                                                }
                                                if (n17 < 0) {
                                                    Scaffold.mc.field_71439_g.field_70181_x = Math.round(Scaffold.mc.field_71439_g.field_70163_u) - Scaffold.mc.field_71439_g.field_70163_u;
                                                }
                                            }
                                        }
                                    }
                                    n12 = (int)(n13 = (Class33.isOnGround(1.0E-4) ? 1 : 0));
                                }
                            }
                            if (array2 == null) {
                                if (n16 != 0) {
                                    break Label_1155;
                                }
                                n12 = (int)(n11 = (n13 = dcmpl(Scaffold.mc.field_71439_g.field_70181_x, 0.1)));
                            }
                            if (array2 == null) {
                                if (n17 <= 0) {
                                    break Label_1155;
                                }
                                n13 = (n12 = dcmpl(Scaffold.mc.field_71439_g.field_70163_u, Math.round(Scaffold.mc.field_71439_g.field_70163_u) - 1.0E-4));
                            }
                            final EntityPlayerSP field_71439_g;
                            Label_1151: {
                                if (array2 == null) {
                                    if (n12 < 0) {
                                        break Label_1155;
                                    }
                                    field_71439_g = Scaffold.mc.field_71439_g;
                                    if (array2 != null) {
                                        break Label_1151;
                                    }
                                    n13 = dcmpg(field_71439_g.field_70163_u, Math.round(Scaffold.mc.field_71439_g.field_70163_u) + 1.0E-4);
                                }
                                if (n13 > 0) {
                                    break Label_1155;
                                }
                                final EntityPlayerSP field_71439_g2 = Scaffold.mc.field_71439_g;
                            }
                            field_71439_g.field_70181_x = 0.0;
                        }
                        break Label_1641;
                    }
                    final boolean b15;
                    b13 = (b15 = (delayComplete = (b14 = s.equalsIgnoreCase("Hypixel"))));
                }
                if (array2 == null) {
                    if (!b12) {
                        break Label_1641;
                    }
                    delayComplete = (b13 = (b14 = Class333.isMoving2()));
                }
                if (array2 == null) {
                    if (b13) {
                        double n22;
                        int n21;
                        int n20;
                        int n19;
                        final int n18 = n19 = (n20 = (n21 = (int)(n22 = (Class33.isOnGround(0.76) ? 1 : 0))));
                        final int n24;
                        final double n25;
                        Label_1313: {
                            if (array2 == null) {
                                if (n18 != 0) {
                                    final int n23 = n19 = (n20 = (n21 = (int)(n22 = (Class33.isOnGround(0.75) ? 1 : 0))));
                                    if (array2 != null) {
                                        break Label_1313;
                                    }
                                    if (n23 == 0) {
                                        n24 = (n20 = (n21 = (int)(n22 = dcmpl(Scaffold.mc.field_71439_g.field_70181_x, 0.23))));
                                        if (array2 != null) {
                                            break Label_1313;
                                        }
                                        if (n24 > 0) {
                                            n25 = (n21 = (int)(n22 = dcmpg(Scaffold.mc.field_71439_g.field_70181_x, 0.25)));
                                            if (array2 != null) {
                                                break Label_1313;
                                            }
                                            if (n25 < 0) {
                                                Scaffold.mc.field_71439_g.field_70181_x = Math.round(Scaffold.mc.field_71439_g.field_70163_u) - Scaffold.mc.field_71439_g.field_70163_u;
                                            }
                                        }
                                    }
                                }
                                n21 = (int)(n22 = (this.timer2.isDelayComplete(1000L) ? 1 : 0));
                            }
                        }
                        if (array2 == null) {
                            if (n24 != 0) {
                                Scaffold.mc.field_71439_g.field_70181_x = -0.27994532;
                                this.timer2.lastMs = System.currentTimeMillis();
                            }
                            n21 = (n20 = (int)(n22 = (Class33.isOnGround(1.0E-4) ? 1 : 0)));
                        }
                        if (array2 == null) {
                            if (n25 != 0) {
                                Scaffold.mc.field_71439_g.field_70181_x = 0.41993956416514;
                                final EntityPlayerSP field_71439_g3 = Scaffold.mc.field_71439_g;
                                field_71439_g3.field_70159_w *= 0.9;
                                final EntityPlayerSP field_71439_g4 = Scaffold.mc.field_71439_g;
                                field_71439_g4.field_70179_y *= 0.9;
                                if (array2 == null) {
                                    break Label_1641;
                                }
                            }
                            n22 = (n21 = dcmpl(Scaffold.mc.field_71439_g.field_70163_u, Math.round(Scaffold.mc.field_71439_g.field_70163_u) - 1.0E-4));
                        }
                        final EntityPlayerSP field_71439_g5;
                        Label_1501: {
                            if (array2 == null) {
                                if (n21 < 0) {
                                    break Label_1641;
                                }
                                field_71439_g5 = Scaffold.mc.field_71439_g;
                                if (array2 != null) {
                                    break Label_1501;
                                }
                                n22 = dcmpg(field_71439_g5.field_70163_u, Math.round(Scaffold.mc.field_71439_g.field_70163_u) + 1.0E-4);
                            }
                            if (n22 > 0) {
                                break Label_1641;
                            }
                            final EntityPlayerSP field_71439_g6 = Scaffold.mc.field_71439_g;
                        }
                        field_71439_g5.field_70181_x = 0.0;
                        if (array2 == null) {
                            break Label_1641;
                        }
                    }
                    Scaffold.mc.field_71439_g.field_70159_w = 0.0;
                    Scaffold.mc.field_71439_g.field_70179_y = 0.0;
                    Scaffold.mc.field_71439_g.field_70747_aH = 0.0f;
                    b14 = (delayComplete = this.timer2.isDelayComplete(1000L));
                }
                if (array2 == null) {
                    if (delayComplete) {
                        Scaffold.mc.field_71439_g.field_70181_x = -0.27994532;
                        this.timer2.lastMs = System.currentTimeMillis();
                    }
                    b14 = isAirBlock(func_177230_c2);
                }
                if (b14 && blockData2 != null) {
                    Scaffold.mc.field_71439_g.field_70181_x = 0.4195751556457;
                    final EntityPlayerSP field_71439_g7 = Scaffold.mc.field_71439_g;
                    field_71439_g7.field_70159_w *= 0.75;
                    final EntityPlayerSP field_71439_g8 = Scaffold.mc.field_71439_g;
                    field_71439_g8.field_70179_y *= 0.75;
                }
            }
        }
        final boolean b16;
        final boolean b20;
        final boolean field_70122_E;
        Label_1974: {
            if (blockData != null) {
                boolean b18;
                final boolean b17;
                b16 = (b17 = (b18 = isAirBlock(func_177230_c)));
                if (b != null) {
                    break Label_1974;
                }
                if (b16) {
                    final BlockPos position = blockData.position;
                    final EnumFacing face = blockData.face;
                    final BlockPos blockPos3 = position;
                    final double n26 = position.func_177958_n() + 0.5 - Scaffold.mc.field_71439_g.field_70165_t + face.func_82601_c() / 2.0;
                    final double n27 = blockPos3.func_177952_p() + 0.5 - Scaffold.mc.field_71439_g.field_70161_v + face.func_82599_e() / 2.0;
                    final double n28 = blockPos3.func_177956_o() + 0.5;
                    final int[] b19 = Class139.b();
                    final double n29 = Scaffold.mc.field_71439_g.field_70163_u + Scaffold.mc.field_71439_g.func_70047_e() - n28;
                    final double n30 = n26;
                    final double n31 = n30 * n30;
                    final double n32 = n27;
                    final double n33 = MathHelper.func_76133_a(n31 + n32 * n32);
                    final int[] array3 = b19;
                    float n34 = (float)(Math.atan2(n27, n26) * 180.0 / 3.141592653589793) - 90.0f;
                    final float n35 = (float)(Math.atan2(n29, n33) * 180.0 / 3.141592653589793);
                    final float n36 = fcmpg(n34, 0.0f);
                    if (array3 == null && n36 < 0) {
                        n34 += 360.0f;
                        goto Label_1859;
                    }
                    final float[] array4 = new float[n36];
                    array4[0] = n34;
                    array4[1] = n35;
                    final float[] array5 = array4;
                    eventPreMotion.yaw = array5[0] + (float)randomNumber(1.0, -1.0);
                    eventPreMotion.pitch = array5[1];
                    b20 = (b18 = ((IKeyBinding)Scaffold.mc.field_71474_y.field_74314_A).getPress());
                    if (b != null) {
                        break Label_1974;
                    }
                    if (!b20) {
                        field_70122_E = Scaffold.mc.field_71439_g.field_70122_E;
                        if (b != null) {
                            break Label_1974;
                        }
                        if (field_70122_E) {
                            final boolean onGround = Class33.isOnGround(0.001);
                            if (b != null) {
                                break Label_1974;
                            }
                            if (onGround) {
                                final boolean field_70124_G = Scaffold.mc.field_71439_g.field_70124_G;
                                if (b != null) {
                                    break Label_1974;
                                }
                                if (field_70124_G) {
                                    eventPreMotion.onGround = false;
                                }
                            }
                        }
                    }
                }
            }
            Class333.MovementInput();
        }
        if (b == null) {
            if (!b16) {
                return;
            }
            Scaffold.mode.isCurrentMode("HypixelCN");
        }
        if (b == null) {
            if (b20) {
                return;
            }
            Scaffold.mode.isCurrentMode("AAC");
        }
        if (field_70122_E) {
            Class333.setSpeed(0.11);
        }
    }
    
    @EventTarget
    private void onPost$457908ce() {
        final int[] b = Class139.b();
        boolean b2;
        final int n = (b2 = (getBlockCount() != 0)) ? 1 : 0;
        if (b == null) {
            if (n == 0) {
                return;
            }
            final boolean delayComplete;
            b2 = (delayComplete = this.tDelay.isDelayComplete(80L));
        }
        final double n2;
        Label_0079: {
            final Minecraft mc;
            Label_0073: {
                Label_0070: {
                    if (b == null) {
                        if (n != 0) {
                            break Label_0070;
                        }
                        n2 = 0.01;
                        if (b != null) {
                            break Label_0079;
                        }
                        b2 = Class33.isOnGround(n2);
                    }
                    if (b2) {
                        mc = Scaffold.mc;
                        if (b != null) {
                            break Label_0073;
                        }
                        if (!((IKeyBinding)mc.field_71474_y.field_74314_A).getPress()) {
                            return;
                        }
                    }
                }
                final Minecraft mc2 = Scaffold.mc;
            }
            final double field_70165_t = mc.field_71439_g.field_70165_t;
        }
        final BlockPos blockPos = new BlockPos(n2, this.y - 1.0 - (this.isSneaking ? 0.01 : 0.0), Scaffold.mc.field_71439_g.field_70161_v);
        Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        final Class357 blockData = this.getBlockData(blockPos);
        this.tDelay.lastMs = System.currentTimeMillis();
        final int field_70461_c = Scaffold.mc.field_71439_g.field_71071_by.field_70461_c;
        final ItemStack itemStack = new ItemStack(Item.func_150899_d(261));
        this.theSlot = -1;
        int n3 = 36;
        Label_0901: {
            boolean b4;
            boolean delayComplete2;
            boolean b3;
            int n9;
            int n8;
            int n7;
            int n6 = 0;
            while (true) {
                final int n4 = n3;
                final int n5 = 45;
                try {
                    Label_0362: {
                        if (n4 < n5) {
                            this.theSlot = n3 - 36;
                            final Container field_71069_bz = Scaffold.mc.field_71439_g.field_71069_bz;
                            if (b == null) {
                                n6 = (n7 = (n8 = (n9 = ((b3 = (delayComplete2 = (b4 = Container.func_94527_a(Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n3), itemStack, (boolean)(1 != 0))))) ? 1 : 0))));
                                if (b != null) {
                                    break;
                                }
                                Label_0355: {
                                    if (n6 == 0) {
                                        final ItemStack func_75211_c = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n3).func_75211_c();
                                        if (b == null) {
                                            if (!(func_75211_c.func_77973_b() instanceof ItemBlock)) {
                                                break Label_0355;
                                            }
                                            Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n3).func_75211_c();
                                        }
                                        if (func_75211_c != null) {
                                            int n10;
                                            final boolean b5 = (n10 = (isValid(Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n3).func_75211_c().func_77973_b()) ? 1 : 0)) != 0;
                                            if (b == null) {
                                                if (!b5) {
                                                    break Label_0355;
                                                }
                                                n10 = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n3).func_75211_c().field_77994_a;
                                            }
                                            if (n10 != 0 && b == null) {
                                                break Label_0362;
                                            }
                                        }
                                    }
                                }
                                ++n3;
                            }
                            if (b == null) {
                                continue;
                            }
                        }
                    }
                }
                catch (Exception ex) {}
                Object o = this;
                if (b == null) {
                    ++this.count;
                    if (blockData == null) {
                        break Label_0901;
                    }
                    o = null;
                }
                final int n11;
                n7 = (n11 = (n8 = (n9 = ((b3 = (delayComplete2 = (b4 = isAirBlock((Block)o)))) ? 1 : 0))));
                break;
            }
            if (b == null) {
                if (n6 == 0) {
                    return;
                }
                n8 = (n7 = (n9 = ((b3 = (delayComplete2 = (b4 = (Scaffold.mc.field_71439_g.field_71071_by.field_70461_c != 0)))) ? 1 : 0)));
            }
            if (b == null) {
                if (lIIIllIIlIIl(n7, this.theSlot)) {
                    n9 = (n8 = ((b3 = (delayComplete2 = (b4 = true))) ? 1 : 0));
                }
                else {
                    n9 = (n8 = ((b3 = (delayComplete2 = (b4 = false))) ? 1 : 0));
                }
            }
            final int n12 = n8;
            if (b == null) {
                if (n9 != 0) {
                    Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C09PacketHeldItemChange(this.theSlot));
                }
                Scaffold.currentlyHolding = Scaffold.mc.field_71439_g.field_71071_by.func_70301_a(this.theSlot);
                final PlayerControllerMP field_71442_b = Scaffold.mc.field_71442_b;
                final EntityPlayerSP field_71439_g = Scaffold.mc.field_71439_g;
                final WorldClient field_71441_e = Scaffold.mc.field_71441_e;
                final ItemStack func_70301_a = Scaffold.mc.field_71439_g.field_71071_by.func_70301_a(this.theSlot);
                final BlockPos position = blockData.position;
                final EnumFacing face = blockData.face;
                final BlockPos position2 = blockData.position;
                final EnumFacing face2 = blockData.face;
                final BlockPos blockPos2 = position2;
                final double n13 = position2.func_177958_n() + 0.5;
                final int[] b6 = Class139.b();
                final double n14 = blockPos2.func_177956_o() + 0.5;
                final int[] array = b6;
                final double n15 = blockPos2.func_177952_p() + 0.5;
                double n16 = n13 + face2.func_82601_c() / 2.0;
                double n17 = n15 + face2.func_82599_e() / 2.0;
                double n18 = n14 + face2.func_96559_d() / 2.0;
                Label_0682: {
                    Label_0668: {
                        if (array == null) {
                            if (lIIIllIIlllI(face2, EnumFacing.UP) && !lIIIllIIllll(face2, EnumFacing.DOWN)) {
                                break Label_0668;
                            }
                            n16 += randomNumber(0.3, -0.3);
                            n17 += randomNumber(0.3, -0.3);
                        }
                        if (array == null) {
                            break Label_0682;
                        }
                    }
                    n18 += randomNumber(0.3, -0.3);
                }
                EnumFacing enumFacing3;
                EnumFacing enumFacing2;
                final EnumFacing enumFacing = enumFacing2 = (enumFacing3 = face2);
                EnumFacing enumFacing5;
                EnumFacing south;
                final EnumFacing enumFacing4 = south = (enumFacing5 = EnumFacing.WEST);
                Label_0730: {
                    Label_0726: {
                        Label_0712: {
                            if (array == null) {
                                if (!lIIIllIIlllI(enumFacing, enumFacing4)) {
                                    break Label_0712;
                                }
                                final EnumFacing enumFacing6;
                                enumFacing2 = (enumFacing6 = (enumFacing3 = face2));
                                final EnumFacing enumFacing7;
                                south = (enumFacing7 = (enumFacing5 = EnumFacing.EAST));
                            }
                            if (array != null) {
                                break Label_0730;
                            }
                            if (!lIIIllIIllll(enumFacing, enumFacing4)) {
                                break Label_0726;
                            }
                        }
                        n17 += randomNumber(0.3, -0.3);
                    }
                    enumFacing3 = (enumFacing2 = face2);
                    enumFacing5 = (south = EnumFacing.SOUTH);
                }
                Label_0765: {
                    Label_0751: {
                        if (array == null) {
                            if (!lIIIllIIlllI(enumFacing2, south)) {
                                break Label_0751;
                            }
                            enumFacing3 = face2;
                            enumFacing5 = EnumFacing.NORTH;
                        }
                        if (!lIIIllIIllll(enumFacing3, enumFacing5)) {
                            break Label_0765;
                        }
                    }
                    n16 += randomNumber(0.3, -0.3);
                }
                field_71442_b.func_178890_a(field_71439_g, field_71441_e, func_70301_a, position, face, new Vec3(n16, n18, n17));
                delayComplete2 = (b3 = (b4 = (n12 != 0)));
            }
            if (b == null) {
                if (b3) {
                    Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C09PacketHeldItemChange(Scaffold.mc.field_71439_g.field_71071_by.field_70461_c));
                }
                b4 = (delayComplete2 = this.timer.isDelayComplete(250L));
            }
            if (b == null) {
                if (delayComplete2) {
                    this.timer.lastMs = System.currentTimeMillis();
                }
                b4 = this.noswing.value;
            }
            Label_0897: {
                if (b4) {
                    Scaffold.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0APacketAnimation());
                    if (b == null) {
                        break Label_0897;
                    }
                }
                Scaffold.mc.field_71439_g.func_71038_i();
            }
            if (b == null) {
                return;
            }
        }
        Scaffold.currentlyHolding = null;
    }
    
    @EventTarget
    private static void onPacket$1d2175e0() {
        Class139.b();
    }
    
    @EventTarget
    private void onSafe(final EventSafeWalk eventSafeWalk) {
        if (!this.isSneaking) {
            eventSafeWalk.safe = true;
        }
    }
    
    @EventTarget
    private static void onMove(final EventMove eventMove) {
        if (Class139.b() == null) {
            if (!Scaffold.mode.isCurrentMode("HypixelGlobal")) {
                return;
            }
            eventMove.x *= 0.75;
        }
        eventMove.z *= 0.75;
    }
    
    private static void swap$255f295(final int n) {
        Scaffold.mc.field_71442_b.func_78753_a(Scaffold.mc.field_71439_g.field_71069_bz.field_75152_c, n, 7, 2, (EntityPlayer)Scaffold.mc.field_71439_g);
    }
    
    private static boolean invCheck() {
        final int[] b = Class139.b();
        int i = 36;
        final int[] array = b;
        boolean func_75216_d = false;
        while (i < 45) {
            final Slot func_75139_a = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
            Label_0087: {
                Label_0084: {
                    if (array == null) {
                        func_75216_d = func_75139_a.func_75216_d();
                        if (array != null) {
                            return func_75216_d;
                        }
                        if (!func_75216_d) {
                            break Label_0084;
                        }
                        Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                    }
                    final Item func_77973_b = func_75139_a.func_75211_c().func_77973_b();
                    if (array != null) {
                        break Label_0087;
                    }
                    if (func_77973_b instanceof ItemBlock) {
                        final boolean valid = isValid(func_77973_b);
                        if (array != null || valid) {
                            return valid;
                        }
                    }
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        return func_75216_d;
    }
    
    private static int getBlockCount() {
        final int[] b = Class139.b();
        int n = 0;
        final int[] array = b;
        int i = 0;
        while (i < 45) {
            final Slot func_75139_a = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
            Label_0100: {
                Label_0097: {
                    if (array == null) {
                        final int func_75216_d;
                        final boolean b2 = (func_75216_d = (func_75139_a.func_75216_d() ? 1 : 0)) != 0;
                        if (array != null) {
                            return func_75216_d;
                        }
                        if (!b2) {
                            break Label_0097;
                        }
                        Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                    }
                    final ItemStack func_75211_c;
                    final Item func_77973_b = (func_75211_c = func_75139_a.func_75211_c()).func_77973_b();
                    if (array != null) {
                        break Label_0100;
                    }
                    if (func_75211_c.func_77973_b() instanceof ItemBlock) {
                        final int valid = isValid(func_77973_b) ? 1 : 0;
                        if (array == null) {
                            if (valid == 0) {
                                break Label_0097;
                            }
                            final int n2 = n + func_75211_c.field_77994_a;
                        }
                        n = valid;
                    }
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        return n;
    }
    
    private static boolean isAirBlock(final Block block) {
        final int[] b = Class139.b();
        final boolean func_76222_j = block.func_149688_o().func_76222_j();
        if (b == null && func_76222_j) {
            double n;
            final boolean b2 = (n = ((block instanceof BlockSnow) ? 1 : 0)) != 0.0;
            if (b == null) {
                if (b2) {
                    final double n2 = n = dcmpl(block.func_149669_A(), 0.125);
                    if (b != null) {
                        return n != 0.0;
                    }
                    if (n2 > 0) {
                        return false;
                    }
                }
                n = (true ? 1 : 0);
            }
            return n != 0.0;
        }
        return func_76222_j;
    }
    
    private static int getBiggestBlockSlotInv() {
        int n = -1;
        final int[] b = Class139.b();
        int field_77994_a = 0;
        final int[] array = b;
        final int blockCount = getBlockCount();
        if (array == null && blockCount == 0) {
            return -1;
        }
        int i = blockCount;
        while (i < 36) {
            final Slot func_75139_a = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
            Label_0146: {
                Label_0143: {
                    if (array == null) {
                        final int func_75216_d;
                        final boolean b2 = (func_75216_d = (func_75139_a.func_75216_d() ? 1 : 0)) != 0;
                        if (array != null) {
                            return func_75216_d;
                        }
                        if (!b2) {
                            break Label_0143;
                        }
                        Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                    }
                    final Item func_77973_b = func_75139_a.func_75211_c().func_77973_b();
                    final ItemStack func_75211_c = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                    if (array != null) {
                        break Label_0146;
                    }
                    if (func_77973_b instanceof ItemBlock) {
                        int valid;
                        final int n2 = valid = (isValid(func_77973_b) ? 1 : 0);
                        if (array == null) {
                            if (n2 == 0) {
                                break Label_0143;
                            }
                            final int field_77994_a2;
                            valid = (field_77994_a2 = func_75211_c.field_77994_a);
                        }
                        if (array == null) {
                            if (!lIIIllIIllII(n2, field_77994_a)) {
                                break Label_0143;
                            }
                            field_77994_a = func_75211_c.field_77994_a;
                            valid = i;
                        }
                        n = valid;
                    }
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        return n;
    }
    
    private static int getBiggestBlockSlotHotbar() {
        final int[] b = Class139.b();
        int n = -1;
        final int[] array = b;
        int field_77994_a = 0;
        final int blockCount = getBlockCount();
        if (array == null && blockCount == 0) {
            return -1;
        }
        int i = blockCount;
        while (i < 45) {
            final Slot func_75139_a = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
            Label_0146: {
                Label_0143: {
                    if (array == null) {
                        final int func_75216_d;
                        final boolean b2 = (func_75216_d = (func_75139_a.func_75216_d() ? 1 : 0)) != 0;
                        if (array != null) {
                            return func_75216_d;
                        }
                        if (!b2) {
                            break Label_0143;
                        }
                        Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                    }
                    final Item func_77973_b = func_75139_a.func_75211_c().func_77973_b();
                    final ItemStack func_75211_c = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                    if (array != null) {
                        break Label_0146;
                    }
                    if (func_77973_b instanceof ItemBlock) {
                        int valid;
                        final int n2 = valid = (isValid(func_77973_b) ? 1 : 0);
                        if (array == null) {
                            if (n2 == 0) {
                                break Label_0143;
                            }
                            final int field_77994_a2;
                            valid = (field_77994_a2 = func_75211_c.field_77994_a);
                        }
                        if (array == null) {
                            if (!lIIIllIIllII(n2, field_77994_a)) {
                                break Label_0143;
                            }
                            field_77994_a = func_75211_c.field_77994_a;
                            valid = i;
                        }
                        n = valid;
                    }
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        return n;
    }
    
    private static void getBestBlocks() {
        final int[] b = Class139.b();
        final int blockCount;
        final int n = blockCount = getBlockCount();
        int func_75216_d = 0;
        if (b == null) {
            if (n == 0) {
                return;
            }
            final int[] b2 = Class139.b();
            int i = 36;
            final int[] array = b2;
            while (i < 45) {
                final Slot func_75139_a = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                Label_0104: {
                    Label_0101: {
                        if (array == null) {
                            func_75216_d = (func_75139_a.func_75216_d() ? 1 : 0);
                            if (array != null) {
                                break;
                            }
                            if (func_75216_d == 0) {
                                break Label_0101;
                            }
                            Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                        }
                        final Item func_77973_b = func_75139_a.func_75211_c().func_77973_b();
                        if (array != null) {
                            break Label_0104;
                        }
                        if (func_77973_b instanceof ItemBlock) {
                            final boolean valid = isValid(func_77973_b);
                            if (array != null || valid) {
                                break;
                            }
                        }
                    }
                    ++i;
                }
                if (array != null) {
                    break;
                }
            }
        }
        if (b != null || n != 0) {
            int j = func_75216_d;
            while (j < 36) {
                final Slot func_75139_a2 = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(j);
                Label_0261: {
                    if (b == null) {
                        if (!func_75139_a2.func_75216_d()) {
                            break Label_0261;
                        }
                        Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(j);
                    }
                    final ItemBlock func_77973_b2;
                    boolean contains;
                    final boolean b3 = contains = ((func_77973_b2 = (ItemBlock)func_75139_a2.func_75211_c().func_77973_b()) instanceof ItemBlock);
                    if (b == null) {
                        if (!b3) {
                            break Label_0261;
                        }
                        final boolean contains2;
                        contains = (contains2 = Scaffold.blacklistedBlocks.contains(func_77973_b2.func_179223_d()));
                    }
                    if (b == null) {
                        if (b3) {
                            break Label_0261;
                        }
                        contains = func_77973_b2.func_179223_d().func_149732_F().toLowerCase().contains("chest");
                    }
                    if (!contains) {
                        Scaffold.mc.field_71442_b.func_78753_a(Scaffold.mc.field_71439_g.field_71069_bz.field_75152_c, j, 7, 2, (EntityPlayer)Scaffold.mc.field_71439_g);
                        if (b == null) {
                            break;
                        }
                    }
                }
                ++j;
                if (b != null) {
                    break;
                }
            }
        }
    }
    
    private static Vec3 getVec3(final BlockPos blockPos, final EnumFacing enumFacing) {
        final double n = blockPos.func_177958_n() + 0.5;
        final int[] b = Class139.b();
        final double n2 = blockPos.func_177956_o() + 0.5;
        final int[] array = b;
        final double n3 = blockPos.func_177952_p() + 0.5;
        double n4 = n + enumFacing.func_82601_c() / 2.0;
        double n5 = n3 + enumFacing.func_82599_e() / 2.0;
        double n6 = n2 + enumFacing.func_96559_d() / 2.0;
        Label_0144: {
            Label_0130: {
                if (array == null) {
                    if (lIIIllIIlllI(enumFacing, EnumFacing.UP) && !lIIIllIIllll(enumFacing, EnumFacing.DOWN)) {
                        break Label_0130;
                    }
                    n4 += randomNumber(0.3, -0.3);
                    n5 += randomNumber(0.3, -0.3);
                }
                if (array == null) {
                    break Label_0144;
                }
            }
            n6 += randomNumber(0.3, -0.3);
        }
        EnumFacing enumFacing2 = enumFacing;
        EnumFacing enumFacing3 = enumFacing;
        EnumFacing enumFacing4 = enumFacing;
        EnumFacing enumFacing6;
        EnumFacing south;
        final EnumFacing enumFacing5 = south = (enumFacing6 = EnumFacing.WEST);
        Label_0190: {
            Label_0186: {
                Label_0172: {
                    if (array == null) {
                        if (!lIIIllIIlllI(enumFacing, enumFacing5)) {
                            break Label_0172;
                        }
                        enumFacing2 = enumFacing;
                        enumFacing3 = enumFacing;
                        enumFacing4 = enumFacing;
                        final EnumFacing enumFacing7;
                        south = (enumFacing7 = (enumFacing6 = EnumFacing.EAST));
                    }
                    if (array != null) {
                        break Label_0190;
                    }
                    if (!lIIIllIIllll(enumFacing4, enumFacing5)) {
                        break Label_0186;
                    }
                }
                n5 += randomNumber(0.3, -0.3);
            }
            enumFacing2 = enumFacing;
            enumFacing3 = enumFacing;
            enumFacing6 = (south = EnumFacing.SOUTH);
        }
        Label_0210: {
            if (array == null) {
                if (!lIIIllIIlllI(enumFacing3, south)) {
                    break Label_0210;
                }
                enumFacing2 = enumFacing;
                enumFacing6 = EnumFacing.NORTH;
            }
            if (!lIIIllIIllll(enumFacing2, enumFacing6)) {
                return new Vec3(n4, n6, n5);
            }
        }
        n4 += randomNumber(0.3, -0.3);
        return new Vec3(n4, n6, n5);
    }
    
    private static boolean isPosSolid(final BlockPos blockPos) {
        final int[] b = Class139.b();
        final Block func_177230_c = Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        final int[] array = b;
        final boolean func_76220_a;
        final boolean b2 = func_76220_a = func_177230_c.func_149688_o().func_76220_a();
        final boolean func_149751_l;
        Label_0107: {
            if (array == null) {
                if (!b2) {
                    func_149751_l = func_177230_c.func_149751_l();
                    if (array != null) {
                        break Label_0107;
                    }
                    if (func_149751_l) {
                        final boolean func_149686_d = func_177230_c.func_149686_d();
                        if (array != null) {
                            break Label_0107;
                        }
                        if (!func_149686_d) {
                            final boolean b3 = func_177230_c instanceof BlockLadder;
                            if (array != null) {
                                break Label_0107;
                            }
                            if (!b3) {
                                final boolean b4 = func_177230_c instanceof BlockCarpet;
                                if (array != null) {
                                    break Label_0107;
                                }
                                if (!b4) {
                                    final boolean b5 = func_177230_c instanceof BlockSnow;
                                    if (array != null) {
                                        break Label_0107;
                                    }
                                    if (!b5) {
                                        final boolean b6 = func_177230_c instanceof BlockSkull;
                                        if (array != null) {
                                            return func_149751_l;
                                        }
                                        if (!b6) {
                                            return func_149751_l;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                func_177230_c.func_149688_o().func_76224_d();
            }
        }
        if (array == null) {
            if (!b2) {
                final boolean b7 = func_177230_c instanceof BlockContainer;
                if (array == null) {
                    if (!b7) {
                        return true;
                    }
                }
            }
        }
        return func_149751_l;
    }
    
    private static void ItemSpoof() {
        final int[] b = Class139.b();
        final ItemStack itemStack = new ItemStack(Item.func_150899_d(261));
        final int[] array = b;
        int n = 36;
        while (true) {
            final int n2 = n;
            final int n3 = 45;
            try {
                if (n2 < n3) {
                    final int field_70461_c = n - 36;
                    final Container field_71069_bz = Scaffold.mc.field_71439_g.field_71069_bz;
                    if (array != null) {
                        break;
                    }
                    if (array == null) {
                        Label_0222: {
                            if (!Container.func_94527_a(Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n), itemStack, true)) {
                                final ItemStack func_75211_c = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c();
                                if (array == null) {
                                    if (!(func_75211_c.func_77973_b() instanceof ItemBlock)) {
                                        break Label_0222;
                                    }
                                    Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c();
                                }
                                if (func_75211_c != null) {
                                    int n5;
                                    final int n4 = n5 = (isValid(Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c().func_77973_b()) ? 1 : 0);
                                    if (array == null) {
                                        if (n4 == 0) {
                                            break Label_0222;
                                        }
                                        final int field_77994_a;
                                        n5 = (field_77994_a = Scaffold.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c().field_77994_a);
                                    }
                                    final InventoryPlayer field_71071_by;
                                    Label_0205: {
                                        if (array == null) {
                                            if (n4 == 0) {
                                                break Label_0222;
                                            }
                                            field_71071_by = Scaffold.mc.field_71439_g.field_71071_by;
                                            if (array != null) {
                                                break Label_0205;
                                            }
                                            n5 = field_71071_by.field_70461_c;
                                        }
                                        if (!lIIIllIIlIIl(n5, field_70461_c)) {
                                            return;
                                        }
                                        final InventoryPlayer field_71071_by2 = Scaffold.mc.field_71439_g.field_71071_by;
                                    }
                                    field_71071_by.field_70461_c = field_70461_c;
                                    Scaffold.mc.field_71442_b.func_78765_e();
                                    if (array == null) {
                                        return;
                                    }
                                }
                            }
                        }
                        ++n;
                    }
                    if (array == null) {
                        continue;
                    }
                }
                return;
            }
            catch (Exception ex) {}
            break;
        }
    }
    
    private static float[] getRotations(final BlockPos blockPos, final EnumFacing enumFacing) {
        final double n = blockPos.func_177958_n() + 0.5 - Scaffold.mc.field_71439_g.field_70165_t + enumFacing.func_82601_c() / 2.0;
        final double n2 = blockPos.func_177952_p() + 0.5 - Scaffold.mc.field_71439_g.field_70161_v + enumFacing.func_82599_e() / 2.0;
        final double n3 = blockPos.func_177956_o() + 0.5;
        final int[] b = Class139.b();
        final double n4 = Scaffold.mc.field_71439_g.field_70163_u + Scaffold.mc.field_71439_g.func_70047_e() - n3;
        final double n5 = n;
        final double n6 = n5 * n5;
        final double n7 = n2;
        final double n8 = MathHelper.func_76133_a(n6 + n7 * n7);
        final int[] array = b;
        float n9 = (float)(Math.atan2(n2, n) * 180.0 / 3.141592653589793) - 90.0f;
        final float n10 = (float)(Math.atan2(n4, n8) * 180.0 / 3.141592653589793);
        final float n11 = fcmpg(n9, 0.0f);
        if (array == null && n11 < 0) {
            n9 += 360.0f;
            goto Label_0174;
        }
        final float[] array2 = new float[n11];
        array2[0] = n9;
        array2[1] = n10;
        return array2;
    }
    
    private static boolean hotbarContainBlock() {
        final int[] b = Class139.b();
        int i = 36;
        final int[] array = b;
        while (i < 45) {
            final Minecraft mc = Scaffold.mc;
            try {
                final ItemStack func_75211_c = mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                if (array == null) {
                    Label_0077: {
                        if (func_75211_c != null) {
                            final Item func_77973_b = func_75211_c.func_77973_b();
                            if (array == null) {
                                if (func_77973_b == null) {
                                    break Label_0077;
                                }
                                func_75211_c.func_77973_b();
                            }
                            boolean b3;
                            final boolean b2 = b3 = (func_77973_b instanceof ItemBlock);
                            if (array == null) {
                                if (!b2) {
                                    break Label_0077;
                                }
                                final boolean valid;
                                b3 = (valid = isValid(func_75211_c.func_77973_b()));
                            }
                            if (array != null) {
                                return b3;
                            }
                            if (b2) {
                                return true;
                            }
                        }
                    }
                    ++i;
                }
                if (array == null) {
                    continue;
                }
                return true;
            }
            catch (Exception ex) {
                if (array == null) {
                    continue;
                }
            }
            break;
        }
        return false;
    }
    
    private static boolean isValid(final Item item) {
        final int[] b = Class139.b();
        Item item2 = item;
        if (b == null) {
            if (!(item instanceof ItemBlock)) {
                return false;
            }
            item2 = item;
        }
        final boolean contains = Scaffold.blacklistedBlocks.contains(((ItemBlock)item2).func_179223_d());
        return (b != null || !contains) && contains;
    }
    
    private void tower$50b5b9fb(final String s) {
        final BlockPos blockPos = new BlockPos(Scaffold.mc.field_71439_g.field_70165_t, Scaffold.mc.field_71439_g.field_70163_u - 1.0, Scaffold.mc.field_71439_g.field_70161_v);
        final int[] b = Class139.b();
        final Block func_177230_c = Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        final Class357 blockData = this.getBlockData(blockPos);
        final int[] array = b;
        boolean b4;
        boolean delayComplete;
        boolean b3;
        final boolean b2 = b3 = (delayComplete = (b4 = ((IKeyBinding)Scaffold.mc.field_71474_y.field_74314_A).getPress()));
        if (array == null) {
            if (!b2) {
                double n6;
                int n5;
                double n4;
                int n3;
                int n2;
                final int n = n2 = (n3 = (int)(n4 = (n5 = (int)(n6 = (Class333.isMoving2() ? 1 : 0)))));
                if (array == null) {
                    if (n == 0) {
                        return;
                    }
                    final int n7;
                    n2 = (n7 = (n3 = (int)(n4 = (n5 = (int)(n6 = (s.equalsIgnoreCase("Hypixel") ? 1 : 0))))));
                }
                if (array == null) {
                    if (n == 0) {
                        return;
                    }
                    n2 = (int)(n4 = (n5 = (int)(n6 = (Class33.isOnGround(0.76) ? 1 : 0))));
                }
                final int n8;
                Label_0231: {
                    if (array == null) {
                        if (n2 != 0) {
                            n8 = (int)(n4 = (n5 = (int)(n6 = (Class33.isOnGround(0.75) ? 1 : 0))));
                            if (array != null) {
                                break Label_0231;
                            }
                            if (n8 == 0) {
                                final int n9 = n3 = (int)(n4 = (n5 = (int)(n6 = dcmpl(Scaffold.mc.field_71439_g.field_70181_x, 0.23))));
                                if (array != null) {
                                    break Label_0231;
                                }
                                if (n9 > 0) {
                                    final int n10 = n3 = (int)(n4 = (n5 = (int)(n6 = dcmpg(Scaffold.mc.field_71439_g.field_70181_x, 0.25))));
                                    if (array != null) {
                                        break Label_0231;
                                    }
                                    if (n10 < 0) {
                                        Scaffold.mc.field_71439_g.field_70181_x = Math.round(Scaffold.mc.field_71439_g.field_70163_u) - Scaffold.mc.field_71439_g.field_70163_u;
                                    }
                                }
                            }
                        }
                        n4 = (n3 = (n5 = (int)(n6 = (Class33.isOnGround(1.0E-4) ? 1 : 0))));
                    }
                }
                if (array == null) {
                    if (n8 != 0) {
                        return;
                    }
                    n5 = (int)(n4 = (n6 = dcmpl(Scaffold.mc.field_71439_g.field_70181_x, 0.1)));
                }
                if (array == null) {
                    if (n4 <= 0) {
                        return;
                    }
                    n6 = (n5 = dcmpl(Scaffold.mc.field_71439_g.field_70163_u, Math.round(Scaffold.mc.field_71439_g.field_70163_u) - 1.0E-4));
                }
                final EntityPlayerSP field_71439_g;
                Label_0356: {
                    if (array == null) {
                        if (n5 < 0) {
                            return;
                        }
                        field_71439_g = Scaffold.mc.field_71439_g;
                        if (array != null) {
                            break Label_0356;
                        }
                        n6 = dcmpg(field_71439_g.field_70163_u, Math.round(Scaffold.mc.field_71439_g.field_70163_u) + 1.0E-4);
                    }
                    if (n6 > 0) {
                        return;
                    }
                    final EntityPlayerSP field_71439_g2 = Scaffold.mc.field_71439_g;
                }
                field_71439_g.field_70181_x = 0.0;
                return;
            }
            final boolean b5;
            b3 = (b5 = (delayComplete = (b4 = s.equalsIgnoreCase("Hypixel"))));
        }
        if (array == null) {
            if (!b2) {
                return;
            }
            delayComplete = (b3 = (b4 = Class333.isMoving2()));
        }
        if (array == null) {
            if (b3) {
                double n14;
                int n13;
                int n12;
                final int n11 = n12 = (n13 = (int)(n14 = (Class33.isOnGround(0.76) ? 1 : 0)));
                final int n15;
                Label_0508: {
                    if (array == null) {
                        if (n11 != 0) {
                            n15 = (n13 = (int)(n14 = (Class33.isOnGround(0.75) ? 1 : 0)));
                            if (array != null) {
                                break Label_0508;
                            }
                            if (n15 == 0) {
                                int n17;
                                final int n16 = n17 = (n12 = (n13 = (int)(n14 = dcmpl(Scaffold.mc.field_71439_g.field_70181_x, 0.23))));
                                if (array != null) {
                                    break Label_0508;
                                }
                                if (n16 > 0) {
                                    final int n18 = n17 = (n12 = (n13 = (int)(n14 = dcmpg(Scaffold.mc.field_71439_g.field_70181_x, 0.25))));
                                    if (array != null) {
                                        break Label_0508;
                                    }
                                    if (n18 < 0) {
                                        Scaffold.mc.field_71439_g.field_70181_x = Math.round(Scaffold.mc.field_71439_g.field_70163_u) - Scaffold.mc.field_71439_g.field_70163_u;
                                    }
                                }
                            }
                        }
                        n13 = (int)(n14 = (this.timer2.isDelayComplete(1000L) ? 1 : 0));
                    }
                }
                if (array == null) {
                    if (n11 != 0) {
                        Scaffold.mc.field_71439_g.field_70181_x = -0.27994532;
                        this.timer2.lastMs = System.currentTimeMillis();
                    }
                    n13 = (n12 = (int)(n14 = (Class33.isOnGround(1.0E-4) ? 1 : 0)));
                }
                if (array == null) {
                    if (n15 != 0) {
                        Scaffold.mc.field_71439_g.field_70181_x = 0.41993956416514;
                        final EntityPlayerSP field_71439_g3 = Scaffold.mc.field_71439_g;
                        field_71439_g3.field_70159_w *= 0.9;
                        final EntityPlayerSP field_71439_g4 = Scaffold.mc.field_71439_g;
                        field_71439_g4.field_70179_y *= 0.9;
                        if (array == null) {
                            return;
                        }
                    }
                    n14 = (n13 = dcmpl(Scaffold.mc.field_71439_g.field_70163_u, Math.round(Scaffold.mc.field_71439_g.field_70163_u) - 1.0E-4));
                }
                final EntityPlayerSP field_71439_g5;
                Label_0690: {
                    if (array == null) {
                        if (n13 < 0) {
                            return;
                        }
                        field_71439_g5 = Scaffold.mc.field_71439_g;
                        if (array != null) {
                            break Label_0690;
                        }
                        n14 = dcmpg(field_71439_g5.field_70163_u, Math.round(Scaffold.mc.field_71439_g.field_70163_u) + 1.0E-4);
                    }
                    if (n14 > 0) {
                        return;
                    }
                    final EntityPlayerSP field_71439_g6 = Scaffold.mc.field_71439_g;
                }
                field_71439_g5.field_70181_x = 0.0;
                if (array == null) {
                    return;
                }
            }
            Scaffold.mc.field_71439_g.field_70159_w = 0.0;
            Scaffold.mc.field_71439_g.field_70179_y = 0.0;
            Scaffold.mc.field_71439_g.field_70747_aH = 0.0f;
            b4 = (delayComplete = this.timer2.isDelayComplete(1000L));
        }
        if (array == null) {
            if (delayComplete) {
                Scaffold.mc.field_71439_g.field_70181_x = -0.27994532;
                this.timer2.lastMs = System.currentTimeMillis();
            }
            b4 = isAirBlock(func_177230_c);
        }
        if (b4 && blockData != null) {
            Scaffold.mc.field_71439_g.field_70181_x = 0.4195751556457;
            final EntityPlayerSP field_71439_g7 = Scaffold.mc.field_71439_g;
            field_71439_g7.field_70159_w *= 0.75;
            final EntityPlayerSP field_71439_g8 = Scaffold.mc.field_71439_g;
            field_71439_g8.field_70179_y *= 0.75;
        }
    }
    
    private static void setSpeed$50b5b9fb() {
        final double field_70159_w = Scaffold.mc.field_71439_g.field_70159_w;
        final double field_70179_y = Scaffold.mc.field_71439_g.field_70179_y;
    }
    
    private static double[] getExpandCoords(final double n, final double n2, final double n3, final double n4, final float n5) {
        Block block = Scaffold.mc.field_71441_e.func_180495_p(new BlockPos(n, Scaffold.mc.field_71439_g.field_70163_u - 1.0, n2)).func_177230_c();
        double n6 = -999.0;
        double n7 = -999.0;
        final int[] b = Class139.b();
        double n8 = 0.0;
        final int[] array = b;
        while (true) {
            while (!isAirBlock(block)) {
                n6 = n;
                n7 = n2;
                final double n10;
                final double n9 = n10 = dcmpl(++n8, 0.8);
                if (array != null) {
                    final double[] array2 = new double[n10];
                    array2[0] = n6;
                    array2[1] = n7;
                    return array2;
                }
                Label_0262: {
                    if (array == null) {
                        if (n9 > 0) {
                            n8 = 0.8;
                        }
                        n6 = n + (n3 * 0.45 * Math.cos(Math.toRadians(n5 + 90.0f)) + n4 * 0.45 * Math.sin(Math.toRadians(n5 + 90.0f))) * n8;
                        n7 = n2 + (n3 * 0.45 * Math.sin(Math.toRadians(n5 + 90.0f)) - n4 * 0.45 * Math.cos(Math.toRadians(n5 + 90.0f))) * n8;
                        if (array != null) {
                            break Label_0262;
                        }
                        final double n11 = dcmpl(n8, 0.8);
                    }
                    if (n9 == 0 && array == null) {
                        break;
                    }
                    block = Scaffold.mc.field_71441_e.func_180495_p(new BlockPos(n6, Scaffold.mc.field_71439_g.field_70163_u - 1.0, n7)).func_177230_c();
                }
                if (array != null) {
                    break;
                }
            }
            double n10 = 2;
            continue;
        }
    }
    
    private static double randomNumber(final double n, final double n2) {
        return Math.random() * (n - n2) + n2;
    }
    
    private Class357 getBlockData(BlockPos func_177977_b) {
        Class357 class357 = null;
        final int[] b = Class139.b();
        int n = 0;
        final int[] array = b;
        while (true) {
            boolean b2;
            int blockPosAir;
            int n17;
            int n16;
            int n15;
            int n14;
            int n13;
            int n12;
            int n11;
            int n10;
            int n9;
            int n8;
            int n7;
            int n6;
            int n5;
            int n4;
            int n3;
            final int n2 = n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = (n != 0)) ? 1 : 0))))))))))))))));
            if (array == null) {
                if (n2 >= 2 && array == null) {
                    break;
                }
                final int n18;
                n3 = (n18 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(0, 0, 1))) ? 1 : 0)))))))))))))))));
            }
            if (array == null) {
                if (n2 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(0, 0, 1), EnumFacing.NORTH, (Class121)null);
                    break;
                }
                n4 = (n3 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(0, 0, -1))) ? 1 : 0))))))))))))))));
            }
            if (array == null) {
                if (n3 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(0, 0, -1), EnumFacing.SOUTH, (Class121)null);
                    break;
                }
                n5 = (n4 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(1, 0, 0))) ? 1 : 0)))))))))))))));
            }
            if (array == null) {
                if (n4 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(1, 0, 0), EnumFacing.WEST, (Class121)null);
                    break;
                }
                n6 = (n5 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(-1, 0, 0))) ? 1 : 0))))))))))))));
            }
            if (array == null) {
                if (n5 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(-1, 0, 0), EnumFacing.EAST, (Class121)null);
                    break;
                }
                n7 = (n6 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(0, -1, 0))) ? 1 : 0)))))))))))));
            }
            if (array == null) {
                if (n6 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(0, -1, 0), EnumFacing.UP, (Class121)null);
                    break;
                }
                n8 = (n7 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(0, 1, 0))) ? 1 : 0))))))))))));
            }
            Label_0292: {
                if (array == null) {
                    if (n7 == 0) {
                        final int n19 = n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = this.isSneaking) ? 1 : 0)))))))))));
                        if (array != null) {
                            break Label_0292;
                        }
                        if (n19 != 0) {
                            class357 = new Class357(this, func_177977_b.func_177982_a(0, 1, 0), EnumFacing.DOWN, (Class121)null);
                            break;
                        }
                    }
                    n9 = (n8 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(0, 1, 1))) ? 1 : 0)))))))))));
                }
            }
            Label_0343: {
                if (array == null) {
                    if (n8 == 0) {
                        final int n20 = n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = this.isSneaking) ? 1 : 0))))))))));
                        if (array != null) {
                            break Label_0343;
                        }
                        if (n20 != 0) {
                            class357 = new Class357(this, func_177977_b.func_177982_a(0, 1, 1), EnumFacing.DOWN, (Class121)null);
                            break;
                        }
                    }
                    n10 = (n9 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(0, 1, -1))) ? 1 : 0))))))))));
                }
            }
            Label_0394: {
                if (array == null) {
                    if (n9 == 0) {
                        final int n21 = n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = this.isSneaking) ? 1 : 0)))))))));
                        if (array != null) {
                            break Label_0394;
                        }
                        if (n21 != 0) {
                            class357 = new Class357(this, func_177977_b.func_177982_a(0, 1, -1), EnumFacing.DOWN, (Class121)null);
                            break;
                        }
                    }
                    n11 = (n10 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(1, 1, 0))) ? 1 : 0)))))))));
                }
            }
            Label_0445: {
                if (array == null) {
                    if (n10 == 0) {
                        final int n22 = n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = this.isSneaking) ? 1 : 0))))))));
                        if (array != null) {
                            break Label_0445;
                        }
                        if (n22 != 0) {
                            class357 = new Class357(this, func_177977_b.func_177982_a(1, 1, 0), EnumFacing.DOWN, (Class121)null);
                            break;
                        }
                    }
                    n12 = (n11 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(-1, 1, 0))) ? 1 : 0))))))));
                }
            }
            Label_0496: {
                if (array == null) {
                    if (n11 == 0) {
                        final int n23 = n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = this.isSneaking) ? 1 : 0)))))));
                        if (array != null) {
                            break Label_0496;
                        }
                        if (n23 != 0) {
                            class357 = new Class357(this, func_177977_b.func_177982_a(-1, 1, 0), EnumFacing.DOWN, (Class121)null);
                            break;
                        }
                    }
                    n13 = (n12 = (n14 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(1, 0, 1))) ? 1 : 0)))))));
                }
            }
            if (array == null) {
                if (n12 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(1, 0, 1), EnumFacing.NORTH, (Class121)null);
                    break;
                }
                n14 = (n13 = (n15 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(-1, 0, -1))) ? 1 : 0))))));
            }
            if (array == null) {
                if (n13 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(-1, 0, -1), EnumFacing.SOUTH, (Class121)null);
                    break;
                }
                n15 = (n14 = (n16 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(1, 0, 1))) ? 1 : 0)))));
            }
            if (array == null) {
                if (n14 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(1, 0, 1), EnumFacing.WEST, (Class121)null);
                    break;
                }
                n16 = (n15 = (n17 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(-1, 0, -1))) ? 1 : 0))));
            }
            if (array == null) {
                if (n15 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(-1, 0, -1), EnumFacing.EAST, (Class121)null);
                    break;
                }
                n17 = (n16 = (blockPosAir = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(-1, 0, 1))) ? 1 : 0)));
            }
            if (array == null) {
                if (n16 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(-1, 0, 1), EnumFacing.NORTH, (Class121)null);
                    break;
                }
                blockPosAir = (n17 = ((b2 = isBlockPosAir(func_177977_b.func_177982_a(1, 0, -1))) ? 1 : 0));
            }
            if (array == null) {
                if (n17 == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(1, 0, -1), EnumFacing.SOUTH, (Class121)null);
                    break;
                }
                b2 = ((blockPosAir = (isBlockPosAir(func_177977_b.func_177982_a(1, 0, -1)) ? 1 : 0)) != 0);
            }
            if (array == null) {
                if (blockPosAir == 0) {
                    class357 = new Class357(this, func_177977_b.func_177982_a(1, 0, -1), EnumFacing.WEST, (Class121)null);
                    break;
                }
                b2 = isBlockPosAir(func_177977_b.func_177982_a(-1, 0, 1));
            }
            if (!b2) {
                class357 = new Class357(this, func_177977_b.func_177982_a(-1, 0, 1), EnumFacing.EAST, (Class121)null);
                break;
            }
            func_177977_b = func_177977_b.func_177977_b();
            ++n;
        }
        return class357;
    }
    
    private static boolean isBlockPosAir(final BlockPos blockPos) {
        final int[] b = Class139.b();
        final Block blockByPos = getBlockByPos(blockPos);
        if (b == null) {
            if (!lIIIllIIlllI(blockByPos, Blocks.field_150350_a)) {
                return true;
            }
            getBlockByPos(blockPos);
        }
        final boolean b2 = blockByPos instanceof BlockLiquid;
        if (b != null || !b2) {
            return b2;
        }
        return true;
    }
    
    private static Block getBlockByPos(final BlockPos blockPos) {
        return Scaffold.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
    }
    
    private static Vec3 getBlockSide(final BlockPos blockPos, final EnumFacing enumFacing) {
        final int[] b = Class139.b();
        EnumFacing enumFacing2 = enumFacing;
        EnumFacing enumFacing3 = enumFacing;
        EnumFacing enumFacing4 = enumFacing;
        EnumFacing enumFacing6;
        EnumFacing south;
        final EnumFacing enumFacing5 = south = (enumFacing6 = EnumFacing.NORTH);
        if (b == null) {
            if (lIIIllIIllll(enumFacing, enumFacing5)) {
                return new Vec3((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), blockPos.func_177952_p() - 0.5);
            }
            enumFacing2 = enumFacing;
            enumFacing3 = enumFacing;
            enumFacing4 = enumFacing;
            final EnumFacing enumFacing7;
            south = (enumFacing7 = (enumFacing6 = EnumFacing.EAST));
        }
        if (b == null) {
            if (lIIIllIIllll(enumFacing4, enumFacing5)) {
                return new Vec3(blockPos.func_177958_n() + 0.5, (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
            }
            enumFacing2 = enumFacing;
            enumFacing3 = enumFacing;
            enumFacing6 = (south = EnumFacing.SOUTH);
        }
        if (b == null) {
            if (lIIIllIIllll(enumFacing3, south)) {
                return new Vec3((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), blockPos.func_177952_p() + 0.5);
            }
            enumFacing2 = enumFacing;
            enumFacing6 = EnumFacing.WEST;
        }
        if (lIIIllIIllll(enumFacing2, enumFacing6)) {
            return new Vec3(blockPos.func_177958_n() - 0.5, (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
        }
        return new Vec3((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
    }
    
    static {
        lIIIlIllllII();
        Class169.a(-787446043144408732L, 5323266041288407333L, MethodHandles.lookup().lookupClass()).a(229049452181033L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Scaffold.lIllllllIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Scaffold.lIllllllIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(27235475510859L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[14];
        int n2 = 0;
        String s;
        int n3 = (s = Scaffold.lIllllllIl[2]).length();
        int n4 = 24;
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
                    final String intern = b(instance.doFinal(s3.getBytes(Scaffold.lIllllllIl[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Scaffold.lIllllllIl[3]).length();
                            n4 = 24;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
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
        c = c2;
        d = new String[14];
        Scaffold.mode = new Value<String>("Scaffold", "Mode", 0);
        Scaffold.currentlyHolding = null;
    }
    
    private static Exception a(final Exception ex) {
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
    
    private static String b(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5777;
        if (Scaffold.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Scaffold.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Scaffold.lIllllllIl[5]);
                    array[1] = SecretKeyFactory.getInstance(Scaffold.lIllllllIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Scaffold.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Scaffold.lIllllllIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Scaffold.d[n3] = b(((Cipher)array[0]).doFinal(Scaffold.c[n3].getBytes(Scaffold.lIllllllIl[8])));
        }
        return Scaffold.d[n3];
    }
    
    private static void lIIIlIllllII() {
        (lIllllllIl = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Scaffold.lIllllllIl[1] = "DES";
        Scaffold.lIllllllIl[2] = "|'GC¼Î\u009c¡×\u001f`ÅZrk&?¦\u0004\u009abÓ!T\u0010RL\u000bÀÃ\b÷àTjwMYMr\u000e\u00106DÍy\u001a¶é\u000e\u0099¢ÎzxÀ\u008e\u0010\u0018P \u008b\u001eT\u0015\u0014Udþ\u0010Õ}\u000bVOd¾\u001f`\u0086¤Æm\u0018ô\u0091\u0002\u008f\"\u0002Fíï\u0091\u0092Ãe\u00ad\u0017\u0090s\u0089äc¤îåæ\u0010Öú\u0011\u00162´Â\u0015ÚêÑ\u0004\u0099üØ. º\u0014[çË·rè\u0014\u0096h ñyù\u0015É?\u0001ýa¬\u000e;«\u0017\u0091v0\u0018\u009c (\u0092Âl¥Êk\u0090ç\u0082Ó*\u009aDµ\u001a\u0012Ä\bµ¿\u001dC\u0091°T4\u00138\u0092Y\u0004#,>Ú÷4î>é\u0010²\u0017¸çh\u0087|ª\u0014:â@ C\u0004æ\u0010ß\u0007¥\u000fáÅÎïÚñÀZÝE®\u0081\u0010T\u008dÌ¥ð\nþ)\u0000\u0018Q[óä\u007f\u0002\u0018y\u000eÝ14|\u0099¥\u0014sH\u0004DhÖÝC\u008c¬\u0082\u008eB\u0006\u0016";
        Scaffold.lIllllllIl[3] = ".\tWeÝáªÙ\u0004\u0016\"ÞX¶\u0085(\u0015þÐ\u0099]QdI\u0018O\u0084·j¯Çr¢U[`æì3 ð Ò\u009e¾'\u007f1\u0013";
        Scaffold.lIllllllIl[4] = "ISO-8859-1";
        Scaffold.lIllllllIl[5] = "DES/CBC/PKCS5Padding";
        Scaffold.lIllllllIl[6] = "DES";
        Scaffold.lIllllllIl[7] = "还耀武扬威的啊你现在唯一的赌注是不是你的尊严知道不知道三三两两班门弄斧你还要从我这里摸索点什么你想向你爹爹我下跪你羞涩难以启齿是不是孩子NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u2004\u200e\u200c";
        Scaffold.lIllllllIl[8] = "ISO-8859-1";
        Scaffold.lIllllllIl[9] = "还耀武扬威的啊你现在唯一的赌注是不是你的尊严知道不知道三三两两班门弄斧你还要从我这里摸索点什么你想向你爹爹我下跪你羞涩难以启齿是不是孩子NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u2004\u200e\u200c";
        Scaffold.lIllllllIl[10] = " : ";
        Scaffold.lIllllllIl[11] = " : ";
    }
    
    private static String lIIIlIllIIIl(final String s, final String s2) {
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
    
    private static String lIIIlIllIIll(String s, final String s2) {
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
    
    private static String lIIIlIllIIlI(final String s, final String s2) {
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
    
    private static boolean lIIIlllIIIlI$255f299(final int n) {
        return n >= 2;
    }
    
    private static boolean lIIIllIIllII(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIllIIlllI(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIllIIllll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIIllIlIlll(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIIllIlIlII(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIllIllIIl(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIIllIIIlll(final int n) {
        return n > 0;
    }
    
    private static boolean lIIIllIIlIIl(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lIIIllIIlIlI$25399e8(final double n) {
        return dcmpl(n, 0.125);
    }
    
    private static int lIIIllIlIIll$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
    
    private static int lIIIllIlIlIl(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIIllIlIllI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIIIlllIIIIl$25399e8(final double n) {
        return dcmpl(n, 0.8);
    }
}
