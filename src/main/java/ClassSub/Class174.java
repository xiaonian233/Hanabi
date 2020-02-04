package ClassSub;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import java.lang.invoke.*;

public final class Class174
{
    private Class63 startVec3;
    private Class63 endVec3;
    public ArrayList<Class63> path;
    private ArrayList<Class56> hubs;
    private ArrayList<Class56> hubsToWork;
    private double minDistanceSquared;
    private boolean nearest;
    private static Class63[] flatCardinalDirections;
    private static final long a;
    
    public Class174(final Class63 class63, final Class63 class64) {
        super();
        this.path = new ArrayList<Class63>();
        this.hubs = new ArrayList<Class56>();
        this.hubsToWork = new ArrayList<Class56>();
        this.minDistanceSquared = 9.0;
        this.nearest = true;
        this.startVec3 = class63.addVector(0.0, 0.0, 0.0).floor();
        this.endVec3 = class64.addVector(0.0, 0.0, 0.0).floor();
    }
    
    private ArrayList<Class63> getPath() {
        return this.path;
    }
    
    public final void compute() {
        this.path.clear();
        this.hubsToWork.clear();
        final int[] b = Class139.b();
        final ArrayList<Class63> list;
        (list = new ArrayList<Class63>()).add(this.startVec3);
        this.hubsToWork.add(new Class56(this.startVec3, null, list, this.startVec3.squareDistanceTo(this.endVec3), 0.0));
        int n = 0;
        final int[] array = b;
        while (true) {
            while (true) {
            Label_0396:
                do {
                    int n2 = 0;
                    Label_0072: {
                        n2 = 1000;
                    }
                    int i = 0;
                    Label_0076:
                    while (i < n2) {
                        Collections.sort(this.hubsToWork, new Class347());
                        int n3 = 0;
                        final ArrayList<Class56> hubsToWork = this.hubsToWork;
                        if (array == null) {
                            final int size = hubsToWork.size();
                            if (array != null) {
                                if (size != 0) {
                                    Collections.sort(this.hubs, new Class347());
                                    final Class174 class174 = this;
                                    class174.path = this.hubs.get(0).path;
                                }
                                return;
                            }
                            if (size == 0 && array == null) {
                                break;
                            }
                            final ArrayList list2 = new ArrayList(this.hubsToWork);
                        }
                        final Iterator<Class56> iterator = hubsToWork.iterator();
                        Label_0385:
                        do {
                            iterator.hasNext();
                            boolean checkPositionValidity$4755ca02 = false;
                            Label_0141:
                            while (checkPositionValidity$4755ca02) {
                                final Class56 class175 = iterator.next();
                                i = ++n3;
                                if (array == null) {
                                    n2 = 4;
                                    if (array != null) {
                                        continue Label_0076;
                                    }
                                    if (i > 4 && array == null) {
                                        break;
                                    }
                                    this.hubsToWork.remove(class175);
                                    this.hubs.add(class175);
                                }
                                final Class63[] flatCardinalDirections;
                                final int length = (flatCardinalDirections = Class174.flatCardinalDirections).length;
                                int j = 0;
                                while (j < length) {
                                    final Class63 class176 = flatCardinalDirections[j];
                                    final Class63 floor = class175.loc.addVector(class176.x, class176.y, class176.z).floor();
                                    if (array == null) {
                                        checkPositionValidity$4755ca02 = checkPositionValidity$4755ca02(floor);
                                        if (array != null) {
                                            continue Label_0141;
                                        }
                                        if (checkPositionValidity$4755ca02 && this.addHub$58f7968f(class175, floor) && array == null) {
                                            break Label_0396;
                                        }
                                        ++j;
                                    }
                                    if (array != null) {
                                        break;
                                    }
                                }
                                Class63 floor3;
                                Class63 floor2;
                                final Class63 class177 = floor2 = (floor3 = class175.loc.addVector(0.0, 1.0, 0.0).floor());
                                if (array == null) {
                                    if (checkPositionValidity$4755ca02(class177) && this.addHub$58f7968f(class175, class177) && array == null) {
                                        break Label_0396;
                                    }
                                    floor3 = (floor2 = class175.loc.addVector(0.0, -1.0, 0.0).floor());
                                }
                                final Class63 class178 = floor2;
                                final boolean checkPositionValidity$4755ca3 = checkPositionValidity$4755ca02(floor3);
                                if (array == null) {
                                    if (!checkPositionValidity$4755ca3) {
                                        continue Label_0385;
                                    }
                                    this.addHub$58f7968f(class175, class178);
                                }
                                if (!checkPositionValidity$4755ca3 || array != null) {
                                    continue Label_0385;
                                }
                                break Label_0396;
                            }
                            break;
                        } while (array == null);
                        ++n;
                        continue Label_0072;
                    }
                    break;
                } while (array == null);
                final Class174 class174 = this;
                if (array == null) {
                    final boolean nearest = this.nearest;
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private void compute$255f295() {
        this.path.clear();
        this.hubsToWork.clear();
        final int[] b = Class139.b();
        final ArrayList<Class63> list;
        (list = new ArrayList<Class63>()).add(this.startVec3);
        this.hubsToWork.add(new Class56(this.startVec3, null, list, this.startVec3.squareDistanceTo(this.endVec3), 0.0));
        int n = 0;
        final int[] array = b;
        while (true) {
            while (true) {
            Label_0392:
                do {
                    int n2 = 0;
                    Label_0070: {
                        n2 = 1000;
                    }
                    int i = 0;
                    Label_0074:
                    while (i < n2) {
                        Collections.sort(this.hubsToWork, new Class347());
                        int n3 = 0;
                        final ArrayList<Class56> hubsToWork = this.hubsToWork;
                        if (array == null) {
                            final int size = hubsToWork.size();
                            if (array != null) {
                                if (size != 0) {
                                    Collections.sort(this.hubs, new Class347());
                                    final Class174 class174 = this;
                                    class174.path = this.hubs.get(0).path;
                                }
                                return;
                            }
                            if (size == 0 && array == null) {
                                break;
                            }
                            final ArrayList list2 = new ArrayList(this.hubsToWork);
                        }
                        final Iterator<Class56> iterator = hubsToWork.iterator();
                        Label_0381:
                        do {
                            iterator.hasNext();
                            boolean checkPositionValidity$4755ca02 = false;
                            Label_0138:
                            while (checkPositionValidity$4755ca02) {
                                final Class56 class175 = iterator.next();
                                i = ++n3;
                                if (array == null) {
                                    n2 = 4;
                                    if (array != null) {
                                        continue Label_0074;
                                    }
                                    if (i > 4 && array == null) {
                                        break;
                                    }
                                    this.hubsToWork.remove(class175);
                                    this.hubs.add(class175);
                                }
                                final Class63[] flatCardinalDirections;
                                final int length = (flatCardinalDirections = Class174.flatCardinalDirections).length;
                                int j = 0;
                                while (j < length) {
                                    final Class63 class176 = flatCardinalDirections[j];
                                    final Class63 floor = class175.loc.addVector(class176.x, class176.y, class176.z).floor();
                                    if (array == null) {
                                        checkPositionValidity$4755ca02 = checkPositionValidity$4755ca02(floor);
                                        if (array != null) {
                                            continue Label_0138;
                                        }
                                        if (checkPositionValidity$4755ca02 && this.addHub$58f7968f(class175, floor) && array == null) {
                                            break Label_0392;
                                        }
                                        ++j;
                                    }
                                    if (array != null) {
                                        break;
                                    }
                                }
                                Class63 floor3;
                                Class63 floor2;
                                final Class63 class177 = floor2 = (floor3 = class175.loc.addVector(0.0, 1.0, 0.0).floor());
                                if (array == null) {
                                    if (checkPositionValidity$4755ca02(class177) && this.addHub$58f7968f(class175, class177) && array == null) {
                                        break Label_0392;
                                    }
                                    floor3 = (floor2 = class175.loc.addVector(0.0, -1.0, 0.0).floor());
                                }
                                final Class63 class178 = floor2;
                                final boolean checkPositionValidity$4755ca3 = checkPositionValidity$4755ca02(floor3);
                                if (array == null) {
                                    if (!checkPositionValidity$4755ca3) {
                                        continue Label_0381;
                                    }
                                    this.addHub$58f7968f(class175, class178);
                                }
                                if (!checkPositionValidity$4755ca3 || array != null) {
                                    continue Label_0381;
                                }
                                break Label_0392;
                            }
                            break;
                        } while (array == null);
                        ++n;
                        continue Label_0070;
                    }
                    break;
                } while (array == null);
                final Class174 class174 = this;
                if (array == null) {
                    final boolean nearest = this.nearest;
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private static boolean checkPositionValidity$4755ca02(final Class63 class63) {
        return checkPositionValidity$3b4dbe76((int)class63.x, (int)class63.y, (int)class63.z);
    }
    
    public static boolean checkPositionValidity$3b4dbe76(final int n, final int n2, final int n3) {
        final BlockPos blockPos = new BlockPos(n, n2, n3);
        final int[] b = Class139.b();
        final BlockPos blockPos2 = new BlockPos(n, n2 + 1, n3);
        final BlockPos blockPos3 = new BlockPos(n, n2 - 1, n3);
        final int[] array = b;
        boolean b5;
        boolean b4;
        boolean b3;
        final boolean b2 = b3 = (b4 = (b5 = isBlockSolid(blockPos)));
        if (array == null) {
            if (b2) {
                return false;
            }
            final boolean b6;
            b3 = (b6 = (b4 = (b5 = isBlockSolid(blockPos2))));
        }
        if (array == null) {
            if (b2) {
                return false;
            }
            b3 = (b5 = isBlockSolid(blockPos3));
        }
        final boolean b7;
        final boolean b10;
        Label_0143: {
            if (array == null) {
                if (!b3) {
                    b7 = (b5 = false);
                    if (array != null) {
                        break Label_0143;
                    }
                    if (b7) {
                        return false;
                    }
                }
                final int[] b8 = Class139.b();
                final boolean b9 = b4 = (b5 = (Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos3).func_177230_c() instanceof BlockFence));
                Label_0142: {
                    if (b8 == null) {
                        if (b9) {
                            break Label_0142;
                        }
                        b10 = (Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos3).func_177230_c() instanceof BlockWall);
                    }
                    if (b8 == null && b9) {}
                }
            }
        }
        if (array != null || b7) {
            return b10;
        }
        return false;
    }
    
    private static boolean isBlockSolid(final BlockPos blockPos) {
        final int[] b = Class139.b();
        final boolean func_149730_j = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c().func_149730_j();
        if (b == null) {
            if (!func_149730_j) {
                final boolean b2 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockSlab;
                if (b == null) {
                    if (!b2) {
                        final boolean b3 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockStairs;
                        if (b == null) {
                            if (!b3) {
                                final boolean b4 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockCactus;
                                if (b == null) {
                                    if (!b4) {
                                        final boolean b5 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockChest;
                                        if (b == null) {
                                            if (!b5) {
                                                final boolean b6 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockEnderChest;
                                                if (b == null) {
                                                    if (!b6) {
                                                        final boolean b7 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockSkull;
                                                        if (b == null) {
                                                            if (!b7) {
                                                                final boolean b8 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockPane;
                                                                if (b == null) {
                                                                    if (!b8) {
                                                                        final boolean b9 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockFence;
                                                                        if (b == null) {
                                                                            if (!b9) {
                                                                                final boolean b10 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockWall;
                                                                                if (b == null) {
                                                                                    if (!b10) {
                                                                                        final boolean b11 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockGlass;
                                                                                        if (b == null) {
                                                                                            if (!b11) {
                                                                                                final boolean b12 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockPistonBase;
                                                                                                if (b == null) {
                                                                                                    if (!b12) {
                                                                                                        final boolean b13 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockPistonExtension;
                                                                                                        if (b == null) {
                                                                                                            if (!b13) {
                                                                                                                final boolean b14 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockPistonMoving;
                                                                                                                if (b == null) {
                                                                                                                    if (!b14) {
                                                                                                                        final boolean b15 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockStainedGlass;
                                                                                                                        if (b == null) {
                                                                                                                            if (!b15) {
                                                                                                                                final boolean b16 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockTrapDoor;
                                                                                                                                if (b == null) {
                                                                                                                                    if (!b16) {
                                                                                                                                        return false;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return func_149730_j;
    }
    
    private static boolean isSafeToWalkOn(final BlockPos blockPos) {
        final int[] b = Class139.b();
        boolean b3;
        final boolean b2 = b3 = (Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockFence);
        if (b == null) {
            if (b2) {
                return false;
            }
            final boolean b4;
            b3 = (b4 = (Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockWall));
        }
        if (b == null) {
            if (b2) {
                return false;
            }
            b3 = true;
        }
        return b3;
    }
    
    private Class56 isHubExisting(final Class63 class63) {
        final int[] b = Class139.b();
        Iterator<Class56> iterator = this.hubs.iterator();
        final int[] array = b;
        while (true) {
            while (iterator.hasNext()) {
                final Class56 class64;
                boolean hasNext;
                double n2;
                final int n = (int)(n2 = ((hasNext = dcmpl((class64 = iterator.next()).loc.x, class63.x)) ? 1 : 0));
                if (array != null) {
                    while (true) {
                        if (hasNext) {
                            final Class56 class65;
                            double n4;
                            final double n3 = n4 = dcmpl((class65 = iterator.next()).loc.x, class63.x);
                            Label_0192: {
                                if (array == null) {
                                    if (n3 != 0) {
                                        break Label_0192;
                                    }
                                    final double n5;
                                    n4 = (n5 = dcmpl(class65.loc.y, class63.y));
                                }
                                final Class56 class66;
                                if (array == null) {
                                    if (n3 != 0) {
                                        break Label_0192;
                                    }
                                    class66 = class65;
                                    if (array != null) {
                                        return class66;
                                    }
                                    n4 = dcmpl(class66.loc.z, class63.z);
                                }
                                if (n4 != 0) {
                                    break Label_0192;
                                }
                                return class66;
                            }
                            if (array == null) {
                                hasNext = iterator.hasNext();
                                continue;
                            }
                        }
                        break;
                    }
                    return null;
                }
                Label_0098: {
                    if (array == null) {
                        if (n != 0) {
                            break Label_0098;
                        }
                        final int n6;
                        n2 = (n6 = dcmpl(class64.loc.y, class63.y));
                    }
                    final Class56 class67;
                    if (array == null) {
                        if (n != 0) {
                            break Label_0098;
                        }
                        class67 = class64;
                        if (array != null) {
                            return class67;
                        }
                        n2 = dcmpl(class67.loc.z, class63.z);
                    }
                    if (n2 != 0) {
                        break Label_0098;
                    }
                    return class67;
                }
                if (array != null) {
                    break;
                }
            }
            iterator = this.hubsToWork.iterator();
            continue;
        }
    }
    
    private boolean addHub$58f7968f(final Class56 parent, final Class63 loc) {
        final Class56 hubExisting = this.isHubExisting(loc);
        final int[] b = Class139.b();
        double totalCost = 0.0;
        final int[] array = b;
        Class56 class56 = parent;
        Class56 class57 = parent;
        if (array == null) {
            if (parent != null) {
                totalCost = 0.0 + parent.totalCost;
            }
            class56 = (class57 = hubExisting);
        }
        if (array == null) {
            Label_0215: {
                if (class57 == null) {
                    double n3;
                    double n2;
                    final double n = n2 = (n3 = dcmpl(loc.x, this.endVec3.x));
                    final double n5;
                    Label_0137: {
                        final double n4;
                        Label_0102: {
                            if (array == null) {
                                if (n == 0) {
                                    n4 = (n3 = dcmpl(loc.y, this.endVec3.y));
                                    if (array != null) {
                                        break Label_0102;
                                    }
                                    if (n4 == 0) {
                                        n5 = dcmpl(loc.z, this.endVec3.z);
                                        if (array != null) {
                                            return n5 != 0.0;
                                        }
                                        if (n5 == 0) {
                                            break Label_0137;
                                        }
                                    }
                                }
                                final double n6 = dcmpl(this.minDistanceSquared, 0.0);
                            }
                        }
                        Label_0163: {
                            if (array == null) {
                                if (n == 0) {
                                    break Label_0163;
                                }
                                n2 = dcmpg(loc.squareDistanceTo(this.endVec3), this.minDistanceSquared);
                            }
                            if (array != null) {
                                return n5 != 0.0;
                            }
                            if (n4 <= 0) {
                                break Label_0137;
                            }
                        }
                        final ArrayList<Class63> list;
                        (list = new ArrayList<Class63>(parent.path)).add(loc);
                        this.hubsToWork.add(new Class56(loc, parent, list, loc.squareDistanceTo(this.endVec3), totalCost));
                        if (array != null) {
                            break Label_0215;
                        }
                        goto Label_0301;
                    }
                    this.path.clear();
                    (this.path = parent.path).add(loc);
                    return n5 != 0.0;
                }
            }
            class56 = hubExisting;
        }
        final double n7 = dcmpl(class56.cost, 0.0);
        if (array == null && n7 > 0) {
            final ArrayList<Class63> path;
            (path = new ArrayList<Class63>(parent.path)).add(loc);
            hubExisting.loc = loc;
            hubExisting.parent = parent;
            hubExisting.path = path;
            hubExisting.squareDistanceToFromTarget = loc.squareDistanceTo(this.endVec3);
            hubExisting.cost = 0.0;
            hubExisting.totalCost = totalCost;
            goto Label_0301;
        }
        return n7 != 0.0;
    }
    
    static {
        Class169.a(2314052536093422052L, 6421951297452323561L, MethodHandles.lookup().lookupClass()).a(188206197651216L);
        Class174.flatCardinalDirections = new Class63[] { new Class63(1.0, 0.0, 0.0), new Class63(-1.0, 0.0, 0.0), new Class63(0.0, 0.0, 1.0), new Class63(0.0, 0.0, -1.0) };
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIIIllIlIlll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIIllIllllI(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIIIllIlllll(final int n) {
        return n > 0;
    }
    
    private static int lIIIIllIllIlI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIIIllIllIll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIIIllIlllII(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
