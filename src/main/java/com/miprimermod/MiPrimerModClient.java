package com.miprimermod;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

// Esta clase solo se carga en el cliente; aquí es seguro usar código de cliente (renderizado, pantallas, etc.).
@Mod(value = MiPrimerMod.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = MiPrimerMod.MOD_ID, value = Dist.CLIENT)
public class MiPrimerModClient {
    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        MiPrimerMod.LOGGER.info("Configuración de cliente de Mi Primer Mod lista");
    }
}
