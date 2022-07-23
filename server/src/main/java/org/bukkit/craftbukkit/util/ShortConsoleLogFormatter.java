package org.bukkit.craftbukkit.util;

import joptsimple.OptionException;
import joptsimple.OptionSet;
import net.minecraft.server.MinecraftServer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ShortConsoleLogFormatter extends Formatter {
    private final SimpleDateFormat date;

    public ShortConsoleLogFormatter(MinecraftServer server) {
        OptionSet options = server.options;
        SimpleDateFormat date = null;

        if (options.has("date-format")) {
            try {
                Object object = options.valueOf("date-format");

                if (object instanceof SimpleDateFormat) {
                    date = (SimpleDateFormat) object;
                }
            } catch (OptionException ex) {
                System.err.println("Given date format is not valid. Falling back to default.");
            }
        } else if (options.has("nojline")) {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        if (date == null) {
            date = new SimpleDateFormat("HH:mm:ss");
        }

        this.date = date;
    }

    /**
     * Format the given log record and return the formatted string.
     * <p>
     * The resulting formatted String will normally include a
     * localized and formatted version of the LogRecord's message field.
     * It is recommended to use the {@link Formatter#formatMessage}
     * convenience method to localize and format the message field.
     *
     * @param record the log record to be formatted.
     * @return the formatted log record
     */
    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        Throwable ex = record.getThrown();

        builder.append(date.format(record.getMillis()));
        builder.append(" [");
        builder.append(record.getLevel().getLocalizedName().toUpperCase());
        builder.append("] ");
        builder.append(record.getMessage());
        builder.append('\n');

        if (ex != null) {
            StringWriter writer = new StringWriter();
            ex.printStackTrace(new PrintWriter(writer));
            builder.append(writer);
        }

        return builder.toString();
    }
}
