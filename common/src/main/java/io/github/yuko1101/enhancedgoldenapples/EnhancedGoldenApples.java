package io.github.yuko1101.enhancedgoldenapples;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public final class EnhancedGoldenApples {
    public static final String MOD_ID = "enhancedgoldenapples";

    public static void init() {
    }


    private static final Identifier HEALTH_BOOST_ID = Identifier.of("enhancedgoldenapples", "health_boost");
    private static final EntityAttributeModifier HEALTH_BOOST = new EntityAttributeModifier(HEALTH_BOOST_ID, 20.0, EntityAttributeModifier.Operation.ADD_VALUE);

    public static void applyCustomStatus(ServerPlayerEntity player, boolean isRespawn) {
        player.setGlowing(true);
        var maxHealth = player.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (maxHealth != null) {
            maxHealth.addPersistentModifier(HEALTH_BOOST);
        }
        if (isRespawn) player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 60 * 20, 0, true, false));
    }
}
