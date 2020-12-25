/* package info.itsthesky.SkUtils.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import com.wasteofplastic.askyblock.events.ChallengeCompleteEvent;
import org.bukkit.entity.Player;

public class SimpleEvents {
    static {

        // -- Challenge Complete Event --
        Skript.registerEvent("Mongo Client Close",
                SimpleEvent.class,
                ChallengeCompleteEvent.class,
                "[askyblock] challenge complete")
                .description("Called when a player complete an aSkyBlock challenge")
                .examples("on challenge complete")
                .since("alpha-0.3");
        EventValues.registerEventValue(ChallengeCompleteEvent.class, Player.class, new Getter<Player, ChallengeCompleteEvent>() {
            @Override
            public Player get(ChallengeCompleteEvent e) {
                return e.getPlayer();
            }
        }, 0);
        EventValues.registerEventValue(ChallengeCompleteEvent.class, String.class, new Getter<String, ChallengeCompleteEvent>() {
            @Override
            public String get(ChallengeCompleteEvent e) {
                return e.getChallengeName();
            }
        }, 0);
        EventValues.registerEventValue(ChallengeCompleteEvent.class, Integer.class, new Getter<Integer, ChallengeCompleteEvent>() {
            @Override
            public Integer get(ChallengeCompleteEvent e) {
                return e.getExpReward();
            }
        }, 0);
        EventValues.registerEventValue(ChallengeCompleteEvent.class, String.class, new Getter<String, ChallengeCompleteEvent>() {
            @Override
            public String get(ChallengeCompleteEvent e) {
                return e.getRewardText();
            }
        }, 0);
    }
} */