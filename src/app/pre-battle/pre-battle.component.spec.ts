import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreBattleComponent } from './pre-battle.component';

describe('PreBattleComponent', () => {
  let component: PreBattleComponent;
  let fixture: ComponentFixture<PreBattleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreBattleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreBattleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
