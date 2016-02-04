package mcjty.hotspots.api;

/**
 * The type of hotspot.
 */
public interface IHotSpotType {

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
}
