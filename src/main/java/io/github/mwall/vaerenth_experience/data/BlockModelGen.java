package io.github.mwall.vaerenth_experience.data;

import io.github.mwall.vaerenth_experience.VaerenthExperience;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
        portal(VaerenthExperience.DUNGEON_DIM1_PORTAL.get());
        portal(VaerenthExperience.DUNGEON_DIM2_PORTAL.get());
        trophy(VaerenthExperience.COPPER_TROPHY.get(), false);
        trophy(VaerenthExperience.SILVER_TROPHY.get(), false);
        trophy(VaerenthExperience.GOLD_TROPHY.get(), true);
    }

    private void trophy(Block trophy, boolean rearing)
    {
        ResourceLocation key = BuiltInRegistries.BLOCK.getKey(trophy);
        ResourceLocation model = VaerenthExperience.id("block/" + (rearing? "rearing_trophy" : "trophy"));
        ResourceLocation texture = VaerenthExperience.id("block/" + key.getPath());

        horizontalBlock(trophy, models().withExistingParent(key.getPath(), model)
                .texture("0", texture)
                .texture("particle", texture));
    }

    private void portal(Block block)
    {
        getVariantBuilder(block)
                .partialState()
                .with(NetherPortalBlock.AXIS, Direction.Axis.X)
                .addModels(buildPortalModel("ns", block))
                .partialState()
                .with(NetherPortalBlock.AXIS, Direction.Axis.Z)
                .addModels(buildPortalModel("ew", block));
    }

    private ConfiguredModel[] buildPortalModel(String postfix, Block block)
    {
        return ConfiguredModel.builder().modelFile(
                        models()
                                .withExistingParent(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + postfix, "minecraft:block/nether_portal_" + postfix)
                                .texture("portal", blockTexture(Blocks.SPRUCE_TRAPDOOR)))
                .build();
    }
}
