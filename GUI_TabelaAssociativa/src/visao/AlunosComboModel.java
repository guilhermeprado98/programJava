
package visao;

import dados.DadosAluno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class AlunosComboModel implements ComboBoxModel{

    
    
    private final List<String> alunos = new ArrayList();
    
    public AlunosComboModel()  {
        ResultSet dadosAlunos = DadosAluno.obtemTodosAlunos();
        try {
            while( dadosAlunos.next() ) {
                String nome = dadosAlunos.getString("nome");
                alunos.add(nome);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunosComboModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String selectedAluno;
    
    @Override
    public void setSelectedItem(Object o) {
        selectedAluno = (String)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedAluno;
    }

    @Override
    public int getSize() {
        return alunos.size();
    }

    @Override
    public Object getElementAt(int i) {
        return alunos.get(i);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
        
    }
}