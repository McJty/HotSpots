package mcjty.hotspots.api;

/**
 * The central API of Hot Spots
 */
public interface IHotSpotManager {

    /**
     * The type of hot spot.
     * @param id it is recommended to use a name formed like this <modid>:<name> to avoid clashes with other mods
     * @param attenuation
     * @param lifecycle
     * @return
     */
    IHotSpotType registerHotSpotType(String id, HotSpotAttenuation attenuation, HotSpotLifecycle lifecycle);

    /**
     * Get a type. Returns null if a type of this id doesn't exist
     * @param id
     * @return
     */
    IHotSpotType getHotSpotType(String id);

    /**
     * Create a new hotspot of a given type.
     * @return
     */
    IHotSpot createHotSpot(IHotSpotType type);
}
