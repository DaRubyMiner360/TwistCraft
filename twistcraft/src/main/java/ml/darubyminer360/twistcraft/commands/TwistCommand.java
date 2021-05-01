package ml.darubyminer360.twistcraft.commands;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class TwistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        
        if (args[0].toLowerCase() == "list") {
          p.sendMessage("- Craftable Command Blocks (craftablecommandblocks)");
        }
        else if (args[0].toLowerCase() == "enable") {
          if (args[1].toLowerCase() == "craftablecommandblocks") {
            // Add recipe
            ShapelessRecipe sr = new ShapelessRecipe(NamespacedKey.minecraft("command_block"), Material.COMMAND);
            sr.addIngredient(1, Material.WORKBENCH);
            sr.addIngredient(1, Material.WOOD_BUTTON);
            Bukkit.getServer().addRecipe(sr);

            p.sendMessage("Craftable Command Blocks enabled!");
          }
          else {
            return false;
          }
        }
        else if (args[0].toLowerCase() == "disable") {
          // Remove recipe
          ShapelessRecipe sr = new ShapelessRecipe(NamespacedKey.minecraft("command_block"), Material.AIR);
          sr.addIngredient(1, Material.WORKBENCH);
          sr.addIngredient(1, Material.WOOD_BUTTON);
          Bukkit.getServer().addRecipe(sr);

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
