package ml.darubyminer360.twistcraft.commands;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.util.Iterator;

public class CraftableCommandBlocksCommand implements CommandExecutor {
    public static ShapelessRecipe commandBlockRecipe;
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            // Add recipe
            commandBlockRecipe = new ShapelessRecipe(new ItemStack(Material.COMMAND));
            commandBlockRecipe.addIngredient(1, Material.WORKBENCH);
            commandBlockRecipe.addIngredient(1, Material.WOOD_BUTTON);
            Bukkit.getServer().addRecipe(commandBlockRecipe);

            p.sendMessage("Craftable Command Blocks enabled!");
            enabled = true;
        }
        else {
            // Remove recipe
            Iterator<Recipe> iter = Bukkit.getServer().recipeIterator();
            while (iter.hasNext()) {
                Recipe r = iter.next();

                if (r == commandBlockRecipe) {
                    iter.remove();
                }
            }

            p.sendMessage("Craftable Command Blocks disabled!");
            enabled = false;
        }

        return true;
    }
}
