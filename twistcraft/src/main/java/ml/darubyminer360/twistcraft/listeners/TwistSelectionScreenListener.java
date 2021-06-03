package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.commands.*;
import ml.darubyminer360.twistcraft.inventories.TwistSelectionScreen;
import ml.darubyminer360.twistcraft.util.SignMenuFactory;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.*;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class TwistSelectionScreenListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        if (event.getClickedInventory() == null) { return; }
        if (event.getClickedInventory().getHolder() instanceof TwistSelectionScreen) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) { return; }
            if (event.getCurrentItem().getType() == Material.COMMAND_BLOCK) {
                // Craftable Command Blocks
                p.closeInventory();

                p.performCommand("craftablecommandblocks");
            }
            else if (event.getCurrentItem().getType() == Material.BARRIER) {
                // Craftable Barrier Blocks
                p.closeInventory();

                p.performCommand("craftablebarrierblocks");
            }
            else if (event.getCurrentItem().getType() == Material.ENCHANTED_GOLDEN_APPLE) {
                // Craftable Enchanted Golden Apples
                p.closeInventory();

                p.performCommand("craftableenchantedgoldenapples");
            }
            else if (event.getCurrentItem().getType() == Material.ZOMBIE_HEAD) {
                // OP Mobs
                p.closeInventory();

                p.performCommand("opmobs");
            }
            else if (event.getCurrentItem().getType() == Material.COOKED_BEEF) {
                // Half Heart Eating
                p.closeInventory();

                p.performCommand("halfhearteating");
            }
            else if (event.getCurrentItem().getType() == Material.BEDROCK) {
                // Everywhere Looked
                p.closeInventory();

                if (EverywhereLookedCommand.enabled) {
                    p.performCommand("everywherelooked");
                }
                else {
                    // Open GUI to select mode
                    p.performCommand("everywherelookedselector");
                }
            }
            else if (event.getCurrentItem().getType() == Material.TNT) {
                // TNT Runner
                p.closeInventory();

                if (TNTRunnerCommand.enabled) {
                    p.performCommand("tntrunner");
                }
                else {
                    // Open GUI to select cooldown
//                    new AnvilGUI.Builder()
//                        .onComplete((player, text) -> {
//                            player.performCommand("tntrunner " + text);
//                            return AnvilGUI.Response.close();
//                        })
//                        .text("Cooldown")
//                        .itemLeft(new ItemStack(Material.PAPER))
//                        .title("Cooldown")
//                        .plugin(TwistCraft.instance)
//                        .open(p);
                    SignMenuFactory.Menu menu = TwistCraft.instance.getSignMenuFactory().newMenu(Arrays.asList("", "^^^^^^^^^^^^^^^", "Cooldown", "in ticks"))
                            .reopenIfFail(true)
                            .response((player, strings) -> {
                                Bukkit.getScheduler().callSyncMethod(TwistCraft.instance, () -> player.performCommand("tntrunner " + strings[0]));
                                return true;
                            });

                    menu.open(p);
                }
            }
            else if (event.getCurrentItem().getType() == Material.COBBLESTONE) {
                // Falling Blocks
                p.closeInventory();

                if (FallingBlocksCommand.enabled) {
                    p.performCommand("fallingblocks");
                }
                else {
                    // Open GUI to select cooldown
//                    new AnvilGUI.Builder()
//                        .onComplete((player, text) -> {
//                            player.performCommand("fallingblocks " + text);
//                            return AnvilGUI.Response.close();
//                        })
//                        .text("Cooldown")
//                        .itemLeft(new ItemStack(Material.PAPER))
//                        .title("Cooldown")
//                        .plugin(TwistCraft.instance)
//                        .open(p);
                    SignMenuFactory.Menu menu = TwistCraft.instance.getSignMenuFactory().newMenu(Arrays.asList("", "^^^^^^^^^^^^^^^", "Cooldown", "in ticks"))
                            .reopenIfFail(true)
                            .response((player, strings) -> {
                                Bukkit.getScheduler().callSyncMethod(TwistCraft.instance, () -> player.performCommand("fallingblocks " + strings[0]));
                                return true;
                            });

                    menu.open(p);
                }
            }
            else if (event.getCurrentItem().getType() == Material.APPLE) {
                // Raining Items
                p.closeInventory();

                if (RainingItemsCommand.enabled) {
                    p.performCommand("rainingitems");
                }
                else {
                    // Open GUI to select cooldown
//                    new AnvilGUI.Builder()
//                        .onComplete((player, text) -> {
//                            player.performCommand("rainingitems " + text);
//                            return AnvilGUI.Response.close();
//                        })
//                        .text("Cooldown")
//                        .itemLeft(new ItemStack(Material.PAPER))
//                        .title("Cooldown")
//                        .plugin(TwistCraft.instance)
//                        .open(p);
                    SignMenuFactory.Menu menu = TwistCraft.instance.getSignMenuFactory().newMenu(Arrays.asList("", "^^^^^^^^^^^^^^^", "Cooldown", "in ticks"))
                            .reopenIfFail(true)
                            .response((player, strings) -> {
                                Bukkit.getScheduler().callSyncMethod(TwistCraft.instance, () -> player.performCommand("rainingitems " + strings[0]));
                                return true;
                            });

                    menu.open(p);
                }
            }
            else if (event.getCurrentItem().getType() == Material.SPLASH_POTION) {
                // Sneak Invisibility
                p.closeInventory();

                p.performCommand("sneakinvisibility");
            }
            else if (event.getCurrentItem().getType() == Material.ELYTRA) {
                // Allowed Flight
                p.closeInventory();

                p.performCommand("allowedflight");
            }
            else if (event.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
                // Custom Enchants
                p.closeInventory();

                p.performCommand("customenchants");
            }
            else if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                // Manhunt
                p.closeInventory();

                if (ManhuntCommand.enabled) {
                    p.performCommand("manhunt");
                }
                else {
                    // Open GUI to select speedrunner
//                    new AnvilGUI.Builder()
//                        .onComplete((player, text) -> {
//                            player.performCommand("manhunt " + text);
//                            return AnvilGUI.Response.close();
//                        })
//                        .text("Speedrunner's Username")
//                        .itemLeft(new ItemStack(Material.PAPER))
//                        .title("Speedrunner's Username")
//                        .plugin(TwistCraft.instance)
//                        .open(p);
                    SignMenuFactory.Menu menu = TwistCraft.instance.getSignMenuFactory().newMenu(Arrays.asList("", "^^^^^^^^^^^^^^^", "Speedrunner's", "Username"))
                            .reopenIfFail(true)
                            .response((player, strings) -> {
                                Bukkit.getScheduler().callSyncMethod(TwistCraft.instance, () -> player.performCommand("manhunt " + strings[0]));
                                return true;
                            });

                    menu.open(p);
                }
            }
            else if (event.getCurrentItem().getType() == Material.NETHERITE_SWORD) {
                // Death Swap
                p.closeInventory();

                if (DeathSwapCommand.enabled) {
                    p.performCommand("deathswap");
                }
                else {
                    // Open GUI to select opponent
//                    new AnvilGUI.Builder()
//                        .onComplete((player, text) -> {
//                            player.performCommand("deathswap " + text);
//                            return AnvilGUI.Response.close();
//                        })
//                        .text("Opponent's Username")
//                        .itemLeft(new ItemStack(Material.PAPER))
//                        .title("Opponent's Username")
//                        .plugin(TwistCraft.instance)
//                        .open(p);
                    SignMenuFactory.Menu menu = TwistCraft.instance.getSignMenuFactory().newMenu(Arrays.asList("", "^^^^^^^^^^^^^^^", "Opponent's", "Username"))
                            .reopenIfFail(true)
                            .response((player, strings) -> {
                                Bukkit.getScheduler().callSyncMethod(TwistCraft.instance, () -> player.performCommand("deathswap " + strings[0]));
                                return true;
                            });

                    menu.open(p);
                }
            }
            else if (event.getCurrentItem().getType() == Material.BEACON) {
                // OP Loot
                p.closeInventory();

                // Open GUI to select what gives OP Loot
                p.performCommand("oploot");
            }
        }
    }
}
