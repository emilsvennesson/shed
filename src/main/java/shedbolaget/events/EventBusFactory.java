package shedbolaget.events;

import com.google.common.eventbus.EventBus;

public class EventBusFactory {
    private static volatile EventBusFactory instance = new EventBusFactory();
    private static final EventBus eventBus = new EventBus();

    private EventBusFactory() {
    }

    public EventBusFactory getInstance() {
        return instance;
    }

    public static EventBus getEventBus() {
        return eventBus;
    }
}
