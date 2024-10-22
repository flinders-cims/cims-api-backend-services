package com.flinders.cims.repository;

import com.flinders.cims.model.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {
    List<ServiceRequest> findByUser_UserIdAndStatus(int userId, String status);
    List<ServiceRequest> findByUser_ManagerUserNameAndStatus(String managerUserName, String status);
}
