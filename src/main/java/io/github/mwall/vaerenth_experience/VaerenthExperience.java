package io.github.mwall.vaerenth_experience;

import io.github.mwall.vaerenth_experience.block.DungeonPortalBlock;
import io.github.mwall.vaerenth_experience.block.TrophyBlock;
import io.github.mwall.vaerenth_experience.data.DataGenProviders;
import io.github.mwall.vaerenth_experience.weapons.IExtraItemDamage;
import io.github.mwall.vaerenth_experience.weapons.RevivalStaffItem;
import io.github.mwall.vaerenth_experience.weapons.SwordOfKings;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
import net.dixta.dixtas_armory.item.custom.attributes.*;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod(VaerenthExperience.MODID)
public class VaerenthExperience
{
    public static final String MODID = "vaerenth_experience";

    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> LONGSWORD_SWORD_OF_KINGS = ITEM_REGISTRY.register("longsword_sword_of_kings", SwordOfKings::new);
    public static final RegistryObject<Item> GREATSWORD_SWORD_OF_KINGS = ITEM_REGISTRY.register("greatsword_sword_of_kings", SwordOfKings::new);
    public static final RegistryObject<Item> KATANA_SWORD_OF_KINGS = ITEM_REGISTRY.register("katana_sword_of_kings", SwordOfKings::new);


    public static final RegistryObject<Item> KNIGHT_OF_VAERENTH_SHIELD = ITEM_REGISTRY.register("knight_of_vaerenth_shield", () -> new ShieldItem((new Item.Properties()).durability(20000)));

