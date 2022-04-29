package com.ab0529.humansvsgoblinsgui.game.items;

import com.ab0529.humansvsgoblinsgui.game.Item;
import com.ab0529.humansvsgoblinsgui.game.Weapon;

public class Stick extends Item implements Weapon {
    int attack;

    public Stick() {
        super(0, "Sharp Stick");
        super.setType(this);

        attack = 2;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
