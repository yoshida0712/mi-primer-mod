# Mi Primer Mod

Mod de Minecraft **1.21.1** hecho con [NeoForge](https://neoforged.net/).

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

- `src/main/java/com/miprimermod/MiPrimerMod.java` – clase principal (cliente y servidor)
- `src/main/java/com/miprimermod/MiPrimerModClient.java` – código solo del cliente
- `src/main/templates/META-INF/neoforge.mods.toml` – metadatos del mod (los valores vienen de `gradle.properties`)
- `src/main/resources/assets/miprimermod` – texturas, modelos, idiomas, etc.

## Documentación

- [Documentación de NeoForge](https://docs.neoforged.net/)

## Licencia

Basado en el [MDK oficial de NeoForge 1.21.1](https://github.com/NeoForgeMDKs/MDK-1.21.1-ModDevGradle).
