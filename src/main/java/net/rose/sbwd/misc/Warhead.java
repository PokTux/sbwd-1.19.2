package net.rose.sbwd.misc;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.rose.sbwd.entity.custom.NukeEntity;

import java.util.function.Predicate;

public final class Warhead {
    private Warhead() {

    }

    public static void explode(ServerWorld world, double x, double y, double z, int radius, Predicate<BlockState> statePredicate) {
        int radiusSq = radius * radius;
        var pos = new BlockPos.Mutable();

        for (int ox = -radius; ox < radius; ox++) {
            for (int oy = -radius; oy < radius; oy++) {
                for (int oz = -radius; oz < radius; oz++) {
                    if (ox * ox + oy * oy + oz * oz > radiusSq) continue;

                    pos.set(x + ox, y + oy, z + oz);
                    var state = world.getBlockState(pos);

                    if (state.isAir() || state.getBlock().getBlastResistance() > 1000) continue;

                    if (!statePredicate.test(state)) continue;

                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                }
            }
        }

    }
}