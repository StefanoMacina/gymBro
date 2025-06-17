import { Component, inject, Input, OnInit } from '@angular/core';
import { IonButtons, IonContent, IonHeader, IonMenu, IonMenuButton, IonTitle, IonToolbar,IonItem, IonSelect, IonSelectOption,IonChip , IonLabel, IonSegment, IonSegmentButton, IonCard, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle  } from '@ionic/angular/standalone';
import { WorkoutPlanDTO } from '../models/workoutPlan.dto';
import { WorkoutPlanService } from '../service/workout.plan.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WorkoutDaysService } from '../service/workout.days.service';
import { WorkoutDayDTO } from '../models/workoutDay.dto';

@Component({
  selector: 'app-explore-container',
  standalone: true,
  templateUrl: './explore-container.component.html',
  imports: [ IonItem, IonSelect, IonSelectOption, CommonModule,IonChip , FormsModule, IonLabel, IonSegment, IonSegmentButton, IonCard, IonCardHeader, IonCardSubtitle, IonCardTitle ],
  styleUrls: ['explore-container.component.scss']
})
export class ExploreContainerComponent implements OnInit {
  @Input() name?: string;
  
  selectedPlan?: string;
  selectedDayId?: number;

  workoutPlans: WorkoutPlanDTO[] = [];
  workoutDays: WorkoutDayDTO[] = [];

  private workoutPlanService = inject(WorkoutPlanService);
  private workoutDaysService = inject(WorkoutDaysService);

  constructor() {}

  ngOnInit(){
    if (this.name === 'userSettings') {
      this.loadWorkoutPlans();
    }
  }

  loadWorkoutPlans() {
    this.workoutPlanService.getWorkoutPlansByUser(1).subscribe({
      next: (response) => {
        if (response.success) {
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

}


