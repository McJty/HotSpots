package mcjty.hotspots.api;

/**
 * Define how a certain hotspot type 'attenuates' in the world
 */
public enum HotSpotAttenuation {
    RADIATE,            // Radiate from a central point
    RADIATE_BLOCKER,    // Radiate from a central point and allow blockers
    CHUNK,              // Propogate to nearby chunks
}
