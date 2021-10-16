package shedbolaget.model.events;

import com.google.common.eventbus.EventBus;

/**
 * Event manager that utilizes the Google Guava EventBus.
 *
 * @author Emil Svensson
 */
public class EventManager {
    private static final EventManager instance = new EventManager();
    private static final EventBus eventBus = new EventBus();

    private EventManager() {
    }

    /**
     * Gets the EventManager instance.
     *
     * @return the instance
     */
    public static EventManager getInstance() {
        return instance;
    }

    /**
     * Register object to event bus.
     *
     * @param object the object to register to the event bus
     */
    public void registerToEventBus(Object object) {
        eventBus.register(object);
    }

    /**
     * Fire event to subscribers.
     *
     * @param event the event to fire
     */
    public void fireEvent(Object event) {
        eventBus.post(event);
    }

    /**
     * Unregister object from event bus.
     *
     * @param object the object to unregister
     */
    public void unregisterFromEventBus(Object object) {
        eventBus.unregister(object);
    }
}
