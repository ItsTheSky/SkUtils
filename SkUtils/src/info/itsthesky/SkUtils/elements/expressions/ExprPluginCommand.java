package info.itsthesky.SkUtils.elements.expressions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Plugin of Command")
@Description("Return the plugin which is assigned the command")
@Since("alpha-0.1")
@Examples("plugin of command \"gm\"")
public class ExprPluginCommand extends SimpleExpression<String> {


    private Expression<String> command;

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.command = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected String[] get(Event event) {
        final String cmd = command.getSingle(event);
        if (cmd != null) {
            final PluginCommand tempCmd = Bukkit.getServer().getPluginCommand(cmd);
            if (tempCmd == null)
                return new String[0];
            return new String[] {tempCmd.getPlugin().getName()};
        }
        return null;
    }
}