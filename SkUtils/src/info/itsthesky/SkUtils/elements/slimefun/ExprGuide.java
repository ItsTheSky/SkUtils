package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.mojang.authlib.BaseUserAuthentication;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;


@Name("SlimeFun Guide Type")
@RequiredPlugins("Slimefun")
@Description("Return the formated value of SlimeFun guide's type. Available : BOOK, CHEST, and CHEAT_SHEET")
@Since("alpha-0.4")
@Examples("set {_type} to slimefun book \"BOOK\"")
public class ExprGuide extends SimpleExpression<SlimefunGuideLayout> {

    private Expression<String> type;

    @Override
    public Class<? extends SlimefunGuideLayout> getReturnType() {
        return SlimefunGuideLayout.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.type = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected SlimefunGuideLayout[] get(Event event) {
        SlimefunGuideLayout f = null;
        if (type.getSingle(event).equalsIgnoreCase("BOOK")) {
            f = SlimefunGuideLayout.BOOK;
        } else if (type.getSingle(event).equalsIgnoreCase("CHEST")) {
            f = SlimefunGuideLayout.CHEST;
        } else if (type.getSingle(event).equalsIgnoreCase("CHEAT_SHEET")) {
            f = SlimefunGuideLayout.CHEAT_SHEET;
        }
        if (f == null) {
            Bukkit.getConsoleSender().sendMessage("§c[SkUtils] Cannot found this SlimeFun Guide's type `§4" + type.getSingle(event) + "§c`. Valid are BOOK, CHEST, and CHEAT_SHEET !");
            return new SlimefunGuideLayout[0];
        }
        return new SlimefunGuideLayout[] {f};
    }
}