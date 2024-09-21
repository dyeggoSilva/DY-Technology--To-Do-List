package com.to_do_list.dytechnology.repositories;

import com.to_do_list.dytechnology.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
