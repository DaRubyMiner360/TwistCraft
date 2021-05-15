package ml.darubyminer360.twistcraft.inventories;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.*;

public class TwistSelectionScreen implements InventoryHolder {
    Inventory inv;

    public TwistSelectionScreen() {
        inv = Bukkit.createInventory(this, 36, "Twist Selector"); // 54 is the max size
        init();
    }

    void init() {
        ItemStack fillerItem = createItem("", Material.BLACK_STAINED_GLASS_PANE, "");
        for (int i = 0; i < 36; i++) {
            if (i == 10) {
                // Craftable Command Blocks
                ItemStack item = createItem("Craftable Command Blocks", Material.COMMAND_BLOCK, "§1Twist", "", "Craftable Command Blocks allows you to craft and use command blocks in survival mode.");
                inv.setItem(i, item);
            }
            else if (i == 11) {
                // Craftable Barrier Blocks
                ItemStack item = createItem("Craftable Barrier Blocks", Material.BARRIER, "§1Twist", "", "Craftable Barrier Blocks allows you to craft barrier blocks.");
                inv.setItem(i, item);
            }
            else if (i == 12) {
                // Craftable Enchanted Golden Apples
                ItemStack item = createItem("Craftable Enchanted Golden Apples", Material.ENCHANTED_GOLDEN_APPLE, "§1Twist", "", "Craftable Enchanted Golden Apples allows you to craft enchanted golden apples.");
                inv.setItem(i, item);
            }
            else if (i == 13) {
                // OP Mobs
                ItemStack item = createItem("OP Mobs", Material.ZOMBIE_HEAD, "§1Twist", "", "OP Mobs makes every mob extremely overpowered.");
                inv.setItem(i, item);
            }
            else if (i == 14) {
                // Half Heart Eating
                ItemStack item = createItem("Half Heart Eating", Material.COOKED_BEEF, "§1Twist", "", "Half Heart Eating makes eating bring you to half a heart.");
                inv.setItem(i, item);
            }
            else if (i == 15) {
                // Everywhere Looked
                ItemStack item = createItem("Everywhere Looked", Material.BEDROCK, "§1Twist", "", "Everywhere Looked makes it to where whereever a player looks, something happens!");
                inv.setItem(i, item);
            }
            else if (i == 16) {
                // TNT Runner
                ItemStack item = createItem("TNT Runner", Material.TNT, "§1Twist", "", "TNT Runner makes TNT spawn on top of you every given amount of time!");
                inv.setItem(i, item);
            }
            else if (i == 19) {
                // Falling Blocks
                ItemStack item = createItem("Falling Blocks", Material.COBBLESTONE, "§1Twist", "", "Falling Blocks makes random blocks fall from the sky every given amount of time!");
                inv.setItem(i, item);
            }
            else if (i == 20) {
                // Raining Items
                ItemStack item = createItem("Raining Items", Material.APPLE, "§1Twist", "", "Raining Items makes random items fall from the sky every given amount of time!");
                inv.setItem(i, item);
            }
            else if (i == 21) {
                // Sneak Invisibility
                ItemStack item = createItem("Sneak Invisibility", Material.SPLASH_POTION, "§1Twist", "", "Sneak Invisibility makes it to where whenever a player sneaks, they become invisible!");
                inv.setItem(i, item);
            }
            else if (i == 22) {
                // Allowed Flight
                ItemStack item = createItem("Allowed Flight", Material.ELYTRA, "§1Twist", "", "Allowed Flight allows everyone to fly like creative mode!");
                inv.setItem(i, item);
            }
            else if (i == 23) {
                // Custom Enchants
                ItemStack item = createItem("Custom Enchants", Material.ENCHANTED_BOOK, "§1Twist", "", "Custom Enchants adds new enchantments!");
                inv.setItem(i, item);
            }
            else if (i == 24) {
                // Manhunt
                ItemStack item = createItem("Manhunt", Material.PLAYER_HEAD, "§4GameMode", "", "Manhunt is the gamemode where a speedrunner attempts to defeat the Ender Dragon while one or more hunters try to kill the speedrunner.");
                inv.setItem(i, item);
            }
            else if (i == 25) {
                // Death Swap
                ItemStack item = createItem("Death Swap", Material.NETHERITE_SWORD, "§4GameMode", "", "Death Swap is the gamemode where two players try to kill each other with traps when they swap positions!");
                inv.setItem(i, item);
            }
            else {
                inv.setItem(i, fillerItem);
            }
        }
    }

    ItemStack createItem(String name, Material mat, String... lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }
    
    @Override
    public Inventory getInventory() {
        return inv;
    }
}
