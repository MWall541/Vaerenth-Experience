package io.github.mwall.vaerenth_experience.weapons;

import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.github.alexthe666.iceandfire.entity.EntityDragonPart;
import io.github.mwall.vaerenth_experience.VaerenthExperience;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;

public class RevivalStaffItem extends Item
{
    public RevivalStaffItem(Item.Properties props)
    {
        super(props);
    }

    public static void interactWithDeadDragon(PlayerInteractEvent.EntityInteractSpecific event)
    {
        EntityDragonBase dragon;
        ItemStack stack = event.getItemStack();
        if (!stack.is(VaerenthExperience.REVIVAL_STAFF.get()))
            return;
        Entity target = event.getTarget();
        Player player = event.getEntity();
        if (target instanceof EntityDragonPart)
        {
            EntityDragonPart p = (EntityDragonPart) target;
            target = p.getParent();
        }
        if (target instanceof EntityDragonBase)
        {
            dragon = (EntityDragonBase) target;
        }
        else
        {
            return;
        }
        if (dragon.getDeathStage() > 0)
            return;
        if (dragon.getOwner() != player)
            return;
        dragon.setModelDead(false);
        dragon.setDeathStage(0);
        if (player.level().isClientSide())
        {
            addUsageParticles(dragon);
        }
        else
        {
            dragon.setHealth(dragon.getMaxHealth() * 0.25F);
            event.getItemStack().hurtAndBreak(1, (LivingEntity) dragon, e ->
            {
            });
        }
        event.setResult(Event.Result.DENY);
    }

    private static void addUsageParticles(EntityDragonBase dragon)
    {
        if (!dragon.level().isClientSide())
            return;
        float scale = dragon.getScale();
        for (int i = 0; i < 30.0F * scale; i++)
        {
            double x = dragon.getRandomX(scale);
            double y = dragon.getRandomY() * scale;
            double z = dragon.getRandomX(scale);
            dragon.level().addParticle(ParticleTypes.ENCHANT, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }
}