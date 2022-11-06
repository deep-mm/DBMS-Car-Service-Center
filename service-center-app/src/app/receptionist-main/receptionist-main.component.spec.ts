import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceptionistMainComponent } from './receptionist-main.component';

describe('ReceptionistMainComponent', () => {
  let component: ReceptionistMainComponent;
  let fixture: ComponentFixture<ReceptionistMainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceptionistMainComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReceptionistMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
