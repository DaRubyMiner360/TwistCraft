package ml.darubyminer360.twistcraft.commands;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.util.Iterator;

public class TwistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        switch (args[0].toLowerCase()) {
            case "list":
                p.sendMessage("- Craftable Command Blocks (craftablecommandblocks)");
                break;
            case "enable":
                if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                    // Add recipe
                    CraftableCommandBlocksCommand.commandBlockRecipe = new ShapelessRecipe(new ItemStack(Material.COMMAND));
                    CraftableCommandBlocksCommand.commandBlockRecipe.addIngredient(1, Material.WORKBENCH);
                    CraftableCommandBlocksCommand.commandBlockRecipe.addIngredient(1, Material.WOOD_BUTTON);
                    Bukkit.getServer().addRecipe(CraftableCommandBlocksCommand.commandBlockRecipe);

                    p.sendMessage("Craftable Command Blocks enabled!");
                    CraftableCommandBlocksCommand.enabled = true;
                } else {
                    return false;
                }
                break;
            case "disable":
                if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                    // Remove recipe
                    Iterator<Recipe> iter = Bukkit.getServer().recipeIterator();
                    while (iter.hasNext()) {
                        Recipe r = iter.next();

                        if (r == CraftableCommandBlocksCommand.commandBlockRecipe) {
                            iter.remove();
                        }
                    }

                    p.sendMessage("Craftable Command Blocks disabled!");
                    CraftableCommandBlocksCommand.enabled = false;
                } else {
                    return false;
                }
                break;
            case "info":
                if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                    p.sendMessage("Craftable Command Blocks allows you to craft and use command blocks in survival mode.");
                } else {
                    return false;
                }
                break;
            default:
                return false;
        }

        return true;
    }
}
