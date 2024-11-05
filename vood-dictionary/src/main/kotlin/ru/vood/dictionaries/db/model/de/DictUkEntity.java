package ru.vood.dictionaries.db.model.de;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "dict_uk", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@jakarta.persistence.IdClass(ru.vood.dictionaries.db.model.de.DictUkEntityPK.class)
public class DictUkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "id", nullable = false, length = 256)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "dict_id", nullable = false, length = 256)
    private String dictId;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "col_id", nullable = false, length = 256)
    private String colId;

    public String getColId() {
        return colId;
    }

    public void setColId(String colId) {
        this.colId = colId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictUkEntity that = (DictUkEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dictId != null ? !dictId.equals(that.dictId) : that.dictId != null) return false;
        if (colId != null ? !colId.equals(that.colId) : that.colId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dictId != null ? dictId.hashCode() : 0);
        result = 31 * result + (colId != null ? colId.hashCode() : 0);
        return result;
    }
}
