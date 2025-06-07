package com.macina.room.entities.workoutDay;

import com.macina.room.DTO.UpdateWorkoutDaySequenceDTO;
import com.macina.room.crud.GenericServiceImpl;
import com.macina.room.entities.WorkoutPlan.WorkoutPlan;
import com.macina.room.entities.WorkoutPlan.WorkoutPlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WorkoutDayService extends GenericServiceImpl<WorkoutDayDTO,WorkoutDay> {

    @Autowired
    private WorkoutDayRepository workoutDayRepository;

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    public WorkoutDayService(WorkoutDayRepository repository, WorkoutDayMapper mapper) {
        super(repository, mapper);
    }

    /** allow to create multiple workoutDay after selecting a workoutPlan, sequence generated automatically in ascending order
     *
     * @param seq number of workoutDays to create, does not have any control on it
     * @param workoutPlanId workout plan to associate those workoutDays
     * @return
     */
    @Transactional
    public List<WorkoutDayDTO> createInBatch(short seq, Long workoutPlanId){
        WorkoutPlan workoutPlan =workoutPlanRepository.findById(workoutPlanId)
                .orElseThrow(() -> new RuntimeException("workoutplan not found with id: " + workoutPlanId));
        List<WorkoutDay> workoutDays = new ArrayList<>();

        short c = 1;
        while(c<=seq){
            WorkoutDay wd = new WorkoutDay(
                    c,workoutPlan
            );
            c++;
            workoutDays.add(wd);
        }
        workoutDayRepository.saveAll(workoutDays);
        return workoutDays.stream().map(mapper::toDto).toList();
    }

    /**
     *  update the order of workoutDays in batch
     * @return
     */
    @Transactional
    public List<WorkoutDayDTO> updateSequence(List<UpdateWorkoutDaySequenceDTO> obj){
        List<WorkoutDay> updated = new ArrayList<>();
        try{
            for(UpdateWorkoutDaySequenceDTO o : obj){
                WorkoutDay existingWDay = workoutDayRepository.findById(o.getWorkoutDayID()).orElseThrow(() -> new RuntimeException("workoutday not found with id: " + o.getWorkoutDayID()));
                existingWDay.setSequence(o.getSequence());
                updated.add(existingWDay);
            }
            workoutDayRepository.saveAll(updated);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return updated.stream().map(mapper::toDto).toList();
    }

}
