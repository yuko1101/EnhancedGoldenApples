package io.github.yuko1101.enhancedgoldenapples.mixin;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(ConsumableComponents.class)
public abstract class MixinConsumableComponents {
    @Shadow
    public static ConsumableComponent.Builder food() {
        throw new AssertionError();
    }

    @Final
    @Shadow
    public static final ConsumableComponent ENCHANTED_GOLDEN_APPLE = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(
                                    new StatusEffectInstance(StatusEffects.REGENERATION, 600, 3),
                                    new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 4)
                            )
                    )
            )
            .build();

    @Final
    @Shadow
    public static final ConsumableComponent GOLDEN_APPLE = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(
                                    new StatusEffectInstance(StatusEffects.REGENERATION, 100, 3),
                                    new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 1)
                            )
                    )
            )
            .build();
}
