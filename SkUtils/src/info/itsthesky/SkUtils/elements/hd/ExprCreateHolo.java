package info.itsthesky.SkUtils.elements.hd;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import info.itsthesky.SkUtils.SkUtils;
import io.github.Leonardo0013YT.UltraSkills.api.UltraSkillsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Create Hologram")
@Description("Create a HolographicDisplays hologram at specific location and with optional text, and return the hologram created")
@Since("alpha-0.3")
@RequiredPlugins("HolographicDisplays")
@Examples("set {_holo} to new hd holo at player's location with text \"&7-&8[ &6Hello World &8]&7\"")
public class ExprCreateHolo extends SimpleExpression<Hologram> {

    private Expression<Location> location;
    private Expression<String> text;

    @Override
    public Class<? extends Hologram> getReturnType() {
        return Hologram.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.location = (Expression<Location>) exprs[0];
        this.text = (Expression<String>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Hologram[] get(Event event) {
        Location l = location.getSingle(event);
        String s = (String) text.getSingle(event);
        if (l != null) {
            Hologram holo = HologramsAPI.createHologram(SkUtils.getInstance(), l);
            if (text != null) {
                holo.appendTextLine(String.valueOf(text).replace("\"", ""));
            }
            return new Hologram[] {holo};
        }
        return new Hologram[0];
    }
}