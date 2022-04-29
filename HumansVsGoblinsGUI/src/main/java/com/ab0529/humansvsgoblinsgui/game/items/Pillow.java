package com.ab0529.humansvsgoblinsgui.game.items;

import com.ab0529.humansvsgoblinsgui.game.Item;
import com.ab0529.humansvsgoblinsgui.game.Shield;

public class Pillow extends Item implements Shield {
    public double defence;

    public Pillow() {
        super(1, "Dirty Pillow");
        super.setType(this);
        defence = 1.10;
    }

    @Override
    public double getDefence() {
        return defence;
    }
}
