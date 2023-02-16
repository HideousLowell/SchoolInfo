package ru.eshakin.schoolinfo.repository;

import ru.eshakin.schoolinfo.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends BaseModel, V> extends JpaRepository<T, V> {
}
