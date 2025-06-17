import { BaseDTO } from './baseDto';
import { WorkoutDayExerciseDTO } from './workoutDayExercise.dto';

export interface WorkoutDayDTO extends BaseDTO {
  name: string;
  sequence: number;
  workoutPlanId: number;
  exercises: WorkoutDayExerciseDTO[];
}
