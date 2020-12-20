package info.itsthesky.SkUtils.elements.events;

import org.bukkit.event.Event;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityAirChangeEvent;
import ch.njol.skript.Skript;
import ch.njol.skript.entity.EntityData;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser.ParseResult;

import javax.annotation.Nullable;

public class EvtOnEnchant extends SkriptEvent {

    Literal<EntityData<?>> entities;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, ParseResult parseResult) {
        entities = (Literal<EntityData<?>>) args[0];
        return true;
    }

    @Override
    public boolean check(Event e) {
        //Explaining still
        return false;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "On enchant event  " + entities.toString(e, debug);
    }

}