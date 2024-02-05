package com.spring.wecare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.wecare.entities.Complaint;
import com.spring.wecare.entities.Jurisdiction;
import com.spring.wecare.entities.Officer;
import com.spring.wecare.entities.Status;
import com.spring.wecare.entities.User;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Integer> {

	List<Complaint> findByJuryComplaint(Jurisdiction jurisdiction);

	List<Complaint> getComplaintByOfficer(Officer officer);

	List<Complaint> getComplaintByUser(User user);
	
	@Query("SELECT COUNT(c) FROM Complaint c WHERE c.status = :status")
    Long countByStatus(@Param("status") Status status);
}

