import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleBundleComponent } from './schedule-bundle.component';

describe('ScheduleBundleComponent', () => {
  let component: ScheduleBundleComponent;
  let fixture: ComponentFixture<ScheduleBundleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleBundleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScheduleBundleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
