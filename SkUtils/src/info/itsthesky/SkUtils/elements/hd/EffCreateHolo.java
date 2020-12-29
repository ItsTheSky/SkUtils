/*
package info.itsthesky.SkUtils.elements.hd;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import info.itsthesky.SkUtils.SkUtils;
import io.netty.channel.nio.AbstractNioByteChannel;
import org.bukkit.Location;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Create Hologram")
@Description("Create a new hologram with a specific ID")
@Since("alpha-0.4")
@RequiredPlugins("HolographicDisplays")
@Examples("create new hologram named \"test\"\" at player's location")
public class EffCreateHolo extends Effect {

    private Expression<String> id;
    private Expression<Location> location;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.id = (Expression<String>) exprs[0];
        this.location = (Expression<Location>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        String i = id.getSingle(event);
        Location loc = location.getSingle(event);
        if (i != null) {
            if (loc != null) {
                Hologram holo = HologramsAPI.createHologram(SkUtils.getInstance(), loc);
                new HDManager().ids.put(i, holo);
            }
        }
    }
}*/