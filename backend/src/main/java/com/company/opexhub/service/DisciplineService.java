package com.company.opexhub.service;

import com.company.opexhub.entity.Discipline;
import com.company.opexhub.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Discipline operations.
 * Handles business logic for discipline-related operations.
 * 
 * @author OpEx Development Team
 */
@Service
@Transactional
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    /**
     * Get all active disciplines.
     * 
     * @return List of active disciplines
     */
    public List<Discipline> getAllActiveDisciplines() {
        return disciplineRepository.findByIsActiveTrue();
    }

    /**
     * Get all disciplines (including inactive).
     * 
     * @return List of all disciplines
     */
    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    /**
     * Get discipline by ID.
     * 
     * @param id Discipline ID
     * @return Optional containing the discipline if found
     */
    public Optional<Discipline> getDisciplineById(Long id) {
        return disciplineRepository.findById(id);
    }

    /**
     * Get discipline by code.
     * 
     * @param code Discipline code
     * @return Optional containing the discipline if found
     */
    public Optional<Discipline> getDisciplineByCode(String code) {
        return disciplineRepository.findByCode(code);
    }

    /**
     * Create a new discipline.
     * 
     * @param discipline Discipline to create
     * @return Created discipline
     */
    public Discipline createDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    /**
     * Update an existing discipline.
     * 
     * @param id Discipline ID
     * @param updatedDiscipline Updated discipline data
     * @return Updated discipline
     * @throws RuntimeException if discipline not found
     */
    public Discipline updateDiscipline(Long id, Discipline updatedDiscipline) {
        return disciplineRepository.findById(id)
                .map(discipline -> {
                    discipline.setCode(updatedDiscipline.getCode());
                    discipline.setName(updatedDiscipline.getName());
                    discipline.setDetails(updatedDiscipline.getDetails());
                    discipline.setIsActive(updatedDiscipline.getIsActive());
                    return disciplineRepository.save(discipline);
                })
                .orElseThrow(() -> new RuntimeException("Discipline not found with id: " + id));
    }

    /**
     * Soft delete a discipline by setting isActive to false.
     * 
     * @param id Discipline ID
     */
    public void deactivateDiscipline(Long id) {
        disciplineRepository.findById(id)
                .ifPresent(discipline -> {
                    discipline.setIsActive(false);
                    disciplineRepository.save(discipline);
                });
    }

    /**
     * Hard delete a discipline.
     * 
     * @param id Discipline ID
     */
    public void deleteDiscipline(Long id) {
        disciplineRepository.deleteById(id);
    }
}