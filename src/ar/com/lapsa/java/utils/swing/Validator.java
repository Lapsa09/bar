package ar.com.lapsa.java.utils.swing;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Validator {
    private JTextField txt;
    public Validator(JTextField txt) { this.txt = txt; }
        private boolean error(String mensaje){
        JOptionPane.showMessageDialog(txt, mensaje,"Error",
                JOptionPane.ERROR_MESSAGE);
        txt.selectAll();
        txt.requestFocus();
        return false;
    }
        public boolean length(int length){
        if(txt.getText().length()==length) return true;
        return error("Debe tener "+length+" caracteres.");
    }
        public boolean length(int min,int max){
        if(txt.getText().length()>=min && txt.getText().length()<=max)
            return true;
        return error("Debe tener entre "+min+" y "+max+" caracteres.");
    }
}
