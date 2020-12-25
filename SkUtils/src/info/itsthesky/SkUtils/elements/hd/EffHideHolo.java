package info.itsthesky.SkUtils.elements.hd;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Hide Hologram")
@Description("Hide the Hologram t a specidic player")
@Since("alpha-0.3")
@RequiredPlugins("HolographicDisplays")
@Examples("hide holo {_holo} from player")
public class EffHideHolo extends Effect {

    private Expression<Player> player;
    private Expression<Hologram> holo;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.holo = (Expression<Hologram>) exprs[0];
        this.player = (Expression<Player>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        Player p = player.getSingle(event);
        Hologram h = holo.getSingle(event);
        if (h != null) {
            if (p != null) {
                h.getVisibilityManager().hideTo(p);
            }
        }
    }
}