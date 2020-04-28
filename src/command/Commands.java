package command;

import armorsets.AetherArmor;
import armorsets.DiscoArmor;
import items.Items;
import me.Bright.main.Main;
import me.Bright.main.Methods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Commands implements CommandExecutor {

    private Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("perm")) {
                if (cmd.getName().equalsIgnoreCase("getitem") && args.length == 1) {
                    if (args[0].equalsIgnoreCase("stickystick")) {
                        player.getInventory().addItem(Items.stickystick());
                        player.sendMessage(ChatColor.WHITE + "You received a " + ChatColor.GREEN + "Sticky Stick.");
                    } else if (args[0].equalsIgnoreCase("discoset")) {
                        player.getInventory().addItem(DiscoArmor.discohel(Color.BLACK));
                        player.getInventory().addItem(DiscoArmor.discochest(Color.BLACK));
                        player.getInventory().addItem(DiscoArmor.discoleg(Color.BLACK));
                        player.getInventory().addItem(DiscoArmor.discoboots(Color.BLACK));
                        player.sendMessage(ChatColor.WHITE + "You received the " + ChatColor.BLACK + "Disco Set.");
                    } else if (args[0].equalsIgnoreCase("slimeboots")) {
                        player.getInventory().addItem(Items.slimeboots());
                        player.sendMessage(ChatColor.WHITE + "You received a pair of " + ChatColor.GREEN + "Slime Boots.");
                    } else if (args[0].equalsIgnoreCase("grapple")) {
                        player.getInventory().addItem(Items.grapple());
                        player.sendMessage(ChatColor.WHITE + "You received a " + ChatColor.GRAY + "Grappling Hook.");
                    } else if (args[0].equalsIgnoreCase("endertools")) {
                        player.getInventory().addItem(Items.pearlpickaxe());
                        player.getInventory().addItem(Items.pearlaxe());
                        player.getInventory().addItem(Items.pearlshovel());
                        player.sendMessage(ChatColor.WHITE + "You received a set of " + ChatColor.DARK_PURPLE + "Ender Tools.");
                    } else if (args[0].equalsIgnoreCase("oldenderpick")) {
                        player.getInventory().addItem(Items.oldperalpickaxe());
                    } else if (args[0].equalsIgnoreCase("slimecore")) {
                        player.getInventory().addItem(Items.slimecore());
                    } else if (args[0].equalsIgnoreCase("aetherset")) {
                        player.getInventory().addItem(AetherArmor.helemt());
                        player.getInventory().addItem(AetherArmor.chestplate());
                        player.getInventory().addItem(AetherArmor.leggings());
                        player.getInventory().addItem(AetherArmor.boots());
                    } else if (args[0].equalsIgnoreCase("dragonbone")) {
                        player.getInventory().addItem(Items.spawndrag());
                    } else if (args[0].equalsIgnoreCase("aethersword")) {
                        player.getInventory().addItem(AetherArmor.sword());
                    } else {
                        player.sendMessage(ChatColor.RED + "Invalid Item.");
                    }
                    return true;
                } else if (cmd.getName().equalsIgnoreCase("push") && args.length == 2) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        try {
                            Player target = Bukkit.getPlayer(args[0]);
                            double factor = Double.parseDouble(args[1]);
                            Methods.setVelocity(player, target, factor);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return true;
    }
}