import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCustomerCarComponent } from './add-customer-car.component';

describe('AddCustomerCarComponent', () => {
  let component: AddCustomerCarComponent;
  let fixture: ComponentFixture<AddCustomerCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCustomerCarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCustomerCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
