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
import org.bukkit.boss.BossBar;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Change BossBar Color")
@Description("Change and edit the color of a specific bossbar. Available colors are RED, BLUE, WHITE, PURPLE, PINK, GREEN and YELLOW")
@Since("alpha-0.4")
@Examples("set color of bossbar {_boss} to \"RED\"")
public class EffChangeBossBarColor extends Effect {

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
                if (t.equalsIgnoreCase("RED") || t.equalsIgnoreCase("YELLOW") || t.equalsIgnoreCase("GREEN") || t.equalsIgnoreCase("WHITE") || t.equalsIgnoreCase("PURPLE") || t.equalsIgnoreCase("PINK")) {
                    b.setColor(BarColor.valueOf(t));
                    return;
                }
                Bukkit.getConsoleSender().sendMessage("§c[SkUtils] The bossbar color `§4" + t + "§c` is not a valid color. Check docs for all valid color !");
                return;
            }
        }
    }
}