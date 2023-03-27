package pro.sky.java.graduatework.homework.controller;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.Lob;
import java.util.Objects;

// entity c картинкой
@Entity
public class AdsEntity {
    @Id
    private String id;
    // как описать хранение картинки в Entity
    @Lob
    private byte[] image;
    public AdsEntity() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdsEntity adsEntity = (AdsEntity) o;
        return id != null && Objects.equals(id, adsEntity.id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    public String getId() {
        return this.id;
    }
    public byte[] getImage() {
        return this.image;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }    public String toString() {
        return "AdsEntity(id=" + this.getId() + ", image=" + java.util.Arrays.toString(this.getImage()) + ")";
    }
}



