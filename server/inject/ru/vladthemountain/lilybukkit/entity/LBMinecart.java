package ru.vladthemountain.lilybukkit.entity;

import net.minecraft.src.EntityMinecart;
import org.bukkit.entity.Minecart;
import org.bukkit.util.Vector;
import ru.vladthemountain.lilybukkit.LBWorld;

/**
 * @author VladTheMountain
 */
public class LBMinecart extends LBVehicle implements Minecart {

    EntityMinecart entity;
    double maxSpeed = 0.4;
    boolean isSlow;

    public LBMinecart(LBWorld w, EntityMinecart e) {
        super(w, e);
        this.entity = e;
        this.isSlow = false;
    }

    /**
     * Sets a minecart's damage.
     *
     * @param damage over 40 to "kill" a minecart
     */
    @Override
    public void setDamage(int damage) {
        this.entity.damageTaken = damage;
    }

    /**
     * Gets a minecart's damage.
     */
    @Override
    public int getDamage() {
        return this.entity.damageTaken;
    }

    /**
     * Gets the maximum speed of a minecart. The speed is unrelated to the velocity.
     */
    @Override
    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    /**
     * Sets the maximum speed of a minecart. Must be nonnegative. Default is 0.4D.
     *
     * @param speed
     */
    @Override
    public void setMaxSpeed(double speed) {
        this.maxSpeed = speed;
    }

    /**
     * Returns whether this minecart will slow down faster without a passenger occupying it
     */
    @Override
    public boolean isSlowWhenEmpty() {
        return this.isSlow;
    }

    /**
     * Sets whether this minecart will slow down faster without a passenger occupying it
     *
     * @param slow
     */
    @Override
    public void setSlowWhenEmpty(boolean slow) {
        this.isSlow = slow;
    }

    /**
     * Gets the flying velocity modifier. Used for minecarts that are in mid-air.
     * A flying minecart's velocity is multiplied by this factor each tick.
     */
    @Override
    public Vector getFlyingVelocityMod() {
        return new Vector(this.entity.motionX, this.entity.motionY, this.entity.motionZ);
    }

    /**
     * Sets the flying velocity modifier. Used for minecarts that are in mid-air.
     * A flying minecart's velocity is multiplied by this factor each tick.
     *
     * @param flying velocity modifier
     */
    @Override
    public void setFlyingVelocityMod(Vector flying) {
        this.entity.addVelocity(flying.getX(), flying.getY(), flying.getZ());
    }

    /**
     * Gets the derailed velocity modifier. Used for minecarts that are on the ground, but not on rails.
     * <p>
     * A derailed minecart's velocity is multiplied by this factor each tick.
     */
    @Override
    public Vector getDerailedVelocityMod() {
        return this.getFlyingVelocityMod();
    }

    /**
     * Sets the derailed velocity modifier. Used for minecarts that are on the ground, but not on rails.
     * A derailed minecart's velocity is multiplied by this factor each tick.
     *
     * @param derailed speed
     */
    @Override
    public void setDerailedVelocityMod(Vector derailed) {
        this.setFlyingVelocityMod(derailed);
    }
}
