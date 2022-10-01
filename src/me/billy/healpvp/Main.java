package me.billy.healpvp;

import me.billy.healpvp.commands.Reload;
import me.billy.healpvp.config.Config;
import me.billy.healpvp.events.PotEvent;
import me.billy.healpvp.events.SoupEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Loading HealPVP...");
        System.out.println("Registering events...");
        Bukkit.getPluginManager().registerEvents(new SoupEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new PotEvent(this), this);
        System.out.println("Registered events!");

        System.out.println("Loading config...");
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Config.config();
        Config.get().options().header("replace-item - Item replaced in your item slot when you soup (BOWL or AIR)\nthrow-speed - When you throw a potion to heal, what speed do you want it? (0 - 4)");
        Config.get().addDefault("replace-item", "BOWL");
        Config.get().addDefault("throw-speed", "1.0");
        Config.get().options().copyDefaults(true);
        Config.save();

        System.out.println("Loaded config!");

        System.out.println("Registering commands...");
        this.getCommand("hp-reload").setExecutor(new Reload());
        System.out.println("Registered commands!");
        System.out.println("Thanks for using my plugin! <333");
    }

    @Override
    public void onDisable() {

    }

}
