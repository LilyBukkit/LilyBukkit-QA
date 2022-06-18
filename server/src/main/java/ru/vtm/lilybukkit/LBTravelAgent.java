package ru.vtm.lilybukkit;

import org.bukkit.Location;
import org.bukkit.TravelAgent;

public class LBTravelAgent implements TravelAgent {
    /**
     * Set the Block radius to search in for available portals.
     *
     * @param radius The radius in which to search for a portal from the location.
     * @return
     */
    @Override
    public TravelAgent setSearchRadius(int radius) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the search radius value for finding an available portal.
     *
     * @return Returns the currently set search radius.
     */
    @Override
    public int getSearchRadius() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the maximum radius from the given location to create a portal.
     *
     * @param radius The radius in which to create a portal from the location.
     * @return
     */
    @Override
    public TravelAgent setCreationRadius(int radius) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the maximum radius from the given location to create a portal.
     *
     * @return Returns the currently set creation radius.
     */
    @Override
    public int getCreationRadius() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns whether the TravelAgent will attempt to create a destination portal or not.
     *
     * @return Return whether the TravelAgent should create a destination portal or not.
     */
    @Override
    public boolean getCanCreatePortal() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets whether the TravelAgent should attempt to create a destination portal or not.
     *
     * @param create Sets whether the TravelAgent should create a destination portal or not.
     */
    @Override
    public void setCanCreatePortal(boolean create) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Attempt to find a portal near the given location, if a portal is not found it will attempt to create one.
     *
     * @param location The location where the search for a portal should begin.
     * @return Returns the location of a portal which has been found or returns the location passed to the method if unsuccessful.
     */
    @Override
    public Location findOrCreate(Location location) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Attempt to find a portal near the given location.
     *
     * @param location
     * @return Returns the location of the nearest portal to the location.
     */
    @Override
    public Location findPortal(Location location) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Attempt to create a portal near the given location.
     *
     * @param location
     * @return True if a nether portal was successfully created.
     */
    @Override
    public boolean createPortal(Location location) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
