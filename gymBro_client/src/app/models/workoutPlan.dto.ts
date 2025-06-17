
import { BaseDTO } from "./baseDto";

export interface WorkoutPlanDTO extends BaseDTO {
  name: string;
  userId: number;
  startDate: string; 
  endDate: string;   
  isActive: boolean;
  isBuiltFromUser: boolean;
}