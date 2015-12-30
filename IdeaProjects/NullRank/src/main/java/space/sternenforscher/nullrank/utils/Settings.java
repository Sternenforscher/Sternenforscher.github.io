package space.sternenforscher.nullrank.utils;

import org.bukkit.configuration.file.FileConfiguration;
import space.sternenforscher.nullrank.NullRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sternenforscher on 29.12.15, 23:14.
 */
public class Settings {
    private NullRank plugin;
    private List<LogType> logables = new ArrayList<>();

    public Settings(NullRank plugin){
        this.plugin = plugin;
    }

    public void reloadSettings(){
        FileConfiguration conf = plugin.getConfig();
        for (String string : conf.getStringList("logTypes")){
            if (LogType.valueOf(string) != null){
                logables.add(LogType.valueOf(string));
            } else {
                plugin.log(LogType.SEVERE, "Could not get the logging-value of "+string+"! Please check your configuration file.");
            }
        }
    }

    public List<LogType> getLogables() {
        return logables;
    }
}
