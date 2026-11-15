package io.github.thebusybiscuit.extraheads.listeners;

import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.extraheads.ExtraHeads;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.weapons.SwordOfBeheading;

public class HeadListener implements Listener {

    public HeadListener(ExtraHeads plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(ignoreCancelled = true)
    public void onKill(EntityDeathEvent e) {
        var entityType = e.getEntityType();
        SlimefunItem head = ExtraHeads.getRegistry().getHeads().get(entityType);

        if (head == null) {
            return;
        }

        double chance = getChance(entityType, e.getEntity().getKiller());

        // nextDouble() keeps fractional chances (e.g. 0.5%) accurate,
        // nextInt(100) would round them up to the next whole percent.
        if (ThreadLocalRandom.current().nextDouble(100) < chance) {
            e.getDrops().add(head.getItem().clone());
        }
    }

    private double getChance(@Nonnull EntityType type, @Nullable Player killer) {
        double chance = ExtraHeads.getRegistry().getConfig().getDouble("chances." + type);

        if (killer == null) {
            return chance;
        }

        ItemStack item = killer.getInventory().getItemInMainHand();
        if (item.getType().isAir() || !(SlimefunItems.SWORD_OF_BEHEADING.getItem() instanceof SwordOfBeheading sword)
            || !sword.isItem(item) || sword.isDisabledIn(killer.getWorld())) {
            return chance;
        }

        return chance * ExtraHeads.getRegistry().getConfig().getDouble("options.sword-of-beheading-multiplier");
    }
}
