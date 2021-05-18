package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.inventories.OPLootSelectionScreen;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class OPLootCommand implements CommandExecutor {
    public static HashMap<String, Boolean> enabled = new HashMap<String, Boolean>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("doors")) {
                if (!enabled.get("doors")) {
                    TwistCraft.instance.messageServer("Doors Drop OP Loot enabled!", p);
                    enabled.replace("doors", true);
                }
                else {
                    TwistCraft.instance.messageServer("Doors Drop OP Loot disabled!", p);
                    enabled.replace("doors", false);
                }
            }
            else if (args[0].equalsIgnoreCase("trapdoors")) {
                if (!enabled.get("trapdoors")) {
                    TwistCraft.instance.messageServer("Trapdoors Drop OP Loot enabled!", p);
                    enabled.replace("trapdoors", true);
                }
                else {
                    TwistCraft.instance.messageServer("Trapdoors Drop OP Loot disabled!", p);
                    enabled.replace("trapdoors", false);
                }
            }
            else if (args[0].equalsIgnoreCase("shearing")) {
                if (!enabled.get("shearing")) {
                    TwistCraft.instance.messageServer("Shearing Animals Drops OP Loot enabled!", p);
                    enabled.replace("shearing", true);
                }
                else {
                    TwistCraft.instance.messageServer("Shearing Animals Drops OP Loot disabled!", p);
                    enabled.replace("shearing", false);
                }
            }
            else if (args[0].equalsIgnoreCase("mending")) {
                if (!enabled.get("mending")) {
                    TwistCraft.instance.messageServer("Mending Items Drops OP Loot enabled!", p);
                    enabled.replace("mending", true);
                }
                else {
                    TwistCraft.instance.messageServer("Mending Items Drops OP Loot disabled!", p);
                    enabled.replace("mending", false);
                }
            }
        }
        else {
            OPLootSelectionScreen opLootSelector = new OPLootSelectionScreen();
            p.openInventory(opLootSelector.getInventory());
        }

        return true;
    }
}

