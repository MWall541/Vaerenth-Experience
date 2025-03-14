package io.github.mwall5410.vaerenth_experience;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DummyEnchantment extends Enchantment
{
    public DummyEnchantment()
    {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR, new EquipmentSlot[0]);
    }

    @Override
    public boolean canEnchant(ItemStack pStack)
    {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack)
    {
        return false;
    }

    @Override
    public boolean isTradeable()
    {
        return false;
    }

    @Override
    public boolean isDiscoverable()
    {
        return false;
    }

    @Override
    public boolean isAllowedOnBooks()
    {
        return false;
    }
}