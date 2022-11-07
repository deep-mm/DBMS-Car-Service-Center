import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSwapComponent } from './add-swap.component';

describe('AddSwapComponent', () => {
  let component: AddSwapComponent;
  let fixture: ComponentFixture<AddSwapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSwapComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddSwapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
