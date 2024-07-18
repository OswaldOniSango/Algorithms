package org.algorithm;

import java.util.HashMap;

public class Trust {
    public static void main(String[] args) {
        // Sample data: subgroups and their values
        HashMap<String, Integer> subgroups = new HashMap<>();
        subgroups.put("Subgroup1", 10);
        subgroups.put("Subgroup2", 20);
        subgroups.put("Subgroup3", 70);
        subgroups.put("Subgroup4", 100);

        findTrustWorthyGroups(subgroups);
    }

    private static void findTrustWorthyGroups(HashMap<String, Integer> subgroups) {
        // Find the maximum value
        int maxValue = 0;
        for (int value : subgroups.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        // Filter the trustworthy subgroups
        for (String subgroup : subgroups.keySet()) {
            int value = subgroups.get(subgroup);
            double weight = (double) value / maxValue;
            if (weight >= 0.7) { // Set a reliability threshold (e.g., 0.9)
                System.out.println(subgroup + " is trustworthy with a weight of " + weight);
            }
        }
    }
}
