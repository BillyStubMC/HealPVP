package me.billy.healpvp.events;

import me.billy.healpvp.Main;
import me.billy.healpvp.config.Config;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.event.block.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class SoupEvent implements Listener
{
    public SoupEvent(final Main main) {
    }

    @EventHandler
    public void onSoup(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (p.getItemInHand() != null && p.getItemInHand().getType() == Material.MUSHROOM_SOUP && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (p.getHealth() != 20.0 && p.getHealth() != 0.0) {
                p.setHealth(Math.min(p.getHealth() + 7.0, p.getMaxHealth()));
                p.getItemInHand().setType(Material.valueOf(Config.get().getString("replace-item")));
                final ItemStack replace = new ItemStack(Material.valueOf(Config.get().getString("replace-item")));
                p.setItemInHand(replace);
            }
            p.setSprinting(false);
        }
    }
}