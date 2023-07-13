package repository;

import java.io.Serializable;

import pattern.idGeneratorStrategy;

public class SequencialContaIdGeneratorStrategy implements idGeneratorStrategy, Serializable{

    private int prox_num;

    public SequencialContaIdGeneratorStrategy() {
        this.prox_num = 1;

    }

    public String nextId() { //adiciana o proximo idex para o prox_num + 1
        return String.valueOf(prox_num++);
    }
    
}
