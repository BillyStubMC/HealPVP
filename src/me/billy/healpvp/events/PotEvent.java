package me.billy.healpvp.events;

import me.billy.healpvp.Main;
import me.billy.healpvp.config.Config;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.util.Vector;

public class PotEvent implements Listener {

    public PotEvent(final Main main) {
    }

    public void onSplash(PotionSplashEvent e) {
        if (e.getEntityType() == EntityType.SPLASH_POTION && (e.getEntity()).getShooter() instanceof Player){
            Vector velocity = e.getPotion().getVelocity();
            velocity.setY(velocity.getY() - Double.parseDouble(Config.get().getString("throw-speed")));
            e.getPotion().setVelocity(velocity);
        }
    }
}
