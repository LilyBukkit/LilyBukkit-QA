package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityBoat;
import org.bukkit.entity.Boat;

public class LBBoat extends LBVehicle implements Boat {

    EntityBoat entity;
    double maxSpeed = 0.4;

    /**
     * Gets the maximum speed of a boat. The speed is unrelated to the velocity.
     */
    @Override
    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    /**
     * Sets the maximum speed of a boat. Must be nonnegative. Default is 0.4D.
     *
     * @param speed
     */
    @Override
    public void setMaxSpeed(double speed) {
        this.maxSpeed = speed;
    }
}
