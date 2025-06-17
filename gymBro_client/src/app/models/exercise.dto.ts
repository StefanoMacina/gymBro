import { BaseDTO } from './baseDto';
import { BodyGroupDTO } from './bodyGroup.dto';

export interface ExerciseDTO extends BaseDTO {
  name: string;
  description: string;
  bodyGroup: BodyGroupDTO;
}
