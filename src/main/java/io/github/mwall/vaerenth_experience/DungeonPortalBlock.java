package io.github.mwall.vaerenth_experience;

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
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.material.PushReaction;

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
        ResourceKey<Level> dimension = pLevel.dimension() == dimensionToTravel? Level.OVERWORLD : dimensionToTravel;
        pEntity.changeDimension(pLevel.getServer().getLevel(dimension));
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {}


}
