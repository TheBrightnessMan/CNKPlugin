package command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (((Player) sender).hasPermission("perm")){
                if (cmd.getName().equalsIgnoreCase("getitem") && args.length == 1) {
                    List<String> list = new ArrayList<>();
                    list.add("stickystick");
                    list.add("discoset");
                    list.add("slimeboots");
                    list.add("grapple");
                    list.add("endertools");
                    list.add("launchpad");
                    list.add("slimecore");
                    list.add("aetherset");
                    return list;
                }
            }
        }
        return null;
    }
}
