package pro.sky.java.graduatework.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.java.graduatework.homework.controller.AdsEntity;
import pro.sky.java.graduatework.homework.model.Model;

import java.util.Collection;

public interface Repository extends JpaRepository<Model, Long> {

    static AdsEntity saveAndFlush(AdsEntity entity) {
        return entity;
    }

    Model findByUsername(String username);

    Collection<Model> findAllByUsername(String username);

    Collection<Model> findAllByUsernameContains(String part);

}
