package io.github.yuko1101.enhancedgoldenapples.mixin;

import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static net.minecraft.item.Items.register;

@Mixin(Items.class)
public class MixinItems {
    @Shadow
    private static RegistryKey<Item> keyOf(String id) {
        throw new AssertionError();
    }

    @Inject(method = "register(Ljava/lang/String;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;", at = @At("HEAD"), cancellable = true)
    private static void registerGoldenCarrot(String id, Item.Settings settings, CallbackInfoReturnable<Item> cir) {
        if (id.equals("golden_carrot")) {
            cir.setReturnValue(register(keyOf(id), Item::new, new Item.Settings().food(
                    FoodComponents.GOLDEN_CARROT,
                    ConsumableComponents.food()
                            .consumeSeconds(0.8F)
                            .consumeEffect(
                                    new ApplyEffectsConsumeEffect(
                                            List.of(
                                                    new StatusEffectInstance(StatusEffects.REGENERATION, 2, 10),
                                                    new StatusEffectInstance(StatusEffects.SPEED, 100, 0)
                                            )
                                    )
                            )
                            .build()

            )));
        }
    }
}
