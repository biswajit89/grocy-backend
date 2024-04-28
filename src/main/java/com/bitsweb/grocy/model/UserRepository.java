/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bitsweb.grocy.model;

import com.bitsweb.grocy.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

/**
 *
 * @author Biswajit
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByName(String name);
}
