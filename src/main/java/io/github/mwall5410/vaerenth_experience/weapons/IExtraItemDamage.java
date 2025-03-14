package io.github.mwall5410.vaerenth_experience.weapons;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.github.mwall5410.vaerenth_experience.VaerenthExperience;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.UUID;

public interface IExtraItemDamage
{
    default float getAdditionalHurtDamage(ItemStack stack, LivingEntity attacker, LivingEntity attacking)
    {
        return 0f;
    }

    float SILVER_UNDEAD_BONUS = 2f;
    UUID UNDEAD_MOD_UUID = UUID.fromString("50435ad1-16f4-435c-bff3-b1f398303b63");
    static Multimap<Attribute, AttributeModifier> addSilverAttributeMods(Multimap<Attribute, AttributeModifier> old, EquipmentSlot slot)
    {
        if (slot == EquipmentSlot.MAINHAND)
        {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(old);
            builder.put(VaerenthExperience.UNDEAD_DAMAGE.get(), new AttributeModifier(UNDEAD_MOD_UUID, "Weapon modifier", SILVER_UNDEAD_BONUS, AttributeModifier.Operation.ADDITION));
            return builder.build();
        }
        return old;
    }

    static void dealExtraDamage(LivingHurtEvent evt)
    {
        if (evt.getSource().getEntity() instanceof LivingEntity l && l.getMainHandItem().getItem() instanceof IExtraItemDamage e)
        {
            evt.setAmount(evt.getAmount() + e.getAdditionalHurtDamage(l.getMainHandItem(), l, evt.getEntity()));
            if (l instanceof Player p) p.magicCrit(evt.getEntity());
        }
    }
}
