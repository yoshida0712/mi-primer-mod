# Ideas para el addon de Overgrown Vegetation

Lista de ideas para el complemento. **Ninguna está aprobada ni programada todavía.**

## Antes de programar
- El autor (yayuy) recomendó **esperar a la 0.2.0 beta**, porque está reestructurando los sistemas principales del mod.
- **Cada idea se le propone primero**, para que no choque con sus planes.
- Los detalles técnicos del mod están en [referencia-overgrown-vegetation.md](referencia-overgrown-vegetation.md).

**Estados posibles:** 💭 Idea · 📨 Propuesta al autor · ✅ Aprobada · 🛠️ En desarrollo · ❌ Descartada

---

## 1. Métodos de cura para mobs infectados
**Estado:** 💭 Idea · **Anotada:** 03/11/2026

**El hueco en el mod:** en la 0.2.0-alpha **no existe ninguna forma de curar a un mob**.
- Las medicinas solo funcionan en el jugador.
- La leche no quita el efecto *Spore Infection*: el mod lo bloquea a propósito.
- Cuando un mob muere infectado, deja un **cadáver corrompido** que emite esporas, corrompe el terreno a su alrededor y luego **eclosiona** con cierta probabilidad, soltando la versión parasitada del mob.
- Los mobs parasitados (*Parasitized Cow*, *Parasitized Villager*, etc.) son entidades distintas y no tienen vuelta atrás.
- La única defensa hoy es romper el cadáver antes de que eclosione.

**Posibles enfoques, de más simple a más complejo:**
1. **Vacuna o antídoto para mobs:** se usa sobre un animal infectado vivo y le quita el efecto antes de que muera.
2. **Tratamiento de cadáveres:** un ítem que neutraliza el cadáver para que no eclosione ni siga corrompiendo.
3. **Curar a un mob parasitado:** un proceso al estilo del aldeano zombi de vanilla (debilidad + manzana dorada), que lo convierte de nuevo en la versión normal.

**Puntos de enganche en el mod:**
- el efecto `overgrown_vegetation:spore_infection`;
- los bloques de cadáver (`overgrown_<mob>_corpse`);
- las entidades `parasitized_*`.

**Preguntas para el autor:**
- ¿La infección de mobs es incurable a propósito, como parte de la dificultad?
- ¿Tiene planeado algo parecido?

---

## 2. Vehículos
**Estado:** 💭 Idea · **Anotada:** 03/11/2026

**El hueco en el mod:** la 0.2.0-alpha **no tiene vehículos ni monturas**.
- La movilidad se limita al planeador (*Glider*), el *Ley Updraft* y la teletransportación con *Ley Waystone*.
- El *Siege Cannon* tiene un asiento, pero no se mueve.
- Las bases aliadas ya tienen **cobertizos de vehículos (*Vehicle Shed*) y estacionamientos (*Parking*) vacíos**. Puede ser una pista de que el autor piensa agregarlos.

**Posibles enfoques:**
- **Vehículo terrestre militar**, que encaje con la facción aliada y proteja de las esporas.
- **Alimentado por baterías Ley**, para integrarse con su sistema de energía.
- **Criaturas del Carbonífero montables**, como Arthropleura (milpiés gigante) o Meganeura (libélula gigante).

**Dificultad:** alta. Requiere modelos, físicas, controles y sincronización entre el cliente y el servidor. Conviene dejarlo para cuando haya más experiencia con modding.

**Preguntas para el autor:**
- ¿Piensa agregar vehículos? Los estacionamientos vacíos lo sugieren.
- ¿Le parecería bien que el addon los aporte, o prefiere hacerlos por su cuenta?
