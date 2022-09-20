package net.anchikai.endium.block.custom;

import net.anchikai.endium.screen.ChromiumAnvilScreenHandler;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModAnvilBlock extends AnvilBlock {
    private static final Text TITLE = Text.translatable("container.repair");

    public ModAnvilBlock(Settings settings) {
        super(settings);
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> new ChromiumAnvilScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos)), TITLE);
    }
}