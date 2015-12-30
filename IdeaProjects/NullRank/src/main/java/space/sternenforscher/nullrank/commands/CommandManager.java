package space.sternenforscher.nullrank.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import space.sternenforscher.nullrank.NullRank;

import java.util.List;

/**
 * Created by Sternenforscher on 30.12.15, 16:55.
 */
public class CommandManager implements CommandExecutor, TabCompleter {
    private NullRank plugin;
    private List<SubCommand> subCommands;

    public CommandManager(NullRank plugin){
        this.plugin = plugin;
        this.subCommands.add(new ReloadCommand(plugin));
    }

    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 1) {
            for (SubCommand subCommand : subCommands) {
                if (subCommand.getEnterArguments().contains(args[0])){
                    if (plugin.getPermissionHelper().checkCommandAccess(sender, subCommand.getEnterPermission())){
                        subCommand.execute(sender, label, args);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param alias   The alias used
     * @param args    The arguments passed to the command, including final
     *                partial argument to be completed and command label
     * @return A List of possible completions for the final argument, or null
     * to default to the command executor
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
