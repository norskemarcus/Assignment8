package com.example.externalapi.repository;


import com.example.externalapi.entity.NameInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NameRepository extends JpaRepository<NameInfo, String> {

}
