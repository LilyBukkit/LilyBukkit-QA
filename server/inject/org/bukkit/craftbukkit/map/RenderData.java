package org.bukkit.craftbukkit.map;

import java.util.ArrayList;

@Deprecated
public class RenderData {

    public final byte[] buffer;
    public final ArrayList<Object /*MapCursor*/> cursors;

    public RenderData(){
        this.buffer = new byte[128*128];
        this.cursors = new ArrayList<>();
    }
}
