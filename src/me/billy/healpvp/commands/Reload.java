package me.billy.healpvp.commands;

import me.billy.healpvp.config.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        if (cs.hasPermission("healpvp.reload")){
            Config.save();
            Config.reload();
            cs.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&aHealPVP&7] &aReloaded the config.yml!"));
            return false;
        }
        if (!cs.hasPermission("healpvp.reload")){
            cs.sendMessage(ChatColor.RED + "You do not have permission to execute this command! (healpvp.reload)");
            return false;
        }
        return false;
    }
}
