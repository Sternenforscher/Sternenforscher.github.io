package space.sternenforscher.nullrank.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import space.sternenforscher.nullrank.NullRank;

/**
 * Created by Sternenforscher on 30.12.15, 00:39.
 */
public class PlaceholderHelper {
    private NullRank plugin;
    private String message;
    private String replacedMessage;
    private Player player;

    public PlaceholderHelper(NullRank plugin, String message){
        this.plugin = plugin;
        this.message = message;
    }

    public PlaceholderHelper(NullRank plugin, String message, Player player){
        this.plugin = plugin;
        this.message = message;
        this.player = player;
    }

    private void applyPlaceholders(){
        this.replacedMessage = message
                .replace("%serverName%", plugin.getServer().getServerName())
                .replace("%serverPlayerCount%", plugin.getServer().getOnlinePlayers().size()+"");
        if (player != null){
            this.replacedMessage = replacedMessage
                    .replace("%player%", player.getName())
                    .replace("%uuid%", player.getUniqueId().toString());
        }
        this.replacedMessage = ChatColor.translateAlternateColorCodes('&', replacedMessage);
    }

    public String getReplacedMessage(){
        applyPlaceholders();
        return replacedMessage;
    }
}
