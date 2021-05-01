package ml.darubyminer360.twistcraft;

import ml.darubyminer360.twistcraft.commands.CraftableCommandBlocksCommand;
import ml.darubyminer360.twistcraft.commands.TwistCommand;

import ml.darubyminer360.twistcraft.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TwistCraft extends JavaPlugin {
    @Override
    public void onEnable() {
      getCommand("twist").setExecutor(new TwistCommand());
        getCommand("craftablecommandblocks").setExecutor(new CraftableCommandBlocksCommand());
      ItemManager.init();
    }

    @Override
    public void onDisable() {
    }
}
