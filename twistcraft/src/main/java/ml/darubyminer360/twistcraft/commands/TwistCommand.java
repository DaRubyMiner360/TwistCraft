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
                p.sendMessage("- Half Heart Eating (halfhearteating)");
                p.sendMessage("- Craftable Enchanted Golden Apples (craftableenchantedgoldenapples)");
                p.sendMessage("- Manhunt (manhunt <speedrunner>)");
                p.sendMessage("- Everywhere Looked (everywherelooked <mode>)");
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
                else if (args[1].equalsIgnoreCase("halfhearteating")) {
                    p.sendMessage("Half Heart Eating enabled!");
                    HalfHeartEatingCommand.enabled = true;
                }
                else if (args[1].equalsIgnoreCase("craftableenchantedgoldenapples")) {
                    // Add recipe
                    CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe = new ShapedRecipe(new NamespacedKey(TwistCraft.instance, "enchanted_golden_apple"), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
                    CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe.shape(
                            "GGG",
                            "GAG",
                            "GGG"
                    );
                    CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe.setIngredient('G', Material.GOLD_BLOCK);
                    CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe.setIngredient('A', Material.APPLE);
                    Bukkit.getServer().addRecipe(CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe);

                    p.sendMessage("Craftable Enchanted Golden Apples enabled!");
                    CraftableEnchantedGoldenApplesCommand.enabled = true;
                }
                else if (args[1].equalsIgnoreCase("manhunt")) {
                    if (args.length > 2) {
                        ManhuntCommand.hunted = args[2];

                        p.sendMessage("Manhunt enabled! " + args[2] + " is the speedrunner!");
                        ManhuntCommand.enabled = true;
                    }
                    else {
                        p.sendMessage("Add the speedrunner as an argument!");
                    }
                }
                else if (args[1].equalsIgnoreCase("everywherelooked")) {
                    if (args.length > 2) {
                        p.sendMessage("Everywhere Looked enabled! " + args[2] + " is the selected mode!");
                        EverywhereLookedCommand.enabled = true;
                    }
                    else {
                        p.sendMessage("Add the mode as an argument!");
                    }
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
                else if (args[1].equalsIgnoreCase("halfhearteating")) {
                    p.sendMessage("Half Heart Eating disabled!");
                    HalfHeartEatingCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("craftableenchantedgoldenapples")) {
                    // Remove recipe
                    Iterator<Recipe> iter = Bukkit.getServer().recipeIterator();
                    while (iter.hasNext()) {
                        Recipe r = iter.next();

                        if (r == CraftableEnchantedGoldenApplesCommand.enchantedGoldenAppleRecipe) {
                            iter.remove();
                        }
                    }

                    p.sendMessage("Craftable Enchanted Golden Apples disabled!");
                    CraftableEnchantedGoldenApplesCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("manhunt")) {
                    p.sendMessage("Manhunt disabled!");
                    ManhuntCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("everywherelooked")) {
                    p.sendMessage("Everywhere Looked disabled!");
                    EverywhereLookedCommand.enabled = false;
                }
                break;
            case "info":
                if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                    p.sendMessage("Craftable Command Blocks allows you to craft and use command blocks in survival mode.");
                }
                else if (args[1].equalsIgnoreCase("opmobs")) {
                    p.sendMessage("OP Mobs makes every mob extremely overpowered.");
                }
                else if (args[1].equalsIgnoreCase("halfhearteating")) {
                    p.sendMessage("Half Heart Eating makes eating bring you to half a heart.");
                }
                else if (args[1].equalsIgnoreCase("craftableenchantedgoldenapples")) {
                    p.sendMessage("Craftable Enchanted Golden Apples you to craft enchanted golden apples.");
                }
                else if (args[1].equalsIgnoreCase("manhunt")) {
                    p.sendMessage("Manhunt is the gamemode where a speedrunner attempts to defeat the Ender Dragon while one or more hunters try to kill the speedrunner.");
                    ManhuntCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("everywherelooked")) {
                    p.sendMessage("Everywhere Looked is the gamemode where whereever a player looks, something happens!");
                    EverywhereLookedCommand.enabled = false;
                }
                break;
        }

        return true;
    }
}
