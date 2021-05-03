package ml.darubyminer360.twistcraft;

import ml.darubyminer360.twistcraft.commands.*;

import ml.darubyminer360.twistcraft.listeners.*;
import ml.darubyminer360.twistcraft.util.Config;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class TwistCraft extends JavaPlugin {
    public static TwistCraft instance;

    public ItemStack[] opLootTable;

    @Override
    public void onEnable() {
        instance = this;

        // Setup OP Loot Table
        ItemStack netheriteHoe = new ItemStack(Material.NETHERITE_HOE, 1);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 7);
        netheriteHoe.addUnsafeEnchantment(Enchantment.MENDING, 3);
        ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD, 1);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 7);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 7);
        netheriteHoe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);
        netheriteHoe.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        netheriteHoe.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 5);
        netheriteHoe.addUnsafeEnchantment(Enchantment.MENDING, 3);
        ItemStack netheriteAxe = new ItemStack(Material.NETHERITE_AXE, 1);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DURABILITY, 6);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 8);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 8);
        netheriteHoe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 6);
        netheriteHoe.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        netheriteHoe.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 6);
        netheriteHoe.addUnsafeEnchantment(Enchantment.MENDING, 3);
        ItemStack ironChestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.THORNS, 3);
        netheriteHoe.addUnsafeEnchantment(Enchantment.MENDING, 1);
        ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS, 1);
        netheriteHoe.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        netheriteHoe.addUnsafeEnchantment(Enchantment.FROST_WALKER, 2);
        netheriteHoe.addUnsafeEnchantment(Enchantment.SOUL_SPEED, 10);
        netheriteHoe.addUnsafeEnchantment(Enchantment.THORNS, 3);
        netheriteHoe.addUnsafeEnchantment(Enchantment.MENDING, 1);
        opLootTable = new ItemStack[] { new ItemStack(Material.DIAMOND, 6), new ItemStack(Material.DIAMOND_BLOCK, 3), new ItemStack(Material.IRON_INGOT, 6), new ItemStack(Material.IRON_BLOCK, 3), new ItemStack(Material.NETHERITE_INGOT, 1), netheriteHoe, netheriteSword, netheriteAxe };

        // Setup commands
        getCommand("twist").setExecutor(new TwistCommand());
        getCommand("craftablecommandblocks").setExecutor(new CraftableCommandBlocksCommand());
        getCommand("opmobs").setExecutor(new OPMobsCommand());
        getCommand("halfhearteating").setExecutor(new HalfHeartEatingCommand());
        getCommand("manhunt").setExecutor(new ManhuntCommand());
        getCommand("everywherelooked").setExecutor(new EverywhereLookedCommand());
        getCommand("deathswap").setExecutor(new DeathSwapCommand());
        getCommand("tntrunner").setExecutor(new TNTRunnerCommand());
        getCommand("fallingblocks").setExecutor(new FallingBlocksCommand());

        // Setup Listeners
        getServer().getPluginManager().registerEvents(new CraftableCommandBlocksListener(), this);
        getServer().getPluginManager().registerEvents(new OPMobsListener(), this);
        getServer().getPluginManager().registerEvents(new HalfHeartEatingListener(), this);
        getServer().getPluginManager().registerEvents(new ManhuntListener(), this);
        getServer().getPluginManager().registerEvents(new EverywhereLookedListener(), this);

        // Setup config
        Config.setup();
        Config.get().addDefault("BroadcastMessages", false);
        Config.get().options().copyDefaults(true);
        Config.save();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public void messageServer(String message, Player p) {
        if (Config.get().getBoolean("BroadcastMessages")) {
            p.getServer().broadcastMessage(message);
        }
        else {
            p.sendMessage(message);
        }
    }
}
