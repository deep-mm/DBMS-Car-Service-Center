import { TestBed } from '@angular/core/testing';

import { ServiceCenterService } from './service-center.service';

describe('ServiceCenterService', () => {
  let service: ServiceCenterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceCenterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
