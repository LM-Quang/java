package models;

import exception.IdInvalidException;
import utils.Utils;

public abstract class User {
    private String id; // Citizenship Identification Number
    private String name;

    public User() {}

    public User(String id, String name) throws Exception{
        setId(id);
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (!Utils.isCitizenshipIDValid(id)) {
            throw new IdInvalidException("Invalid ID");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}