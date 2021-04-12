import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerTradesComponent } from './trainer-trades.component';

describe('TrainerTradesComponent', () => {
  let component: TrainerTradesComponent;
  let fixture: ComponentFixture<TrainerTradesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainerTradesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerTradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
