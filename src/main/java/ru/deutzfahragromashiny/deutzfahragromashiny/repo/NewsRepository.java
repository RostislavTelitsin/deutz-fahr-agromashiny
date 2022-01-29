package ru.deutzfahragromashiny.deutzfahragromashiny.repo;

import org.springframework.data.repository.CrudRepository;
import ru.deutzfahragromashiny.deutzfahragromashiny.models.News;

public interface NewsRepository extends CrudRepository<News, Integer> {
}
