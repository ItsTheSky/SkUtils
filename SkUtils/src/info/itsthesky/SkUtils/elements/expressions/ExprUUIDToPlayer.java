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
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.UUID;

@Name("UUID to Player")
@Description("Return an offline player from a specific UUID")
@Since("alpha-0.1")
@Examples("player from uuid \"731fe3a9-249a-466e-a8f9-3b1b6166b761\" ")
public class ExprUUIDToPlayer extends SimpleExpression<OfflinePlayer> {


    private Expression<String> uuid;

    @Override
    public Class<? extends OfflinePlayer> getReturnType() {
        return OfflinePlayer.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.uuid = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected OfflinePlayer[] get(Event event) {
        final String uid = uuid.getSingle(event);
        if (uid == null) {
            return new OfflinePlayer[0];
        }
        return new OfflinePlayer[] {Bukkit.getOfflinePlayer(UUID.fromString(uid))};
    }
}