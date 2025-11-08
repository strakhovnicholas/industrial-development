package ru.strakhov.devs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.strakhov.devs.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
