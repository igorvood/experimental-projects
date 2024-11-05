package ru.vood.dictionaries.db.model.de;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class DictColumnMetaEntityPK implements Serializable {
    @Column(name = "id", nullable = false, length = 256)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "dict_id", nullable = false, length = 256)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dictId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictColumnMetaEntityPK that = (DictColumnMetaEntityPK) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dictId != null ? !dictId.equals(that.dictId) : that.dictId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dictId != null ? dictId.hashCode() : 0);
        return result;
    }
}
