public enum Path {
    // enum with all config file paths
    WARRIOR("Warriors.txt"),
    SORCERER("Sorcerers.txt"),
    PALADIN("Paladins.txt"),
    DRAGON("Dragons.txt"),
    EXOSKELETON("Exoskeletons.txt"),
    SPIRIT("Spirits.txt"),
    WEAPON("Weaponry.txt"),
    ARMOR("Armory.txt"),
    FIRESPELL("FireSpells.txt"),
    ICESPELL("IceSpells.txt"),
    LIGHTNINGSPELL("LightningSpells.txt"),
    POTION("Potions.txt");

    private static final String root = "\\src\\ConfigFiles\\";
    private final String path;
    Path(String s) {
        this.path = System.getProperty("user.dir") + root + s;
    }

    public String toString() {
        return this.path;
    }
}
