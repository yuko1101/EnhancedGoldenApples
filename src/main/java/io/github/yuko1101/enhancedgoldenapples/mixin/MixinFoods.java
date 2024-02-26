package io.github.yuko1101.enhancedgoldenapples.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Foods.class)
public class MixinFoods {

    @Final
    @Shadow
    public static final FoodProperties ENCHANTED_GOLDEN_APPLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 600, 3), 1.0F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 4), 1.0F).alwaysEat().build();

    @Final
    @Shadow
    public static final FoodProperties GOLDEN_APPLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 3), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1), 1.0F).alwaysEat().build();

    @Final
    @Shadow
    public static final FoodProperties GOLDEN_CARROT = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 2, 10), 1.0F).fast().alwaysEat().build();
}