    public static final RegistryObject<Item> REVIVAL_STAFF = ITEM_REGISTRY.register("revival_staff", () -> new RevivalStaffItem((new Item.Properties()).durability(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> GREYELF_DAGGER = ITEM_REGISTRY.register("greyelf_dagger", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 3.5F, (new Item.Properties()), 1.8f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 15, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_SHORTSWORD = ITEM_REGISTRY.register("greyelf_shortsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 2, 2.2F, (new Item.Properties()), 2.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.75F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_STILETTO = ITEM_REGISTRY.register("greyelf_stiletto", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.5F, (new Item.Properties()), 2.0f, new AttackAttribute(0.0F, 0.25F, 4.0F, 0.0F, 17, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_RAPIER = ITEM_REGISTRY.register("greyelf_rapier", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.0F, (new Item.Properties()), 3.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 3.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_KATANA = ITEM_REGISTRY.register("greyelf_katana", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.8F, (new Item.Properties()), 3.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 2, 5, 0.05F, 1.0F), new SweepAttribute(true, 2.0F, 1.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_GREATSWORD = ITEM_REGISTRY.register("greyelf_greatsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.2F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 5.0F, 1.5F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_LONGSWORD = ITEM_REGISTRY.register("greyelf_longsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 5, 1.3F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 2.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_TWINBLADE = ITEM_REGISTRY.register("greyelf_twinblade", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.9F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_ZWEIHANDER = ITEM_REGISTRY.register("greyelf_zweihander", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.5F), new SweepAttribute(true, 2.0F, 2.5F), ThrownWeaponAttribute.none, false), -1));

//    public static final RegistryObject<Item> GREYELF_BATTLEAXE = ITEM_REGISTRY.register("greyelf_battle_axe", () -> new AdvancedAxeItem(Tiers.DIAMOND, 11.0F, -3.4F, (new Item.Properties()), 3.25f, 0.0F, 0.0F, 2, 1, 5, 0.1F, 0.25F, 20, 1, 0.5F, null));

    public static final RegistryObject<Item> GREYELF_GLAIVE = ITEM_REGISTRY.register("greyelf_glaive", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.5F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_SPEAR = ITEM_REGISTRY.register("greyelf_spear", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 1, 1.3F, (new Item.Properties()), 4.199999809265137f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 3, 0.1F, 0.55F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREY_ELF_HALBERD = ITEM_REGISTRY.register("greyelf_halberd", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 0.7F, (new Item.Properties()), 4.5f, new AttackAttribute(0.0F, 0.5F, 4.0F, 0.0F, 20, 1.5F, 1.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.2F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GREYELF_PIKE = ITEM_REGISTRY.register("greyelf_pike", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 0.8F, (new Item.Properties()), 5.0f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.3F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_DAGGER = ITEM_REGISTRY.register("dwarfish_dagger", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 3.5F, (new Item.Properties()), 1.8f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 15, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_SHORTSWORD = ITEM_REGISTRY.register("dwarfish_shortsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 2, 2.2F, (new Item.Properties()), 2.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.75F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_STILETTO = ITEM_REGISTRY.register("dwarfish_stiletto", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.5F, (new Item.Properties()), 2.0f, new AttackAttribute(0.0F, 0.25F, 4.0F, 0.0F, 17, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_RAPIER = ITEM_REGISTRY.register("dwarfish_rapier", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.0F, (new Item.Properties()), 3.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 3.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_KATANA = ITEM_REGISTRY.register("dwarfish_katana", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.8F, (new Item.Properties()), 3.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 2, 5, 0.05F, 1.0F), new SweepAttribute(true, 2.0F, 1.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_GREATSWORD = ITEM_REGISTRY.register("dwarfish_greatsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.2F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 5.0F, 1.5F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_LONGSWORD = ITEM_REGISTRY.register("dwarfish_longsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 5, 1.3F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 2.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_TWINBLADE = ITEM_REGISTRY.register("dwarfish_twinblade", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.9F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_ZWEIHANDER = ITEM_REGISTRY.register("dwarfish_zweihander", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.5F), new SweepAttribute(true, 2.0F, 2.5F), ThrownWeaponAttribute.none, false), -1));

//    public static final RegistryObject<Item> DWARFISH_BATTLEAXE = ITEM_REGISTRY.register("dwarfish_battle_axe", () -> new AdvancedAxeItem(Tiers.DIAMOND, 11.0F, -3.4F, (new Item.Properties()), 3.25f, 0.0F, 0.0F, 2, 1, 5, 0.1F, 0.25F, 20, 1, 0.5F, null));

    public static final RegistryObject<Item> DWARFISH_GLAIVE = ITEM_REGISTRY.register("dwarfish_glaive", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.5F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_SPEAR = ITEM_REGISTRY.register("dwarfish_spear", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 1, 1.3F, (new Item.Properties()), 4.199999809265137f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 3, 0.1F, 0.55F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_HALBERD = ITEM_REGISTRY.register("dwarfish_halberd", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 0.7F, (new Item.Properties()), 4.5f, new AttackAttribute(0.0F, 0.5F, 4.0F, 0.0F, 20, 1.5F, 1.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.2F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> DWARFISH_PIKE = ITEM_REGISTRY.register("dwarfish_pike", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 0.8F, (new Item.Properties()), 5.0f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.3F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_DAGGER = ITEM_REGISTRY.register("goblin_dagger", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 3.5F, (new Item.Properties()), 1.8f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 15, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_SHORTSWORD = ITEM_REGISTRY.register("goblin_shortsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 2, 2.2F, (new Item.Properties()), 2.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.75F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_STILETTO = ITEM_REGISTRY.register("goblin_stiletto", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.5F, (new Item.Properties()), 2.0f, new AttackAttribute(0.0F, 0.25F, 4.0F, 0.0F, 17, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_RAPIER = ITEM_REGISTRY.register("goblin_rapier", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.0F, (new Item.Properties()), 3.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 3.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_KATANA = ITEM_REGISTRY.register("goblin_katana", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.8F, (new Item.Properties()), 3.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 2, 5, 0.05F, 1.0F), new SweepAttribute(true, 2.0F, 1.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_GREATSWORD = ITEM_REGISTRY.register("goblin_greatsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.2F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 5.0F, 1.5F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_LONGSWORD = ITEM_REGISTRY.register("goblin_longsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 5, 1.3F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 2.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_TWINBLADE = ITEM_REGISTRY.register("goblin_twinblade", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.9F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_ZWEIHANDER = ITEM_REGISTRY.register("goblin_zweihander", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.5F), new SweepAttribute(true, 2.0F, 2.5F), ThrownWeaponAttribute.none, false), -1));

//    public static final RegistryObject<Item> GOBLIN_BATTLEAXE = ITEM_REGISTRY.register("goblin_battle_axe", () -> new AdvancedAxeItem(Tiers.DIAMOND, 11.0F, -3.4F, (new Item.Properties()), 3.25f, 0.0F, 0.0F, 2, 1, 5, 0.1F, 0.25F, 20, 1, 0.5F, null));

    public static final RegistryObject<Item> GOBLIN_GLAIVE = ITEM_REGISTRY.register("goblin_glaive", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.5F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_SPEAR = ITEM_REGISTRY.register("goblin_spear", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 1, 1.3F, (new Item.Properties()), 4.199999809265137f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 3, 0.1F, 0.55F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_HALBERD = ITEM_REGISTRY.register("goblin_halberd", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 0.7F, (new Item.Properties()), 4.5f, new AttackAttribute(0.0F, 0.5F, 4.0F, 0.0F, 20, 1.5F, 1.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.2F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> GOBLIN_PIKE = ITEM_REGISTRY.register("goblin_pike", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 0.8F, (new Item.Properties()), 5.0f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.3F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_DAGGER = ITEM_REGISTRY.register("orcish_dagger", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 3.5F, (new Item.Properties()), 1.8f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 15, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_SHORTSWORD = ITEM_REGISTRY.register("orcish_shortsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 2, 2.2F, (new Item.Properties()), 2.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.75F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_STILETTO = ITEM_REGISTRY.register("orcish_stiletto", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.5F, (new Item.Properties()), 2.0f, new AttackAttribute(0.0F, 0.25F, 4.0F, 0.0F, 17, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_RAPIER = ITEM_REGISTRY.register("orcish_rapier", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.0F, (new Item.Properties()), 3.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 3.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_KATANA = ITEM_REGISTRY.register("orcish_katana", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.8F, (new Item.Properties()), 3.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 2, 5, 0.05F, 1.0F), new SweepAttribute(true, 2.0F, 1.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_GREATSWORD = ITEM_REGISTRY.register("orcish_greatsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.2F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 5.0F, 1.5F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_LONGSWORD = ITEM_REGISTRY.register("orcish_longsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 5, 1.3F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 2.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_TWINBLADE = ITEM_REGISTRY.register("orcish_twinblade", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.9F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_ZWEIHANDER = ITEM_REGISTRY.register("orcish_zweihander", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.5F), new SweepAttribute(true, 2.0F, 2.5F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_BATTLEAXE = ITEM_REGISTRY.register("orcish_battle_axe", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 11.0F, -3.4F, (new Item.Properties()), 3.25f, new AttackAttribute(0, 0, 0, 0, 20, 0, 0F, 0, false, 0), new TwoHandedAttribute(2, 1, 5, 0.1f, 0.25f), SweepAttribute.none, ThrownWeaponAttribute.none, true), -1));

    public static final RegistryObject<Item> ORCISH_GLAIVE = ITEM_REGISTRY.register("orcish_glaive", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.5F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_SPEAR = ITEM_REGISTRY.register("orcish_spear", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 1, 1.3F, (new Item.Properties()), 4.199999809265137f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 3, 0.1F, 0.55F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_HALBERD = ITEM_REGISTRY.register("orcish_halberd", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 0.7F, (new Item.Properties()), 4.5f, new AttackAttribute(0.0F, 0.5F, 4.0F, 0.0F, 20, 1.5F, 1.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.2F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> ORCISH_PIKE = ITEM_REGISTRY.register("orcish_pike", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 0.8F, (new Item.Properties()), 5.0f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.3F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_DAGGER = ITEM_REGISTRY.register("woodelf_dagger", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 3.5F, (new Item.Properties()), 1.8f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 15, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_SHORTSWORD = ITEM_REGISTRY.register("woodelf_shortsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 2, 2.2F, (new Item.Properties()), 2.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 0.75F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_STILETTO = ITEM_REGISTRY.register("woodelf_stiletto", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.5F, (new Item.Properties()), 2.0f, new AttackAttribute(0.0F, 0.25F, 4.0F, 0.0F, 17, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_RAPIER = ITEM_REGISTRY.register("woodelf_rapier", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 0, 2.0F, (new Item.Properties()), 3.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 3.0F, 20, 0.0F, 0.0F, 0, false, 0), TwoHandedAttribute.none, new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_KATANA = ITEM_REGISTRY.register("woodelf_katana", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.8F, (new Item.Properties()), 3.25f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 2, 5, 0.05F, 1.0F), new SweepAttribute(true, 2.0F, 1.25F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_GREATSWORD = ITEM_REGISTRY.register("woodelf_greatsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.2F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 5.0F, 1.5F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_LONGSWORD = ITEM_REGISTRY.register("woodelf_longsword", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 5, 1.3F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 2.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_TWINBLADE = ITEM_REGISTRY.register("woodelf_twinblade", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 3, 1.9F, (new Item.Properties()), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_ZWEIHANDER = ITEM_REGISTRY.register("woodelf_zweihander", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.5F), new SweepAttribute(true, 2.0F, 2.5F), ThrownWeaponAttribute.none, false), -1));

//    public static final RegistryObject<Item> WOODELF_BATTLEAXE = ITEM_REGISTRY.register("woodelf_battle_axe", () -> new AdvancedAxeItem(Tiers.DIAMOND, 11.0F, -3.4F, (new Item.Properties()), 3.25f, 0.0F, 0.0F, 2, 1, 5, 0.1F, 0.25F, 20, 1, 0.5F, null));

    public static final RegistryObject<Item> WOODELF_GLAIVE = ITEM_REGISTRY.register("woodelf_glaive", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 1.0F, (new Item.Properties()), 4.0f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.5F), new SweepAttribute(true, 1.0F, 1.0F), ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_SPEAR = ITEM_REGISTRY.register("woodelf_spear", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 1, 1.3F, (new Item.Properties()), 4.199999809265137f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 3, 0.1F, 0.55F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_HALBERD = ITEM_REGISTRY.register("woodelf_halberd", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 6, 0.7F, (new Item.Properties()), 4.5f, new AttackAttribute(0.0F, 0.5F, 4.0F, 0.0F, 20, 1.5F, 1.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 5, 0.0F, 0.2F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> WOODELF_PIKE = ITEM_REGISTRY.register("woodelf_pike", () -> new AdvancedSwordItem(new WeaponProperty(Tiers.DIAMOND, 4, 0.8F, (new Item.Properties()), 5.0f, new AttackAttribute(0.0F, 1.0F, 2.0F, 0.0F, 20, 0.0F, 0.0F, 0, false, 0), new TwoHandedAttribute(2, 0, 4, 0.0F, 0.3F), SweepAttribute.none, ThrownWeaponAttribute.none, false), -1));

    public static final RegistryObject<Item> RUSTY_DAGGER = ITEM_REGISTRY.register("rusty_dagger", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_SHORTSWORD = ITEM_REGISTRY.register("rusty_shortsword", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_STILETTO = ITEM_REGISTRY.register("rusty_stiletto", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_RAPIER = ITEM_REGISTRY.register("rusty_rapier", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_KATANA = ITEM_REGISTRY.register("rusty_katana", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_GREATSWORD = ITEM_REGISTRY.register("rusty_greatsword", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_LONGSWORD = ITEM_REGISTRY.register("rusty_longsword", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_TWINBLADE = ITEM_REGISTRY.register("rusty_twinblade", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_ZWEIHANDER = ITEM_REGISTRY.register("rusty_zweihander", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_BATTLEAXE = ITEM_REGISTRY.register("rusty_battle_axe", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_GLAIVE = ITEM_REGISTRY.register("rusty_glaive", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_SPEAR = ITEM_REGISTRY.register("rusty_spear", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_HALBERD = ITEM_REGISTRY.register("rusty_halberd", () -> new Item((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> RUSTY_PIKE = ITEM_REGISTRY.register("rusty_pike", () -> new Item((new Item.Properties()).stacksTo(1)));

    //coins
    static
    {
        for (String coin : new String[]{
                "silver_glari",
                "silver_donti",
                "shield",
                "red_glaong",
                "medal_sword",
                "medal_joust",
                "gold_ladan",
                "gold_glari",
                "gold_glaong",
                "gold_chrysant",
                "copper_hawk",
                "copper_halfglass",
                "copper_glass",
                "copper_glari",
                "bronze_tel",
                "bronze_glaong"})
            ITEM_REGISTRY.register(coin, () -> new Item(new Item.Properties().stacksTo(64)));
    }

    public static final ResourceKey<Level> DUNGEON_DIM1 = ResourceKey.create(Registries.DIMENSION, id("dungeon_dim1"));
    public static final ResourceKey<Level> DUNGEON_DIM2 = ResourceKey.create(Registries.DIMENSION, id("dungeon_dim2"));

    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> DUNGEON_DIM1_PORTAL = BLOCK_REGISTRY.register("dungeon_dim1_portal", () -> new DungeonPortalBlock(DUNGEON_DIM1));
    public static final RegistryObject<Block> DUNGEON_DIM2_PORTAL = BLOCK_REGISTRY.register("dungeon_dim2_portal", () -> new DungeonPortalBlock(DUNGEON_DIM2));
    public static final RegistryObject<Block> COPPER_TROPHY = registerBlockAndItem("copper_trophy", () -> new TrophyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).noOcclusion().requiresCorrectToolForDrops().strength(3, 6).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> SILVER_TROPHY = registerBlockAndItem("silver_trophy", () -> new TrophyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion().requiresCorrectToolForDrops().strength(3, 6).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GOLD_TROPHY = registerBlockAndItem("gold_trophy", () -> new TrophyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).noOcclusion().requiresCorrectToolForDrops().strength(3, 6).sound(SoundType.METAL)));

    public static final DeferredRegister<Attribute> ATTRIBUTE_REGISTRY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, MODID);
    public static final RegistryObject<Attribute> UNDEAD_DAMAGE = ATTRIBUTE_REGISTRY.register("undead.attack_damage", () -> new RangedAttribute("attribute.name.undead.attack_damage", 0, 0, 2048).setSyncable(true));

    private static RegistryObject<Block> registerBlockAndItem(String id, Supplier<Block> block)
    {
        RegistryObject<Block> regB = BLOCK_REGISTRY.register(id, block);
        ITEM_REGISTRY.register(id, () -> new BlockItem(regB.get(), new Item.Properties()));
        return regB;
    }

    public VaerenthExperience(FMLJavaModLoadingContext ctx)
    {
        IEventBus modBus = ctx.getModEventBus();

        ITEM_REGISTRY.register(modBus);
        BLOCK_REGISTRY.register(modBus);
        ATTRIBUTE_REGISTRY.register(modBus);

        modBus.addListener(VaerenthExperience::setup);
        modBus.addListener(VaerenthExperience::addCreativeTabItems);
        modBus.addListener(VaerenthExperience::registryReplace);
        modBus.addListener(DataGenProviders::register);

        MinecraftForge.EVENT_BUS.addListener(RevivalStaffItem::interactWithDeadDragon);
        MinecraftForge.EVENT_BUS.addListener(IExtraItemDamage::dealExtraDamage);
        MinecraftForge.EVENT_BUS.addListener(CustomPortalShape::onFlintAndSteel);
    }

    public static ResourceLocation id(String resource)
    {
        return new ResourceLocation(MODID, resource);
    }

    private static void addCreativeTabItems(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.COMBAT)
            for (var item : ITEM_REGISTRY.getEntries())
                event.accept(item);
    }

    private static void registryReplace(RegisterEvent event)
    {
        if (event.getRegistryKey().equals(Registries.ENCHANTMENT))
            event.register(Registries.ENCHANTMENT, new ResourceLocation("minecraft:fire_protection"), DummyEnchantment::new);
    }

    private static void setup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> ItemProperties.register(KNIGHT_OF_VAERENTH_SHIELD.get(), new ResourceLocation("blocking"), (stack, level, entity, light) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack? 1f : 0f));
    }
}
