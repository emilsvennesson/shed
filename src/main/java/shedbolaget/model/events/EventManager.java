package shedbolaget.model.events;

import com.google.common.eventbus.EventBus;

public class EventManager {
    private static final EventManager instance = new EventManager();
    private static final EventBus eventBus = new EventBus();

    private EventManager() {
    }

    public static EventManager getInstance() {
        return instance;
    }

    public void registerToEventBus(Object o) {
        eventBus.register(o);
    }

    public void fireEvent(Object event) {
        eventBus.post(event);
    }

    public void unregisterFromEventBus(Object o) {
        eventBus.unregister(o);
    }
}
