import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerDeckComponent } from './trainer-deck.component';

describe('TrainerDeckComponent', () => {
  let component: TrainerDeckComponent;
  let fixture: ComponentFixture<TrainerDeckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainerDeckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerDeckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
