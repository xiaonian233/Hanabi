package cn.Hanabi.injection.mixins;

import net.minecraft.client.renderer.chunk.*;
import org.spongepowered.asm.mixin.*;
import java.util.*;
import net.minecraft.util.*;

@Mixin({ VisGraph.class })
public abstract class MixinVisGraph
{
    @Shadow
    private BitSet field_178612_d;
    @Shadow
    private static int[] field_178613_e;
    @Shadow
    private int field_178611_f;
    
    public MixinVisGraph() {
        super();
    }
    
    private static int getIndex(final BlockPos blockPos) {
        return (blockPos.func_177958_n() & 0xF) | (blockPos.func_177956_o() & 0xF) << 8 | (blockPos.func_177952_p() & 0xF) << 4;
    }
    
    private static int getIndex(final int n, final int n2, final int n3) {
        return n | n2 << 8 | n3 << 4;
    }
    
    @Shadow
    public abstract Set<EnumFacing> func_178604_a$7d02b99d();
}
