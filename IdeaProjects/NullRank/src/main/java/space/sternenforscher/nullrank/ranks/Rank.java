package space.sternenforscher.nullrank.ranks;

import org.bukkit.configuration.ConfigurationSection;
import space.sternenforscher.nullrank.requirements.Requirement;
import space.sternenforscher.nullrank.rewards.Reward;

import java.util.List;

/**
 * Created by Sternenforscher on 30.12.15, 01:04.
 */
public class Rank {
    private String name;
    private String description;
    private List<Requirement> requirements;
    private List<Reward> rewards;

    public Rank(ConfigurationSection configurationSection){
        readFromConfigurationSection(configurationSection);
    }

    private void readFromConfigurationSection(ConfigurationSection configurationSection){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
