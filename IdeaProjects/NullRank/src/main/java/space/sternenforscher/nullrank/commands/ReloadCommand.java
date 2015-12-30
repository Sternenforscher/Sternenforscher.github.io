package space.sternenforscher.nullrank.commands;

import org.bukkit.command.CommandSender;
import space.sternenforscher.nullrank.NullRank;

import java.util.List;

/**
 * Created by Sternenforscher on 30.12.15, 17:08.
 */
public class ReloadCommand implements SubCommand {
    private NullRank plugin;

    public ReloadCommand(NullRank plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender commandSender, String label, String[] args) {
        if (args.length == 2){

        }
        return false;
    }

    @Override
    public String getEnterPermission() {
        return null;
    }

    @Override
    public String getParentCommand() {
        return null;
    }

    @Override
    public String getHelp(CommandSender sender) {
        if (plugin.getPermissionHelper().permcheck(sender, "nullrank.reload")) {
            return plugin.getLanguageHelper().getLang("help.reload");
        }
        return null;
    }

    @Override
    public List<String> getEnterArguments() {
        return null;
    }

    @Override
    public List<String> getTabCompleter(CommandSender sender, String label, String[] args) {
        return null;
    }

    @Override
    public boolean isPlayerOnly() {
        return false;
    }
}
