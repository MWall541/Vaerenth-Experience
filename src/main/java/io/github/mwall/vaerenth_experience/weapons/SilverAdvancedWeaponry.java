package io.github.mwall.vaerenth_experience.weapons;

import com.google.common.collect.Multimap;
import net.dixta.dixtas_armory.item.custom.AdvancedSwordItem;
import net.dixta.dixtas_armory.item.custom.attributes.WeaponProperty;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

public class SilverAdvancedWeaponry extends AdvancedSwordItem implements IExtraItemDamage
{
    public SilverAdvancedWeaponry(WeaponProperty pWeaponData)
    {
        super(pWeaponData, -1);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack)
    {
        return IExtraItemDamage.addSilverAttributeMods(super.getAttributeModifiers(slot, stack), slot);
    }

    @Override
    public float getAdditionalHurtDamage(ItemStack stack, LivingEntity attacker, LivingEntity attacking)
    {
        return attacking.getMobType() == MobType.UNDEAD? SILVER_UNDEAD_BONUS : 0;
    }
}
