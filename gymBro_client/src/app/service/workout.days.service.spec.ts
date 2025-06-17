import { TestBed } from '@angular/core/testing';

import { WorkoutDaysService } from './workout.days.service';

describe('WorkoutDaysService', () => {
  let service: WorkoutDaysService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorkoutDaysService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
