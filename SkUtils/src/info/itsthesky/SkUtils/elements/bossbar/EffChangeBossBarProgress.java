package info.itsthesky.SkUtils.elements.bossbar;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Change BossBar Progress")
@Description("Change and edit the progression of a specific bossbar. Progress is between 0.0 and 1.0")
@Since("alpha-0.4")
@Examples("set progress of bossbar {_boss} to 0.6")
public class EffChangeBossBarProgress extends Effect {

    private Expression<Number> progress;
    private Expression<BossBar> boss;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.boss = (Expression<BossBar>) exprs[0];
        this.progress = (Expression<Number>) exprs[1];
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
        Number p = progress.getSingle(event);
        if (p != null) {
            if (b != null) {
                if (p.intValue() >= 0 && p.intValue() <= 1) {
                    b.setProgress((Double) p);
                    return;
                }
                Bukkit.getConsoleSender().sendMessage("§c[SkUtils] The bossbar's progress must be between §40.0 §cand §41.0§c !");
            }
        }
    }
}