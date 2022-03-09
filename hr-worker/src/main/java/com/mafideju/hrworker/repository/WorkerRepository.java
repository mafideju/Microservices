package com.mafideju.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mafideju.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
