package net.anchikai.endium.block;

import net.anchikai.endium.misc.EndiumModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class AmaranthSaplingBlock extends SaplingBlock {
    public AmaranthSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(EndiumModTags.AMARANTH_PLANTABLE);
    }
}
