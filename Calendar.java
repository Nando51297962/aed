import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Calendar {

    private ArrayList<EventoData> listaDatas;

    public Calendar() {
        listaDatas = new ArrayList<>();
    }

    public void addEvent (LocalDate date, String event) {
        if(this.hasEvents(date)) {
            int i = 0;
            while(!listaDatas.get(i).data().equals(date) && i < listaDatas.size()) {
                i++;
            }
            listaDatas.get(i).addEvent(event);
        } else {
            EventoData aux = new EventoData(date);
            aux.addEvent(event);
            listaDatas.add(aux);
        }
    }

    public boolean hasEvents(LocalDate date) {
        if(listaDatas.isEmpty()) {
            return false;
        }
        int j = 0;
        while(!listaDatas.get(j).data().equals(date) && j < listaDatas.size()) {
            j++;
        }
        return !listaDatas.get(j).eventos().isEmpty();
    }

    public List<String> getEvents(LocalDate date) {
        if(listaDatas.isEmpty()) {
            return new ArrayList<>();
        }
        int i = 0;
        while(!listaDatas.get(i).data().equals(date) && i < listaDatas.size()) {
            i++;
        }
        return (i >= listaDatas.size())? new ArrayList<>():listaDatas.get(i).eventos();
    }

    public void removeOneString(LocalDate date) {
        int i = 0;
        while(!listaDatas.get(i).data().equals(date) && i < listaDatas.size()) {
            i++;
        }
        if(i <= listaDatas.size()) {
            listaDatas.get(i).removeEvent();
        }
    }

    private class EventoData {

        private LocalDate data;
        private List<String> evento;

        private EventoData(LocalDate date) {
            this.data = date;
            this.evento = new ArrayList<>();
        }

        private void addEvent(String event) {
            this.evento.add(event);
        }

        private void removeEvent() {
            this.evento.remove(this.evento.size()-1);
        }

        private LocalDate data() {
            return this.data;
        }

        private List<String> eventos() {
            return this.evento;
        }
    }
}
