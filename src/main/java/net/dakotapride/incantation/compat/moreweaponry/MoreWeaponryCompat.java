package net.dakotapride.incantation.compat.moreweaponry;


import net.dakotapride.incantation.common.IncantationMod;
import net.dakotapride.incantation.common.effect.EmptyStatusEffect;
import net.dakotapride.incantation.compat.moreweaponry.item.HarmingResistanceScrollItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreWeaponryCompat {
    public static final String MORE_WEAPONRY_ID = ("moreweaponry");

    // Items

    public static StatusEffect HARMING_RESISTANCE = new EmptyStatusEffect(StatusEffectCategory.BENEFICIAL, 0xCEFFF2);
    public static HarmingResistanceScrollItem HARMING_RESISTANCE_SCROLL;

    // Registration

    public static <T extends Item> T registerItem(String name, T item) {
        Registry.register(Registry.ITEM, new Identifier(MORE_WEAPONRY_ID, name), item);
        return item;
    }


    public static void moreWeaponryCompatRegistry() {

        Registry.register(Registry.STATUS_EFFECT, new Identifier(MORE_WEAPONRY_ID, "milky_resistance"), HARMING_RESISTANCE);
        HARMING_RESISTANCE_SCROLL = registerItem("harming_resistance_scroll",
                new HarmingResistanceScrollItem(new FabricItemSettings().maxCount(16).group(IncantationMod.INCANTATION_GROUP)));

    }

}
