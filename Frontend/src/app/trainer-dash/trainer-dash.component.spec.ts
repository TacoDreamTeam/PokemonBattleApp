import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerDashComponent } from './trainer-dash.component';

describe('TrainerDashComponent', () => {
  let component: TrainerDashComponent;
  let fixture: ComponentFixture<TrainerDashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainerDashComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
