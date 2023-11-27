package com.marketclub.clients.repositories;

import com.marketclub.clients.entities.AccountLevel;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface AccountLevelRepository extends CrudRepository<AccountLevel, Integer> {

    // Find Account level per level (BRONZE, SILVER or GOLD)
    Optional<AccountLevel> findLevelByLevel(String level);
}
