package io.github.yuko1101.enhancedgoldenapples.mixin;

import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.ClearAllEffectsConsumeEffect;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(DeathProtectionComponent.class)
public class MixinDeathProtectionComponent {
    @Final
    @Shadow
    public static final DeathProtectionComponent TOTEM_OF_UNDYING = new DeathProtectionComponent(
            List.of(
                    new ClearAllEffectsConsumeEffect(),
                    new ApplyEffectsConsumeEffect(
                            List.of(
                                    new StatusEffectInstance(StatusEffects.REGENERATION, 40, 5),
                                    new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 2),
                                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0)
                            )
                    )
            )
    );
}
