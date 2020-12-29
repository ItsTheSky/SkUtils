package info.itsthesky.SkUtils.elements.bossbar;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.Type;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boss;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

@Name("Create Bossbar")
@Description("Create and return a new bossbar")
@Since("alpha-0.4")
@Examples("set {_boss} to new bossbar")
public class ExprBossbar extends SimpleExpression<BossBar> {

    @Override
    public Class<? extends BossBar> getReturnType() {
        return BossBar.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected BossBar[] get(Event event) {
        return new BossBar[] {Bukkit.createBossBar("Default Title", BarColor.WHITE, BarStyle.SOLID)};
    }
}