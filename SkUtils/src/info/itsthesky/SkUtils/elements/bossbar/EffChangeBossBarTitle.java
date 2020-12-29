package info.itsthesky.SkUtils.elements.bossbar;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Change BossBar Title")
@Description("Change and edit the title of a specific bossbar")
@Since("alpha-0.4")
@Examples("set title of bossbar {_boss} to \"&6&lWebsite: &e&lwww.example.com\"")
public class EffChangeBossBarTitle extends Effect {

    private Expression<String> title;
    private Expression<BossBar> boss;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.boss = (Expression<BossBar>) exprs[0];
        this.title = (Expression<String>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        BossBar b = boss.getSingle(event);
        String t = title.getSingle(event);
        if (t != null) {
            if (b != null) {
                b.setTitle(t);
            }
        }
    }
}