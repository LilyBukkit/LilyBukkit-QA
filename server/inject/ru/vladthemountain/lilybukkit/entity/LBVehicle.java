package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.Entity;
import org.bukkit.World;
import org.bukkit.entity.Vehicle;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBVehicle extends LBEntity implements Vehicle {
    public LBVehicle(World w, Entity e) {
        super(w, e);
    }
}
