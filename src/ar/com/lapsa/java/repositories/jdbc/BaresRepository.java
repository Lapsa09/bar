package ar.com.lapsa.java.repositories.jdbc;
import ar.com.lapsa.java.entities.Bares;
import ar.com.lapsa.java.gui.Bar;
import ar.com.lapsa.java.repositories.interfaces.I_BaresRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BaresRepository implements I_BaresRepository {
    private Connection conn;
    public BaresRepository(Connection conn){this.conn=conn;}

    @Override
    public void save(Bares bar) {
        if(bar==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "insert into Bar (bar) values (?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        )) {
            ps.setString(1, bar.getBar());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) bar.setId(rs.getInt(1));
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override public void remove(Bares bar) {
        if(bar==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from Bar where id=?")){
            ps.setInt(1, bar.getId());
            ps.execute();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void update(Bares bar) {
        if(bar==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "update Bar set bar=? where id=?"
        )) {
            ps.setInt(1, bar.getId());
            ps.execute();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public List<Bares> getAll() {
        List<Bares>list=new ArrayList();
        try {
            String sql="select * from Bar";
            PreparedStatement st=conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Bares bar=new Bares();
                int id=rs.getInt("id");
                String bar2=rs.getString("bar");
                bar.setId(id);
                bar.setBar(bar2);
                list.add(bar);
            }
        } catch (Exception e) { e.printStackTrace();  }
        return list;
    }

    @Override
    public boolean existe(String bar) {
        boolean respuesta=false;
        try {
            String sql="select * from Bar where bar=?";
            PreparedStatement st=conn.prepareStatement(sql);
            st.setString(1, bar);
            ResultSet rs=st.executeQuery();
            if(rs.next())
                respuesta=true;
        } catch (Exception e) {e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public Bares getBar2(String bar) {
        Bares b=new Bares();
        try {
            String sql="select * from Bar where bar=?";
            PreparedStatement st=conn.prepareStatement(sql);
            st.setString(1, bar);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                b.setId(rs.getInt("id"));
                b.setBar(rs.getString("bar"));
            }                
        } catch (Exception e) {e.printStackTrace();
        }
        return b;
    }
    public void cerrar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
