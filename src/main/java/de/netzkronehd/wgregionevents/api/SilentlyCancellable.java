package de.netzkronehd.wgregionevents.api;

/**
 * Allows events to be silently cancelled without affecting the primary event.
 */
public interface SilentlyCancellable {
    /**
     * @return true if silently cancelled without affecting the primary event.
     */
    boolean isSilentlyCancelled();

    /**
     * @param b true if the event should be silently cancelled without affecting the primary event.
     */
    void setSilentlyCancelled(final boolean b);
}
