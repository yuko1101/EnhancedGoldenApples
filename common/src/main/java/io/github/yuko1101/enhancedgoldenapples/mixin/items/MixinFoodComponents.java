package io.github.yuko1101.enhancedgoldenapples.mixin.items;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FoodComponents.class)
public class MixinFoodComponents {

    @Final
    @Shadow
    public static final FoodComponent ENCHANTED_GOLDEN_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2F).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 3), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 4), 1.0F)
            .build();

    @Final
    @Shadow
    public static final FoodComponent GOLDEN_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2F).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 3), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 1), 1.0F)
            .build();

    @Final
    @Shadow
    public static final FoodComponent GOLDEN_CARROT = new FoodComponent.Builder().nutrition(2).saturationModifier(1.2F).alwaysEdible().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2, 10), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 0), 1.0F)
            .build();
}