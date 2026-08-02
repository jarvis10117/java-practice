package oop.simunit_inheritance;

class RetentionBot extends SimUnit {
    public RetentionBot() {
        super("Retention");
    }

    @Override
    public int getPowerUse() {
        return 2;
    }
}