package me.koppam.hoverable;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class YamlFIle {

    private static YamlConfiguration getFile(String name){
        YamlConfiguration f = YamlConfiguration.loadConfiguration(new File(Main.dis.getDataFolder()+"/"+name+".yml"));

        return f;


    }

    private static void setFile(String name,YamlConfiguration config){
        File f = new File(Main.dis.getDataFolder()+"/"+name+".yml");

        try {
            config.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static YamlConfiguration getPlayerConfig(Player player) {
        YamlConfiguration list = getFile("users/"+player.getUniqueId()+".yml");
        return list;
    }

    public static void setPlayer(Player player, YamlConfiguration list) {
        setFile("users/"+player.getUniqueId()+".yml", list);
    }
}
