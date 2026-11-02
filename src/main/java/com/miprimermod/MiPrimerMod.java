package com.miprimermod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiPrimerMod implements ModInitializer {
	public static final String MOD_ID = "miprimermod";

	// Logger para escribir en la consola y en el archivo de log.
	// Usar el mod id como nombre deja claro qué mod escribió cada mensaje.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Este código se ejecuta en cuanto Minecraft está listo para cargar mods.
		// Algunas cosas (como los recursos) aún pueden no estar inicializadas.

		LOGGER.info("¡Hola desde Mi Primer Mod!");
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
