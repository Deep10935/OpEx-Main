// package com.company.opexhub.controller;

// import com.company.opexhub.entity.Discipline;
// import com.company.opexhub.service.DisciplineService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// /**
//  * REST Controller for Discipline management.
//  * Provides API endpoints for discipline-related operations.
//  * 
//  * @author OpEx Development Team
//  */
// @RestController
// @RequestMapping("/api/disciplines")
// @CrossOrigin(origins = "*")
// public class DisciplineController {

//     @Autowired
//     private DisciplineService disciplineService;

//     /**
//      * Get all active disciplines.
//      * 
//      * @return ResponseEntity with list of active disciplines
//      */
//     @GetMapping
//     public ResponseEntity<Map<String, Object>> getAllActiveDisciplines() {
//         try {
//             List<Discipline> disciplines = disciplineService.getAllActiveDisciplines();
//             Map<String, Object> response = new HashMap<>();
//             response.put("success", true);
//             response.put("data", disciplines);
//             response.put("message", "Disciplines retrieved successfully");
//             return ResponseEntity.ok(response);
//         } catch (Exception e) {
//             Map<String, Object> errorResponse = new HashMap<>();
//             errorResponse.put("success", false);
//             errorResponse.put("message", "Failed to retrieve disciplines: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//         }
//     }

//     /**
//      * Get all disciplines including inactive ones.
//      * 
//      * @return ResponseEntity with list of all disciplines
//      */
//     @GetMapping("/all")
//     public ResponseEntity<Map<String, Object>> getAllDisciplines() {
//         try {
//             List<Discipline> disciplines = disciplineService.getAllDisciplines();
//             Map<String, Object> response = new HashMap<>();
//             response.put("success", true);
//             response.put("data", disciplines);
//             response.put("message", "All disciplines retrieved successfully");
//             return ResponseEntity.ok(response);
//         } catch (Exception e) {
//             Map<String, Object> errorResponse = new HashMap<>();
//             errorResponse.put("success", false);
//             errorResponse.put("message", "Failed to retrieve disciplines: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//         }
//     }

//     /**
//      * Get discipline by ID.
//      * 
//      * @param id Discipline ID
//      * @return ResponseEntity with discipline data
//      */
//     @GetMapping("/{id}")
//     public ResponseEntity<Map<String, Object>> getDisciplineById(@PathVariable Long id) {
//         try {
//             return disciplineService.getDisciplineById(id)
//                     .map(discipline -> {
//                         Map<String, Object> response = new HashMap<>();
//                         response.put("success", true);
//                         response.put("data", discipline);
//                         response.put("message", "Discipline found");
//                         return ResponseEntity.ok(response);
//                     })
//                     .orElseGet(() -> {
//                         Map<String, Object> errorResponse = new HashMap<>();
//                         errorResponse.put("success", false);
//                         errorResponse.put("message", "Discipline not found with id: " + id);
//                         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//                     });
//         } catch (Exception e) {
//             Map<String, Object> errorResponse = new HashMap<>();
//             errorResponse.put("success", false);
//             errorResponse.put("message", "Failed to retrieve discipline: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//         }
//     }

//     /**
//      * Create a new discipline.
//      * 
//      * @param discipline Discipline to create
//      * @return ResponseEntity with created discipline
//      */
//     @PostMapping
//     public ResponseEntity<Map<String, Object>> createDiscipline(@RequestBody Discipline discipline) {
//         try {
//             Discipline createdDiscipline = disciplineService.createDiscipline(discipline);
//             Map<String, Object> response = new HashMap<>();
//             response.put("success", true);
//             response.put("data", createdDiscipline);
//             response.put("message", "Discipline created successfully");
//             return ResponseEntity.status(HttpStatus.CREATED).body(response);
//         } catch (Exception e) {
//             Map<String, Object> errorResponse = new HashMap<>();
//             errorResponse.put("success", false);
//             errorResponse.put("message", "Failed to create discipline: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//         }
//     }

//     /**
//      * Update an existing discipline.
//      * 
//      * @param id Discipline ID
//      * @param discipline Updated discipline data
//      * @return ResponseEntity with updated discipline
//      */
//     @PutMapping("/{id}")
//     public ResponseEntity<Map<String, Object>> updateDiscipline(@PathVariable Long id, @RequestBody Discipline discipline) {
//         try {
//             Discipline updatedDiscipline = disciplineService.updateDiscipline(id, discipline);
//             Map<String, Object> response = new HashMap<>();
//             response.put("success", true);
//             response.put("data", updatedDiscipline);
//             response.put("message", "Discipline updated successfully");
//             return ResponseEntity.ok(response);
//         } catch (RuntimeException e) {
//             Map<String, Object> errorResponse = new HashMap<>();
//             errorResponse.put("success", false);
//             errorResponse.put("message", e.getMessage());
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//         } catch (Exception e) {
//             Map<String, Object> errorResponse = new HashMap<>();
//             errorResponse.put("success", false);
//             errorResponse.put("message", "Failed to update discipline: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//         }
//     }

//     /**
//      * Deactivate a discipline (soft delete).
//      * 
//      * @param id Discipline ID
//      * @return ResponseEntity with success message
//      */
//     @PatchMapping("/{id}/deactivate")
//     public ResponseEntity<Map<String, Object>> deactivateDiscipline(@PathVariable Long id) {
//         try {
//             disciplineService.deactivateDiscipline(id);
//             Map<String, Object> response = new HashMap<>();
//             response.put("success", true);
//             response.put("message", "Discipline deactivated successfully");
//             return ResponseEntity.ok(response);
//         } catch (Exception e) {
//             Map<String, Object> errorResponse = new HashMap<>();
//             errorResponse.put("success", false);
//             errorResponse.put("message", "Failed to deactivate discipline: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//         }
//     }

//     /**
//      * Delete a discipline (hard delete).
//      * 
//      * @param id Discipline ID
//      * @return ResponseEntity with success message
//      */
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Map<String, Object>> deleteDiscipline(@PathVariable Long id) {
//         try {
//             disciplineService.deleteDiscipline(id);
//             Map<String, Object> response = new HashMap<>();
//             response.put("success", true);
//             response.put("message", "Discipline deleted successfully");
//             return ResponseEntity.ok(response);
//         } catch (Exception e) {
//             Map<String, Object> errorResponse = new HashMap<>();
//             errorResponse.put("success", false);
//             errorResponse.put("message", "Failed to delete discipline: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//         }
//     }
// }