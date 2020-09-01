package me.koppam.hoverable;

import me.koppam.hoverable.commands.addFriend;
import me.koppam.hoverable.commands.deleteFriend;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main dis;


    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        dis = this;
       this.getCommand("addfriend").setExecutor(new addFriend());
       this.getCommand("delfriend").setExecutor(new deleteFriend());
        getDataFolder().mkdirs();
    }



}
