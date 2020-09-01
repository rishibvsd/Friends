package me.koppam.hoverable.commands;

import me.koppam.hoverable.Main;
import me.koppam.hoverable.YamlFIle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class addFriend implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (s.equalsIgnoreCase("friend")) {

            if (strings.length != 1)
                return false;

            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("You are not a player!");
                return true;
            }
            Player player = (Player) commandSender;

            Player target = Main.dis.getServer().getPlayer(strings[0]);

            if (target == null) {
                player.sendMessage(ChatColor.RED + "Player was not found.");
                return true;
            }
            YamlConfiguration config = YamlFIle.getPlayerConfig(player);

            List<String> l = config.getStringList("friends");

            String frienedUUID = target.getUniqueId().toString();
            if (l.contains(frienedUUID)) {
                player.sendMessage(ChatColor.RED + "Player is already on your friends list!");

                return true;

            }

            l.add(frienedUUID);
            config.set("freinds", l);
            YamlFIle.setPlayer(player, config);
            player.sendMessage(ChatColor.GREEN + "You have added" + target + "as a friend!");
            target.sendMessage(player.getDisplayName() + ChatColor.GRAY + "has added you as a friend!");
            return true;


        }

        return false;
    }


}
