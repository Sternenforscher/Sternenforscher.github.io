package space.sternenforscher.nullrank.requirements;

import org.bukkit.entity.Player;

/**
 * Created by Sternenforscher on 30.12.15, 00:19.
 */
public interface Requirement {
    boolean hasRequirement(Player player);

    String name();
}
