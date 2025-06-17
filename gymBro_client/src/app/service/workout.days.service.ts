import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IDRequest } from '../models/IDRequest';
import { ResponseDto } from '../models/response.dto';
import { Page } from '../models/page';
import { WorkoutDayDTO } from '../models/workoutDay.dto';

@Injectable({
  providedIn: 'root'
})
export class WorkoutDaysService {
  private http = inject(HttpClient);
  
  private readonly baseUrl =`${environment.apiBaseUrl}/workoutDay`;

  constructor() { }

  getWorkoutDaysByPlanID(planID: number = 1): Observable<ResponseDto<Page<WorkoutDayDTO>>> {
      const request: IDRequest = { id: planID };
      return this.http.post<ResponseDto<Page<WorkoutDayDTO>>>(
        `${this.baseUrl}/workoutPlan`,
        request
      );
    }

}
