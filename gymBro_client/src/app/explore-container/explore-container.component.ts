import { CommonModule } from '@angular/common';
import { Component, inject, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IonButton, IonCard, IonCardHeader, IonCardSubtitle, IonCardTitle, IonChip, IonItem, IonLabel, IonSegment, IonSegmentButton, IonSelect, IonSelectOption } from '@ionic/angular/standalone';
import { WorkoutDayDTO } from '../models/workoutDay.dto';
import { WorkoutPlanDTO } from '../models/workoutPlan.dto';
import { WorkoutDaysService } from '../service/workout.days.service';
import { WorkoutPlanService } from '../service/workout.plan.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-explore-container',
  standalone: true,
  templateUrl: './explore-container.component.html',
  imports: [FormsModule, IonItem, IonButton,IonSelect, IonSelectOption, CommonModule,IonChip , IonLabel, IonSegment, IonSegmentButton, IonCard, IonCardHeader, IonCardSubtitle, IonCardTitle ],
  styleUrls: ['explore-container.component.scss']
})
export class ExploreContainerComponent implements OnInit {
  @Input() name?: string;
  
  selectedPlan?: string;
  selectedDayId?: number;

  workoutPlans: WorkoutPlanDTO[] = [];
  workoutDays: WorkoutDayDTO[] = [];
  planLenght: number = 0;

  private workoutPlanService = inject(WorkoutPlanService);
  private workoutDaysService = inject(WorkoutDaysService);

  constructor(private router: Router) {}

  ngOnInit(){
    if (this.name === 'userSettings') {
      this.loadWorkoutPlans();
    }
  }

  ionViewWillEnter() {
    if (this.name === 'userSettings') {
      this.loadWorkoutPlans();
    }
  }

  loadWorkoutPlans() {
    this.workoutPlanService.getWorkoutPlansByUser(1).subscribe({
      next: (response) => {
        if (response.success) {
          this.planLenght = response.data.totalElements
          this.workoutPlans = response.data.content;
        }
      },
      error: (err) => {
        console.error('Errore durante il caricamento dei workout plans', err);
      }
    });
  }

  loadWorkoutPlanDetails(planID: number) {
    this.workoutDaysService.getWorkoutDaysByPlanID(planID).subscribe({
      next: (response) => {
        if (response.success) {
          this.workoutDays = response.data.content;
          if (this.workoutDays.length > 0) {
            this.selectedDayId = this.workoutDays[0].id;
          }
        }
      },
      error: (err) => {
        console.error('Errore durante il caricamento dei workout days', err);
      }
    });
  }

  onWorkoutPlanChange(event: any) {
    const planID = event.detail.value;
    this.loadWorkoutPlanDetails(planID);
  }

  onImageError(event: Event) {
    const imgElement = event.target as HTMLImageElement;
    imgElement.src = 'https://ionicframework.com/docs/img/demos/card-media.png';
  }

  goToWorkoutBuilder(){
    this.router.navigate(['/workout-builder'])
  }

}


