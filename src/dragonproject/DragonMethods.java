package dragonproject;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;

public class DragonMethods {

    public void spawnEnderman(Player player, double x, double y, double z) {
        World world = player.getLocation().getWorld();
        Location location = new Location(world, x, y, z);

        Mob enderman = (Mob) world.spawnEntity(location, EntityType.ENDERMAN);
        LivingEntity target = (LivingEntity) player;
        enderman.setTarget(target);
    }
}
