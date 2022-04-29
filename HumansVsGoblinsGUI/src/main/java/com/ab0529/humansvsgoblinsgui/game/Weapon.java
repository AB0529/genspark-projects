package com.ab0529.humansvsgoblinsgui.game;

/**
 * Weapons are used to attack and will handle attacking
 */
public interface Weapon {

    /**
     * Gets the attack value of the item
     * @return the attack stat
     */
    int getAttack();

    /**
     * Attacks a target
     * @param attacker the attacker which is attacking
     * @param target the target to attack with the weapon
     * @return the target after the attack
     */
    default Entity attack(Entity attacker, Entity target) {
        int targetsHealth = target.getHealth();

        // Defence calculations
        if (target.getInventory().hasShield())
            targetsHealth =  target.getInventory().getShield().defend(target);

        target.setHealth(targetsHealth - attacker.getStrength());

        return target;
    }
}
