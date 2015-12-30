package space.sternenforscher.nullrank.hooks;

import com.earth2me.essentials.Essentials;
import org.bukkit.plugin.Plugin;
import space.sternenforscher.nullrank.NullRank;
import space.sternenforscher.nullrank.utils.LogType;

/**
 * Created by Sternenforscher on 30.12.15, 03:00.
 */
public class EssentialsHook implements Hook{
    private Essentials essentials;
    private NullRank plugin;

    public EssentialsHook(NullRank plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean setupBridge() {
        Plugin essentials = plugin.getServer().getPluginManager().getPlugin("Essentials");
        if (essentials == null) {
            this.essentials = null;
            plugin.log(LogType.INFO, "Could not hook into Essentials.");
            return false;
        }
        this.essentials = (Essentials) essentials;
        plugin.log(LogType.INFO, "Hooked into Essentials!");
        return true;
    }

    @Override
    public String getName() {
        return "Essentials";
    }

    @Override
    public String getDescription() {
        return "Multi-functional plugin.";
    }

}
