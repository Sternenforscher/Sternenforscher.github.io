package space.sternenforscher.nullrank.hooks;

import org.black_ixx.playerpoints.PlayerPoints;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import space.sternenforscher.nullrank.NullRank;
import space.sternenforscher.nullrank.utils.LogType;

import java.util.UUID;

/**
 * Created by Sternenforscher on 30.12.15, 02:13.
 */
public class PlayerPointsHook implements Hook{
    private NullRank plugin;
    private PlayerPoints playerPoints;

    public PlayerPointsHook(NullRank plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean setupBridge() {
        Plugin pointsPlugin = Bukkit.getPluginManager().getPlugin("PlayerPoints");
        if (pointsPlugin == null) {
            playerPoints = null;
            plugin.log(LogType.INFO, "Could not hook into PlayerPoints.");
            return false;
        }
        playerPoints = (PlayerPoints) pointsPlugin;
        plugin.log(LogType.INFO, "Hooked into PlayerPoints!");
        return true;
    }

    public boolean isValid(){
        return playerPoints != null;
    }

    public int getPoints(UUID uuid){
        if (isValid()){
            return playerPoints.getAPI().look(uuid);
        } else {
            return 0;
        }
    }

    public boolean givePoints(UUID uuid, int amount) {
        return isValid() && playerPoints.getAPI().give(uuid, amount);
    }

    public boolean takePoints(UUID uuid, int amount) {
        return isValid() && playerPoints.getAPI().take(uuid, amount);
    }


    @Override
    public String getName() {
        return "PlayerPoints";
    }

    @Override
    public String getDescription() {
        return "Players can have points over multiple server. You can require them for ranks.";
    }
}
