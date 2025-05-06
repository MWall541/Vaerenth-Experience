package io.github.mwall.vaerenth_experience.weapons;

import net.dixta.dixtas_armory.item.custom.attributes.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class SwordOfKings extends SilverAdvancedWeaponry
{
    public SwordOfKings()
    {
        super(new WeaponProperty(Tiers.DIAMOND, 4, 1.2F, new Item.Properties().rarity(Rarity.UNCOMMON), 3.5f, new AttackAttribute(0.0F, 0.0F, 0.0F, 0.0F, 20, 0.0F, 0.0F), new TwoHandedAttribute(2, 0, 6, 0.0F, 0.4F), new SweepAttribute(true, 5.0F, 1.5F), ThrownWeaponAttribute.none, false));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        pTooltipComponents.add(Component.translatable(getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken)
    {
        int newDura = stack.getDamageValue() + amount;
        if (newDura >= stack.getMaxDamage())
            amount = stack.getMaxDamage() - stack.getDamageValue() - 1; // prevent "actual breakage"

        return super.damageItem(stack, amount, entity, onBroken);
    }
}
