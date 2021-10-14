package shedbolaget.model.events;

import com.google.common.eventbus.EventBus;

public class EventHandler {
    private static final EventBus eventBus = new EventBus();

    private EventHandler() {
    }

    public EventBus getInstance() {
        return eventBus;
    }

    public void registerToEventBus(Object o) {
        eventBus.register(o);
    }

    public void unregisterFromEventBus(Object o) {
        eventBus.unregister(o);
    }
}
