package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.UUID;

@Name("Open SlimeFun Guide")
@Description("Open the book to a player with the specific SlimeFun Guide's type")
@Since("alpha-0.4")
@RequiredPlugins("Slimefun")
@Examples("open sf book \"CHEST\" to player")
public class EffOpenSFBook extends Effect {

    private Expression<SlimefunGuideLayout> guide;
    private Expression<Player> player;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.guide = (Expression<SlimefunGuideLayout>) exprs[0];
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
        SlimefunGuideLayout g = guide.getSingle(event);
        if (p != null) {
            if (g != null) {
                SlimefunGuide.openGuide(p,g);
            }
        }
    }
}