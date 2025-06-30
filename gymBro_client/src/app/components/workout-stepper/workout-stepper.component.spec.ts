import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { WorkoutStepperComponent } from './workout-stepper.component';

describe('WorkoutStepperComponent', () => {
  let component: WorkoutStepperComponent;
  let fixture: ComponentFixture<WorkoutStepperComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [WorkoutStepperComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(WorkoutStepperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
