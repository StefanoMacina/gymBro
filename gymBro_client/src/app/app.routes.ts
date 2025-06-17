import { Routes } from '@angular/router';
import { WorkoutBuilderComponent } from './components/workoutBuilder/workout-builder/workout-builder.component';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./tabs/tabs.routes').then((m) => m.routes),
  },
  {
    path: 'workout-builder',
    component: WorkoutBuilderComponent,
  },
];
