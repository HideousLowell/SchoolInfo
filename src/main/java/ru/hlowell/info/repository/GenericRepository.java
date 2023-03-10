package ru.hlowell.info.repository;

import ru.hlowell.info.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends BaseModel, V> extends JpaRepository<T, V> {
}
