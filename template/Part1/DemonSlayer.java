public class DemonSlayer {
    public static final int SLAYER = 0;
    public static final int DEMON = 1;
    public int type;
    public String name;
    public int health;
    public int damage;
    public boolean isUpperMoon = false;

    public DemonSlayer(int type, String name, boolean isUpperMoon) {
        this.type = type;
        if (type == DemonSlayer.SLAYER) {
            this.name = name;
            this.health = 100;
            this.damage = 15;
        } else {
            if (isUpperMoon) {
                this.name = name;
                this.health = 150;
                this.damage = 20;
                this.isUpperMoon = true;
            } else {
                this.name = name;
                this.health = 100;
                this.damage = 10;
            }
        }
    }

    public int attack() {
        return this.damage;
    }

    public String wound(int damage) {
        String res = "";
        this.health -= damage;
        if (this.type == DemonSlayer.SLAYER) {
            res = this.name + " was wounded! Current health: " + this.health;        
        } else if (this.type == DemonSlayer.DEMON) {
            if (this.isUpperMoon) {
                res = "Demon " + this.name + ": upper moon " + " was wounded! Current health: " + this.health;
            } else {
                res ="Demon " + this.name + " was wounded! Current health: " + this.health;
            }
        }
        return res;
    }


    @Override
    public String toString() {
        if (this.type == DemonSlayer.SLAYER) {
            return this.name;
        } else if (this.type == DemonSlayer.DEMON) {
            if (this.isUpperMoon) {
                return "Demon " + this.name + ": upper moon ";
            } else {
                return "Demon " + this.name;
            }
        } else {
            return "unidentified species";
        }
    }

}
