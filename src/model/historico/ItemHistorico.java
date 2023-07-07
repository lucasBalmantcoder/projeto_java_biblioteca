package model.historico;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ItemHistorico implements Serializable {

    private LocalDateTime data;
    private String historico;
 

    public ItemHistorico(LocalDateTime data, String historico) {
        this.data = data;
        this.historico = historico;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getHistorico() {
        return this.historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }



}