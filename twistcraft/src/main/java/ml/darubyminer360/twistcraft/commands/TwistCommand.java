package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.*;
import org.bukkit.inventory.*;
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
                p.sendMessage("- OP Mobs (opmobs)");
                break;
            case "enable":
                if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                    // Add recipe
                    CraftableCommandBlocksCommand.commandBlockRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "command_block"), new ItemStack(Material.COMMAND_BLOCK));
                    CraftableCommandBlocksCommand.commandBlockRecipe.addIngredient(1, Material.CRAFTING_TABLE);
                    CraftableCommandBlocksCommand.commandBlockRecipe.addIngredient(1, Material.OAK_BUTTON);
                    Bukkit.getServer().addRecipe(CraftableCommandBlocksCommand.commandBlockRecipe);

                    p.sendMessage("Craftable Command Blocks enabled!");
                    CraftableCommandBlocksCommand.enabled = true;
                }
                else if (args[1].equalsIgnoreCase("opmobs")) {
                    p.sendMessage("OP Mobs enabled!");
                    OPMobsCommand.enabled = true;
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
                }
                else if (args[1].equalsIgnoreCase("opmobs")) {
                    p.sendMessage("OP Mobs disabled!");
                    OPMobsCommand.enabled = false;
                }
                break;
            case "info":
                if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                    p.sendMessage("Craftable Command Blocks allows you to craft and use command blocks in survival mode.");
                }
                else if (args[1].equalsIgnoreCase("opmobs")) {
                    p.sendMessage("OP Mobs makes every mob extremely overpowered.");
                }
                break;
        }

        return true;
    }
}
