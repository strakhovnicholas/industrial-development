package ru.strakhov.devs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.strakhov.devs.entity.Deal;

public interface DealRepository extends JpaRepository<Deal, Long> {
}
