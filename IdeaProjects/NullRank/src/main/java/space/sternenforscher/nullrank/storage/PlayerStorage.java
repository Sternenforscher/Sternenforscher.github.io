package space.sternenforscher.nullrank.storage;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import space.sternenforscher.nullrank.NullRank;
import space.sternenforscher.nullrank.utils.SavePlayer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Sternenforscher on 30.12.15, 03:24.
 */
public class PlayerStorage {
    private NullRank plugin;
    private File storageFile;
    private FileConfiguration storageFileConfiguration;
    private List<SavePlayer> savePlayers;

    public PlayerStorage(NullRank plugin){
        this.plugin = plugin;
        this.savePlayers = new ArrayList<>();
        loadFile();
        loadSavePlayers();
    }

    public void loadFile(){
        if (storageFile == null){
            storageFile = new File(plugin.getDataFolder(), "storage.yml");
        }
        storageFileConfiguration = YamlConfiguration.loadConfiguration(storageFile);
    }

    public void saveFile(){
        if (storageFileConfiguration == null){
            return;
        }
        try {
            storageFileConfiguration.save(storageFile);
        } catch (IOException e) {
            e.printStackTrace();
            plugin.getLogger().log(Level.SEVERE, "Could not save storageFile to " + storageFile, e);
        }
    }

    public void load(){
        loadFile();
        loadSavePlayers();
    }

    public void loadSavePlayers(){
        for (String string : storageFileConfiguration.getConfigurationSection("players").getKeys(false)){
            this.savePlayers.add(new SavePlayer(storageFileConfiguration.getConfigurationSection(string)));
        }
    }

    public void savePlayers(){
        for (SavePlayer savePlayer : savePlayers){
            storageFileConfiguration.set("players."+savePlayer.getUuid(), savePlayer.getAsConfigurationSection());
        }
    }
}
