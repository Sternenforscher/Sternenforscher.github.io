package space.sternenforscher.nullrank.hooks;

import space.sternenforscher.nullrank.NullRank;
import space.sternenforscher.nullrank.utils.LogType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sternenforscher on 30.12.15, 16:13.
 */
public class HookManager {
    private NullRank plugin;
    private List<Hook> hooks = new ArrayList<>();
    private List<Hook> enabledHooks = new ArrayList<>();

    public HookManager(NullRank plugin){
        this.plugin = plugin;
        this.hooks.add(new EssentialsHook(plugin));
        this.hooks.add(new PlayerPointsHook(plugin));
    }

    public void reloadHooks() {
        for (Hook hook : hooks){
            plugin.log(LogType.DEBUG, "Checking "+hook.getName());
            if (hook.setupBridge()){
                enabledHooks.add(hook);
            }
        }
    }

    public List<Hook> getEnabledHooks() {
        return enabledHooks;
    }
}
