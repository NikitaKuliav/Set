package Transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation {
    Queue<Transport <?>> queue;
    public ServiceStation() {
        this.queue = new LinkedList<Transport<?>>() {
        };
    }
    public void addTransport(Transport<?> transport) {
        if (transport instanceof Bus) {
            System.out.println("Автобусы не нуждаются в техобслуживании!");
            return;
        }
        queue.add(transport);
        System.out.println("Транспорт успешно добавлен");
    }
    public void doMaintenance(){
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }
        Transport<?> transport = queue.poll();
        System.out.println("Транспорт " + transport.getModel() + " прошел техобслуживание и покинул очередь");
    }

}
