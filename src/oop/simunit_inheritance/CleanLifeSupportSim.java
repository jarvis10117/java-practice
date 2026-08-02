package oop.simunit_inheritance;

import java.util.ArrayList;
import java.util.List;


public class CleanLifeSupportSim {

    // Helper factory method using polymorphism
    private static void addUnits(List<SimUnit> list, SimUnit unitTemplate, int count) {
        for (int i = 0; i < count; i++) {
            list.add(unitTemplate);
        }
    }

    public static void main(String[] args) {
        List<SimUnit> simulationList = new ArrayList<>();

        // Explicit, clear initialization meeting all exact mission specifications:
        // 1. v3:v2 Radiator ratio = 2:1 (10 v3, 5 v2)
        addUnits(simulationList, new Radiator(), 5);
        addUnits(simulationList, new V3Radiator(), 10);

        // 2. Retention:Radiator ratio = 4:3 (20 Retention vs 15 total Radiators)
        addUnits(simulationList, new RetentionBot(), 20);

        // Calculate total power polymorphically
        int totalPower = 0;
        for (SimUnit unit : simulationList) {
            totalPower += unit.getPowerUse(); // Polymorphic method call!
        }

        System.out.println("Total Units Created: " + simulationList.size());
        System.out.println("Total Power Consumption: " + totalPower + " units");
    }
}
