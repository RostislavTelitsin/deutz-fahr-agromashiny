package ru.deutzfahragromashiny.deutzfahragromashiny.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.deutzfahragromashiny.deutzfahragromashiny.models.ImgFile;

public interface ImgRepository extends JpaRepository<ImgFile, Integer> {
}
