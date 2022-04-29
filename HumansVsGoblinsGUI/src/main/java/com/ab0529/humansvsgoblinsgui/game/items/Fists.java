package com.ab0529.humansvsgoblinsgui.game.items;

import com.ab0529.humansvsgoblinsgui.game.Item;
import com.ab0529.humansvsgoblinsgui.game.Weapon;

public class Fists extends Item implements Weapon {
    int attack;

    public Fists() {
        super(2, "Fists");
        super.setType(this);

        attack = 1;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
