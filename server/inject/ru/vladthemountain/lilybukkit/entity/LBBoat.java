package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityBoat;
import org.bukkit.entity.Boat;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBBoat extends LBVehicle implements Boat {

    EntityBoat entity;
    double maxSpeed = 0.4;

    public LBBoat(LBWorld w, EntityBoat e) {
        super(w, e);
        this.entity = e;
    }

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

    @Override
    public double getOccupiedDeceleration() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void setOccupiedDeceleration(double v) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public double getUnoccupiedDeceleration() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void setUnoccupiedDeceleration(double v) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean getWorkOnLand() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void setWorkOnLand(boolean b) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
