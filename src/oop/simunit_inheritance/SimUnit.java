package oop.simunit_inheritance;

abstract class SimUnit {
    private final String botType;

    public SimUnit(String botType) {
        this.botType = botType;
    }

    public String getBotType() {
        return botType;
    }

    // Abstract method: Every subclass MUST define its own power consumption
    public abstract int getPowerUse();
}