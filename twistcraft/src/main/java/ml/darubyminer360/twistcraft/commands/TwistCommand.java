package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Iterator;

public class TwistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        switch (args[0].toLowerCase()) {
            case "list":
                TwistCraft.instance.messageServer("- Craftable Command Blocks (craftablecommandblocks)", p);
                TwistCraft.instance.messageServer("- OP Mobs (opmobs)", p);
                TwistCraft.instance.messageServer("- Half Heart Eating (halfhearteating)", p);
                TwistCraft.instance.messageServer("- Craftable Enchanted Golden Apples (craftableenchantedgoldenapples)", p);
                TwistCraft.instance.messageServer("- Manhunt (manhunt <speedrunner>)", p);
                TwistCraft.instance.messageServer("- Everywhere Looked (everywherelooked <mode>)", p);
                TwistCraft.instance.messageServer("- Death Swap (deathswap <other>)", p);
                TwistCraft.instance.messageServer("- TNT Runner (tntrunner <cooldown>)", p);
                break;
            case "enable":
                if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                    // Add recipe
                    CraftableCommandBlocksCommand.commandBlockRecipe = new ShapelessRecipe(new NamespacedKey(TwistCraft.instance, "command_block"), new ItemStack(Material.COMMAND_BLOCK));
                    CraftableCommandBlocksCommand.commandBlockRecipe.addIngredient(1, Material.CRAFTING_TABLE);
                    CraftableCommandBlocksCommand.commandBlockRecipe.addIngredient(1, Material.OAK_BUTTON);
                    Bukkit.getServer().addRecipe(CraftableCommandBlocksCommand.commandBlockRecipe);

