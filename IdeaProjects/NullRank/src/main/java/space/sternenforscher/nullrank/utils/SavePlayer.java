package space.sternenforscher.nullrank.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;
import java.util.UUID;

/**
 * Created by Sternenforscher on 30.12.15, 04:06.
 */
public class SavePlayer {
    private UUID uuid;
    //In milliseconds
    private Onlinetime onlinetime;
    private List<String> ownedRanks;

    public SavePlayer(ConfigurationSection configurationSection){
        readFromConfigurationSection(configurationSection);
    }

    public void readFromConfigurationSection(ConfigurationSection configurationSection){
        this.onlinetime = new Onlinetime(configurationSection.getLong("onlinetime"));
        this.ownedRanks = configurationSection.getStringList("ownedRanks");
    }

    public ConfigurationSection getAsConfigurationSection(){
        ConfigurationSection section = new YamlConfiguration();
        section.set("onlinetime", onlinetime);
        section.set("ownedRanks", ownedRanks);
        return section;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid(){
        return uuid;
    }

    public void setOnlinetime(long onlinetime) {
        this.onlinetime.setOnlinetime(onlinetime);
    }

    public Onlinetime getOnlinetime(){
        return onlinetime;
    }
}
