# Referencia: Overgrown Vegetation 0.2.0-alpha

Análisis del mod [Overgrown Vegetation](https://www.curseforge.com/minecraft/mc-mods/overgrown-vegetation) para diseñar este proyecto como **addon** (complemento) suyo.

- **Versión analizada:** `overgrown_vegetation-0.2.0-alpha.jar` (publicada el 24/10/2026). Se comparó con la 0.1.9.
- **Fecha del análisis:** 02/11/2026
- **Método:** se extrajo el `.jar` y se descompiló con Vineflower, sin ejecutarlo. El repositorio público del autor ([yayuy-01/overgrown-vegetation](https://github.com/yayuy-01/overgrown-vegetation)) es solo el esqueleto de una reescritura ("etapa 0") y **no** contiene el código de la 0.2.0.

> ⚠️ Es una versión alfa y el autor está reescribiendo el mod. Revisa este documento cada vez que salga una versión nueva.

## Datos básicos

| Campo | Valor |
|---|---|
| Mod id | `overgrown_vegetation` |
| Autor | yayuy |
| Loader | NeoForge `[21.1.0,)` |
| Minecraft | `[1.21.1, 1.22)` |
| Dependencias obligatorias | **GeckoLib** `[4.7,)` y **Player Animation Library** `[1.1,)` |
| Licencia | **MIT (código)** / **All Rights Reserved (assets)** |
| Paquete Java | `com.yayuy.overgrownvegetation` |

**Licencia:** su código se puede estudiar y reutilizar (MIT, conservando el aviso). Sus texturas, modelos y sonidos **no se pueden copiar**: este addon debe tener sus propios assets.

**Nota:** el `neoforge.mods.toml` de la 0.2.0-alpha sigue diciendo `version = "0.1.9"`. Si declaramos una versión mínima como dependencia, hay que tenerlo en cuenta.

## Contenido

### Corrupción del mundo (núcleo del mod)
- Unas **100 variantes "overgrown"** de bloques vanilla: piedra, tierra, arena, menas, ladrillos, bloques del Nether y del End, etc. Siguen el patrón `overgrown_<bloque_vanilla>`.
- Unos **34 biomas**, en tres familias de intensidad: `overgrown_*`, `overgrowth_*` y `engulfed_*`, además de `burnt_wasteland`. Cubren el Overworld, océanos, ríos, pantanos y pantanos fúngicos, el Nether (crimson, warped, basalt, soul sand) y el End.
- Efectos de la corrupción: arcos y puentes, raíces, crecimiento en cuevas, inundación de pantanos, caída de árboles, corrupción de portales y spawners, y solidificación de lava.

### Criaturas (unas 75)
- **Fauna del Carbonífero:** Meganeura, Arthropleura, Megarachne, Hylonomus, Petrolacosaurus, Rhizodus, Xenacanthus y otras. En la 0.2.0 se añadieron Eryops, Diplocaulus, Lungfish, Hibbertopterus, Pulmonoscorpius, Crassigyrinus, Giant Snail y Stenodictya Nymph.
- **Plantas y organismos parásitos:** Blight Fern, Blight Waterweed, Hive Node, Phyllosens, Sporophyll, Velophyll, Arbora, Pedicula y la familia *-mnes* (Falcimnes, Scutimnes, Acumnes…).
- **Mobs vanilla parasitados (unos 22):** vaca, oveja, cerdo, zombi, aldeano, creeper, araña, enderman, warden, ghast, blaze, golem de hierro, piglins, etc.
- **Infectados nuevos en 0.2.0:** Vinearm Zombie, Hollow Villager, Sporesac Cow, Podded Creeper, Vine Executioner, Root Striker, Walking Sporangium y Burst Pod.
- **Jefe:** Dorga-Archelaus Titanica.
- **Facción humana aliada:** Rifleman, Artilleryman, Combat Engineer y Elite Operator, más el Raid Beacon.

### Sistemas
- **Fases:** la infección avanza por etapas en el mundo. Los mobs se agrupan en 10 grupos, que aparecen según la fase y la profundidad del crecimiento.
- **Esporas:** concentración de esporas por zona, efecto *Spore Infection*, contaminación del equipo, filtros, máscara, tienda y capa.
- **Purificación:** lanzallamas, frasco incendiario y tierra quemada, que ya no se corrompe.
- **Defensa:** estacas que bloquean la corrupción, abatis, cuerdas con badajo, torretas y cañón.
- **Progresión:** minerales (Chlorophyllite, Phloemite, Thylakite, Sap Crystal y, desde 0.2.0, zinc y latón), herramientas, armaduras (incluida la servoarmadura), armas (Zweihander, Estoc, HK416, lanzallamas), accesorios y *Adaptation Records*.
- **Novedades de 0.2.0:**
  - Hierbas y cultivos (Moonlight Herb, Pungent Herb, Bitter Root, Warmbloom) con polvos, aceites, elixires y píldoras.
  - Tirachinas, planeador, mochila y vendas.
  - Sistema **Ley**: cristales, brújula, horno, lámpara, bomba y waystones.
  - Libro guía.
- **Pestañas creativas:** *Covered Blocks*, *Plants* y *Humanity*.

### Cambios entre 0.1.9 y 0.2.0
- **Eliminados:** `hive_vine` y `blight_water_grass` (entidades), y `organ_node`, `organ_vine` y `spore_gland` (bloques).
- **Añadidos:** unos 130 IDs nuevos. Son la lista de la sección anterior.

## Cómo funciona la corrupción

La clase clave es `corruption.CorruptionRegistry`.

1. **Mapa fijo (`EXACT`):** reglas programadas directamente, del tipo "piedra → piedra overgrown". Es privado, así que **desde fuera no se pueden añadir entradas**.
2. **Reglas por tag (`TAG_RULES`):** si un bloque no está en el mapa fijo, se mira qué tags vanilla tiene:

   | Tag vanilla | Se convierte en |
   |---|---|
   | `minecraft:logs` | `overgrown_log` |
   | `minecraft:leaves` | `overgrown_leaves` |
   | `minecraft:planks` y `wooden_slabs` | `overgrown_planks` |
   | `minecraft:wooden_stairs` | `overgrown_stairs` |
   | `minecraft:stairs` | `overgrown_stone_stairs` |
   | `minecraft:walls` | `overgrown_wall` |
   | `minecraft:fences` | `overgrown_fence` |
   | `minecraft:dirt` y `terracotta` | `overgrown_dirt` |
   | `minecraft:sand` | `overgrown_sand` |
   | `minecraft:base_stone_overworld` y `stone_bricks` | `overgrown_stone` |
   | `minecraft:flowers`, `crops` y `coral_plants` | `overgrown_growth` |
   | `minecraft:saplings` | `overgrown_sapling` |

   → **Si un bloque de este addon tiene esos tags, se corromperá automáticamente.**

3. **`canCorrupt(...)` devuelve `false`, es decir, el bloque no se corrompe, si:**
   - la corrupción está apagada (`CorruptionSwitch`);
   - el bloque es aire o agua que no es bloque completo;
   - tiene el tag `overgrown_vegetation:corrupted` o `overgrown_vegetation:corruption_immune`;
   - está en tierra quemada (`BurntLand`) o protegido por estacas (`StakeWards`);
   - son hojas naturales no persistentes;
   - es irrompible (dureza < 0);
   - es un block entity y la opción `corruptBlockEntities` está desactivada (salvo contenedores, spawners y bloques encapsulables);
   - está protegido por un dispositivo anti-esporas (`SporeDeviceData`).

4. **Configuración:** la clase `OvergrownVegetationConfig` tiene más de 3000 líneas de opciones. Las más relevantes son `corruptionSpeedMultiplier`, las de arcos y puentes (`corruptionArch*`, `corruptionBridge*`), las de esporas (`sporeConcentration*`, `sporeInfectionCheckIntervalTicks`), `convertLavaToBasalt` y `corruptBlockEntities`.

## Puntos de enganche para el addon

El mod **no tiene una API pública ni eventos propios**. Lo más estable son los **tags** y los **IDs de registro**: se definen en archivos JSON y no dependen de clases internas.

### Tags del mod (`data/overgrown_vegetation/tags/`)

**Bloques**
- `corruption_immune`: bloques que nunca se corrompen.
- `corrupted`: bloques ya corrompidos.
- `husk_immune`, `ley_vein_replaceable`, `climax_ore_replaceable` y `climax_deepslate_ore_replaceable`.
- `conceals_entities`, `spore_puff_plants`, `growth_hanging_only`, `not_cave_roof` y `bomb_shatters`.
- `climbable_trunk`, `dragonfly_perch`, `phalangiotarbus_perch` y `stenodictya_food`.
- `road_blocks`, `clapper_rope_posts` y `not_swing_through`.

**Ítems**
- `overgrowth_bane` (daño extra contra la plaga), `overgrowth_ward` y `overgrowth_resistant`.
- `spore_contaminable` y `spore_contamination_immune`.
- `herbs` y `minor_herbs`.
- `two_handed` y `swings_through_foliage`.
- `adaptation_records`, con las subcategorías `defense`, `durability` y `toughness`.
- `extra_armor/head`, `body`, `waist` y `feet`.
- `overgrown_logs` y `covered_*_logs`.

**Entidades**
- `group_1` a `group_10`: grupos de spawn por fase.
- `overgrowth`, `allies` y `phase_infectable_animals`.
- `nether_native`, `ranged_attacker`, `peaceful_allowed`, `refuge_exempt` y `water_rot_immune`.

**Tipos de daño**
- `armor_piercing` y `siege_boss_attack`.
- `factor/impact`, `pierce`, `blast`, `toxin` y `spore`.

**Tags comunes `c:`:** el mod registra zinc y latón como `c:ingots/zinc`, `c:ingots/brass`, `c:ores/zinc`, etc. Es útil para recetas compatibles con otros mods.

### Ganchos por código (más frágiles)
- `CorruptionRegistry.canCorrupt(level, pos, state)` y `CorruptionRegistry.corrupt(level, pos, state, random)`.
- `PhaseData.get(serverLevel)`: estado de la fase del mundo.
- `ModBlocks` y `ModItems`: registros. Es preferible referenciarlos por ID (`overgrown_vegetation:<nombre>`) y no por la clase.

Usar estas clases obliga a compilar contra el `.jar` del mod, y probablemente se rompa en la próxima versión.

## Ideas de complemento

- **Purificación:** un bloque o máquina que revierta los bloques `overgrown_*` a su forma vanilla. El mod quema, pero no "cura".
- **Fauna o flora nueva** del Carbonífero, añadida a los tags `group_N`.
- **Investigación:** detectores o medidores de la infección, usando el tag `corrupted`.
- **Equipo** con los tags `overgrowth_bane`, `overgrowth_ward` y `spore_contamination_immune`.
- **Recetas** que usen sus materiales: `overgrown_vegetation:spore`, `chlorophyllite`, `sap_crystal`, `plant_fiber`, etc.