                    TwistCraft.instance.messageServer("Craftable Command Blocks enabled!", p);
                    CraftableCommandBlocksCommand.enabled = true;
                }
                else if (args[1].equalsIgnoreCase("opmobs")) {
                    TwistCraft.instance.messageServer("OP Mobs enabled!", p);
                    OPMobsCommand.enabled = true;
                }
                else if (args[1].equalsIgnoreCase("halfhearteating")) {
                    TwistCraft.instance.messageServer("Half Heart Eating enabled!", p);
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

                    TwistCraft.instance.messageServer("Craftable Enchanted Golden Apples enabled!", p);
                    CraftableEnchantedGoldenApplesCommand.enabled = true;
                }
                else if (args[1].equalsIgnoreCase("manhunt")) {
                    if (args.length > 2) {
                        ManhuntCommand.hunted = args[2];

                        TwistCraft.instance.messageServer("Manhunt enabled! " + args[2] + " is the speedrunner!", p);
                        ManhuntCommand.enabled = true;
                    }
                    else {
                        p.sendMessage("Add the speedrunner as an argument!");
                    }
                }
                else if (args[1].equalsIgnoreCase("everywherelooked")) {
                    if (args.length > 2) {
                        TwistCraft.instance.messageServer("Everywhere Looked enabled! " + args[2] + " is the selected mode!", p);
                        EverywhereLookedCommand.enabled = true;
                    }
                    else {
                        p.sendMessage("Add the mode as an argument!");
                    }
                }
                else if (args[1].equalsIgnoreCase("deathswap")) {
                    if (args.length > 2) {
                        Player p2 = p.getServer().getPlayer(args[2]);

                        BukkitScheduler scheduler = p.getServer().getScheduler();
                        DeathSwapCommand.task1 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                            int num = 10;

                            @Override
                            public void run() {
                                if (num == 0) {
                                    p.getServer().broadcastMessage("Go!");
                                    p.getServer().getScheduler().cancelTask(DeathSwapCommand.task1);
                                }
                                else {
                                    p.getServer().broadcastMessage(Integer.toString(num--));
                                }
                            }
                        }, 20L, 20L);
                        DeathSwapCommand.task2 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                            @Override
                            public void run() {
                                DeathSwapCommand.task3 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                                    int num = 20;

                                    @Override
                                    public void run() {
                                        if (num == 0) {
                                            Location l1 = p.getLocation();
                                            p.teleport(p2.getLocation());
                                            p2.teleport(l1);
                                            p.getServer().getScheduler().cancelTask(DeathSwapCommand.task3);
                                        }
                                        else {
                                            p.getServer().broadcastMessage(Integer.toString(num--));
                                        }
                                    }
                                }, 0L, 20L);
                            }
                        }, 6020L, 6000L);

                        TwistCraft.instance.messageServer("Death Swap enabled! The players are " + p.getDisplayName() + " and " + args[2] + "!", p);
                        DeathSwapCommand.enabled = true;
                    }
                    else {
                        p.sendMessage("Add the other player as an argument!");
                    }
                }
                else if (args[1].equalsIgnoreCase("tntrunner")) {
                    if (args.length > 2) {
                        int cooldown = Integer.parseInt(args[2]);

                        BukkitScheduler scheduler = p.getServer().getScheduler();
                        TNTRunnerCommand.task = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                            @Override
                            public void run() {
                                Entity tnt = p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
                                ((TNTPrimed)tnt).setFuseTicks(80);
                            }
                        }, cooldown * 20L, cooldown * 20L);

                        TwistCraft.instance.messageServer("TNT Runner enabled with a cooldown of " + args[2] + "!", p);
                        TNTRunnerCommand.enabled = true;
                    }
                    else {
                        p.sendMessage("Add the amount of time between TNT spawns (in seconds) as an argument!");
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

                    TwistCraft.instance.messageServer("Craftable Command Blocks disabled!", p);
                    CraftableCommandBlocksCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("opmobs")) {
                    TwistCraft.instance.messageServer("OP Mobs disabled!", p);
                    OPMobsCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("halfhearteating")) {
                    TwistCraft.instance.messageServer("Half Heart Eating disabled!", p);
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

                    TwistCraft.instance.messageServer("Craftable Enchanted Golden Apples disabled!", p);
                    CraftableEnchantedGoldenApplesCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("manhunt")) {
                    TwistCraft.instance.messageServer("Manhunt disabled!", p);
                    ManhuntCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("everywherelooked")) {
                    TwistCraft.instance.messageServer("Everywhere Looked disabled!", p);
                    EverywhereLookedCommand.enabled = false;
                }
                else if (args[1].equalsIgnoreCase("deathswap")) {
                    if (DeathSwapCommand.enabled) {
                        p.getServer().getScheduler().cancelTask(DeathSwapCommand.task1);
                        p.getServer().getScheduler().cancelTask(DeathSwapCommand.task2);
                        p.getServer().getScheduler().cancelTask(DeathSwapCommand.task3);

                        TwistCraft.instance.messageServer("Death Swap disabled!", p);
                        DeathSwapCommand.enabled = false;
                    }
                }
                else if (args[1].equalsIgnoreCase("tntrunner")) {
                    if (TNTRunnerCommand.enabled) {
                        p.getServer().getScheduler().cancelTask(TNTRunnerCommand.task);

                        TwistCraft.instance.messageServer("TNT Runner disabled!", p);
                        TNTRunnerCommand.enabled = false;
                    }
                }
                break;
            case "info":
                if (args[1].equalsIgnoreCase("craftablecommandblocks")) {
                    TwistCraft.instance.messageServer("Craftable Command Blocks allows you to craft and use command blocks in survival mode.", p);
                }
                else if (args[1].equalsIgnoreCase("opmobs")) {
                    TwistCraft.instance.messageServer("OP Mobs makes every mob extremely overpowered.", p);
                }
                else if (args[1].equalsIgnoreCase("halfhearteating")) {
                    TwistCraft.instance.messageServer("Half Heart Eating makes eating bring you to half a heart.", p);
                }
                else if (args[1].equalsIgnoreCase("craftableenchantedgoldenapples")) {
                    TwistCraft.instance.messageServer("Craftable Enchanted Golden Apples you to craft enchanted golden apples.", p);
                }
                else if (args[1].equalsIgnoreCase("manhunt")) {
                    TwistCraft.instance.messageServer("Manhunt is the gamemode where a speedrunner attempts to defeat the Ender Dragon while one or more hunters try to kill the speedrunner.", p);
                }
                else if (args[1].equalsIgnoreCase("everywherelooked")) {
                    TwistCraft.instance.messageServer("Everywhere Looked is the gamemode where whereever a player looks, something happens!", p);
                }
                else if (args[1].equalsIgnoreCase("deathswap")) {
                    TwistCraft.instance.messageServer("Death Swap is the gamemode where two players try to kill each other with traps when they swap positions!", p);
                }
                else if (args[1].equalsIgnoreCase("tntrunner")) {
                    TwistCraft.instance.messageServer("TNT Runner makes TNT spawn on top of you every given amount of seconds!", p);
                }
                break;
            default:
                p.sendMessage("Use '/twist list' for a list of possible twists");
                break;
        }

        return true;
    }
}
