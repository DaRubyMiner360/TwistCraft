package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.*;
import org.bukkit.inventory.*;
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
            commandBlockRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "command_block"), new ItemStack(Material.COMMAND_BLOCK));
            commandBlockRecipe.addIngredient(1, Material.CRAFTING_TABLE);
            commandBlockRecipe.addIngredient(1, Material.OAK_BUTTON);
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
