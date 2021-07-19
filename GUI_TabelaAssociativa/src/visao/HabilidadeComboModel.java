package visao;

import dados.DadosAluno;
import dados.DadosHabilidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;


public class HabilidadeComboModel implements ComboBoxModel {

    
    
    private final List<String> habilidades = new ArrayList();
    
    public HabilidadeComboModel(String nomeAluno)  {
        ResultSet dadosHabilidades = DadosHabilidade.obtemHabilidadesQueAlunoNaoTem(nomeAluno);
        try {
            while( dadosHabilidades.next() ) {
                String desc = dadosHabilidades.getString("descricao");
                habilidades.add(desc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HabilidadeComboModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String selectedHabilidade;
    
    @Override
    public void setSelectedItem(Object o) {
        selectedHabilidade = (String)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedHabilidade;
    }

    @Override
    public int getSize() {
        return habilidades.size();
    }

    @Override
    public Object getElementAt(int i) {
        return habilidades.get(i);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
        
    }

    
}
