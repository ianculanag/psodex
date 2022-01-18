package com.dabi.jar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JarRepository extends JpaRepository<Jar, Integer> {
}
