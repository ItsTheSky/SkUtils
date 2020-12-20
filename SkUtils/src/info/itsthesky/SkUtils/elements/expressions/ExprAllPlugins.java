package info.itsthesky.SkUtils.elements.expressions;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;

@Name("All Installed Plugins")
@Description("Returns all installed and enabled plugins on the server")
@Since("alpha-0.1")
@Examples("all installed plugins")
public class ExprAllPlugins extends SimpleExpression<Plugin> {


    private Expression<World> world;

    @Override
    public Class<? extends Plugin> getReturnType() {
        return Plugin.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return false;
    }

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
    protected Plugin[] get(Event event) {
        return Bukkit.getPluginManager().getPlugins();
    }
}