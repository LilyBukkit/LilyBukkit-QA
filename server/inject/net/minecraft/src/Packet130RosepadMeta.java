package net.minecraft.src;

import org.bukkit.Bukkit;
import ru.vladthemountain.lilybukkit.core.LilyBukkit;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Packet130RosepadMeta extends Packet {
    public List<ULPPExtension> extensions = new ArrayList<>();
    public String serverName = "§2" + Bukkit.getServer().getName();
    public String host = "";
    public int[] version = ((LilyBukkit) Bukkit.getServer()).getRosepadVersion();
    public String tag = ((LilyBukkit) Bukkit.getServer()).getRosepadVersionTag();
    public long flags = 0;

    @Override
    public void readPacketData(DataInputStream dataInputStream) throws IOException {
        serverName = dataInputStream.readUTF();
        tag = dataInputStream.readUTF();
        host = dataInputStream.readUTF();
        short verLen = dataInputStream.readShort();
        version = new int[verLen];
        for (short i = 0; i < verLen; i++)
            version[i] = dataInputStream.readShort();
        int count = dataInputStream.readInt();
        extensions.clear();
        for (int i = 0; i < count; i++) {
            ULPPExtension ext = new ULPPExtension(
                    dataInputStream.readUTF(),
                    dataInputStream.readInt()
            );
            extensions.add(ext);
        }
        flags = dataInputStream.readLong();
    }

    @Override
    public void writePacket(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(serverName);
        dataOutputStream.writeUTF(tag);
        dataOutputStream.writeUTF(host);
        dataOutputStream.writeShort(version.length);
        for (int i : version) {
            dataOutputStream.writeShort(i);
        }
        dataOutputStream.writeInt(extensions.size());
        for (ULPPExtension ext : extensions) {
            dataOutputStream.writeUTF(ext.getName());
            dataOutputStream.writeInt(ext.getVersion());
        }
        dataOutputStream.writeLong(flags);
    }

    public Packet130RosepadMeta Default() {
        this.extensions.clear();
        this.extensions.add(new ULPPExtension("ULPP", 1));
        this.extensions.add(new ULPPExtension("ROSE", 2));

        this.version = ((LilyBukkit) Bukkit.getServer()).getRosepadVersion();
        this.tag = ((LilyBukkit) Bukkit.getServer()).getRosepadVersionTag();

        this.serverName = "§2" + Bukkit.getServer().getName();
        this.flags = 0;

        return this;
    }

    @Override
    public void processPacket(NetHandler netHandler) {
        netHandler.handleRosepadMeta(this);
    }

    @Override
    public int getPacketSize() {
        int len = 18 + serverName.length() + tag.length() + version.length * 2;
        for (ULPPExtension ext : extensions) {
            len += 6 + ext.getName().length();
        }
        return len;
    }
}
