package io.github.yuko1101.enhancedgoldenapples.mixin;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FoodComponents.class)
public class MixinFoodComponents {

    @Final
    @Shadow
    public static final FoodComponent ENCHANTED_GOLDEN_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2F).alwaysEdible().build();

    @Final
    @Shadow
    public static final FoodComponent GOLDEN_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2F).alwaysEdible().build();

    @Final
    @Shadow
    public static final FoodComponent GOLDEN_CARROT = new FoodComponent.Builder().nutrition(2).saturationModifier(1.2F).alwaysEdible().build();
}