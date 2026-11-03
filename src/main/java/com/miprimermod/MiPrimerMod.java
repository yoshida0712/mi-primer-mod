package com.miprimermod;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

// El valor debe coincidir con el modId de META-INF/neoforge.mods.toml
@Mod(MiPrimerMod.MOD_ID)
public class MiPrimerMod {
    public static final String MOD_ID = "miprimermod";

    // Logger para escribir en la consola y en el archivo de log.
    public static final Logger LOGGER = LogUtils.getLogger();

    // El constructor es lo primero que se ejecuta al cargar el mod.
    // NeoForge pasa automáticamente el bus de eventos del mod y su contenedor.
    public MiPrimerMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("¡Hola desde Mi Primer Mod!");
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
