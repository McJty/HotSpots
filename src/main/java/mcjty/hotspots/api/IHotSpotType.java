package mcjty.hotspots.api;

/**
 * The type of hotspot.
 */
public interface IHotSpotType {

    /**
     * Get the ID of this type (usually <modid>:<name>)
     * @return
     */
    String getID();

    /**
     * Return how hotspots of this type attenuate
     * @return
     */
    HotSpotAttenuation getAttenuation();

    /**
     * Return the lifecycle of hotspots of this type.
     * @return
     */
    HotSpotLifecycle getLifeCycle();

    /**
     * Remove all hotspots of this type.
     */
    void clear();
}
