package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.util.Iterator;
import java.util.HashMap;

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

            TwistCraft.instance.messageServer("Craftable Command Blocks enabled!", p);
            enabled = true;
        }
        else {
            // Remove recipe
            Bukkit.getServer().removeRecipe(commandBlockRecipe.getKey());

            TwistCraft.instance.messageServer("Craftable Command Blocks disabled!", p);
            enabled = false;
        }

        return true;
    }
}
