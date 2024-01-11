/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */
package net.rose.sbwd.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Plush
        extends HorizontalFacingBlock {
    public Plush(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        return super.getFluidState(state);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch (dir) {
            case NORTH:
                return Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
            case SOUTH:
                return Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
            case EAST:
                return Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
            case WEST:
                return Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
            default:
                return Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);


        }
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());

    }
}