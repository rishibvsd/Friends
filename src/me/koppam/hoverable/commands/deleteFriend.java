package me.koppam.hoverable.commands;

import me.koppam.hoverable.Main;
import me.koppam.hoverable.YamlFIle;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class deleteFriend implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {



        String command = cmd.getName().toLowerCase();
        if (command.equals("delfriend")) {
            if (!(strings.length == 1)) { return false; }

            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED+"ERROR: Only players should use this command.");
                return true;
            }

            Player player = (Player) sender;

            Player targetFriend = Main.dis.getServer().getPlayer(strings[0]);

            if (targetFriend == null) {
                player.sendMessage(ChatColor.RED+"ERROR: Player not found.");
                return true;
            }

            YamlConfiguration config = YamlFIle.getPlayerConfig(player);

            List<String> l = config.getStringList("friends");

            String friendUUID = targetFriend.getUniqueId().toString();

            if (!l.contains(friendUUID)) {
                player.sendMessage(ChatColor.RED+"ERROR: Player is not on your friends list.");
                return true;
            }

            l.remove(friendUUID);
            config.set("friends", l);
            YamlFIle.setPlayer(player, config);
            player.sendMessage(ChatColor.GRAY+"You have removed "+ChatColor.WHITE+targetFriend.getDisplayName()+ChatColor.GRAY+" as a friend.");
            targetFriend.sendMessage(player.getDisplayName()+ ChatColor.GRAY+" has removed you as a friend.");
            return true;
        }
        return false;
    }
}

