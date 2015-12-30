package space.sternenforscher.nullrank.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import space.sternenforscher.nullrank.NullRank;

import java.io.*;

/**
 * Created by Sternenforscher on 29.12.15, 23:57.
 */
public class LanguageHelper {
    private File localeFile;
    private FileConfiguration language;
    private NullRank plugin;
    private String noPermMessage;

    public LanguageHelper(NullRank plugin){
        this.plugin = plugin;
    }

    public void reloadMessages() {
        if (localeFile == null) {
            localeFile = new File(plugin.getDataFolder(), "locale.yml");
        }
        language = YamlConfiguration.loadConfiguration(localeFile);
        language.options().copyDefaults(true);
        Reader defConfigStream = null;
        try {
            defConfigStream = new InputStreamReader(plugin.getResource("locale.yml"), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            language.setDefaults(defConfig);
        }
        try {
            language.save(localeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        noPermMessage = ChatColor.translateAlternateColorCodes('&', language.getString("error.permissionMissing"));
    }

    public void sendMessage(CommandSender sender, String message){
        Player player = null;
        if (sender instanceof Player){
            player = (Player) sender;
        }
        PlaceholderHelper placeholderHelper = new PlaceholderHelper(plugin, message, player);
        plugin.log(LogType.DEBUG, "Sending message '"+message+"' to "+sender.getName());
        sender.sendMessage(placeholderHelper.getReplacedMessage());
    }

    public void broadcast(String message){
        for (Player player : plugin.getServer().getOnlinePlayers()){
            sendMessage(player, message);
        }
    }

    public String getNoPermMessage() {
        return noPermMessage;
    }

    public String getLang(String path){
        return language.getString(path);
    }
}
