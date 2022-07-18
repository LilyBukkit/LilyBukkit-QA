package ru.vladthemountain.lilybukkit.util;

import com.jcabi.github.Coordinates.Simple;
import com.jcabi.github.Release;
import com.jcabi.github.RtGithub;
import net.minecraft.src.PropertyManager;

import java.io.File;
import java.io.IOException;

public class UpdateChecker {
    public static void checkForUpdates() {
        RtGithub github = new RtGithub();
        int maxNumber = 0;

        for (Release release : github.repos().get(new Simple("Vladg24YT", "LilyBukkit")).releases().iterate()) {
            maxNumber = Math.max(release.number(), maxNumber);
        }
        File versionFile = new File(".version");
        if (!versionFile.exists()) {
            try {
                versionFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        PropertyManager versionProps = new PropertyManager(versionFile);
        if (versionProps.getIntProperty("lilybukkit-version", 3) < maxNumber) {
            System.out.print("### An update for LilyBukkit is available! ###");
        }
    }
}
