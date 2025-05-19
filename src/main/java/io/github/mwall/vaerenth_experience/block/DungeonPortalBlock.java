package io.github.mwall.vaerenth_experience.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.common.util.ITeleporter;

public class DungeonPortalBlock extends NetherPortalBlock
{
    private final ResourceKey<Level> dimensionToTravel;

    public DungeonPortalBlock(ResourceKey<Level> dimension)
    {
        super(BlockBehaviour.Properties
                .of()
                .noCollission()
                .randomTicks()
                .strength(-1.0F)
                .sound(SoundType.GLASS)
                .lightLevel($ -> 11)
                .pushReaction(PushReaction.BLOCK));

        this.dimensionToTravel = dimension;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {}

    @Override
    @SuppressWarnings("ConstantConditions")
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity)
    {
        if (pLevel instanceof ServerLevel server && pEntity.canChangeDimensions() && Shapes.joinIsNotEmpty(Shapes.create(pEntity.getBoundingBox().move(-pPos.getX(), -pPos.getY(), -pPos.getZ())), pState.getShape(pLevel, pPos), BooleanOp.AND))
        {
            ResourceKey<Level> dimension = pLevel.dimension() == dimensionToTravel? Level.OVERWORLD : dimensionToTravel;
            ServerLevel destination = server.getServer().getLevel(dimension);
            if (destination != null)
                pEntity.changeDimension(destination, new ITeleporter() {}); // necessary for custom forge changeDim implementation
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {}
}
