package ml.darubyminer360.twistcraft.commands;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.util.Iterator;

public class TwistCommand implements CommandExecutor {
    ShapelessRecipe commandBlockRecipe;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        
        if (args[0].toLowerCase() == "list") {
          p.sendMessage("- Craftable Command Blocks (craftablecommandblocks)");
        }
        else if (args[0].toLowerCase() == "enable") {
          if (args[1].toLowerCase() == "craftablecommandblocks") {
            // Add recipe
              commandBlockRecipe = new ShapelessRecipe(new ItemStack(Material.COMMAND));
              commandBlockRecipe.addIngredient(1, Material.WORKBENCH);
              commandBlockRecipe.addIngredient(1, Material.WOOD_BUTTON);
            Bukkit.getServer().addRecipe(commandBlockRecipe);

            p.sendMessage("Craftable Command Blocks enabled!");
          }
          else {
            return false;
          }
        }
        else if (args[0].toLowerCase() == "disable") {
          // Remove recipe
          Iterator<Recipe> iter = Bukkit.getServer().recipeIterator();
          while (iter.hasNext()) {
              Recipe r = iter.next();

              if (r == commandBlockRecipe) {
                  iter.remove();
              }
          }

          if (args[1].toLowerCase() == "craftablecommandblocks") {
            p.sendMessage("Craftable Command Blocks disabled!");
          }
          else {
            return false;
          }
        }
        else if (args[0].toLowerCase() == "info") {
          if (args[1].toLowerCase() == "craftablecommandblocks") {
            p.sendMessage("Craftable Command Blocks allows you to craft and use command blocks in survival mode.");
          }
          else {
            return false;
          }
        }
        else {
          return false;
        }

        return true;
    }
}
