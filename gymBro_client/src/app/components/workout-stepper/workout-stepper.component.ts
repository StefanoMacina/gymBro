import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonButton, IonItem, IonLabel, IonContent, IonIcon, IonSelect, IonSelectOption, IonTextarea, IonInput } from '@ionic/angular/standalone';
import { FormsModule } from '@angular/forms';
import { addIcons } from 'ionicons';
import { arrowBackOutline, arrowForwardOutline, checkmarkOutline } from 'ionicons/icons';
import { WorkoutPlanService } from 'src/app/service/workout.plan.service';
import { WorkoutPlanDTO } from 'src/app/models/workoutPlan.dto';

@Component({
  selector: 'app-workout-stepper',
  templateUrl: './workout-stepper.component.html',
  styleUrls: ['./workout-stepper.component.scss'],
  imports:[CommonModule, FormsModule, IonButton, IonContent, IonIcon, IonSelect, IonSelectOption, IonTextarea, IonInput],
  standalone: true,
})
export class WorkoutStepperComponent  implements OnInit {
  step = 0;
  formValues: { [key: string]: any } = {};

  @Input() config: any[] = [];

  constructor(private workoutPlanService: WorkoutPlanService) { 
    addIcons({arrowForwardOutline, arrowBackOutline, checkmarkOutline})
  }

  ngOnInit() {}

  nextStep() {
    if (this.step === 0) {
      const dto: WorkoutPlanDTO = {
        name: this.formValues['Name'],
        userId: 1,
        startDate: this.formValues['startDate'],
        endDate: this.formValues['endDate'],
        isActive: false,
        isBuiltFromUser: true
      };

      this.workoutPlanService.createWorkoutPlan(dto).subscribe({
        next: (response) => {
          console.log('Workout plan creato:', response);
          if (this.step < this.config.length - 1) {
            this.step++;
          }
        },
        error: (err) => {
          console.error('Errore durante la creazione del workout plan', err);
          
        }
      });
    } else {
      if (this.step < this.config.length - 1) {
        this.step++;
      }
    }
  }

  prevStep() {
    if (this.step > 0) {
      this.step--;
    }
  }


  submit() {
    console.log('Step completato!');
  }

  
}
