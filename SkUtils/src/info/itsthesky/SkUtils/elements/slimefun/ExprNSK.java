package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import info.itsthesky.SkUtils.SkUtils;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import javax.xml.stream.events.Namespace;


@Name("New NamespacedKey")
@Description("Register and create new NamespacedKey with specific (unique) ID")
@Since("alpha-0.4")
@Examples("set {_nsk} to new nsk with id \"cool_category\"")
public class ExprNSK extends SimpleExpression<NamespacedKey> {

    private Expression<String> id;

    @Override
    public Class<? extends NamespacedKey> getReturnType() {
        return NamespacedKey.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.id = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected NamespacedKey[] get(Event event) {
        String i = id.getSingle(event);
        NamespacedKey f = new NamespacedKey(SkUtils.getInstance(), i);
        if (f == null) {
            return new NamespacedKey[0];
        }
        return new NamespacedKey[] {f};
    }
}