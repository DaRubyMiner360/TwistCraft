package ml.darubyminer360.twistcraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;

public class CraftableEnchantedGoldenApplesCommand implements CommandExecutor {
    public static boolean enabled;
    public static ShapedRecipe enchantedGoldenAppleRecipe;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            p.sendMessage("Craftable Enchanted Golden Apples enabled!");
            enabled = true;
        }
        else {
            p.sendMessage("Craftable Enchanted Golden Apples disabled!");
            enabled = false;
        }

        return true;
    }
}


