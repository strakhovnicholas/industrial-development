package ru.strakhov.devs.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import ru.strakhov.devs.entity.User;

import java.util.function.Function;

public interface UserRepository extends JpaRepository<User, Long> {
}
