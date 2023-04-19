package net.anchikai.endium.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class EndiumArmorMaterials implements ArmorMaterial {

    public static final EndiumArmorMaterials ENDIUM = new EndiumArmorMaterials();

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final SoundEvent equipSound = SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    private final int durabilityMultiplier = 35;
    private final int[] protectionAmounts = {3, 6, 8, 3};
    private final int enchantability = 15;
    private final float toughness = 3.0f;
    private final float knockbackResistance = 0.0f;

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()] * this.durabilityMultiplier;
}

    @Override
    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts[type.getEquipmentSlot().getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EndiumItems.ENDIUM_INGOT);
    }

    public String getName() {
        return "endium";
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}