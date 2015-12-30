package space.sternenforscher.nullrank.utils;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;
import space.sternenforscher.nullrank.NullRank;

/**
 * Created by Sternenforscher on 30.12.15, 00:28.
 */
public class PermissionHelper {
    private Permission vpermission = null;
    private NullRank plugin;

    public PermissionHelper(NullRank plugin){
        this.plugin = plugin;
    }

    public boolean setupVaultPermissions() {
        if(plugin.getServer().getPluginManager().getPlugin("Vault") != null && plugin.getServer().getPluginManager().getPlugin("Vault").isEnabled()) {
            RegisteredServiceProvider<Permission> permissionProvider = plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
            if (permissionProvider != null) {
                vpermission = permissionProvider.getProvider();
                plugin.log(LogType.INFO, "Vault found and hooked!");
            }
        } else {
            plugin.log(LogType.INFO, "Vault was not found, we will use the native bukkit permission resolver.");
            vpermission = null;
        }
        return vpermission != null;
    }

    public boolean permcheck(CommandSender target, String permission){
        if(vpermission != null){
            return vpermission.has(target, permission);
        } else {
            return target.hasPermission(permission);
        }
    }

    public boolean checkCommandAccess(CommandSender sender, String permission){
        if (permcheck(sender, permission)){
            plugin.log(LogType.DEBUG, sender.getName()+" has the permission "+permission);
            return true;
        } else {
            plugin.log(LogType.DEBUG, sender.getName()+" does not has the permission "+permission);
            sender.sendMessage(plugin.getLanguageHelper().getNoPermMessage());
            return false;
        }
    }
}
