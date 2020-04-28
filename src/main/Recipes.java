package me.Bright.main;

import items.Items;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Recipes implements Listener {

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        CraftingInventory inventory = event.getInventory();
        if(inventory.getMatrix().length <9){
            return;
        }

        HashMap<Integer, ItemStack> enderpickrecipe = new HashMap<>();
        enderpickrecipe.put(0, new ItemStack(Material.ENDER_PEARL));
        enderpickrecipe.put(1, new ItemStack(Material.DIAMOND));
        enderpickrecipe.put(2, new ItemStack(Material.ENDER_PEARL));
        enderpickrecipe.put(4, new ItemStack(Material.STICK));
        enderpickrecipe.put(7, new ItemStack(Material.END_ROD));

        HashMap<Integer, ItemStack> enderaxerecipe = new HashMap<>();
        enderaxerecipe.put(0, new ItemStack(Material.ENDER_PEARL));
        enderaxerecipe.put(1, new ItemStack(Material.DIAMOND));
        enderaxerecipe.put(3, new ItemStack(Material.ENDER_PEARL));
        enderaxerecipe.put(4, new ItemStack(Material.STICK));
        enderaxerecipe.put(7, new ItemStack(Material.END_ROD));

        HashMap<Integer, ItemStack> endershovelrecipe = new HashMap<>();
        endershovelrecipe.put(1, new ItemStack(Material.ENDER_PEARL));
        endershovelrecipe.put(4, new ItemStack(Material.STICK));
        endershovelrecipe.put(7, new ItemStack(Material.END_ROD));

        HashMap<Integer, ItemStack> simebootsrecipe = new HashMap<>();
        simebootsrecipe.put(3, new ItemStack(Material.SLIME_BLOCK));
        simebootsrecipe.put(5, new ItemStack(Material.SLIME_BLOCK));
        simebootsrecipe.put(6, Items.slimecore());
        simebootsrecipe.put(8, Items.slimecore());

        Methods.checkCraft(Items.pearlpickaxe(), inventory, enderpickrecipe);
        Methods.checkCraft(Items.pearlaxe(), inventory, enderaxerecipe);
        Methods.checkCraft(Items.pearlshovel(), inventory, endershovelrecipe);
        Methods.checkCraft(Items.slimeboots(), inventory, simebootsrecipe);
    }
}