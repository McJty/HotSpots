package mcjty.hotspots.api;

/**
 * The central API of Hot Spots
 */
public interface IHotSpotManager {

    /**
     * Create a builder for hot spot types for the radiating attenuation type. Use the
     * builder to set various attributes for this hotspot type and then you
     * can register your new type
     * @return
     */
    IRadiatingHotSpotTypeBuilder createRadiatingHotSpotTypeBuilder();

    /**
     * Create a builder for hot spot types for the chunk attenuation type. Use the
     * builder to set various attributes for this hotspot type and then you
     * can register your new type
     * @return
     */
    IChunkHotSpotTypeBuilder createChunkHotSpotTypeBuilder();

    /**
     * Register a new hot spot type.
     * @param id it is recommended to use a name formed like this <modid>:<name> to avoid clashes with other mods
     * @param attenuation
     * @param lifecycle
     * @return the created hotspot type
     */
    IHotSpotType registerHotSpotType(String id, IHotSpotTypeBuilder builder);

    /**
     * Get a type. Returns null if a type of this id doesn't exist
     * @param id
     * @return
     */
    IHotSpotType getHotSpotType(String id);
}
