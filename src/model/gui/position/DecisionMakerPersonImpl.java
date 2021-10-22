package model.gui.position;

import java.awt.Desktop.Action;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


public class DecisionMakerPersonImpl implements DecisionMakerPerson {
	//la persona va nell'attivit� pi� vicina
	/*public Map<Action, Double> getDecision(final BacteriaKnowledge knowledge) {
        final Map<Action, Double> result = new HashMap<>();
        final Map<Direction, Double> distances = new EnumMap<>(Direction.class);
        double tempVal = 0.0;
        for (final Direction d : Direction.values()) {
            final double dirVal = knowledge.getCurrentPerception().distFromActivity(d).orElse(0.0);
            distances.put(d, dirVal);
            tempVal += dirVal;
        }
        final double totVal = tempVal;
        distances.forEach((d,
                v) -> result.put(ActionFactory.createAction(ActionType.MOVE, d,
                        Math.min(knowledge.getCurrentPerception().distFromActivity(d)),
                        v != 0 ? ((totVal - v) / totVal) : 0)));
        return result;*/

}

