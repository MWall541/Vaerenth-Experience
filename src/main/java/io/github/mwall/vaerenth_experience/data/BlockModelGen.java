package io.github.mwall.vaerenth_experience.data;

import io.github.mwall.vaerenth_experience.VaerenthExperience;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModelGen extends BlockStateProvider
{
    public BlockModelGen(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, VaerenthExperience.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        portal(VaerenthExperience.DUNGEON_DIM1_PORTAL.get(), Blocks.SPRUCE_TRAPDOOR);
        portal(VaerenthExperience.DUNGEON_DIM2_PORTAL.get(), Blocks.SPRUCE_TRAPDOOR);
    }

    private void portal(Block block, Block texture)
    {
        getVariantBuilder(block)
                .partialState()
                .with(NetherPortalBlock.AXIS, Direction.Axis.X)
                .addModels(buildPortalModel("ns", block, texture))
                .partialState()
                .with(NetherPortalBlock.AXIS, Direction.Axis.Z)
                .addModels(buildPortalModel("ew", block, texture));
    }

    private ConfiguredModel[] buildPortalModel(String postfix, Block block, Block texture)
    {
        return ConfiguredModel.builder().modelFile(
                        models()
                                .withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + postfix, "minecraft:block/nether_portal_" + postfix)
                                .texture("portal", blockTexture(texture)))
                .build();
    }
}
