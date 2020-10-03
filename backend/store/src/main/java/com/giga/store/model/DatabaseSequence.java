package com.giga.store.model;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * DB sequence model to store _ids in the DB
 */
@Entity(name = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private String seq;

    public DatabaseSequence() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
