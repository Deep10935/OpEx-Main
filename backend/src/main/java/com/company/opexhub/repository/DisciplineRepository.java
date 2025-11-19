// package com.company.opexhub.repository;

// import com.company.opexhub.entity.Discipline;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

// /**
//  * Repository interface for Discipline entity.
//  * Provides database access methods for discipline operations.
//  * 
//  * @author OpEx Development Team
//  */
// @Repository
// public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    
//     /**
//      * Find all active disciplines.
//      * 
//      * @return List of active disciplines
//      */
//     List<Discipline> findByIsActiveTrue();
    
//     /**
//      * Find discipline by code.
//      * 
//      * @param code Discipline code
//      * @return Optional containing the discipline if found
//      */
//     Optional<Discipline> findByCode(String code);
    
//     /**
//      * Check if a discipline exists by code.
//      * 
//      * @param code Discipline code
//      * @return true if exists, false otherwise
//      */
//     boolean existsByCode(String code);
// }