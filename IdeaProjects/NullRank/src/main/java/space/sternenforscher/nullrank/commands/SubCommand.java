package space.sternenforscher.nullrank.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Created by Sternenforscher on 30.12.15, 16:54.
 */
public interface SubCommand {
    boolean execute(CommandSender commandSender, String label, String[] args);

    String getEnterPermission();

    String getParentCommand();

    String getHelp(CommandSender sender);

    List<String> getEnterArguments();

    List<String> getTabCompleter(CommandSender sender, String label, String[] args);

    boolean isPlayerOnly();
}
