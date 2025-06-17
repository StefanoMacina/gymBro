import { Component, inject, OnInit } from '@angular/core';
import { IonBackButton, IonBadge, IonButtons, IonCard, IonCardContent, IonContent, IonFab, IonFabButton, IonHeader, IonIcon, IonItem, IonLabel, IonSearchbar, IonTitle, IonToolbar } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { add } from 'ionicons/icons';
import { WorkoutPlanDTO } from 'src/app/models/workoutPlan.dto';
import { WorkoutPlanService } from 'src/app/service/workout.plan.service';


@Component({
  selector: 'app-workout-builder',
  templateUrl: './workout-builder.component.html',
  standalone: true,
  imports: [IonSearchbar,IonItem,IonBadge, IonLabel,IonCard, IonCardContent, IonHeader, IonToolbar, IonTitle, IonButtons,IonBackButton, IonContent,IonFabButton, IonFab, IonIcon ],
  styleUrls: ['./workout-builder.component.scss'],
})
export class WorkoutBuilderComponent  implements OnInit {
  workoutPlans: WorkoutPlanDTO[] = [];
  private workoutPlanService = inject(WorkoutPlanService);

  constructor() {
    addIcons({ add });
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


  ngOnInit() {
    this.loadWorkoutPlans();
  }

}
