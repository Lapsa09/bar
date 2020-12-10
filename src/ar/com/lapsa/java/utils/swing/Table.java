package ar.com.lapsa.java.utils.swing;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Table <E> {
    public void cargar(JTable tbl,List<E> list){
        if(tbl==null) return;
        DefaultTableModel dtm=new DefaultTableModel();
        tbl.setModel(dtm);
        if(list==null || list.isEmpty()) return;
        E e=list.get(0);
        Field[] campos=e.getClass().getDeclaredFields();
        for(Field c:campos)
            dtm.addColumn(c.getName().substring(0, 1).toUpperCase()+c.getName().substring(1));
        Object[] fila=new Object[campos.length];
        for(E x: list){            
            for(int a=0;a<campos.length;a++){
                String metodo="get"
                        +campos[a]
                                .getName()
                                .substring(0, 1)
                                .toUpperCase()
                        +campos[a]
                                .getName()
                                .substring(1);
                try {
                    fila[a]=e.getClass().getMethod(metodo, null).invoke(x, null);
                } catch (Exception ex) { ex.printStackTrace(); }
            }
            dtm.addRow(fila);
        }
    }
}