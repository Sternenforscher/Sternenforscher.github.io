package space.sternenforscher.nullrank.hooks;

import org.bukkit.plugin.Plugin;

/**
 * Created by Sternenforscher on 30.12.15, 16:05.
 */
public interface Hook {
    boolean setupBridge();

    String getName();

    String getDescription();
}
