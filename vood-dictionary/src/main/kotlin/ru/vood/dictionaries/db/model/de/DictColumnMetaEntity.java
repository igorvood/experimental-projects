package ru.vood.dictionaries.db.model.de;

import jakarta.persistence.*;

@Entity
@jakarta.persistence.Table(name = "dict_column_meta", schema = "db_configuration_manager", catalog = "db_configuration_manager")
@IdClass(ru.vood.dictionaries.db.model.de.DictColumnMetaEntityPK.class)
public class DictColumnMetaEntity {
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

    @Basic
    @Column(name = "type_col_id", nullable = false, length = 256)
    private String typeColId;

    public String getTypeColId() {
        return typeColId;
    }

    public void setTypeColId(String typeColId) {
        this.typeColId = typeColId;
    }

    @Basic
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 512)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictColumnMetaEntity that = (DictColumnMetaEntity) o;

        if (isDeleted != that.isDeleted) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dictId != null ? !dictId.equals(that.dictId) : that.dictId != null) return false;
        if (typeColId != null ? !typeColId.equals(that.typeColId) : that.typeColId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dictId != null ? dictId.hashCode() : 0);
        result = 31 * result + (typeColId != null ? typeColId.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
