import { Component, inject, OnInit, ViewChild } from '@angular/core';
import { ActionSheetController,IonButton,IonModal,IonBackButton, IonBadge, IonButtons, IonCard, IonCardContent, IonContent, IonFab, IonFabButton, IonHeader, IonIcon, IonItem, IonLabel, IonSearchbar, IonTitle, IonToolbar } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { add } from 'ionicons/icons';
import { WorkoutPlanDTO } from 'src/app/models/workoutPlan.dto';
import { WorkoutPlanService } from 'src/app/service/workout.plan.service';
import { FormsModule } from '@angular/forms';
import { OverlayEventDetail } from '@ionic/core/components';
import { WorkoutStepperComponent } from '../../workout-stepper/workout-stepper.component';

@Component({
  selector: 'app-workout-builder',
  templateUrl: './workout-builder.component.html',
  standalone: true,
  imports: [ WorkoutStepperComponent,IonButton,FormsModule,IonSearchbar,IonModal,IonItem,IonBadge, IonLabel,IonCard, IonCardContent, IonHeader, IonToolbar, IonTitle, IonButtons,IonBackButton, IonContent,IonFabButton, IonFab, IonIcon ],
  styleUrls: ['./workout-builder.component.scss'],
})
export class WorkoutBuilderComponent  implements OnInit {
  @ViewChild(IonModal) modal!: IonModal;
  name!: string;
  message!: string;
  workoutPlans: WorkoutPlanDTO[] = [];
  private workoutPlanService = inject(WorkoutPlanService);

  stepsConfig = [
  {
    label: 'Workout Plan',
    fields: [
      {
        label: 'Name',
        type: 'text',
        name: 'Name',
        placeholder: 'Plan Name',
      },
      {
        label: 'startDate',
        type: 'date',
        name: 'startDate',
        placeholder: 'startDate',
      },
      {
        label: 'endDate',
        type: 'date',
        name: 'endDate',
        placeholder: 'endDate',
      },
      {
        label: 'Days',
        type: 'select',
        name: 'Days',
        options: [
          { label: '1', value: '1' },
          { label: '2', value: '2' },
          { label: '3', value: '3' },
          { label: '4', value: '4' },
          { label: '5', value: '5' },
          { label: '6', value: '6' },
          { label: '7', value: '7' },
        ]
      }
    ]
  },
  {
    label: 'Days',
    fields: [
      {
        label: 'Days',
        type: 'select',
        name: 'Days',
        options: [
          { label: '1', value: '1' },
          { label: '2', value: '2' },
          { label: '3', value: '3' },
          { label: '4', value: '4' },
          { label: '5', value: '5' },
          { label: '6', value: '6' },
          { label: '7', value: '7' },
        ]
      }
    ]
  },
  {
    label: 'Note',
    fields: [
      {
        label: 'Note aggiuntive',
        type: 'textarea',
        name: 'note',
        placeholder: 'Scrivi qui...'
      }
    ]
  }
];



  constructor(private actionSheetCtrl: ActionSheetController) {
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

  canDismiss = async () => {
    const actionSheet = await this.actionSheetCtrl.create({
      header: 'Are you sure?',
      buttons: [
        {
          text: 'Yes',
          role: 'confirm',
        },
        {
          text: 'No',
          role: 'cancel',
        },
      ],
    });

    actionSheet.present();

    const { role } = await actionSheet.onWillDismiss();
        this.loadWorkoutPlans();

    return role === 'confirm';
  };

  cancel() {
    this.loadWorkoutPlans();
    this.modal.dismiss(null, 'cancel');
  }

  confirm() {
    this.loadWorkoutPlans();
    this.modal.dismiss(this.name, 'confirm');
  }

  onWillDismiss(event: CustomEvent<OverlayEventDetail>) {
    
    if (event.detail.role === 'confirm') {
        this.loadWorkoutPlans();
      this.message = `Hello, ${event.detail.data}!`;
    }
  }

}
