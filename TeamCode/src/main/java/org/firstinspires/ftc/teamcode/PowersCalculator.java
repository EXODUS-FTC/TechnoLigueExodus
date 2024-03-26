package org.firstinspires.ftc.teamcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PowersCalculator {
    public static Map<String, Double> normalizePowers(Map<String, Double> powers) {
        Map<String, Double> normalized_powers = new HashMap<>();
        double maximal_power = Collections.max(powers.values());
        if (maximal_power <= 1.0) return powers;
        for (Map.Entry<String, Double> power : powers.entrySet()) {
            normalized_powers.put(power.getKey(), power.getValue() / maximal_power);
        }
        return normalized_powers;
    }
    public static Map<String, Double> calculatePowers(HashMap<String, Float> movementValues) {
        Map<String, Double> powers = new HashMap<>();
        double vertical = movementValues.get("vertical");
        double horizontal = movementValues.get("horizontal");
        double rotation = movementValues.get("rotation");
        powers.put("r1", -vertical-horizontal-(rotation/2));
        powers.put("l1", vertical-horizontal-(rotation/2));
        powers.put("r2", -vertical+horizontal-(rotation/2));
        powers.put("l2", vertical+horizontal-(rotation/2));
        return powers;
    }
}
