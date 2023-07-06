package model.historico;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import java.util.stream.Collectors;

public class Historico implements Serializable {
    List<ItemHistorico> itens;

    public Historico() {
        itens = new LinkedList<>(null);
    }   

    public void addItem(ItemHistorico item) {
        itens.add(item);
    }

    public List<ItemHistorico> getAllFromDate(LocalDate data) {
        List<ItemHistorico> filtereList;
        LocalDateTime inicial = LocalDateTime.of(data, null);

        filtereList = itens.stream()
         .filter(item -> item.getData().isAfter(inicial))
         .collect(Collectors.toList());

        return filtereList;
    }

    public List<ItemHistorico> getAllBetWeenDate(LocalDate dataInicial,
     LocalDate dataFinal) {
        List<ItemHistorico> filtereList;
        LocalDateTime data_inicial = LocalDateTime.of(dataInicial,
         null);
        LocalDateTime data_final = LocalDateTime.of(dataFinal
        .plusDays(1), null);

        filtereList = itens.stream()
         .filter(item -> item.getData().isAfter(data_inicial) &&
          item.getData().isAfter(data_final)).collect(Collectors.toList());

        return filtereList;
    }



}