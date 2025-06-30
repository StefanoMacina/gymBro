import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { WorkoutPlanDTO } from '../models/workoutPlan.dto';
import { Page } from '../models/page';
import { ResponseDto } from '../models/response.dto';
import { IDRequest } from '../models/IDRequest';


@Injectable({
  providedIn: 'root'
})
export class WorkoutPlanService {
  private http = inject(HttpClient);
  
  constructor() { }
  
  private readonly baseUrl = `${environment.apiBaseUrl}/workoutPlan`;
  
  getWorkoutPlansByUser(userId: number = 1): Observable<ResponseDto<Page<WorkoutPlanDTO>>> {
    const request: IDRequest = { id: userId };
    return this.http.post<ResponseDto<Page<WorkoutPlanDTO>>>(
      `${this.baseUrl}/user`,
      request
    );
  }


  createWorkoutPlan(dto: WorkoutPlanDTO): Observable<ResponseDto<Page<WorkoutPlanDTO>>> {
    return this.http.post<ResponseDto<Page<WorkoutPlanDTO>>>(this.baseUrl, dto);
  }
}
