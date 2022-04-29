package com.ab0529.humansvsgoblinsgui.game;

/**
 * Shield are used to defend and will handle defence calculations
 */
public interface Shield {


    /**
     * Gets defence stat of the item
     * @return the defence stat
     */
    double getDefence();

    /**
     * Defends from a target using equipped item
     * @param e the defence target
     * @return the targets' health + defence%
     */
    default int defend(Entity e) {
        return (int) (e.getHealth() * this.getDefence());
    }
}
