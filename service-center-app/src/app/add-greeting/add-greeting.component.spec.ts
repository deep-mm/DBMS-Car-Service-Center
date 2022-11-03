import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGreetingComponent } from './add-greeting.component';

describe('AddGreetingComponent', () => {
  let component: AddGreetingComponent;
  let fixture: ComponentFixture<AddGreetingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddGreetingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddGreetingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
