package com.to_do_list.dytechnology.repositories;

import com.to_do_list.dytechnology.model.TaskDone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface TaskDoneRepository extends JpaRepository<TaskDone, UUID> {
}
