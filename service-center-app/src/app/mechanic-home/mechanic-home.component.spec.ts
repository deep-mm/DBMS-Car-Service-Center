import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MechanicHomeComponent } from './mechanic-home.component';

describe('MechanicHomeComponent', () => {
  let component: MechanicHomeComponent;
  let fixture: ComponentFixture<MechanicHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MechanicHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MechanicHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
