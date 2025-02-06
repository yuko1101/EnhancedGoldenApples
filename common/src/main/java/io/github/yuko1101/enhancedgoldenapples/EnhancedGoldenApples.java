package io.github.yuko1101.enhancedgoldenapples;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.util.Identifier;

public final class EnhancedGoldenApples {
    public static final String MOD_ID = "enhancedgoldenapples";

    public static void init() {
    }


    public static final Identifier HEALTH_BOOST_ID = Identifier.of("enhancedgoldenapples", "health_boost");
    public static final EntityAttributeModifier HEALTH_BOOST = new EntityAttributeModifier(HEALTH_BOOST_ID, 20.0, EntityAttributeModifier.Operation.ADD_VALUE);
}
