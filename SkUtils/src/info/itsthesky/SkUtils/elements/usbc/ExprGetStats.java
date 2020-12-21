package info.itsthesky.SkUtils.elements.usbc;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import io.github.Leonardo0013YT.UltraSkills.api.UltraSkillsAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("USBC Get Player Stats")
@RequiredPlugins("UltraSkyBlock-Core")
@Description("Return the specific current stats value of the player.\nAvailable stats : health, intelligence, shield, force, speed, critdamage, critchance")
@Since("alpha-0.2")
@Examples("usbc stats \"speed\" of player")
public class ExprGetStats extends SimpleExpression<Double> {

    private Expression<String> stats;
    private Expression<Player> player;

    @Override
    public Class<? extends Double> getReturnType() {
        return Double.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.stats = (Expression<String>) exprs[0];
        this.player = (Expression<Player>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Double[] get(Event event) {
        Player p = player.getSingle(event);
        String s = stats.getSingle(event);
        assert s != null;
        Double finalvalue = null;
        if (s.equalsIgnoreCase("health")) {
            finalvalue = (double) UltraSkillsAPI.getHealth(p);
        } else if (s.equalsIgnoreCase("speed")) {
            finalvalue = UltraSkillsAPI.getSpeed(p);
        } else if (s.equalsIgnoreCase("CritDamage")) {
            finalvalue = (double) UltraSkillsAPI.getCritDamage(p);
        } else if (s.equalsIgnoreCase("intelligence")) {
            finalvalue = (double) UltraSkillsAPI.getIntelligence(p);
        } else if (s.equalsIgnoreCase("shield")) {
            finalvalue = (double) UltraSkillsAPI.getShield(p);
        } else if (s.equalsIgnoreCase("force")) {
            finalvalue = (double) UltraSkillsAPI.getForce(p);
        }
        if (finalvalue == null) {
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§c Cannot found the USBC " + s + " stats !");
            return new Double[0];
        } else {
            return new Double[] {finalvalue};
        }
    }
}