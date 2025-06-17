import { BaseDTO } from './baseDto';
import { ExerciseDTO } from './exercise.dto';

export interface WorkoutDayExerciseDTO extends BaseDTO {
  sets: number;
  reps: number;
  notes: string;
  workoutDayId: number;
  exercise: ExerciseDTO;
  sequence: number;
}
