package ru.vtm.lilybukkit.entity;

import org.bukkit.entity.Boat;

public class LBBoat extends LBVehicle implements Boat {

    /**
     * Gets the maximum speed of a boat. The speed is unrelated to the velocity.
     */
    @Override
    public double getMaxSpeed() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the maximum speed of a boat. Must be nonnegative. Default is 0.4D.
     *
     * @param speed
     */
    @Override
    public void setMaxSpeed(double speed) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
