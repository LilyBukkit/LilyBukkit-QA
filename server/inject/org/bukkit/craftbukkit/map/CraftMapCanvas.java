package org.bukkit.craftbukkit.map;

@Deprecated
public class CraftMapCanvas /*implements MapCanvas*/{
    protected CraftMapCanvas(CraftMapView mapView){
        throw new UnsupportedOperationException("One of the plugins managed to call protected deprecated Map API");
    }
}
