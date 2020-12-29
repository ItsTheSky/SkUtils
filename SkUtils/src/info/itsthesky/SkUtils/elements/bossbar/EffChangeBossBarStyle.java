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
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Change BossBar Style")
@Description("Change and edit the style of a specific bossbar. Available styles are SOLID, SEGMENTED_6, SEGMENTED_10, SEGMENTED_12 and SEGMENTED_20")
@Since("alpha-0.4")
@Examples("set style of bossbar {_boss} to \"SOLID\"")
public class EffChangeBossBarStyle extends Effect {

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
                if (t.equalsIgnoreCase("SOLID") || t.equalsIgnoreCase("SEGMENTED_6") || t.equalsIgnoreCase("SEGMENTED_10") || t.equalsIgnoreCase("SEGMENTED_12") || t.equalsIgnoreCase("SEGMENTED_20")) {
                    b.setStyle(BarStyle.valueOf(t));
                    return;
                }
                Bukkit.getConsoleSender().sendMessage("§c[SkUtils] The bossbar style `§4" + t + "§c` is not a valid style. Check docs for all valid style !");
                return;
            }
        }
    }
}