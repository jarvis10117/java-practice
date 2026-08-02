package oop.simunit_inheritance;

class Radiator extends SimUnit {
    public Radiator(String type) {
        super(type);
    }

    public Radiator() {
        super("V2Radiator");
    }

    @Override
    public int getPowerUse() {
        return 4;
    }
}