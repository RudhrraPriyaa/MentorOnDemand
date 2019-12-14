import { TestBed } from '@angular/core/testing';

import { MentorServiceService } from './mentor-service.service';

describe('MentorServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MentorServiceService = TestBed.get(MentorServiceService);
    expect(service).toBeTruthy();
  });
});
