package ar.com.lapsa.java.repositories.interfaces;
import ar.com.lapsa.java.entities.Bares;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public interface I_BaresRepository {
    void save(Bares bar);
    void remove(Bares bar);
    void update(Bares bar);
    List<Bares>getAll();
    boolean existe(String bar);
    Bares getBar2(String bar);
    default Bares getById(int id){
        return getAll()
                .stream()
                .filter(a->a.getId()==id)
                .findFirst()
                .orElse(new Bares());
    }
    default List<Bares> getBar(String bar){
        if(bar==null)return new ArrayList<Bares>();
        return getAll()
                .stream()
                .filter(a->a.getBar().toLowerCase().contains(bar.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void cerrar();
    

}