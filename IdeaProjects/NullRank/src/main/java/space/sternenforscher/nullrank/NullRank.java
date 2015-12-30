package space.sternenforscher.nullrank;

import org.bukkit.plugin.java.JavaPlugin;
import space.sternenforscher.nullrank.commands.CommandManager;
import space.sternenforscher.nullrank.hooks.Hook;
import space.sternenforscher.nullrank.hooks.HookManager;
import space.sternenforscher.nullrank.hooks.PlayerPointsHook;
import space.sternenforscher.nullrank.storage.PlayerStorage;
import space.sternenforscher.nullrank.utils.*;

import java.util.List;

/**
 * Created by Sternenforscher on 29.12.15, 23:07.
 */
public class NullRank extends JavaPlugin {
    private Settings settings;
    private PermissionHelper permissionHelper;
    private LanguageHelper languageHelper;
    private HookManager hookManager;
    private PlayerStorage playerStorage;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        reload();
    }

    public void reload(){
        log(LogType.DEBUG, "Loading settings");
        this.settings = new Settings(this);
        this.settings.reloadSettings();
        log(LogType.DEBUG, "Initialising PermissionHelper");
        this.permissionHelper = new PermissionHelper(this);
        this.permissionHelper.setupVaultPermissions();
        log(LogType.DEBUG, "Activating LanguageHelper");
        this.languageHelper = new LanguageHelper(this);
        this.languageHelper.reloadMessages();
        log(LogType.DEBUG, "Loading Hook manager");
        this.hookManager = new HookManager(this);
        this.hookManager.reloadHooks();
        log(LogType.DEBUG, "Reinitializising PlayerStorage");
        this.playerStorage = new PlayerStorage(this);
        this.playerStorage.load();
        log(LogType.DEBUG, "Initialising CommmandManager");
        this.commandManager = new CommandManager(this);
        getCommand("nullrank").setExecutor(commandManager);
    }

    public void log(LogType logType, String message){
        if (settings.getLogables().contains(logType) || logType.equals(LogType.SEVERE)){
            switch (logType){
                case SEVERE: case WARNING:
                    getLogger().warning(message);
                    return;
                case INFO:
                    getLogger().info(message);
                    return;
                case CONFIG:
                    getLogger().config(message);
                    return;
                case DEBUG:
                    getLogger().info("DEBUG: "+message);
            }
        }
    }

    public Settings getSettings() {
        return settings;
    }

    public LanguageHelper getLanguageHelper() {
        return languageHelper;
    }

    public PermissionHelper getPermissionHelper() {
        return permissionHelper;
    }

    public HookManager getHookManager() {
        return hookManager;
    }

    public PlayerStorage getPlayerStorage() {
        return playerStorage;
    }
}
