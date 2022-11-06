import { TestBed } from '@angular/core/testing';

import { ServiceCenterProvidesServiceService } from './service-center-provides-service.service';

describe('ServiceCenterProvidesServiceService', () => {
  let service: ServiceCenterProvidesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceCenterProvidesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
