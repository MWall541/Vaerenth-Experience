package io.github.mwall.vaerenth_experience.data;

import dev.kosmx.playerAnim.core.util.Vec3d;
import dev.kosmx.playerAnim.core.util.Vec3f;
import io.github.mwall.vaerenth_experience.VaerenthExperience;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

import java.util.Objects;

public class ItemModelGen extends ItemModelProvider
{
    public ItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, VaerenthExperience.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        breakableWithParent(VaerenthExperience.LONGSWORD_SWORD_OF_KINGS.get(), "handheld_2x");
        breakableWithParent(VaerenthExperience.GREATSWORD_SWORD_OF_KINGS.get(), "greatsword");
        breakableWithParent(VaerenthExperience.KATANA_SWORD_OF_KINGS.get(), "greatsword");

        for (RegistryObject trophy : new RegistryObject[]{
                VaerenthExperience.COPPER_TROPHY,
                VaerenthExperience.SILVER_TROPHY,
                VaerenthExperience.GOLD_TROPHY,
        }) withExistingParent(trophy.getId().getPath(), VaerenthExperience.id("block/" + trophy.getId().getPath()))
                .rootTransforms()
                .scale(0.5f)
                .translation(-0.2f, -0.2f, -0.7f)
                .rotation(0, 90, 0, true)
                .end();
    }

    private ItemModelBuilder breakableWithParent(Item item, String parent)
    {
        ResourceLocation key = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        ResourceLocation broken = new ResourceLocation(key.getNamespace(), "broken_" + key.getPath());

        basicItem(broken);
        return getBuilder(key.toString())
                .parent(new ModelFile.UncheckedModelFile("dixtas_armory:item/" + parent))
                .texture("layer0", new ResourceLocation(key.getNamespace(), "item/" + key.getPath()))
                .override()
                .predicate(VaerenthExperience.id("broken"), 1)
                .model(new ModelFile.UncheckedModelFile(new ResourceLocation(broken.getNamespace(), "item/" + broken.getPath())))
                .end();
    }
}
