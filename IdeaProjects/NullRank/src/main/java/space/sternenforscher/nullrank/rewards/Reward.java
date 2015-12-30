package space.sternenforscher.nullrank.rewards;

import org.bukkit.entity.Player;

/**
 * Created by Sternenforscher on 29.12.15, 23:53.
 */
public interface Reward {
    void give(Player player);

    String name();
}
