import { TestBed } from '@angular/core/testing';

import { CustomerCarService } from './customer-car.service';

describe('CustomerCarService', () => {
  let service: CustomerCarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerCarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
