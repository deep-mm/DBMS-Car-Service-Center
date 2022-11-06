import { TestBed } from '@angular/core/testing';

import { ScheduleBundleService } from './schedule-bundle.service';

describe('ScheduleBundleService', () => {
  let service: ScheduleBundleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScheduleBundleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
