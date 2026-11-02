# Mi Primer Mod

Mod de Minecraft **1.21.1** hecho con [Fabric](https://fabricmc.net/).

## Requisitos

- Java 21 (JDK)
- Git

## Comandos útiles

```bash
./gradlew build        # compila el mod; el .jar queda en build/libs/
./gradlew runClient    # abre Minecraft con el mod cargado
./gradlew runServer    # inicia un servidor de prueba con el mod
```

En Windows usa `gradlew.bat` en lugar de `./gradlew`.

## Estructura

- `src/main/java` – código común (cliente y servidor). Entrada: `com.miprimermod.MiPrimerMod`
- `src/client/java` – código solo del cliente. Entrada: `com.miprimermod.client.MiPrimerModClient`
- `src/main/resources/fabric.mod.json` – metadatos del mod
- `src/main/resources/assets/miprimermod` – texturas, modelos, idiomas, etc.

## Documentación

- [Documentación de Fabric](https://docs.fabricmc.net/develop/)

## Licencia

Basado en la plantilla oficial [fabric-example-mod](https://github.com/FabricMC/fabric-example-mod) (CC0).
